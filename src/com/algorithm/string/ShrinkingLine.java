package com.algorithm.string;

import java.util.ArrayList;
import java.util.List;

public class ShrinkingLine {

    public static int minimize(List<Integer> point, int k) {
        // Write your code here
        List<LinePoint> linePoints = new ArrayList<>();
        for(Integer i : point){
            LinePoint lp = new LinePoint(i,i+k,i-k);
            linePoints.add(lp);
        }
        int findMinInMax = Integer.MAX_VALUE;
        for(LinePoint lp : linePoints){
            if(lp.max < findMinInMax){
                findMinInMax = lp.max;
            }
        }
        int findMinSum = Integer.MAX_VALUE;
        for(LinePoint lp : linePoints){
            if(lp.max != findMinInMax){
                if((findMinInMax - lp.Min) < findMinSum ){
                    findMinSum = findMinInMax - lp.Min;
                }
            }
        }
        return Math.abs(findMinSum);
    }

}
class LinePoint{
    int point;
    int max;
    int Min;

    public LinePoint(int point, int max, int min) {
        this.point = point;
        this.max = max;
        Min = min;
    }
}
