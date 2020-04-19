package com.hackerEarth;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ElevatorProblem {
    public static void main(String[] args) {
        System.out.println("output--> "+ getMinimumTravelTime("2,7,3"));//12
        System.out.println("output--> "+ getMinimumTravelTime("1,3,4"));//8
        System.out.println("output--> "+ getMinimumTravelTime("10,10,10,10,10"));//70

    }
    public static int getMinimumTravelTime(String weightsOfPeople) {
        System.out.println("weightOfPeople-->"+weightsOfPeople);
        String[] inputArr = weightsOfPeople.split(",");
        List<Integer> inputList=Arrays.stream(inputArr).map(s->Integer.parseInt(s)).sorted().collect(Collectors.toList());
        System.out.println("input list -->"+inputList);
        int sum = 0 ;
        for(Integer in : inputList){
            sum = sum +in;
        }
        sum  = sum - inputList.get(0) + (inputList.size()-2)*inputList.get(0);

        return sum;
    }
}
