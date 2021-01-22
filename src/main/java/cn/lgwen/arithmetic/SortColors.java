package cn.lgwen.arithmetic;

/**
 * @Author aven.wu
 * @Date 2021/1/13
 */
public class SortColors {
    public static void main(String[] args) {
        new SortColors().sortColors(new int[]{2,0,2,1,1,0});
    }

    public void sortColors(int[] nums) {
        // 使用双指针定义
        // [0,left] = 0
        // [right, len] = 2
        // (left, right) = 1

        int left = 0, right = nums.length - 1;
        for (int i = 0; i <= right; i++) {
            while (i <= right && nums[i] == 2) {
                swap(nums, i, right);
                right--;
            }
            while (i <= right && nums[i] == 0) {
                swap(nums, i, left);
                left++;
            }
            // 1 如何处理？
        }

    }

    private void swap (int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
