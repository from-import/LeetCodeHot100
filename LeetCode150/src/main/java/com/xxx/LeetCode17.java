package com.xxx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeetCode17 {
    public static List<String> letterCombinations(String digits) {
        // 如果输入为空，直接返回空结果
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        // 数字到字母的映射
        HashMap<Character, String> phoneMap = new HashMap<>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");

        // 用于存储结果
        List<String> result = new ArrayList<>();
        // 调用回溯函数
        backTracking(0, digits, new StringBuilder(), phoneMap, result);
        return result;
    }

    private static void backTracking(
            int index,                // 当前索引
            String digits,            // 输入数字字符串
            StringBuilder path,       // 当前路径
            HashMap<Character, String> phoneMap,  // 数字到字母映射
            List<String> result       // 结果集
    ) {
        // 终止条件：路径长度等于数字字符串长度
        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }

        // 当前数字对应的字母集合
        String possibleLetters = phoneMap.get(digits.charAt(index));
        // 遍历所有字母
        for (char letter : possibleLetters.toCharArray()) {
            path.append(letter);            // 做选择
            backTracking(index + 1, digits, path, phoneMap, result); // 递归
            path.deleteCharAt(path.length() - 1); // 撤销选择
        }
    }
}
