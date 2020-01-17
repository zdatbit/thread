package com.zdatbit.juc.exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

/**
 * 交换两个线程的数据，感觉这个场景应该用不到
 * Created by zhangdi21 on 2019/12/24.
 */
public class ExchangerTest {

    private static Exchanger<Integer> exchanger = new Exchanger<>();

    public static void change1(){
        Integer init = 0;
        try {
            System.out.println("交换数据前:"+Thread.currentThread().getName()+"->"+init);
            Integer exchange = exchanger.exchange(0);
            System.out.println("交换数据后:"+Thread.currentThread().getName()+"->"+exchange);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void change2(){
        Integer init = 1;
        try {
            System.out.println("交换数据前:"+Thread.currentThread().getName()+"->"+init);
            Integer exchange = exchanger.exchange(init);
            System.out.println("交换数据后:"+Thread.currentThread().getName()+"->"+exchange);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new Thread(()->change1()).start();
        try{
            TimeUnit.SECONDS.sleep(2);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        new Thread(()->change2()).start();
    }
}
