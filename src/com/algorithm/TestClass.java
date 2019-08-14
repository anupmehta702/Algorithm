package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestClass {

    public static void main(String[] args) {
        String[] inputArr = getInput();

    }

    public static String[] getInput() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String firstInput = br.readLine();                // Reading input from STDIN
            String[] inputArr = br.readLine().split(" ");
            return inputArr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}

