package com.zdatbit.jdk8.lambda;

import org.junit.Test;

import java.util.function.Predicate;

/**
 * 预测型接口,入参一个泛型，返回一个boolean
 */
public class PredicatePractice {

    @Test
    public void test(){
        Predicate<String> pre = x-> x instanceof String;

        System.out.println(pre.test("str"));
    }
}
