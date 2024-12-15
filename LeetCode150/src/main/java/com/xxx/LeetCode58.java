package com.xxx;

public class LeetCode58 {
    public int lengthOfLastWord(String s) {
        char[] string = s.toCharArray();
        int res = 0;
        boolean flag = false;
        for (int i = string.length - 1; i >= 0; i--) {
            if (flag) {
                if (string[i] != ' ') {
                    res++;
                }
                else{
                    break;
                }
            }
            if (string[i] != ' ' && flag == false) {
                res++;
                flag = true;
            }

        }
        return res;
    }
}
