package cn.lgwen.arithmetic;

import java.util.Arrays;

/**
 * @Author aven.wu
 * @Date 2021/1/5
 * 31. 下一个排列
 */
public class NextPermutation {
    public static void main(String[] args) {
        int[] array = new int[]{1,3,2};
        new NextPermutation().nextPermutation(array);
        System.out.println(Arrays.toString(array));
    }

    public void nextPermutation(int[] nums) {
        // 从右往左，找到第一个(首位) n < n+1 的数进行交换。 总体就会字典序增加
        int len = nums.length;
        for(int n = len - 1; n > 0; n --) {
            if (dictLess(nums[n - 1], nums[n])) {
                //swap(nums, n - 1, n);
                // 定位当前位置 n - 1 然后从 n -1 -> len 中找出最小的
                int minIndex = n - 1;
                // 从后往前 再找出另一个最大索引 l 满足 nums[l] > nums[n - 1]
                for (int j = len - 1; j >= n ; j--) {
                    if (nums[minIndex] < nums[j]) {
                        minIndex = j;
                        break;
                    }
                }
                swap(nums, minIndex, n - 1);
                // 翻转 n -> len
                int a = n, b = len - 1;
                while (a < b) {
                    swap(nums, a++, b--);
                }
                return ;
            }
        }
        // 如果运行到这来说明是倒序，则反过来即可
        for (int j = 0; j < len / 2; j++) {
            swap(nums, j, len - 1 - j);
        }
    }

    // 返回a 字典序 小于b
    private boolean dictLess(int a, int b) {
        return a < b;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
