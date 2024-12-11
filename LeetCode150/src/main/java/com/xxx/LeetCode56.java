package com.xxx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode56 {

    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        int left = intervals[0][0];
        int right = intervals[0][intervals[0].length - 1];

        for (int i = 1; i < intervals.length; i++) {
            int farLeftNow = intervals[i][0];
            int farRightNow = intervals[i][1];

            if (farLeftNow <= right) {
                // 拓展右边界
                right = Math.max(right, farRightNow);
            } else {
                // 边界出现断层，新建数组
                res.add(new int[] {left, right});
                left = farLeftNow;
                right = farRightNow;
            }
        }

        // 添加最后一个区间
        res.add(new int[] {left, right});
        return res.toArray(new int[res.size()][]);
    }

    public int[][] merge2(int[][] intervals) {
        // 按区间起点排序
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();

        // 初始化合并区间的左右边界
        int left = intervals[0][0];
        int right = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            // 发生区间重叠
            if (intervals[i][0] <= right) {
                right = Math.max(right, intervals[i][1]);
            }
            else {
                // 如果没有重叠，保存当前合并区间，并更新左右边界
                res.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            }

        }
        // 最后一个区间需要加入结果
        res.add(new int[]{left, right});

        return res.toArray(new int[res.size()][]);
    }
}
