package com.zdatbit.jdk8.lambda;

import org.junit.Test;

import java.util.function.Function;

/**
 * 函数式接口，入参一个，返回结果一个
 */
public class FunctionPractice {

    @Test
    public void test(){
        Function<String,Integer> fun = ((x) -> Integer.parseInt(x));

        System.out.println(fun.apply("100"));


        Function<String,Integer> fun1 = Integer::parseInt;

        System.out.println(fun1.apply("10000"));
    }

}
