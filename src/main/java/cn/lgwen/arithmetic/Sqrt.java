package cn.lgwen.arithmetic;

/**
 * 2020/5/21
 * aven.wu
 * danxieai258@163.com
 * 求平方根
 */
public class Sqrt {

    public static void main(String[] args) {
        System.out.println(new Sqrt().mySqrt(1));
        System.out.println(new Sqrt().mySqrt(2));
        System.out.println(new Sqrt().mySqrt(3));
        System.out.println(new Sqrt().mySqrt(9));
        System.out.println(new Sqrt().mySqrt(16));
    }

    public int mySqrt(int x) {
        // 二分法查找平方根
        int left = 0;
        int right = x / 2 + 1;
        while (left < right) {
            // 向右取证
            int mid = (left + right + 1) / 2;
            if (mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return Math.min(left, right);
    }
}
