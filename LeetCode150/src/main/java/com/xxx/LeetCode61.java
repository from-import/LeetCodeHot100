package com.xxx;

import java.util.Arrays;

public class LeetCode61 {
    public int firstMissingPositive(int[] nums) {
        int[] res = new int[100001];
        // 将 `nums` 中的正整数标记在 `res` 中
        for (int num : nums) {
            if (num > 0 && num < 100001) {
                res[num] = 1;  // 标记该位置，表示该正整数存在
            }
        }
        for(int i = 1; i < res.length; i++){
            if(res[i] == 0){
                return i;
            }
        }
        return 100001;
        // test
    }

    public static void main(String[] args) {
        LeetCode61 leetCode61 = new LeetCode61();
        System.out.println("hello world");
    }
}
