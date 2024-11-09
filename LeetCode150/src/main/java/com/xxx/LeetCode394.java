package com.xxx;

import java.util.Stack;

public class LeetCode394 {
    /**
     * 如果遇到数字：继续读取，直到数字结束，然后转换为整数表示重复次数 k。
     * 如果遇到 [：将当前的数字 k 和当前构建的字符串压入栈，并开始新的字符串构建。
     * 如果遇到字母：将其加入当前的字符串构建中。
     * 如果遇到 ]：弹出栈中的重复次数 k 和上一个构建的字符串，将当前的字符串重复 k 次，并将其附加到上一个字符串后面。
     */
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // 如果是数字，构建 k
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                // 遇到 '[' 时，将当前数字 k 和当前字符串压入栈
                countStack.push(k);
                stringStack.push(currentString);
                currentString = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                // 遇到 ']' 时，弹出栈中的重复次数和之前的字符串
                int repeatTimes = countStack.pop();
                StringBuilder decodedString = stringStack.pop();
                // 将当前字符串重复 k 次并追加到之前的字符串
                for (int i = 0; i < repeatTimes; i++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                // 如果是字母，将其追加到当前字符串
                currentString.append(c);
            }
        }
        return currentString.toString();
    }

}
