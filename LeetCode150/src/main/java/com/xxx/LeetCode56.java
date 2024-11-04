package com.xxx;

import java.util.ArrayList;
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
}
