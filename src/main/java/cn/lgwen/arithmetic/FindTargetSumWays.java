package cn.lgwen.arithmetic;

/**
 * 2021/1/16
 * aven.wu
 * danxieai258@163.com
 */
public class FindTargetSumWays {

    public static void main(String[] args) {
        new FindTargetSumWays().findTargetSumWays(
                new int[]{1,1}, 0);
    }

    private int value = 0;

    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums, 0, 0, S);
        return value;
    }

    void dfs(int[] nums, int ids, int curren, int S) {
        if (ids == nums.length) {
            if (curren == S)
                value++;
            return;
        }
        dfs(nums, ids+1, curren + nums[ids], S);
        dfs(nums, ids+1, curren - nums[ids], S);
    }
}
