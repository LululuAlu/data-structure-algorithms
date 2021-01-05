package cn.lgwen.structure;

import org.junit.Test;

import java.util.HashMap;

/**
 * @Author aven.wu
 * @Date 2021/1/5
 */
public class Map {

    @Test
    public void resize() {
        HashMap<Integer, Integer> map = new HashMap<>(8, 0.5f);
        map.put(0, 1);
        map.put(2, 1);
        map.put(3, 1);
        map.put(4, 1);

        map.put(10, 1);
        map.put(9, 1);
        map.put(11, 1);
        map.put(12, 1);
    }
}
