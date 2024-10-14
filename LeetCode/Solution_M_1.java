package ProblemSolving.LeetCode;

import java.util.*;

// 1. Two Sum (https://leetcode.com/problems/two-sum/description/)
class Solution_M_1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            map.put(nums[i], i);
        }

        return new int[] {-1, -1};
    }
}