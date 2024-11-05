package com.xxx;

import java.util.HashMap;

public class LeetCode287 {
    public int findDuplicate(int[] nums) {
        int length = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            if(map.getOrDefault(num , 0) == 1){
                return num;
            }
            map.put(num, 1);
        }
        return 0;
    }

    public int findDuplicate2(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j<nums.length; j++){
                if(nums[i] == nums[j]){
                    return nums[i];
                }
            }
        }
        return 0;
    }

    public int findDuplicate3(int[] nums) {
        int fast = nums[0];
        int slow = nums[0];
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);
        fast = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
