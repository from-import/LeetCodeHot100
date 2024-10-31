package com.xxx;

import java.util.Arrays;

/**
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，
 * 其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * nums1 = [1,2,3,0,0,0]
 * nums2 = [2,5,6]
 */

public class LeetCode88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        for(int i = m;i<nums1.length;i++){
                nums1[i] = nums2[j];
                j++;
            }
        Arrays.sort(nums1);
        System.out.println(nums1);

    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] sorted = new int[m + n];
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
            // p1 + p2 表示已经处理了多少个元素（包括当前元素）。
        }
        for (int i = 0; i != m + n; ++i) {
            nums1[i] = sorted[i];
        }
    }

    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0;
        int p2 = 0;
        int res;
        int[] result =new int[m+n];
        while(p1 < m || p2 < n){
            res = 0;
            if(p1 == m){
                res = nums2[p2++];
            }else if(p2 == n){
                res = nums1[p1++];
            }
            else if(nums1[p1] < nums2[p2]){
                res = nums1[p1++];
            }else if(nums1[p1] >= nums2[p2]){
                res = nums2[p2++];
            }
            result[p1 + p2 -1] = res;
        }
    }


}
