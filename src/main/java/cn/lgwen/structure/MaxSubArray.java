package cn.lgwen.structure;

/**
 * 2020/5/14
 * aven.wu
 * danxieai258@163.com
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int count = new MaxSubArray().maxSubArray(new int[]{3,-1,3});
        System.out.println(count);
    }

    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for(int num: nums) {
            if(sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
