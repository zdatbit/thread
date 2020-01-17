package com.zdatbit.juc.lock;

import java.util.Optional;
import java.util.concurrent.locks.StampedLock;

/**
 * Created by zhangdi21 on 2019/12/25.
 */
public class StampedLockTest {

    private static StampedLock lock = new StampedLock();

    private static int count=0;


    public void read1(){
        long stamp = -1;
        try{
            stamp = lock.readLock();
            Optional.of(Thread.currentThread().getName()+"->"+count).ifPresent(System.out::println);
        }finally {
            lock.unlockRead(stamp);
        }
    }

    /**
     * 乐观读，读的同时允许一个线程写，所以可能读会存在问题，需要validate判断一下
     * 主要可以提高多读少写时的吞吐量
     */
    public void read2(){
        long stamp = -1;
        try {
            stamp = lock.tryOptimisticRead();//其实没有获取锁
            if(!lock.validate(stamp)){
                stamp = lock.readLock();
                Optional.of(Thread.currentThread().getName()+"->"+count).ifPresent(System.out::println);
            }
        }finally {
            lock.unlockRead(stamp);
        }
    }


    public void write(){
        long stamp = -1;
        try{
            stamp = lock.writeLock();
            Optional.of(Thread.currentThread().getName()+"->"+(++count)).ifPresent(System.out::println);
        }finally {
            lock.unlockWrite(stamp);
        }
    }
}
