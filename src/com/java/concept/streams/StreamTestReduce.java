package com.java.concept.streams;

import java.util.Arrays;
import java.util.List;

public class StreamTestReduce {

    public static void main(String[] args) {
        Integer[] inputArr = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        List<Integer> inputList = Arrays.asList(inputArr);
        inputList.stream().reduce(100, StreamTestReduce::process);//128
        System.out.println(inputList.stream().reduce(100, Integer::min));//1
        System.out.println(Arrays.asList("str1", "str2")
                .parallelStream()
                .reduce(0,
                        (parResult, input) -> parResult + input.length(),
                        StreamTestReduce::combiner));

        User[] users = new User[]{new User("Anup", 34), new User("Randeep", 30)};

        System.out.println("Sum of ages -->" +
                Arrays.asList(users)
                        .stream()
                        .reduce(0, (partialAge, user) -> partialAge + user.age
                                , (partialAge1, PartialAge2) -> {
                                    System.out.println("In combiner for user");
                                    return partialAge1 + partialAge1;
                                })
        );

    }

    private static Integer combiner(Integer a, Integer b) {
        System.out.println("In combiner");
        return a + b;
    }


    private static Integer process(Integer initialValue, Integer input) {
        System.out.println("Initial value -->" + initialValue);
        input = initialValue + input;
        System.out.println("New Input -->" + input);
        return input;
    }


}

class User {
    String name;
    public Integer age;

    public User(String name, int age) {
        this.age = age;
        this.name = name;
    }
}