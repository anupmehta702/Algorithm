package com.algorithm.string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacter {
    public static void main(String[] args) {
       System.out.println("max length-->"+lengthOfLongestSubstring("pwwkew"));//ans - 3 (wke)
       System.out.println("max length-->"+lengthOfLongestSubstring("dvdf"));// ans - 3(vdf)
       System.out.println("max length-->"+lengthOfLongestSubstring("anviaj")); // ans - 5(nviaj)
    }
    public static int lengthOfLongestSubstring(String s) {
        if(s.length()<=1)
            return s.length();
        char[] inputArr = s.toCharArray();
        int i = 1;
        int j = 0;
        int curLen = 1;
        int max = curLen;
        Map<Character, Integer> charToIndexMap = new HashMap<Character, Integer>();
        charToIndexMap.put(inputArr[0], 0);
        while (i < inputArr.length) {
            if (!charToIndexMap.containsKey(inputArr[i]) || charToIndexMap.get(inputArr[i]) < j) {
                curLen=Math.max(curLen+1,(i-j)+1);
                charToIndexMap.put(inputArr[i], i);
                i++;
            } else {
                j++;
                if (curLen > max) {
                    max = curLen;
                }
                curLen = 1;
            }

            if (j == i) {
                charToIndexMap.put(inputArr[i], i);
                i++;
            }
        }
        return curLen > max ? curLen : max;
    }

}

