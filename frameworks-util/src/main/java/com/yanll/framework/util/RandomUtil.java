package com.yanll.framework.util;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: YANLL
 * Date: 14-3-29
 * Time: 上午12:21
 * To change this template use File | Settings | File Templates.
 */
public class RandomUtil {

    /**
     * 六位长度随机整数
     *
     * @return
     */
    public static int random(int... ii) {
        Random random = new Random();
        Integer i = new Integer(random.nextInt(900000) + 100000);
        return i;
    }

    public static void main(String[] args) {
        System.out.println(random());
    }
}
