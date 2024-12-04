package com.xxx;

import java.util.*;

public class LeetCode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        // 排序后去重
        Arrays.sort(nums);
        List<List<Integer>> finalTarget = new ArrayList<>();
        Set<List<Integer>> uniqueTriplets = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            List<List<Integer>> twoSumResults = twoSum(nums, i + 1, -nums[i]);
            for (List<Integer> pair : twoSumResults) {
                // 组成三元组
                List<Integer> triplet = new ArrayList<>();
                triplet.add(nums[i]);          // 第一个数字
                triplet.add(pair.get(0));      // 二元组的第一个数字
                triplet.add(pair.get(1));      // 二元组的第二个数字
                uniqueTriplets.add(triplet);   // 将排序后的三元组加入 Set 去重
            }

        }
        // 将去重后的结果转为 List
        finalTarget.addAll(uniqueTriplets);
        return finalTarget;
    }

    // 即使找到了一对解，后续也可能有其他解
    public List<List<Integer>> twoSum(int[] nums, int start, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> results = new ArrayList<>();

        for (int i = start; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                // 找到一对符合条件的元素
                results.add(Arrays.asList(nums[i], target - nums[i]));
            } else {
                // 保存 target - nums[i] 到 map 中
                map.put(target - nums[i], i);
            }
        }
        return results;
    }
}
