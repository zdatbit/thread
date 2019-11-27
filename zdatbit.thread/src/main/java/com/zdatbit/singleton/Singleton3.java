package com.zdatbit.singleton;

/**
 * 解决线程安全的问题，有一个问题是效率问题
 * Created by zhangdi21 on 2019/11/27.
 */
public class Singleton3 {

    private static Singleton3 instance;

    private Singleton3(){

    }

    public synchronized static Singleton3 getInstance(){
        if(instance==null){
            return new Singleton3();
        }
        return instance;
    }
}
