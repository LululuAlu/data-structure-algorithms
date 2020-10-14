package cn.lgwen.arithmetic;

/**
 * @author aven danxieai@163.com
 * @version 0.1
 * @date 2020/7/16
 */
public class SortedArrayToBST {


    public static void main(String[] args) {
        int[] num = new int[]{-10,-3,0,5,9};
        TreeNode treeNode = new SortedArrayToBST().sortedArrayToBST(num);
        System.out.println(treeNode);
    }

    public TreeNode sortedArrayToBST(int[] num) {
        if (num.length == 0) {
            return null;
        }
        if (num.length == 1) {
            return new TreeNode(num[0]);
        }
        return tst(num, 0, num.length - 1);
    }

    public TreeNode tst(int[] num, int start, int end) {
        if (start > end) {
            return null;
        }
        int middle = (start + end) / 2;
        TreeNode treeNode = new TreeNode(num[middle]);
        treeNode.left = tst(num, start, middle - 1);
        treeNode.right = tst(num, middle + 1, end);
        return treeNode;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}


