package com.zdatbit.atomic;

import sun.misc.Unsafe;

import java.io.File;
import java.lang.reflect.Field;

/**
 * Created by zhangdi21 on 2019/12/19.
 */
public class UnsafeTest {

    public static void main(String[] args) throws Exception {
        Unsafe unSafe = getUnSafe();
        Simple simple = new Simple();

        Field f = Simple.class.getDeclaredField("i");

        unSafe.compareAndSwapInt(simple,unSafe.objectFieldOffset(f),1,45);

        System.out.println(simple.getI());


        unSafe.putInt(simple,unSafe.objectFieldOffset(f),45);
        System.out.println(simple.getI());


        Field j = Simple.class.getDeclaredField("j");
        unSafe.compareAndSwapLong(simple,unSafe.objectFieldOffset(j),32,34);
        System.out.println(j.get(simple));
    }


    public static Unsafe getUnSafe() throws Exception {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe o = (Unsafe)field.get(Unsafe.class);
        return o;
    }

    static class Simple{
        volatile int i = 0;
        long j = 32;

        public int getI() {
            return i;
        }
    }
}
