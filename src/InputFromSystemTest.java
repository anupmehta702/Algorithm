import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputFromSystemTest {

    public static void main(String[] args) {
        String[] inputArr = getInput();
        for(String input : inputArr) {
            System.out.println("Printing input -->" + input);
        }
    }

    public static String[] getInput() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String firstInput = br.readLine();                // Reading input from STDIN
            String[] inputArr = firstInput.split(" ");
            return inputArr;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}

