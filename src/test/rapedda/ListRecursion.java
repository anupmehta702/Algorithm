package test.rapedda;

import java.util.ArrayList;
import java.util.List;

/**
 * flatten the list and print alternate
 */
public class ListRecursion {

    public static void main(String[] args) {
        List<Object> inputList = new ArrayList<>();
        inputList.add(1);
        List<Object> nestedList1 = new ArrayList<>();
        nestedList1.add(2);
        nestedList1.add(3);
        List<Object> nestedList2 = new ArrayList<>();
        nestedList2.add(4);
        nestedList2.add(5);
        List<Object> nestedList3 = new ArrayList<>();
        nestedList2.add(6);
        nestedList2.add(7);
        nestedList2.add(nestedList3);
        nestedList1.add(nestedList2);

        inputList.add(nestedList1);
        inputList.add(8);

        List<Integer> flattenedList = new ArrayList<>();
        printList(inputList, flattenedList);
        printAlternate(flattenedList);


    }

    public static void printAlternate(List<Integer> flattenedList) {
        Boolean print = new Boolean(true);
        for(int input : flattenedList){
            if(print){
                System.out.println("-- -- "+input);
                print = false;
            }else{
                print = true;
            }
        }
    }

    public static void printList(List inputList, List flattenedList) {
        for (Object input : inputList) {
            if (input instanceof List) {
                printList((List) input, flattenedList);
            } else {
                System.out.println(" -->" + input);
                flattenedList.add(input);
            }
        }

    }

}
