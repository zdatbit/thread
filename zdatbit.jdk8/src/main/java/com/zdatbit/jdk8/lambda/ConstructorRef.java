package com.zdatbit.jdk8.lambda;

import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Function;

public class ConstructorRef {

    @Test
    public void test(){
        Function<Integer,Person> fun = Person::new;

        System.out.println(fun.apply(1));


        BiFunction<Integer,String,Person> fun1 = Person::new;

        System.out.println(fun1.apply(1,"zhangsan"));
    }


    @Test
    public void test1(){
        Function<Integer,String[]> fun = x->new String[x];

        System.out.println(fun.apply(5).length);



        Function<Integer,String[]> fun1 = String[]::new;
        System.out.println(fun1.apply(19).length);
    }
}
