package com.zdatbit.singleton;

import java.util.stream.IntStream;

/**
 * 解决了线程安全问题，并且可以懒加载，可能出现空指针的问题
 * Created by zhangdi21 on 2019/11/27.
 */
public class Singleton4 {

    private static Singleton4 instace;

    private Singleton4(){

    }

    public static Singleton4 getInstace(){
        if(instace==null){
            synchronized (Singleton4.class){
                if(instace==null){
                    //问题出在这，由于JVM的优化，可能实例并未初始化完成，就被另一个线程调用，可能出现空指针的问题
                    instace = new Singleton4();
                }
            }
        }
        return instace;
    }


    public static void main(String[] args) {
        IntStream.range(0,100).forEach(i->new Thread(){
            @Override
            public void run() {
                System.out.println(getInstace());
            }
        }.start());
    }
}
