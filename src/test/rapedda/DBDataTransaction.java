package test.rapedda;

import java.util.HashMap;
import java.util.Map;

/**
 * THis program takes input as series of DB commands and performs action on it .
 * We use another (inMemory)Map which is a deep copy of original map and replace it with original map once commit is called.
 * During rollback we simply discard the copied map
 * This uses space complexitiy of O(n) as we create another similiar map that stores all the details
 */
public class DBDataTransaction {

    public static void main(String[] args) {

        String[] inputList = new String[]{
                "BEGIN"
                , "CREATE|1|Name=Anup,Place=Mumbai"
                , "CREATE|2|Name=Randeep,Place=Mumbai"
                , "READ"
                , "COMMIT"
                , "BEGIN"
                , "UPDATE|1|Place=Pune"
                , "DELETE|2"
                , "UPDATE|1|Place=Nashik"
                , "CREATE|3|Name=Priyaranjan,Place=Bangalore"
                , "READ"
                , "COMMIT"
                , "READ"
        };
        DBData dbData = new DBData();
        for (String input : inputList) {
            String[] splitArr = input.split("\\|");
            Integer rowNum = 0;

            if (splitArr.length > 1) {
                rowNum = Integer.parseInt(splitArr[1]);
            }
            if (input.contains("BEGIN")) {
                dbData.beginTransaction();
            } else if (input.contains("CREATE")) {
                dbData.create(rowNum, splitArr[2]);
            } else if (input.contains("UPDATE")) {
                dbData.update(rowNum, splitArr[2]);
            } else if (input.contains("READ")) {
                dbData.read();
            } else if (input.contains("DELETE")) {
                dbData.delete(rowNum);
            } else if (input.contains("ROLLBACK")) {
                dbData.rollBack();
            } else if (input.contains("COMMIT")) {
                dbData.commit();
            }
        }

    }
}

class DBData {
    Map<Integer, Map<String, String>> dbMap = new HashMap<>();
    Map<Integer, Map<String, String>> inMemoryMap = new HashMap<>();
    Map<Integer, String> inMemoryDeletedMap = new HashMap<>();
    boolean isTransactionActive = false;

    public void beginTransaction() {
        isTransactionActive = true;
        //deep copy
/*
        dbMap.forEach((key, value) -> {
            Map<String, String> originalColumns = value;
            Map<String, String> inMemoryColumns = new HashMap<>();
            originalColumns.forEach(inMemoryColumns::put);
            inMemoryMap.put(key, inMemoryColumns);
        });
*/

    }


    public void create(Integer rowNum, String columnData) {
        Map<String, String> columns = extractColumnsDataFrom(columnData);
        inMemoryMap.put(rowNum, columns);

    }


    public void update(Integer rowNum, String columnData) {
        Map<String, String> inputColumnsMap = extractColumnsDataFrom(columnData);

        //if data not present in inMemoryDB, copy it from dbMap
        if (!inMemoryMap.containsKey(rowNum)) {
            loadFromDB(rowNum);
        }

        Map<String, String> existingColumnDataMap = inMemoryMap.get(rowNum);
        inputColumnsMap.forEach((key, value) -> {
            existingColumnDataMap.put(key, value);
        });

        inMemoryMap.put(rowNum, existingColumnDataMap);//TODO not required

    }

    private void loadFromDB(Integer rowNum) {
        Map<String, String> originalColumns = dbMap.get(rowNum);
        Map<String, String> inMemoryColumns = new HashMap<>();
        //deepcopy
        originalColumns.forEach((key, value) -> {
            inMemoryColumns.put(key, value);
        });
        inMemoryMap.put(rowNum, inMemoryColumns);
    }

    public void delete(Integer rowNum) {
        inMemoryDeletedMap.put(rowNum, "");
        //inMemoryMap.remove(rowNum);
    }

    private Map<String, String> extractColumnsDataFrom(String columnData) {
        Map<String, String> columns = new HashMap<>();
        String[] columnArr = columnData.split(",");
        for (String column : columnArr) {
            String[] splitCol = column.split("=");
            columns.put(splitCol[0], splitCol[1]);
        }
        return columns;
    }

