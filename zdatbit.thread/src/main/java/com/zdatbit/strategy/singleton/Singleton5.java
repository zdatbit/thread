package com.zdatbit.strategy.singleton;

import java.util.stream.IntStream;

/**
 * 解决了效率问题，可以懒加载，没有空指针的问题
 * Created by zhangdi21 on 2019/11/27.
 */
public class Singleton5 {

    private static volatile Singleton5 instance;

    private Singleton5(){

    }

    public static Singleton5 getInstance(){
        if(instance==null){
            synchronized (Singleton5.class){
                if(instance==null){
                    instance = new Singleton5();
                }
            }
        }
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
