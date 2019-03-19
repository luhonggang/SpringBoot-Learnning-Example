package com.study.basic.myselfcacheuse;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/3/4 15:08
 * 自定义缓存的使用
 */
public class CacheUse {

    /**
     * 声明cache之后，通过Map.computeIfAbsent() 方法，可以在key所对应的value值不存在的情况下，
     * 计算一个新的value值。超高速缓存（Caching）！由于这个方法是自动执行的，而且我们使用了 ConcurrentHashMap对象，这个缓存是线程安全的，
     * 不需要手动的去写同步方法。另外，它不仅仅可以处理斐波那契额数列，在其他地方也可以被重复使用
     */
    static Map<Integer, Integer> cache = new ConcurrentHashMap<>();

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            System.out.println(" 计算的结果  : " + fibonajisuan(i));
        }

//        System.out.println("生成的数字 : " + fibonajisuan(5));
    }

    /**
     *
     * @param i 输入的值
     * @return
     */
    static int fibonajisuan(int i){
        if(i == 0){
            return i;
        }
        if(i == 1){
            return 1;
        }

        System.out.println(" 调用计算的次数 : " + i );
        return fibonajisuan(i - 2 ) + fibonajisuan( i - 1);
    }


    /**
     *
     * @param i 输入的值
     * @return
     */
    static int fibonajisuan02(int i){
        if(i == 0){
            return i;
        }
        if(i == 1){
            return 1;
        }

        System.out.println(" 调用计算的次数 : " + i );
        return cache.computeIfAbsent(i,(key) -> fibonajisuan02(i - 2) + fibonajisuan02(i - 1));
    }


}
