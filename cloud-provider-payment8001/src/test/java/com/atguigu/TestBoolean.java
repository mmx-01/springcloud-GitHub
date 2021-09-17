package com.atguigu;

import org.junit.Test;

/**
 * @Author LIMENGJIE
 * @ClassName TestBoolean
 * @Date 2021/9/16 1:52 下午 2021
 */
public class TestBoolean {
    @Test
    public void TestBool () {
        String aa = "123";
        String result = null;
        if (1 > 0){
            result = aa != null ? result = "aa" : "";
        }
        System.out.println(result);
    }
}
