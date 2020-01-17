package com.zdatbit.juc.cyclicBarrier;

import java.util.Optional;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Created by zhangdi21 on 2019/12/23.
 */
public class CyclicBarrierTest {

    /**
     * 感觉跟countDownlatch没啥区别
     * countDown要递减count数,cyclicBarrier只有await()
     * cyclicBarrier的await数可以多于barrier数
     * @param args
     */
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

        Random random = new Random(System.currentTimeMillis());

        IntStream.range(0,10).forEach(i->new Thread(()->{
            Optional.of(Thread.currentThread().getName()+" running....").ifPresent(System.out::println);
            try {
                TimeUnit.SECONDS.sleep(random.nextInt(20));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start());
        System.out.println(cyclicBarrier.getParties());
        System.out.println(cyclicBarrier.getNumberWaiting());
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("every thing is over");
    }
}
