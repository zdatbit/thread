package com.zdatbit.strategy.singleton;

import java.util.stream.IntStream;

/**
 * 不加锁的实现方式
 * Created by zhangdi21 on 2019/11/27.
 */
public class Singleton6 {

    public Singleton6(){

    }

    public static class SingleHolder{
        public static Singleton6 instace = new Singleton6();
    }

    public static Singleton6 getInstance(){
        return SingleHolder.instace;
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
