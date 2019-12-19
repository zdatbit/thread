package com.zdatbit.classsLoader;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by zhangdi21 on 2019/12/18.
 */
public class MyUrlClassLoader {

    public static void loadJar(String jarPath){
        File jarFile = new File(jarPath);
        Method method = null;

        try{
            method = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
        }catch (Exception e){
            e.printStackTrace();
        }

        boolean accessible = method.isAccessible();
        try{
            method.setAccessible(true);
            URLClassLoader classLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
            URL url = jarFile.toURI().toURL();
            method.invoke(classLoader,url);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            method.setAccessible(accessible);
        }


    }
}
