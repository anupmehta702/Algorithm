package com.algorithm.dynamic;

public class LongestIncreasingSubsequence {

	public int[] input1=new int[]{3,4,-1,0,6,2,3};
	int input[] = {23,10,22,5,33,8,9,21,50,41,60,80,99, 22,23,24,25,26,27};
    int[] output= {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
	
	public void findLongestIncreasingSubsequence(){
		int i=1;
		int j=0;
		while(i<input.length){
			if(input[i]>input[j]){
				output[i]=Math.max(output[i], output[j]+1);
			}
			j++;
			if(j==i){
				i++;j=0;
			}
		}
		System.out.println("output -->");
		int soln=output[0];		
		for(int k=0;k<output.length;k++){
			if(soln<output[k]){
				soln=output[k];
			}
			System.out.print(" "+output[k]);
		}
		System.out.println(" Final answer -->"+soln);
	}
	public static void main(String[] args) {
		LongestIncreasingSubsequence sub =new LongestIncreasingSubsequence();
		sub.findLongestIncreasingSubsequence();
	}
}
/*Output
output -->
 1 1 2 1 3 2 3 4 5 5 6 7 8 5 6 7 8 9 10 Final answer -->10
 */