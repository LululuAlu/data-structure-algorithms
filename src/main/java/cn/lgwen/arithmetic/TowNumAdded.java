package cn.lgwen.arithmetic;

import java.util.HashMap;
import java.util.Map;

/**
 * 2020/4/21
 * aven.wu
 * danxieai258@163.com
 */
public class TowNumAdded {


    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{3,3}, 6);
        for (int i :ints) {
            System.out.println(i);
        }
    }

    private static int[] idx(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0 ; i < nums.length; i++) {
            if (numMap.containsKey(target - nums[i])) {
                return new int[]{numMap.get(target - nums[i]), i};
            }
            numMap.put(nums[i], i);
        }
        throw new RuntimeException("no solution");
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
