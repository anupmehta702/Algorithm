package com.java.concept.streams;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NthHighestSalary {

    public static void main(String[] args) {
        HashMap<String,Integer> inputMap = new HashMap<String, Integer>();
        inputMap.put("A", 1000);
        inputMap.put("D", 1000);
        inputMap.put("B", 3000);
        inputMap.put("C", 4000);
        inputMap.put("F", 3000);
        inputMap.put("G", 4000);

        Map<Integer, List<Map.Entry<String, Integer>>> groupedMap = inputMap.entrySet().stream()
                .collect(Collectors.groupingBy(e -> e.getValue()));

        System.out.println("groupedMap --> "+groupedMap);
        //o/p groupedMap --> {4000=[C=4000, G=4000], 3000=[B=3000, F=3000], 1000=[A=1000, D=1000]}

        Map<Integer, List<String>> NthHighestSalaryMap = inputMap.entrySet().stream()
                .collect(Collectors.groupingBy(e -> e.getValue(),
                        Collectors.mapping(e -> e.getKey(), Collectors.toList())));

        System.out.println("NthHighestSalaryMap --> "+NthHighestSalaryMap);
        //o/p groupedMap --> {4000=[C=4000, G=4000], 3000=[B=3000, F=3000], 1000=[A=1000, D=1000]}

        List<List<Map.Entry<String, Integer>>> mappingByValue = groupedMap.entrySet().stream()
                .collect(Collectors.mapping(e -> e.getValue(), Collectors.toList()));
        System.out.println("Mapping function -->"+mappingByValue);

        System.out.println("Simple mapping function" + groupedMap
                .entrySet().stream()
                .map(e -> e.getValue()).collect(Collectors.toList()));

    }

}
