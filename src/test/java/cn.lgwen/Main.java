package cn.lgwen;

import org.junit.Test;
import sun.security.acl.WorldGroupImpl;

import java.util.*;

/**
 * 2020/5/8
 * aven.wu
 * danxieai258@163.com
 */
public class Main {
    public static void main(String[] args) {
        int[] arys = new int[]{0,0,1,1,1,2,2,3,3,4};
        int res = removeDuplicates(arys);
        System.out.println("length " + res);
        for (int ars : arys) {
            System.out.println(ars);
        }
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        } else if (nums.length <= 1) {
            return nums.length;
        }
        int p = 0;
        int q = 1;
        while (q < nums.length) {
            if (nums[p] != nums[q]) {
                nums[++p] = nums[q];
            }
            q++;
        }
        return ++p;
    }

    @Test
    public void test() {
        permute(new int[]{1,2,3});
    }

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        boolean[] use = new boolean[len];
        def(nums, use, len, 0, res, new ArrayList<>());

        //dfs(nums, len, 0, new ArrayList<>(), use, res);
        return res;

    }

    void def(int[] nums, boolean[] use, int len, int start, List<List<Integer>> res, List<Integer> list) {
        if (start == len) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (use[i]) continue;
            list.add(nums[i]);
            use[i] = true;
            def(nums, use, len, start+1, res, list);
            // 重置状态
            use[i] = false;
            list.remove(list.size() - 1);
        }
    }

    private void dfs(int[] nums, int len, int depth,
                     List<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        if (depth == len) {
            res.add(path);
            return;
        }

        // 在非叶子结点处，产生不同的分支，这一操作的语义是：在还未选择的数中依次选择一个元素作为下一个位置的元素，这显然得通过一个循环实现。
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;

                dfs(nums, len, depth + 1, path, used, res);
                // 注意：下面这两行代码发生 「回溯」，回溯发生在从 深层结点 回到 浅层结点 的过程，代码在形式上和递归之前是对称的
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
