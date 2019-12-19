package com.zdatbit.waitAndNotify;

/**
 * 实现读写分离
 * Created by zhangdi21 on 2019/12/7.
 */
public class WatiAndNotify3 {

    private volatile int readNum = 0;
    private ReadWrite writeLock = ReadWrite.WRITE;
    private ReadWrite readLock = ReadWrite.READ;


    private int product = 1;


    public void produce(){
       synchronized (writeLock){
           while(readNum>0){
               try{
                   writeLock.wait();
               }catch (InterruptedException e){
                   e.printStackTrace();
               }
           }
           System.out.println(Thread.currentThread().getName()+"-->"+(++product));
           writeLock.notifyAll();
       }
    }

    public void consume(){
        while(readNum>0){
            System.out.println(Thread.currentThread().getName()+"-->"+product);
            readNum--;
        }
    }




    private enum ReadWrite{
        READ,WRITE;
    }
}
