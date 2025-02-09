package test.rapedda;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class DBTransactionUsingStack {
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
                , "CREATE|3|Name=Priyaranjan,Place=Bangalore"
                , "READ"
                , "ROLLBACK"
                , "READ"
        };
        DBDataUsingStack dbData = new DBDataUsingStack();

        for (String input : inputList) {
            dbData.executeCommands( input,false);
        }

    }



}

class DBDataUsingStack {
    Map<Integer, Map<String, String>> dbMap = new HashMap<>();
    Stack<String> rollBackStack = new Stack<>();


    public void beginTransaction() {
        //deep copy
        System.out.println("Begin Transaction !");
        rollBackStack = new Stack<>();

    }


    public void create(Integer rowNum, String columnData, boolean isRollback) {
        System.out.println("Creating a new row with rowNum -> "+rowNum);
        Map<String, String> columns = extractColumnsDataFrom(columnData);
        if(!isRollback) {
            rollBackStack.push("DELETE|" + rowNum);
        }
        dbMap.put(rowNum, columns);
    }

    public void read() {
        System.out.println("-------- READ CMD ----------");
        dbMap.forEach((key, value) -> {
            System.out.println("Printing data for key -->" + key);
            Map<String, String> columns = dbMap.get(key);
            columns.forEach((colKey, colValue) ->
                    System.out.println(colKey + " --> " + colValue));
            System.out.println("----------------------");
        });
    }

    public void update(Integer rowNum, String columnData,boolean isRollBack) {
        System.out.println("Updating the data for rowNum -> "+ rowNum);
        //extract data from input
        Map<String, String> inputColumnsMap = extractColumnsDataFrom(columnData);

        //creating equivalent opposite command for rollback
        if(!isRollBack) {
            createRollbackCmdForUpdate(rowNum, inputColumnsMap);
        }

        //update DB
        Map<String, String> existingColumnDataMap = dbMap.get(rowNum);
        inputColumnsMap.forEach((key, value) -> {
            existingColumnDataMap.put(key, value);
        });

    }


    public void delete(Integer rowNum, boolean isRollBack) {
        System.out.println("Deleting the record with rowNum -->"+rowNum);
        Map<String, String> originalColumns = dbMap.get(rowNum);
        if(!isRollBack) {
            createRollbackCmdForDelete(rowNum, originalColumns);
        }
        dbMap.remove(rowNum);
    }


    //create equivalent update command which contains previous values before the original update statement
    private void createRollbackCmdForUpdate(Integer rowNum, Map<String, String> inputColumnsMap) {
        Map<String, String> existingColumnDataMap = dbMap.get(rowNum);
        StringBuilder originalValues = new StringBuilder();
        inputColumnsMap.forEach((key, value) -> {
            String existingColumnName = key;
            String existingColumnValue = existingColumnDataMap.get(key);
            if (!(originalValues.length() == 0)) { //except for first column pair , add ","
                originalValues.append(",");
            }
            originalValues.append(existingColumnName + "=" + existingColumnValue);
            existingColumnDataMap.put(key, value);
        });
        rollBackStack.push("UPDATE|" + rowNum + "|" + originalValues.toString());
    }

    private void createRollbackCmdForDelete(Integer rowNum, Map<String, String> originalColumns) {
        StringBuilder originalValues = new StringBuilder();
        originalColumns.forEach((columnKey, columnValue) -> {
                    if (!(originalValues.length() == 0)) {
                        originalValues.append(",");
                    }
                    originalValues.append(columnKey + "=" + columnValue);
                }
        );
        rollBackStack.push("CREATE|" + rowNum + "|" + originalValues.toString());
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


    public void commit() {
        System.out.println(" Committing the data !!");
        rollBackStack = new Stack<>(); // resetting the rollbackStack as it is already committed
        System.out.println();
    }

    public void rollBack() {
        System.out.println(" !!------- Rollbacking the data -------!!");
        while (!rollBackStack.isEmpty()) {
            String rollBackCommand = rollBackStack.pop();
            System.out.println("Rollbacking command --> "+rollBackCommand);
            executeCommands(rollBackCommand,true);
        }
    }

    public void printRollbackStack() {
        System.out.println("--- ROLL BACK STACK ---");
        while (!rollBackStack.isEmpty()) {
            System.out.println(rollBackStack.pop());
        }
    }



    public void executeCommands( String input, boolean isRollBack) {
        String[] splitArr = input.split("\\|");
        Integer rowNum = 0;

        if (splitArr.length > 1) {
            rowNum = Integer.parseInt(splitArr[1]);
        }
        if (input.contains("BEGIN")) {
            this.beginTransaction();
        } else if (input.contains("CREATE")) {
            this.create(rowNum, splitArr[2],isRollBack);
        } else if (input.contains("UPDATE")) {
            this.update(rowNum, splitArr[2],isRollBack);
        } else if (input.contains("READ")) {
            this.read();
        } else if (input.contains("DELETE")) {
            this.delete(rowNum,isRollBack);
        } else if (input.contains("ROLLBACK")) {
            this.rollBack();
        } else if (input.contains("COMMIT")) {
            this.commit();
        }
    }

}
/*
OUTPUT

Begin Transaction !
Creating a new row with rowNum -> 1
Creating a new row with rowNum -> 2
-------- READ CMD ----------
Printing data for key -->1
Place --> Mumbai
Name --> Anup
----------------------
Printing data for key -->2
Place --> Mumbai
Name --> Randeep
----------------------
Committing the data !!

Begin Transaction !

Updating the data for rowNum -> 1
Deleting the record with rowNum -->2
Creating a new row with rowNum -> 3
-------- READ CMD ----------
Printing data for key -->1
Place --> Pune
Name --> Anup
----------------------
Printing data for key -->3
Place --> Bangalore
Name --> Priyaranjan
----------------------
 !!------- Rollbacking the data -------!!
Rollbacking command --> DELETE|3
Deleting the record with rowNum -->3
Rollbacking command --> CREATE|2|Place=Mumbai,Name=Randeep
Creating a new row with rowNum -> 2
Rollbacking command --> UPDATE|1|Place=Mumbai
Updating the data for rowNum -> 1
-------- READ CMD ----------
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