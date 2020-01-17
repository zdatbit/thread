package com.zdatbit.juc.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * Created by zhangdi21 on 2019/12/25.
 */
public class ReentrantLockTest {

    private static Lock lock = new ReentrantLock();

    private static Condition condition = lock.newCondition();

    private static volatile boolean flag = true;

    private static int ic = 0;

    /**
     * consume
     */
    public static void consume(){
        try{
            lock.lock();
            while(!flag){
                try {
                    condition.await();// it can be interrupted   condition.await(100,TimeUnite.SECONDS); can set a time to be waited
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            flag = false;
            System.out.println(Thread.currentThread().getName()+"->"+ic);

            condition.signalAll();

        }finally {
            lock.unlock();
        }
    }

    /**
     * produce
     */
    public static void produce(){
        try{
            lock.lock();
            while(flag){
                condition.awaitUninterruptibly();//uninterrupt
            }

            ic++;
            System.out.println(Thread.currentThread().getName()+"->"+ic);
            flag = true;
            condition.signalAll();

        }finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        IntStream.rangeClosed(0,3).forEach(i->new Thread(()->{
            while(true)
            produce();
        },"p-"+i).start());

        IntStream.rangeClosed(0,2).forEach(i->new Thread(()->{
            while(true)
            consume();
        },"c-"+i).start());
    }
}
