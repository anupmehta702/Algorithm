package com.algorithm.string;

import java.util.*;
import java.util.stream.Collectors;


/*
Re arrange the sentence as per the length of the words (increasing order)
put everything in lower case expect outputs first letter to be capital.
example - Houston we have a problem.
output -A we have houston problem.
 */
public class ReAarangeTheSentence {

    public static void main(String[] args) {
        String sentence = "Houston we have a problem.";
        ReAarangeTheSentence r = new ReAarangeTheSentence();
        System.out.println("output->"+r.rearrangeTheSentence("Houston we have a problem."));
        System.out.println("output->"+r.rearrangeTheSentence("Ok is ok."));
        System.out.println("output->"+r.rearrangeTheSentence("It is the hottest sun in the beach."));
    }

    String rearrangeTheSentence(String sentence) {
        class Word implements Comparable<Word>{
            String word;
            Integer length = new Integer(0);

            public Word(String word, int length) {
                this.word = word;
                this.length = length;
            }

            @Override
            public int compareTo(Word o) {
                return this.length.compareTo(o.length);
            }
        }
        StringBuffer output = new StringBuffer();
        List<Word> wordList = new ArrayList<>();
        String sent= sentence.replace('.',' ');
        String[] words= sent.split(" ");
        for(String w : words){
            wordList.add(new Word(w,w.length()));
        }

         Collections.sort(wordList);
        int count = 0;
        for(Word wordObj : wordList){
            if(count==0){
                String firstWord = wordObj.word;
                StringBuffer capital = new StringBuffer();
                for(int i=0; i < firstWord.length();i++){
                    if(i==0){
                        capital.append(Character.toUpperCase(firstWord.charAt(i)));
                    }else{
                        capital.append(firstWord.charAt(i));
                    }
                }
                output.append(capital.toString());
            }else {
                output.append(wordObj.word.toLowerCase());
            }
            output.append(" ");
            count++;
        }
        String outputWithoutFullStop=output.toString().trim();
        return outputWithoutFullStop+".";
    }

    /*this method doesnot consider duplicate elements.If removes duplicates since we are using map
    however that is not our requirement.
    */
    String rearrangeTheSentence1(String sentence) {
         StringBuffer output = new StringBuffer();
        String sent= sentence.replace('.',' ');
        String[] words= sent.split(" ");
        Map<String,Integer> mapOfWords= new LinkedHashMap<>();
        for(String word : words){
            mapOfWords.put(word,word.length());
        }
        Set<Map.Entry<String,Integer>> wordSet = mapOfWords.entrySet();
        List<Map.Entry<String,Integer>> sortedWords =wordSet.stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());
        int count = 0 ;
        for(Map.Entry<String,Integer> word : sortedWords){
            if(count==0){
                String firstWord = word.getKey();
                StringBuffer capital = new StringBuffer();
                for(int i=0; i < firstWord.length();i++){
                    if(i==0){
                        capital.append(Character.toUpperCase(firstWord.charAt(i)));
                    }else{
                        capital.append(firstWord.charAt(i));
                    }
                }
                output.append(capital.toString());
            }else {
                output.append(word.getKey().toLowerCase());
            }
            output.append(" ");
            count++;
        }
        String outputWithoutFullStop=output.toString().trim();
         return outputWithoutFullStop+".";
    }
}

/*Output
output->A we have houston problem.
output->Ok is ok.
output->It is in the sun the beach hottest.
 */