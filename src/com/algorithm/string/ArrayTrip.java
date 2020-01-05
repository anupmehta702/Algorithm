package com.algorithm.string;

import java.util.ArrayList;
import java.util.List;

public class ArrayTrip {

    public static void main(String[] args) {
        ArrayTrip t = new ArrayTrip();
        System.out.println("Ans-->"+t.arrayTrip(new int[]{3,4,-2,1,2},2));
        //System.out.println("Ans-->"+t.arrayTrip(new int[]{0, -3, -2, -5, -7, 1},3));
    }
    long arrayTrip(int[] arr, int k) {
      long sum = 0;
      ArrayList<Integer> elements = new ArrayList<>();
      elements.add(arr[0]);
      //sum =arr[0];
        int j=0;
        int i=1;
      while(i<arr.length){
        if(arr[i]>arr[j]){
            //sum = sum + arr[i];
            elements.add(arr[i]);
            i++;
            j++;
        }else{
            int tempSumWithoutHop = 0;
            if(j+k >= arr.length){
                elements.add(arr[i]);
                i++;
                j++;
            }else {
                List<Integer> tempIntList = new ArrayList<>();
                for (int x = j; x < k; x++) {
                    tempSumWithoutHop = tempSumWithoutHop + arr[x];
                    tempIntList.add(arr[x]);
                }
                if (tempSumWithoutHop > arr[j] + arr[j + k]) {
                    elements.addAll(tempIntList);
                } else {
                    elements.add(arr[j + k]);
                    j = j + k;
                    i = j + 1;
                }
            }
        }
      }
        System.out.println("Elements -->");
      for(int w : elements){
          System.out.print(" "+w);
          sum = sum +w;
      }
        System.out.println("");
      return sum;
    }
}
