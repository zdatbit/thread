package com.zdatbit.jdk8.stream;

import org.junit.Test;

import java.util.Optional;

public class OptionalPractice {

    /**
     * Optional.orElse
     */
    @Test
    public void test3(){
        Optional<Integer> optional = Optional.ofNullable(null);
        System.out.println(optional.orElse(1));
    }
    /**
     * Optional.isPresent
     */
    @Test
    public void test2(){
        Optional<Integer> optional = Optional.ofNullable(null);
        if(optional.isPresent()){
            System.out.println(optional.get());
        }
    }
    /**
     * Optional.ofNullable
     */
    @Test
    public void test1(){
        Optional op = Optional.ofNullable(1);
        op.ifPresent(System.out::println);
    }
}
