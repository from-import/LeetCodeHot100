package com.xxx;

public class LeetCode238 {
        //假如 nums为[1,2,3,4]，那么answer的值分别为[(2,3,4),(1,3,4),(1,2,4),(1,2,3)]
        //如果吧i当前值相乘的时候看做是1那么就有如下样式
        //  1, 2, 3, 4
        //  1, 1, 3, 4
        //  1, 2, 1, 4
        //  1, 2, 3, 1
        // 他的对角线1将他们分割成了两个三角形，对于answer的元素，
        //我们可以先计算一个三角形每行的乘积，然后再去计算另外一个三角形每行的乘积，
        //然后各行相乘，就是answer每个对应的元素
        public int[] productExceptSelf(int[] nums) {
            int[] res = new int[nums.length];
            int[] mid1 = new int[nums.length]; // 左到右的前缀积
            int[] mid2 = new int[nums.length]; // 右到左的前缀积

            mid1[0] = 1;
            for(int i = 1; i < nums.length; i++){
                mid1[i] = mid1[i - 1] * nums[i];
            }

            mid2[nums.length - 1] = 1;  // 因为最后一个位置右侧没有元素，乘积为 1
            for (int i = nums.length - 2; i >= 0; i--) {
                mid2[i] = mid2[i + 1] * nums[i + 1];
            }

            for(int i = 0; i < nums.length; i++){
                res[i] = mid1[i] * mid2[i];
            }
            return res;
        }
}
