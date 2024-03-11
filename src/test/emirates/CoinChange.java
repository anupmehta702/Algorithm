package test.emirates;

import java.io.IOException;
import java.util.*;

/*
Available money denomination -
0.01, "PENNY"
0.05, "NICKEL"
0.10, "DIME"
0.25, "QUARTER"
0.50, "HALF DOLLAR"
1.00, "ONE"
2.00, "TWO"
5.00, "FIVE"
20.00, "TWENTY"
50.00, "FIFTY"
100.00, "HUNDRED"

Input --> 15.95;16.00  ( price;cash)
output --> Nickel
Input --> 15.94;16.00  ( price;cash)
output --> Nickel,Penny
Input --> 15;160.00  ( price;cash)
output --> [HUNDRED, TWENTY, TWENTY, FIVE]
*/
public class CoinChange {

    public static void main(String[] args) throws IOException {
        calculateChange(15.94, 16.00);
        calculateChange(15.95, 16.00);
        calculateChange(15.00, 160.00);

        /*InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
            System.out.println("input -->" + line);

            String[] inputArray = line.split(";");
            double pp = Double.parseDouble(inputArray[0]);
            double ch = Double.parseDouble(inputArray[1]);
            if (ch < pp) {
                System.out.println("ERROR");
            } else if (ch == pp) {
                System.out.println("ZERO");
            } else {
                calculateChange(pp, ch);
            }
        }*/

    }

    public static void calculateChange(double pp, double ch) {
        Map<Double, String> availableMoneyDenomination = getInputMap();
        List<String> output = new ArrayList<String>();

        Double difference = ch - pp;

        Double remainingDifference = Math.round(difference * 100) / 100.0;

        while (remainingDifference != 0.0) {
            if (availableMoneyDenomination.containsKey(remainingDifference)) {
                output.add(availableMoneyDenomination.get(remainingDifference));
                remainingDifference = 0.0;
            } else {
                remainingDifference = findClosestMoneyDenominator(remainingDifference, availableMoneyDenomination, output);
                System.out.println("Remaining difference -->" + remainingDifference);
            }
        }


        System.out.println(output.toString());

    }

    private static Double findClosestMoneyDenominator(Double difference, Map<Double, String> availableMoneyDenomination, List<String> output) {
        Double minDifference = Double.MAX_VALUE;
        String minDenomination = "";

        Set<Map.Entry<Double, String>> entrySet = availableMoneyDenomination.entrySet();
        for (Map.Entry<Double, String> entry : entrySet) {
            Double closestMoneyDenominator = difference - entry.getKey();
            closestMoneyDenominator = Math.round(closestMoneyDenominator * 100.00) / 100.00;

            if (closestMoneyDenominator > 0 && (closestMoneyDenominator < minDifference)) {
                minDifference = closestMoneyDenominator;
                minDenomination = entry.getValue();
            } else {
                break;
            }
        }
        output.add(minDenomination);

        return minDifference;
    }


    public static Map<Double, String> getInputMap() {
        Map<Double, String> inputMap = new TreeMap<>();
        inputMap.put(0.01, "PENNY");
        inputMap.put(0.05, "NICKEL");
        inputMap.put(0.10, "DIME");
        inputMap.put(0.25, "QUARTER");
        inputMap.put(0.50, "HALF DOLLAR");
        inputMap.put(1.00, "ONE");
        inputMap.put(2.00, "TWO");
        inputMap.put(5.00, "FIVE");
        inputMap.put(20.00, "TWENTY");
        inputMap.put(50.00, "FIFTY");
        inputMap.put(100.00, "HUNDRED");
        return inputMap;
    }

}


