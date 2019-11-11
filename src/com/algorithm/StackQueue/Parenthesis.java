package com.algorithm.StackQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Parenthesis {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.isValid("([])");
        s.isValid("((");
        s.isValid("(){");
        s.isValid("(");
        s.isValid("");
    }
}

class Solution {

    public boolean isValid(String s) {
        if (s.length() <= 1) {
            //for input "" , "("
            return s == null || s.length() == 0 ? true : false;
        }
        Map<Character, Character> closeChar = new HashMap<>();
        closeChar.put(')', '(');
        closeChar.put(']', '[');
        closeChar.put('}', '{');
        char[] inputCharArray = s.toCharArray();
        Stack stack = new Stack();
        for (int i = 0; i < inputCharArray.length; i++) {
            if (closeChar.containsKey(inputCharArray[i])) {
                if (!stack.isEmpty() && closeChar.get(inputCharArray[i]).equals(stack.peek())) {
                    //!stack.isEmpty() is for "){"
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(inputCharArray[i]);
            }

        }
        //return true;
        return stack.isEmpty() ? true : false; //for input "(){"
    }
}

