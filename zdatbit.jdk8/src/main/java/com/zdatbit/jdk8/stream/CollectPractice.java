package com.zdatbit.jdk8.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.Optional;

public class CollectPractice {

    @Test
    public void run(){
        Optional<Integer> reduce = Arrays.asList(1).stream().reduce((x, y) -> x + y);

        System.out.println(reduce.get());
    }
}
