package com.java.concept.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {
        testFlatMap();
        biFunctionTest();
        testStreamPredicate();
    }

    public static void testFlatMap() {
        System.out.println(Arrays.asList("str1", "a1", "abc")
                .stream()
                .flatMap(s -> {
                    List<String> t = new ArrayList();
                    t.add(s);
                    t.add(s.length()+"");
                    return t.stream();
                })
                .collect(Collectors.toList()));
    }


    static void testStreamPredicate(){
        StreamTest st = new StreamTest();
        List<String> filteredList = Arrays.asList("Anup", "Mehta", "Mumbai")
                .stream()
                //.filter(StreamTest::startsWith)
                .filter(s->startsWith(s))
                .filter(s->st.startsWith(s))
                .filter(startsWithPredicate())
                .collect(Collectors.toList());
        System.out.println("filtered list -->"+filteredList);
    }

    public  static boolean startsWith(String input){
        return input.charAt(0) == 'A';
    }

    public static Predicate<String> startsWithPredicate(){
        return s -> s.charAt(0) == 'A';
    }

    public static void biFunctionTest() {
        StreamTest st = new StreamTest();
        Integer[] inputArr = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        List<Integer> inputList = collectExampleForMap(inputArr);
        st.calculate(inputList, st.transform());
        st.calculate(inputList, StreamTest::transformMethod);

        totalAllVal(inputList, input -> input % 2 == 0);
        totalAllVal(inputList, oddValues());
        totalAllVal(inputList, StreamTest::isOdd);

    }

    private static List<Integer> collectExampleForMap(Integer[] inputArr) {
        List<Integer> inputList = Arrays.asList(inputArr);
        Map<Integer, Integer> collect = inputList.stream()
                .collect(Collectors.toMap(inputAsKey -> inputAsKey, inputAsValue -> inputAsValue));
        System.out.println("Printing map -->" + collect);
        return inputList;
    }


    public static boolean isOdd(Integer input) {
        return input % 2 != 0;
    }

    public static Predicate<Integer> oddValues() {
        return input -> input % 2 != 0;
    }

    public Function<Integer, Integer> transform() {
        return i -> i * 2;
    }

    public static Integer transformMethod(Integer input) {
        return input * 2;
    }

    private void calculate(List<Integer> inputList, Function<Integer, Integer> transform) {
        List outputList = inputList.stream()
                .map(t -> (Integer) transform.apply(t))
                //.map( t -> transformMethod(t))
                .collect(Collectors.toList());
        System.out.println("Output -->" + outputList);
    }


    public static int totalAllVal(List<Integer> values, Predicate<Integer> selector) {
        Integer result = values.stream()
                .filter(i -> selector.test(i))
                .reduce(0, (prevResult, input) -> prevResult + input);

        System.out.println("Output of totalAllVal-->" + result);
        return result;
    }
}
