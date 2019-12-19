package com.zdatbit.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 对象的设置原子性
 * Created by zhangdi21 on 2019/12/19.
 */
public class AtomicReferenceTest {

    private static AtomicReference<Simple> reference = new AtomicReference<>(new Simple());

    public static void main(String[] args) {
        Simple simple = new Simple(20);
        Simple pre = reference.get();
        reference.compareAndSet(pre,simple);

        Simple now = reference.get();
        System.out.println(now.getI());

    }



    static class Simple{
        int i = 0;

        public Simple(){
            super();
        }

        public Simple(int i){
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
