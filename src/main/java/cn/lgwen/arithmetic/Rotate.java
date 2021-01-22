package cn.lgwen.arithmetic;

/**
 * 2020/12/19
 * aven.wu
 * danxieai258@163.com
 */
public class Rotate {

    public void rotate(int[][] matrix) {
        // x先以对角线进行翻转

        // i 表示纵坐标，j表示横坐标
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (j > i) { // 需要进行交换的位置,对角线交换
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = tmp;
                }
            }
        }

        // 再每行进行中轴线线进行翻转
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <= matrix.length / 2; j++) {
                // 需要进行交换的位置,对角线交换
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - i];
                matrix[i][j] = tmp;
            }
        }
    }
}
