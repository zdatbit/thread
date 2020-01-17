package com.zdatbit.juc.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * 就是个递归
 * Created by zhangdi21 on 2019/12/25.
 */
public class ForkJoinTest {

    private int difference = 10;
    private static AtomicInteger sum = new AtomicInteger(0);


    private class SumTask extends RecursiveAction{

        private int start;
        private int end;

        public SumTask(){
            super();
        }

        public SumTask(int start,int end){
            this.start = start;
            this.end = end;
        }


        @Override
        protected void compute() {
            if(end-start<difference){
                sum.addAndGet(IntStream.rangeClosed(start,end).sum());
            }else{
                int mid = (end-start)/2+start;
                SumTask left = new SumTask(start,mid);
                SumTask right = new SumTask(mid+1,end);
                invokeAll(left,right);
            }
        }
    }


    private class SumTask2 extends RecursiveTask<Integer>{
        private int start;
        private int end;

        public SumTask2(){
            super();
        }

        public SumTask2(int start,int end){
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            if(end-start<difference){
                return IntStream.rangeClosed(start,end).sum();
            }else{
                int mid = (end-start)/2+start;
                SumTask2 left = new SumTask2(start,mid);
                SumTask2 right = new SumTask2(mid+1,end);
                invokeAll(left,right);

                return left.join()+right.join();
            }
        }
    }


    public static void main(String[] args) {
        int start = 0;
        int end = 100;

        SumTask sumTask = new ForkJoinTest().new SumTask(start,end);


        //method 1
//        ForkJoinPool pool = new ForkJoinPool();
//        pool.invoke(sumTask);

        //method 2
//        sumTask.invoke();
        //method3
        sumTask.fork();
        System.out.println(sum);

    }

}
