package cn.lgwen.structure;

/**
 * 2020/5/12
 * aven.wu
 * danxieai258@163.com
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] ints = new int[]{0,1,2,2,3,0,4,2};
        System.out.println(new RemoveElement().removeElement(ints, 2));
        int[] int1 = new int[]{3,2,2,3};
        System.out.println(new RemoveElement().removeElement(int1, 3));
    }

    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        int idx = 0; // 标记当前新数组的处理数据下标
        for(int i = 0; i < length; i++) {
            if (nums[i] != val) {
                if (i == idx) {
                    // 当前下标等于新数组的下标
                    idx++;
                    continue;
                }
                nums[idx++] = nums[i];
            }
        }
        return idx;
    }
}
