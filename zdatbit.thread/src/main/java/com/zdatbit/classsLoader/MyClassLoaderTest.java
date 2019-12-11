package com.zdatbit.classsLoader;

import java.lang.reflect.Method;

/**
 * Created by zhangdi21 on 2019/12/11.
 */
public class MyClassLoaderTest {
    public static void main(String[] args) throws Exception{
        MyClassLoader loader = new MyClassLoader("myLoader");

        Class<?> aClass = loader.loadClass("com.bj58.scf.test.SystemTest");
        System.out.println(aClass);
        System.out.println(aClass.getClassLoader());
        Object o = aClass.newInstance();
        Method run = aClass.getDeclaredMethod("run", null);
        run.invoke(o);
    }
}
