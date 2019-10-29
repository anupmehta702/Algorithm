package com.algorithm.dynamic;

public class Knapsack {

	public static void main(String[] args) {
		int[] wt= new int[]{1,3,4,5};
		int[] val=new int[]{1,4,5,7};
		System.out.println(knapsackWithoutRecursion(wt,val,7));
	}
	
	public static int knapsackWithoutRecursion(int wt[],int val[],int maxWt){
		int[][] k=new int[val.length+1][maxWt+1];
		for(int i=1;i<=val.length;i++){
			for(int j=1;j<=maxWt;j++){
				if(i==0 || j==0){
				 k[i][j]=0;	
				}
				else{
					if(j-wt[i-1]>=0){
						k[i][j]=Math.max(val[i-1]+k[i-1][j-wt[i-1]],
								k[i-1][j]);
					}else{
						k[i][j]=k[i-1][j];
					}
				}
			}
		}
		System.out.println("-->");
		for(int i=1;i<=val.length;i++){
			for(int j=1;j<=maxWt;j++){
				System.out.print(k[i][j]);	
			}
			System.out.println();
			
		}
		return k[val.length][maxWt];
	}
	
}
/* Output
-->
1111111
1145555
1145669
1145789
9
 */