import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Test {

    public static void main(String[] args) {
        String input ="ACCGGGTTTT";
        System.out.println("Reverse -->"+reverseString(input));
        String reversedString = reverseString(input);
        reversedString.replace('A','T');


        char[] reversedCharArray=reversedString.toCharArray();
        StringBuilder output= new StringBuilder();

        for(char inputChar : reversedCharArray){
                if(inputChar == 'A'){
                    output.append("T");
                }
                else if(inputChar == 'T'){
                    output.append("A");
                }
                else if(inputChar == 'C'){
                    output.append("G");
                }
                else if(inputChar == 'G'){
                    output.append("C");
                }
        }

        System.out.println("Final answer -"+ output.toString());

        List<Integer> inputList = new ArrayList<>();
        inputList.add(1);
        inputList.add(3);
        inputList.add(4);
        inputList.add(2);
       // System.out.println("Is Valid"+isValid(inputList));
        System.out.println("Candles burnt-"+getTotalCandlesBurnt(6,2,2));

    }
    public static String reverseString(String input){

        StringBuilder input1 = new StringBuilder();
        input1.append(input);
        input1 = input1.reverse();
        return input1.toString();


    }

    static int getTotalCandlesBurnt(int amount, int costOfCandle, int noOfResidueCandles) {
        int totalNumberOfCandlesPurchased= amount/costOfCandle;
        int residueCandlesCreated= totalNumberOfCandlesPurchased/noOfResidueCandles;
        if(totalNumberOfCandlesPurchased%residueCandlesCreated != 0){
            residueCandlesCreated++;
        }
        return totalNumberOfCandlesPurchased+residueCandlesCreated;

    }

    public static String isValid(List<Integer> a) {
        int root = a.get(0);
        boolean firstRightChildFound=false;
        int firstRightChild = 0;
        for(int index=1;index<a.size();index++){
            if(a.get(index)<root){
                if(firstRightChildFound){
                    return "NO";
                }
            }else if(a.get(index)>root){
                firstRightChildFound=true;
                if(firstRightChild == 0) {
                    firstRightChild = a.get(index);
                }
            }

        }
        if(a.get(a.size()-1) < firstRightChild){
            return "NO";
        }

        return "YES";

    }

}


