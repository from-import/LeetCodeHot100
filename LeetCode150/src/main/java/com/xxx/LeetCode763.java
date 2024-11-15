package com.xxx;

import java.util.ArrayList;
import java.util.List;

public class LeetCode763 {
    /**
     * 详细解释代码逻辑：
     *
     * 假设 s = "ababcbacadefegdehijhklij"，我们来看看如何更新 end 和 start。
     *
     *     初始化：start = 0，end = 0。
     *     遍历字符串：
     *         当前位置 i 为 0，字符 a 的最后出现位置是 8，所以 end = 8。
     *         继续遍历，i = 1 时字符 b 的最后出现位置是 5，但 end 已经是 8，不变。
     *         继续遍历，i = 2 到 i = 8 期间，end 始终保持为 8，因为这些字符的最后出现位置都不超过 8。
     *         当 i == end 时（即 i == 8），说明我们找到了一个片段 [0, 8]，其长度为 8 - 0 + 1 = 9，将其加入结果列表。
     *     更新 start 和继续寻找下一个片段：
     *         将 start 更新为 i + 1 = 9，开始寻找下一个片段。
     *         从 i = 9 继续重复以上步骤，找到下一个片段。
     */

    public List<Integer> partitionLabels(String s) {
        List<Integer> partitions = new ArrayList<>();

        // 记录每个字符最后出现的位置
        int[] lastOccurrence = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }

        // 遍历字符串，确定分区
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            // 更新当前片段的结束位置
            end = Math.max(end, lastOccurrence[s.charAt(i) - 'a']);

            // 当到达当前片段的结束位置时
            if (i == end) {
                // 将当前片段的长度添加到结果
                partitions.add(end - start + 1);
                // 更新起始位置为下一个片段的开始位置
                start = i + 1;
            }
        }

        return partitions;
    }
}
