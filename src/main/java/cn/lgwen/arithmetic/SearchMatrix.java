package cn.lgwen.arithmetic;

/**
 * 2020/12/10
 * aven.wu
 * danxieai258@163.com
 * 240. 搜索二维矩阵 II
 */
public class SearchMatrix {

    public static void main(String[] args) {
        int[][] array = {
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}
        };
        new SearchMatrix().searchMatrix(array, 5);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        //从第一位开始二维搜索，遇到比目标值小就向右一定一格
        // 遇到比目标值大就向下移动一位
        int i = 0; // 横坐标
        int j = 0; // 纵坐标
        while (i < matrix.length && j < matrix[0].length) {
            int val = matrix[i][j];
            if (val == target) {
                return true;
            }
            if (val > target) {
                i--;
                j++;
            } else {
                i++;
            }
        }
        return false;
    }
}
