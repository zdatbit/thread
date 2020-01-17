package com.zdatbit.strategy.proxyStrategy.dynamicProxy;

import com.zdatbit.strategy.proxyStrategy.staticProxy.JavaProgramer;
import com.zdatbit.strategy.proxyStrategy.staticProxy.Program;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by zhangdi21 on 2019/12/19.
 */
public class JdkProxy implements InvocationHandler{

    private Program program;

    public JdkProxy(){
        program = new JavaProgramer();
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("你可知道他是谁？");
        method.invoke(program,args);
        System.out.println("血肉至亲，加钱。。。");
        return null;
    }

    public static void main(String[] args) {

        JdkProxy handler = new JdkProxy();

        Program program = (Program)Proxy.newProxyInstance(JavaProgramer.class.getClassLoader(),
                JavaProgramer.class.getInterfaces(), handler);

        program.code();

    }
}
