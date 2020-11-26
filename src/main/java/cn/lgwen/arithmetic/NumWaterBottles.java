package cn.lgwen.arithmetic;

/**
 * @author aven danxieai@163.com
 * @version 0.1
 * @date 2020/11/22
 */
public class NumWaterBottles {

    public static void main(String[] args) {
        new NumWaterBottles().numWaterBottles(15, 4);
    }

    public int numWaterBottles(int numBottles, int numExchange) {
        int current = numBottles;
        int cut = 0;
        // 剩余空瓶
        int surplus = 0;
        while(current >= numExchange) {
            cut += current;
            // 可以再换几瓶
            int a =  current / numExchange;//3

            // 之前剩下的瓶子 + 加喝完一轮不够倍数的瓶子
            int b =  current % numExchange + surplus; // 3

            surplus = b % numExchange; // 0
            // 使用空瓶换来的
            current = a + b / numExchange; // 3
        }
        return cut + current + surplus / numExchange;
    }
}
