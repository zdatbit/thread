package com.zdatbit.waitAndNotify;

import java.util.stream.Stream;

/**
 * Created by zhangdi21 on 2019/11/28.
 */
public class WaitAndNotify1 {

    public boolean isProduced = false;

    public int anInt = 0;

    public static final Object lock= new Object();

    public void produce(){
        synchronized (lock){
            while(isProduced){
                try {
                    lock.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+" produce -> "+(++anInt));
            isProduced = true;
            lock.notifyAll();
        }
    }

    public void consume(){
        synchronized (lock){
            while (isProduced){
                System.out.println(Thread.currentThread().getName()+" consume -> "+anInt);
                isProduced = false;
                lock.notifyAll();
            }
            try {
                lock.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        WaitAndNotify1 waitAndNotify = new WaitAndNotify1();

        Stream.of("p1","p2").forEach(i->new Thread(i){
            @Override
            public void run() {
                while(true) {
                    waitAndNotify.produce();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start());

        Stream.of("c1","c2").forEach(c->new Thread(c){
            @Override
            public void run() {
                while(true) {
                    waitAndNotify.consume();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start());
    }

}
