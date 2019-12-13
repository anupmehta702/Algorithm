package com.algorithm.string;

import java.util.HashMap;
import java.util.Map;

public class TwoSumEqualToTarget {
    public static void main(String[] args) {
        SolutionForTwoSum soln = new SolutionForTwoSum();
        int[] pair = new int[2];
        pair=soln.twoSum(new int[]{2,7,11,15},9);
        System.out.println("--> [ "+pair[0]+" , "+pair[1]+" ]");
        pair=soln.twoSum(new int[]{3,2,4},6);
        System.out.println("--> [ "+pair[0]+" , "+pair[1]+" ]");
        pair=soln.twoSum(new int[]{3,3},6);
        System.out.println("--> [ "+pair[0]+" , "+pair[1]+" ]");
        pair=soln.twoSum(new int[]{0,4,3,0},0);
        System.out.println("--> [ "+pair[0]+" , "+pair[1]+" ]");
    }
}

class SolutionForTwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length ; i++){
            map.put(nums[i],i);
        }//adding this initially ensures i dont have to do sorting among the pairs
        for(int i = 0 ; i < nums.length ; i++){
            int required = target - nums[i];
            if(map.containsKey(required) && map.get(required) != i){
                return new int[]{i,map.get(required)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    public int[] twoSumMyImpl(int[] nums, int target) {
        int[] soln = new int[2]; //cannot have soln array bcoz it initializes it with 0 ,it might be misintrepreted for answer being 0,0
        int[] requiredArr = new int[target];//cannot use array since size of array unknown ,use hashmap instead
        for(int i = 0 ; i < requiredArr.length ; i++){
            requiredArr[i] = -1;
        }
        for(int i = 0 ; i < nums.length ; i++){
            int required = target - nums[i];
            if(requiredArr[nums[i]] == -1 ) requiredArr[nums[i]] = i;
            if(requiredArr[required] != -1 && requiredArr[required] != i){
                if(i < requiredArr[required] ){
                    soln[0] = i;
                    soln[1] = requiredArr[required];
                    return soln;
                }else{
                    soln[1] = i;
                    soln[0] = requiredArr[required];
                    return soln;
                }

            }
        }
        return soln;

    }


}
/*Algo
create a map of all elements and it's index
find the required number required to meet the target .
search the required field in map if present and return solution.
Test for examples - [2,7,11,15], 9 --> 0,1
                    [3,2,4] , 6 --> 1,2
                    [3,3] ,6 --> 0,1
                    [0,4,3,0],0 --> 0,3

*/