    public void read(Integer rowNum) {

        Map<String, String> columns;
        if (isTransactionActive) {
            System.out.println("!! Dirty Read !!");
            columns = inMemoryMap.get(rowNum);
        } else {
            columns = dbMap.get(rowNum);
        }
        System.out.println("Printing entire row with rowNum = " + rowNum);
        columns.forEach((key, value) ->
                System.out.println(key + " = " + value));
        System.out.println("----------------------------------");
    }

    public void read() {
        if (isTransactionActive) {
            System.out.println("!! Showing dirty read values !!");
            System.out.println("------ Printing inMemoryMap ------");
            print(inMemoryMap);
        } else {
            System.out.println("--------- Printing DBMap ---------");
            print(dbMap);
        }
    }

    public void printDBMap() {
        print(dbMap);
    }

    private void print(Map<Integer, Map<String, String>> map) {

        map.forEach((key, value) -> {
            System.out.println("Printing data for key -->" + key);
            Map<String, String> columns = map.get(key);
            columns.forEach((colKey, colValue) ->
                    System.out.println(colKey + " --> " + colValue));
            System.out.println("----------------------");
        });
    }

    public void commit() {
        System.out.println(" Committing the data !!");

        //deep copy from inMemoryMap to dbMap
        inMemoryMap
                .forEach((key, value) -> {
                    if (dbMap.containsKey(key)) { // for update
                        System.out.println("Updating entry with rowNum -->" + key);
                        //Updating column from inMemory to dbMap
                        Map<String, String> existingColumns = dbMap.get(key);
                        Map<String, String> updatedColumns = value;
                        //deep copying of maps
                        updatedColumns.forEach((updatedRow, updatedCol) -> {
                            if (existingColumns.containsKey(updatedRow)) {
                                existingColumns.put(updatedRow, updatedCol);
                            }
                        });
                    } else {
                        System.out.println("Inserting entry with rowNum -->" + key);
                        dbMap.put(key, value);//for insert
                    }
                });

        // if entry is deleted from inMemoryMap, then delete it from dbMap as well
        inMemoryDeletedMap.forEach((key, value) -> {
            dbMap.remove(key);
        });
        /*Integer rowToDelete = 0;
        Set<Map.Entry<Integer, Map<String, String>>> dbMapEntries = dbMap.entrySet();
        for (Map.Entry<Integer, Map<String, String>> entry : dbMapEntries) {
            if (!inMemoryMap.containsKey(entry.getKey())) {
                rowToDelete = entry.getKey();
            }
        }
        dbMap.remove(rowToDelete);*/
        System.out.println();

        inMemoryMap = new HashMap<>();// resetting the inMemoryMap to default since  this is the end of transaction
        inMemoryDeletedMap = new HashMap<>();
        isTransactionActive = false;
    }

    public void rollBack() {
        System.out.println(" !! Rollbacking the data !!");
        inMemoryMap = new HashMap<>();//flushing all of the uncommitted data
        inMemoryDeletedMap = new HashMap<>();
        isTransactionActive = false;
    }


}
/*
OUTPUT

!! Showing dirty read values !!
------ Printing inMemoryMap ------
Printing data for key -->1
Place --> Mumbai
Name --> Anup
----------------------
Printing data for key -->2
Place --> Mumbai
Name --> Randeep
----------------------
 Commiting the data !!
Inserting entry with rowNum -->1
Inserting entry with rowNum -->2
!! Showing dirty read values !!
------ Printing inMemoryMap ------
Printing data for key -->1
Place --> Pune
Name --> Anup
----------------------
 Rollbacking the data !
--------- Printing DBMap ---------
Printing data for key -->1
Place --> Mumbai
Name --> Anup
----------------------
Printing data for key -->2
Place --> Mumbai
Name --> Randeep
----------------------

Process finished with exit code 0

 */