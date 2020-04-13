package com.zdatbit.jdk8.lambda;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * 消费型接口
 */
public class ConsumerPractice {

    @Test
    public void test(){

        //lambda表达式的第一种写法
        Consumer<String> consumer1 = (str)->System.out.println(str);

        consumer1.accept("Hello world");

        //方法引用
        Consumer<Integer> consumer = System.out::println;

        consumer.accept(1);


        operation("Hello world2",System.out::println);
    }


    public void operation(String str,Consumer<String> con){
        con.accept(str);
    }
}
