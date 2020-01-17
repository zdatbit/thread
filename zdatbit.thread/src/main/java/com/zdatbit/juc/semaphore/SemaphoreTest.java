package com.zdatbit.juc.semaphore;

import java.util.Optional;
import java.util.concurrent.Semaphore;

/**
 *
 * 信号量，跟guava的limiter类似
 * Created by zhangdi21 on 2019/12/24.
 */
public class SemaphoreTest {

    private Semaphore semaphore = new Semaphore(1);

    public void consume(){
        try {
            semaphore.acquire();
            Optional.of("do some thing").ifPresent(System.out::println);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }

    public void consume2(){
        try {
            semaphore.tryAcquire();
            Optional.of("do some thing").ifPresent(System.out::println);
        }finally {
            semaphore.release();
        }
    }
}
