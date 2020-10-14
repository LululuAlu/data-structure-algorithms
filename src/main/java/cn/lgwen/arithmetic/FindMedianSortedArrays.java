package cn.lgwen.arithmetic;

/**
 * @author aven danxieai@163.com
 * @version 0.1
 * @date 2020/9/5
 * 寻找两个正序数组的中位数
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/submissions/
 */
public class FindMedianSortedArrays {


    public static void main(String[] args) {
        int[] ary1 = new int[]{1,3};
        int[] ary2 = new int[]{2,4};
        double res = new FindMedianSortedArrays().findMedianSortedArrays(ary1, ary2);
        System.out.println(res);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int[] mergeArray = merge(nums1, nums2, length / 2);
        if (length % 2 > 0) {
            // 基数，则中位数是直接取值即可
            int idx = length/2;
            return mergeArray[idx];
        } else {
            int idx = length/2;
            // 并且取数据的时候要取 (idx - 1 + idx) / 2
            return (mergeArray[idx - 1] + mergeArray[idx]) / 2.0;
        }
    }

    // 不需要所有多排完序
    public int[] merge(int[] nums1, int[] nums2, int length) {
        int[] newArray = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int idx = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                newArray[idx++] = nums1[i];
                i++;
            } else {
                newArray[idx++] = nums2[j];
                j++;
            }
        }
        if (i < nums1.length) {
            for (; i < nums1.length;) {
                newArray[idx++] = nums1[i++];
            }
        }
        if (j < nums2.length) {
            for (; j < nums2.length;) {
                newArray[idx++] = nums2[j++];
            }
        }
        return newArray;
    }
}
