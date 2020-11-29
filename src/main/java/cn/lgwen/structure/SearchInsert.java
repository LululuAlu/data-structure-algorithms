package cn.lgwen.structure;

/**
 * 2020/5/14
 * aven.wu
 * danxieai258@163.com
 */
public class SearchInsert {

    public static void main(String[] args) {
        int[] arys = new int[]{1,3};

        int res = new SearchInsert().searchInsert(arys, 2);
        System.out.println(res);
    }

    public int searchInsert(int[] nums, int target) {
        int i = 0;
        if (nums[0] >= target) {
            return 0;
        }
        for(;i < nums.length; i++) {
            if (target <= nums[i]) {
                return i;
            }
        }
        return i;
    }
}
