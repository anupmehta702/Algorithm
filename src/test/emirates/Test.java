package test.emirates;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test extends Thread {

    public void run() {
        System.out.println("Before");
        this.stop();
        System.out.println("After");

    }

    public static void main2(String[] args) {
        System.out.println("Hello !!");
        Test t = new Test();
        t.start();
        if (new Boolean("true") == new Boolean("true")) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        String line = "anup";
        System.out.println("length -->" + line.length());
        String[] inputArray = line.split(";");
        double pp = Double.parseDouble(inputArray[0]);
        double cash = Double.parseDouble(inputArray[1]);
        System.out.println("=-->" + pp + " -->" + cash);


    }

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
            //System.out.println("input -->"+line);
            findPasswordStrength(line);
            /*String[] inputArray = line.split(";");
            double pp = Double.parseDouble(inputArray[0]);
            double ch = Double.parseDouble(inputArray[1]);
            if(ch < pp){
                System.out.println("ERROR");
            }else if(ch == pp ){
                System.out.println("ZERO");
            }else{
                calculateChange(pp,ch);
            }
*/
        }

    }

    public static void findPasswordStrength(String inputPassword) {
        if (inputPassword.length() < 6) {
            System.out.println("invalid");
        } else if (inputPassword.length() < 8) {
            System.out.println("weak");
        } else {
            String minimumCriteria = "^(?=.*[0-9])"
                    + "(?=.*[a-z])(?=.*[A-Z])"
                    //+ "(?=.*[@#$%^&+=])"
                    + "(?=\\S+$).{8,25}$";

            Pattern p = Pattern.compile(minimumCriteria);
            Matcher m = p.matcher(inputPassword);

            if (!m.matches()) {
                System.out.println("weak");
            } else {
                String minimumCriteriaWithoutEnd = minimumCriteria.substring(0, minimumCriteria.length() - 1);
                //String strongPasswordCriteria = minimumCriteriaWithoutEnd + "(?=.*[@#$%^&+=])$" ;
                String strongPasswordCriteria = "^(?=.*[0-9])"
                        + "(?=.*[a-z])(?=.*[A-Z])"
                        + "(?=.*[@#$%^&+=])"
                        + "(?=\\S+$).{8,25}$";

                p = Pattern.compile(strongPasswordCriteria);
                m = p.matcher(inputPassword);
                if (m.matches() && inputPassword.length() >= 10) {
                    System.out.println("strong");
                } else {
                    System.out.println("medium");
                }
            }
            //System.out.println(""+m.matches());

        }
    }

    public static void calculateChange(double pp, double ch) {
        Map<Double, String> inputMap = getInputMap();

        Double difference = new Double(ch - pp);

        difference = ch - pp;

        Formatter fm = new Formatter();
        Formatter formattedDifference = fm.format("%.2f", difference);


        StringBuffer output = new StringBuffer();
        if (inputMap.containsKey(formattedDifference)) {
            output.append(inputMap.get(formattedDifference));
        }
        System.out.println(output.toString());

    }


    public static Map<Double, String> getInputMap() {
        Map<Double, String> inputMap = new HashMap<>();
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
