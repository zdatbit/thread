package com.zdatbit.juc.lock;

import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.IntStream;

/**
 * Created by zhangdi21 on 2019/12/25.
 */
public class ReentReadWriteLockTest {

    public static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public static ReentrantReadWriteLock.ReadLock readLock = lock.readLock();

    public static ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

    public static int count = 0;

    public static void read(){
        try{
            readLock.lock();
            System.out.println(Thread.currentThread().getName()+"->"+count);
        }finally {
            readLock.unlock();
        }
    }


    public static void write(){
        try{
            writeLock.lock();
            Optional.of(Thread.currentThread().getName()+"->"+(++count)).ifPresent(System.out::println);
            TimeUnit.SECONDS.toSeconds(5);
        }finally {
            writeLock.unlock();
        }
    }


    public static void main(String[] args) {
        IntStream.rangeClosed(0,10).forEach(i->new Thread(()->{
            while(true){
                read();
            }
        },"r-"+i).start());

        IntStream.rangeClosed(0,2).forEach(i->new Thread(()->{
            while(true){
                write();
            }
        },"w-"+i).start());
    }
}
/**
 * 可能存在的问题，如果多个读线程，少量写线程，可能造成大部分时间都是在读，很少时间在写，造成饥饿问题
 */
