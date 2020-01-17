package com.zdatbit.juc.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zhangdi21 on 2019/12/19.
 */
public class AtomicIntegerTest {

    private static AtomicInteger integer = new AtomicInteger(1);

    public static void main(String[] args) {
        integer.getAndIncrement();
        integer.get();
        /**
         * 加上值并获取
         */
        integer.addAndGet(1);
        /**
         * 设置值
         */
        integer.getAndSet(13);

        /**
         * 当前值更新
         */
        integer.getAndUpdate(pre->{
            return pre+1;
        });



        //计算
        integer.getAndAccumulate(123,(current,next)->{
           return current+next;
        });
        int b = integer.get();
        System.out.println(b);
    }
}
