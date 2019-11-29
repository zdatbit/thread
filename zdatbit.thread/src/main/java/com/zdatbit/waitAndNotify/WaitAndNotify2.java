package com.zdatbit.waitAndNotify;

import java.util.stream.Stream;

/**
 * 读写公用一把锁，有优化空间，实现读写分离
 * Created by zhangdi21 on 2019/11/28.
 */
public class WaitAndNotify2 {

    public boolean isEmpty = true;

    public boolean isFull = false;

    public int[] buffer = new int[5];

    public int anInt = 0;

    public static final Object lock= new Object();

    public void produce(){
        synchronized (lock){
            while(isFull){
                try {
                    lock.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            ++anInt;
            put(anInt);
            System.out.print(Thread.currentThread().getName()+" produce -> "+anInt+",");
            printArray(buffer);
            isEmpty = false;
            isFull = isFull(buffer);
            lock.notifyAll();
        }
    }


    public void consume(){
        synchronized (lock){
            while(isEmpty){
                try{
                    lock.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            int consumeInteger = get();
            System.out.print(Thread.currentThread().getName()+" consume -> "+consumeInteger+",");
            printArray(buffer);
            isFull = false;
            isEmpty = isEmpty(buffer);
            lock.notifyAll();
        }
    }

    /**
     * 放到缓冲区一个数据
     * @param anInt
     */
    public void put(int anInt){
        for(int i=0;i<buffer.length;i++){
            if(buffer[i]==0){
                buffer[i]=anInt;
                break;
            }
        }
    }

    /**
     * 从缓冲区取一个数据
     */
    public int get(){
        int consumeInteger = 0;
        for(int i=0;i<buffer.length;i++){
            if(buffer[i]!=0){
                consumeInteger = buffer[i];
                buffer[i]=0;
                break;
            }
        }
        return consumeInteger;
    }

    /**
     * 当前缓冲区是否空
     * @param buffer
     * @return
     */
    public boolean isEmpty(int[] buffer){
        int count = 0;
        for(int i=0;i<buffer.length;i++){
            if(buffer[i]==0){
                count++;
            }
        }

        if(count==buffer.length){
            return true;
        }
        return false;
    }

    /**
     * 当前缓冲区是否满
     * @param buffer
     * @return
     */
    public boolean isFull(int[] buffer){
        int count = 0;
        for(int i=0;i<buffer.length;i++){
            if(buffer[i]!=0){
                count++;
            }
        }

        if(count==buffer.length){
            return true;
        }
        return false;
    }

    /**
     * 打印当前缓冲区的数据
     * @param buffer
     */
    public void printArray(int[] buffer){
        System.out.print("[");
        for(int i=0;i<buffer.length;i++){
            if(i==4){
                System.out.print(i + "->" + buffer[i]);
            }else {
                System.out.print(i + "->" + buffer[i] + ",");
            }
        }
        System.out.println("]");
    }


    public static void main(String[] args) {

        WaitAndNotify2 waitAndNotify = new WaitAndNotify2();

        Stream.of("p1","p2","p3","p4").forEach(i->new Thread(i){
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

        Stream.of("c1","c2","c3","c4","c5").forEach(c->new Thread(c){

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
