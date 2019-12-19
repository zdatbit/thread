package com.zdatbit.strategy.singleton;

import java.util.stream.IntStream;

/**
 * 饿汉式，能保证线程安全
 * Created by zhangdi21 on 2019/11/27.
 */
public class Singleton1 {

    private static Singleton1 instance = new Singleton1();

    private Singleton1(){

    }

    public static Singleton1 getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        IntStream.range(0,100).forEach(i->new Thread(){
            @Override
            public void run() {
                System.out.println(getInstance());
            }
        }.start());
    }
}
