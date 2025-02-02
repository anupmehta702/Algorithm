package test.rapedda;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static test.rapedda.Action.B;
import static test.rapedda.Action.S;

/**
 * Reconciliation for stocks . You have original holdings , you perform some transactions
 * and then you compare your actual holdings with expected holdings (reconciliation)
 */
public class Reconciliation {

    public static void main(String[] args) {
        String[] portfolio = new String[]{"A|100", "B|200", "C|300", "D|400"};
        String[] transaction = new String[]{"T1|A|10|S", "T2|B|10|S", "T3|C|30|B", "T4|D|40|S"};

        //String[] expectedOutput = new String[]{"A|900", "B|190", "C|330","D|360"};
        String[] expectedOutput = new String[]{"A|900", "B|190", "C|330","E|999"};

        Portfolio p = new Portfolio();
        p.addHoldings(portfolio);

        p.processTransactions(transaction);
        p.printCurrentHoldings();
        System.out.println("-----------");
        p.reconcile(expectedOutput);



    }

}


class Portfolio {
    private Map<String, Integer> currentHoldings = new HashMap<>();

    void addHolding(String stockName, Integer quantity) {
        if (currentHoldings.containsKey(stockName)) {
            currentHoldings.put(stockName, currentHoldings.get(stockName) + quantity);
        } else {
            currentHoldings.put(stockName, quantity);
        }
    }

    void addHoldings(String[] input) {
        List<String> inputList = Arrays.asList(input);
        inputList.forEach(i -> {
            String[] inputArr = i.split("\\|");
            addHolding(inputArr[0], Integer.parseInt(inputArr[1]));
        });

    }

    void printCurrentHoldings() {
        currentHoldings.forEach((k, v) -> System.out.println("Stock name -->" + k + " holding -->" + v));
    }

    void processTransactions(String[] inputArr) {
        List<String> inputList = Arrays.asList(inputArr);
        inputList.forEach(input -> {
            String[] tranArr = input.split("\\|");
            processTransaction(tranArr[1], Integer.parseInt(tranArr[2]), Action.valueOf(tranArr[3]));
        });
    }

    private void processTransaction(String stockName, Integer quantity, Action action) {
        if (action == B) {
            int currentQuantity = currentHoldings.get(stockName);
            currentHoldings.put(stockName, currentQuantity + quantity);
        } else if (action == S) {
            int currentQuantity = currentHoldings.get(stockName);
            currentHoldings.put(stockName, currentQuantity - quantity);
            //TODO check if value is less than 0
        } else {
            throw new UnsupportedOperationException("Unsupported action !");
        }
    }

     void reconcile(String[] expectedOutput){
        Map<String,Integer> expectedHoldings = new HashMap<>();
        for(String output : expectedOutput){
            String[] outputArr = output.split("\\|");
            expectedHoldings.put(outputArr[0],Integer.parseInt(outputArr[1]));
        }

        if(expectedHoldings.equals(currentHoldings)){
            System.out.println("Matched via equals check");
        }else {
            compare(expectedHoldings,currentHoldings);
            compare(currentHoldings,expectedHoldings);
        }

    }

    private void compare(Map<String, Integer> originalHoldings,Map<String, Integer> compareWithHoldings) {
        originalHoldings.forEach((expectedStockName,expectedQuantity)->
        {
            if(compareWithHoldings.containsKey(expectedStockName)){
                if(!compareWithHoldings.get(expectedStockName).equals(expectedQuantity)) {
                    String print = "Mismatch for stockName %s , expected %s but actual %s";
                    System.out.println(String.format(print, expectedStockName, expectedQuantity, compareWithHoldings.get(expectedStockName)));
                }
            }else{
                System.out.println("StockName "+expectedStockName+" expected but missing in actual portfolio");
            }
        });
    }

}

enum Action {
    B,
    S
}
