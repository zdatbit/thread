package com.zdatbit.waitAndNotify;

import java.lang.reflect.Field;

/**
 * 交换两个数据的值
 * Created by zhangdi21 on 2019/11/29.
 */
public class SimpleTypeTest {

    public static void main(String[] args) throws Exception{
        int a = 10;
        int b = 20;
        System.out.printf("交换前：a = %d, b = %d\n",a,b);
        swap(a,b);
        System.out.printf("交换后:a = %d, b = %d\n",a,b);
    }


    public static void swap(Integer a,Integer b) throws Exception {
        int temp = a.intValue();
        System.out.println(temp);
        Class aClass = a.getClass();
        Field value = aClass.getDeclaredField("value");
        value.setAccessible(true);
        value.setInt(a,b);

        System.out.println(a);
        System.out.println(temp);
        value.setInt(b,temp);

        System.out.println(b);
    }

    public static void swap(int a,int b) throws Exception {

        Integer tempA = new Integer(a);

        int temp = a;

        Class aClass = tempA.getClass();
        Field value = aClass.getDeclaredField("value");
        value.setAccessible(true);
        value.setInt(a,b);

        value.setInt(b,temp);

    }

}
