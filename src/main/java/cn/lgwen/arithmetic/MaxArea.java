package cn.lgwen.arithmetic;

/**
 * 2020/12/2
 * aven.wu
 * danxieai258@163.com
 * 11. 盛最多水的容器
 */
public class MaxArea {

    public static void main(String[] args) {
        new MaxArea().maxArea(new int[]{1,8,6,2,5,4,8,3,7});
    }

    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;

        int max = 0;
        while (start <= end) {
            int i = Math.min(height[start], height[end]) * (end - start);
            max = Math.max(max, i);

            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return max;
    }
}
