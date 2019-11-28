package com.zdatbit.synchronize;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by zhangdi21 on 2019/11/28.
 */
public class Synchronized {

    public static final Object object= new Object();

    public static String lockStr= "lock";

    public static List<String> listStr = new ArrayList<>();

    public static Integer simpleInt = 0;

    public TestObj objClass = new TestObj();

    private class TestObj{
        private int testa;
        private int testb;

        public TestObj(){
            this.testa=1;
            this.testb=2;
        }

        public int getTesta() {
            return testa;
        }

        public void setTesta(int testa) {
            this.testa = testa;
        }

        public int getTestb() {
            return testb;
        }

        public void setTestb(int testb) {
            this.testb = testb;
        }
    }

    /**
     * 锁的是this对象
     */
    public synchronized void m1(){
        System.out.println("lock 1");
        try{
            Thread.sleep(10_000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    /**
     * 锁的是class类
     */
    public static synchronized void m2(){
        System.out.println("lock 2");
        try{
            Thread.sleep(10_000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    /**
     * 锁的是this对象
     */
    public void m3(){
        synchronized (this){
            System.out.println("lock 3");
            try{
                Thread.sleep(10_000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 锁的是局部变量
     */
    public void m4(){
        synchronized (object){
            System.out.println("lock 4");
            try{
                Thread.sleep(10_000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 锁的是class对象
     */
    public void m5(){
        synchronized (this.getClass()){
            System.out.println("lock 5");
            try{
                Thread.sleep(10_000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 锁的是lockStr,改变了对象,会造成线程安全的问题
     */
    public void m6(){
        synchronized (lockStr){
            System.out.println("lock 6");
            lockStr="change lock";
            try{
                Thread.sleep(10_000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 锁的是listStr,不会造成线程安全的问题
     */
    public void m7(){
        synchronized (listStr){
            System.out.println(Thread.currentThread().getName()+"-> lock 7");
            listStr.add("mm");
            try{
                Thread.sleep(10_000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }


    /**
     * description:如果是string，如果改变对象，会使锁无效，那么是否所有的简单对象都能使锁无效？
     * question:是否所有的简单对象都能使锁无效？
     * 验证：m8
     * 结论：简单对象的改变会使锁对象改变,对象改变元素不会改变锁对象
     *
     * */



    public void m8(){
        synchronized (simpleInt) {
            System.out.println(Thread.currentThread().getName() + "-> lock 8");
            simpleInt++;
            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void m9(){
        synchronized (objClass){
            System.out.println(Thread.currentThread().getName() + "-> lock 9");
            objClass.setTesta(3);
            objClass.setTestb(4);
            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        Synchronized test = new Synchronized();

        IntStream.range(0,100).forEach(i->new Thread(""+i){
            @Override
            public void run() {
                test.m9();
            }
        }.start());
    }
}
