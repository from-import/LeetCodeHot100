package com.xxx;

public class LeetCode4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            // make sure the shortest nums always nums1
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int length1 = nums1.length;
        int length2 = nums2.length;

        // Regardless of odd or even, the median is on the left
        int half = (length1 + length2 + 1) / 2;

        //  0 <= cut1 <= length1
        // 0 <= cut2 <= length2
        // cut1 + cut2 = half;
        // half - length2 <= cut1 <= half

        int left = Math.max(0, half - length2);
        int right = Math.min(length1, half);
        int middle = left + (right - left) / 2;

        int cut1 = middle;
        int cut2 = half - middle;
        int cut1Left = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
        int cut1Right = cut1 == length1 ? Integer.MAX_VALUE : nums1[cut1];
        int cut2Left = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];
        int cut2Right = cut2 == length2 ? Integer.MAX_VALUE : nums2[cut2];

        while (left <= right) {
            middle = left + (right - left) / 2;
            cut1 = middle;
            cut2 = half - cut1;

            cut1Left = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            cut1Right = cut1 == length1 ? Integer.MAX_VALUE : nums1[cut1];
            cut2Left = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];
            cut2Right = cut2 == length2 ? Integer.MAX_VALUE : nums2[cut2];

            // Assuming the two arrays have been merged
            int leftMax = Math.max(cut1Left, cut2Left);
            int rightMin = Math.min(cut1Right, cut2Right);
            if (leftMax <= rightMin) {
                break;
            }

            // left is bigger
            if (cut1Left > cut2Right) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        int leftMax = Math.max(cut1Left, cut2Left);
        int rightMin = Math.min(cut1Right, cut2Right);
        // check odd or even
        if ((length1 + length2) % 2 == 0) {
            // median do not exist
            return (leftMax + rightMin) / 2.0;
        } else {
            return leftMax;
        }


    }
}
