package cn.lgwen.arithmetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author aven.wu
 * @Date 2020/12/29
 */
public class ThreeSum {

    public static void main(String[] args) {
        threeSum(new int[]{-1,0,1,2,-1,-4});
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        // 预留两个位子，i j
        List<List<Integer>> list = new ArrayList<>();
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) break;
            // 跳过重复的解
            if (k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum > 0) {
                    // 跳过重复
                    while(i < j && nums[j] == nums[--j]);
                } else if (sum < 0) {
                    while(i < j && nums[i] == nums[++i]);
                } else {
                    list.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    while(i < j && nums[i] == nums[++i]);
                    while(i < j && nums[j] == nums[--j]);
                }

            }
        }
        return list;
    }
}
