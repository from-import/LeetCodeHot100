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

    // 基于扫描线的方法
    public int[][] merge3(int[][] intervals) {
        // 1. 找到所有区间的最大右边界
        int max = 0;
        for (int[] nums : intervals) {
            max = Math.max(max, nums[1]); // 更新最大右边界
        }

        // 2. 创建一个结果列表用于存储合并后的区间
        List<int[]> res = new ArrayList<>();

        // 3. 创建扫描线数组，大小为 max * 2 + 2，初始化为 0
        // 倍数扩展是为了避免小数运算和边界冲突
        int[] sum = new int[max * 2 + 2];

        // 4. 遍历区间，记录每个区间的起点和终点
        for (int[] nums : intervals) {
            sum[nums[0] * 2]++;          // 起点位置加 1，表示区间开始
            sum[nums[1] * 2 + 1]--;      // 终点的下一个位置减 1，表示区间结束
        }

        // 5. 计算前缀和，用于统计每个位置上区间的重叠数
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i] + sum[i - 1];
        }

        // 6. 遍历前缀和数组，合并区间
        int j = Integer.MAX_VALUE; // 记录当前区间的起点
        for (int i = 0; i < sum.length; i++) {
            if (sum[i] > 0 && j == Integer.MAX_VALUE) {
                // 区间开始：记录起点
                j = i;
            } else if (sum[i] == 0 && j != Integer.MAX_VALUE) {
                // 区间结束：记录终点并将区间加入结果
                res.add(new int[]{j / 2, i / 2}); // 恢复原始坐标
                j = Integer.MAX_VALUE; // 重置起点标记
            }
        }

        // 7. 将结果列表转换为二维数组并返回
        return res.toArray(new int[res.size()][2]);
    }
}
