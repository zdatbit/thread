package com.zdatbit.singleton;

/**
 * 懒汉式，存在线程安全问题
 * Created by zhangdi21 on 2019/11/27.
 */
public class Singleton2 {

    private static Singleton2 instance ;

    private Singleton2(){

    }

    public static Singleton2 getInstance(){
        if(instance==null){
            return new Singleton2();
        }
        return instance;
    }
}
