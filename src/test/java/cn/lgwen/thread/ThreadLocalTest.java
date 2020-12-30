package cn.lgwen.thread;

import org.junit.Test;

/**
 * 2020/11/27
 * aven.wu
 * danxieai258@163.com
 */
public class ThreadLocalTest {


    private ThreadLocal<String> stringValue;

    private ThreadLocal<Integer> integerValue;

    @Test
    public void test() {
        stringValue.set("aaa");
        integerValue.set(1);
    }
}
