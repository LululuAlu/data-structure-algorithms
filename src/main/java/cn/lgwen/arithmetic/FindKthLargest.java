package cn.lgwen.arithmetic;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 2021/1/18
 * aven.wu
 * danxieai258@163.com
 */
public class FindKthLargest {
    public static void main(String[] args) {
        new FindKthLargest().findKthLargest(new int[]{3,2,1,5,6,4}, 2);
    }

    public int findKthLargest(int[] nums, int k) {
        if(nums.length < k || k <= 0) return 0;

        Queue<Integer> queue = new PriorityQueue<>();

        for(int x : nums)
        {
            if (queue.size() < k) {
                queue.add(x);
            } else {
                if (queue.peek() < x) {
                    queue.poll();
                    queue.add(x);
                }
            }
        }
        return queue.poll();

    }
}
