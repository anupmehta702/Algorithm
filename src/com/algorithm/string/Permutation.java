package com.algorithm.string;

public class Permutation {
    public static void main(String[] args) {
        char[] input = new char[] {'A','B','C'};
        findPermutation(0,input.length-1,input);

        char[] input1 = new char[] {'A','B','C','D'};
        findPermutation(0,input1.length-1,input1);
    }

    public static void findPermutation(int l ,int r,char[] input){
        if(l==r){
           print(input);
        }
        for(int i = l ;i <= r;i++){
            swap(l,i,input);
            findPermutation(l+1,r,input);
            swap(i,l,input);
        }
    }
    public static void swap(int l,int i,char[] input){
        char temp = input[l];
        input[l]= input[i];
        input[i]=temp;
    }

    public static void print(char[] input){
        for(char c : input){
            System.out.print(" "+c+" ");
        }
        System.out.println();
    }
}
/* Output
 A  B  C
 A  C  B
 B  A  C
 B  C  A
 C  B  A
 C  A  B

 A  B  C  D
 A  B  D  C
 A  C  B  D
 A  C  D  B
 A  D  C  B
 A  D  B  C
 B  A  C  D
 B  A  D  C
 B  C  A  D
 B  C  D  A
 B  D  C  A
 B  D  A  C
 C  B  A  D
 C  B  D  A
 C  A  B  D
 C  A  D  B
 C  D  A  B
 C  D  B  A
 D  B  C  A
 D  B  A  C
 D  C  B  A
 D  C  A  B
 D  A  C  B
 D  A  B  C

 */