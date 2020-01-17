package com.zdatbit.juc.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhangdi21 on 2020/1/9.
 */
public class CompletableFutureExample1 {

    public static void main(String[] args) throws InterruptedException {
        //runSync();
        //suply();
        //runAfterBoth();
        runAfterBoth2();
        //thenRun();
        Thread.currentThread().join();
    }


    public static void runSync(){
        CompletableFuture.runAsync(()->{
            sleep(3);
            System.out.println("my hello world");
        });
    }

    public static void suply(){
        CompletableFuture.supplyAsync(()->{
            sleep(10);
            return "hello world";
        }).whenComplete((v,t)->System.out.println(v));
    }


    public static void runAfterBoth(){
        CompletableFuture.supplyAsync(()->"hello world").runAfterBothAsync(CompletableFuture.runAsync(()->{
            System.out.println(".................1");
            sleep(20);
            System.out.println("******************1");
        }),()->{
            System.out.println("...................2");
            sleep(5);
            System.out.println("******************2");
        }).whenComplete((v,t)->System.out.println("DONE"));
    }

    public static void runAfterBoth2(){
        CompletableFuture.runAsync(()->{
            System.out.println("state1 start   1");
            sleep(5);
            System.out.println("state1 end     1");
        }).runAfterBothAsync(CompletableFuture.runAsync(()->{
            System.out.println("state2 start   2");
            sleep(5);
            System.out.println("state2 end     2");
        }),()->{
            System.out.println("begin?");
            sleep(5);
            System.out.println("DONE");
        });
        System.out.println("complete");
    }


    public static void thenRun(){
        CompletableFuture.runAsync(()->{
            System.out.println("state1 start   1");
            sleep(5);
            System.out.println("state1 end     1");
        }).thenRunAsync(()->{
            System.out.println("state2 start   2");
            sleep(5);
            System.out.println("state2 end     2");
        });
        System.out.println("complete");
    }

    public static void thenApplyAsync(){
        CompletableFuture.runAsync(()->{
            System.out.println("state1 start   1");
            sleep(5);
            System.out.println("state1 end     1");
        }).thenApplyAsync(i->{
            System.out.println();
            return "hello";
        });
    }

    public static void run(){
        CompletableFuture.runAsync(()->{
            System.out.println("state1 start   1");
            sleep(5);
            System.out.println("state1 end     1");
        });
    }



    public static void sleep(int seconds){
        try{
            TimeUnit.SECONDS.sleep(seconds);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
