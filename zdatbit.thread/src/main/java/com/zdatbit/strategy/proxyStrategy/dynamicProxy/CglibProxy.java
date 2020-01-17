package com.zdatbit.strategy.proxyStrategy.dynamicProxy;

import com.zdatbit.strategy.proxyStrategy.staticProxy.JavaProgramer;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by zhangdi21 on 2019/12/19.
 */
public class CglibProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

        System.out.println("血肉至亲");
        Object o = proxy.invokeSuper(obj, args);
        System.out.println("加钱...");
        return o;
    }


    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(JavaProgramer.class);
        enhancer.setCallback(new CglibProxy());

        JavaProgramer programer = (JavaProgramer)enhancer.create();
        programer.code();
    }

}
