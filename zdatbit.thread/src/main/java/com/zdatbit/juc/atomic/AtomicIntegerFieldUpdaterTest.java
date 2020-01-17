package com.zdatbit.juc.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * Created by zhangdi21 on 2019/12/19.
 */
public class AtomicIntegerFieldUpdaterTest {

    public static void main(String[] args) {
        AtomicIntegerFieldUpdater aifu = AtomicIntegerFieldUpdater.newUpdater(Updater.class,"i");
        Updater updater = new Updater();

        aifu.compareAndSet(updater,updater.getI(),100);
        System.out.println(updater.getI());

        aifu.getAndDecrement(updater);
        System.out.println(updater.getI());
    }


    static class Updater{
        volatile int i;

        public Updater(){
            super();
        }

        public Updater(int i){
            this.i = i;
        }

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }
    }
}
