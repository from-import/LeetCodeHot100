package com.xxx;

import java.util.Stack;

public class LeetCode84 {
    // 方法1 采用逐层高度遍历的方式，以每一层为基础来计算可以形成的矩形面积
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 1){
            return heights[0];
        }
        int maxHeight = 0;
        for (int height : heights) {
            maxHeight = Math.max(maxHeight, height);
        }
        int maxArea = 0;
        int res = maxArea;
        for (int i = 1; i <= maxHeight; i++){
            // i 代表目前维护的高度
            maxArea = 0;
            for (int j = 0; j < heights.length; j++) {
                if (heights[j] >= i) {
                    maxArea += i;
                }
                else if (heights[j] < i) {
                    res = Math.max(res, maxArea);
                    maxArea = 0;
                }
            }
            res = Math.max(res, maxArea);
        }
        return res;
    }

    // 方法2 单调栈
    public int largestRectangleArea2(int[] heights) {
        int maxArea = 0;
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= n; i++) {
            int currentHeight = (i == n) ? 0 : heights[i];  // 在最后添加一个高度为 0 的柱子
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];  // 弹出栈顶柱子
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;  // 计算宽度
                maxArea = Math.max(maxArea, height * width);  // 更新最大面积
            }
            stack.push(i);  // 将当前柱子索引入栈
        }

        return maxArea;
    }
}
