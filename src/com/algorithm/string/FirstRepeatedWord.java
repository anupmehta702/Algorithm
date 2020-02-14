package com.algorithm.string;

import java.util.HashSet;
import java.util.Set;

public class FirstRepeatedWord {

    public static void main(String[] args) {
        String text = "This -text ad - ad ad-bf ! has \\ /allot; # of, % special: % characters.";
        text = text.replaceAll("[^a-zA-Z0-9\\s]", "");//replace all special characters except alphabets numbers and space
        System.out.println("text --> "+text);

        System.out.println("-->"+firstRepeatedWord("This is Is not a bag but bag not."));
        System.out.println("-->"+firstRepeatedWord("that     that occurs sometimes"));
    }
    public static String firstRepeatedWord(String sentence) {
        // Write your code here , : , ; , -
        //String sent = sentence.replace('.',' ');
        String sent = sentence.replaceAll("[^a-zA-Z0-9\\s]", "");
        String[] words = sent.split(" ");
        Set<String> repeatedWords = new HashSet<String>();
        String firstRepeatedWord="";
        for(String word : words){
            if(repeatedWords.contains(word)){
                firstRepeatedWord=word;
                return firstRepeatedWord;
            }else{
                if(!word.isEmpty()){
                    repeatedWords.add(word);
                }

            }
        }
        return firstRepeatedWord;
    }

}
/*output
text --> This text ad  ad adbf  has  allot  of  special  characters
-->bag
-->that
 */