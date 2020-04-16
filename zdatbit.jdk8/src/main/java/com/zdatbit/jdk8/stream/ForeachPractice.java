package com.zdatbit.jdk8.stream;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ForeachPractice {
    /**
     * Map
     */
    @Test
    public void test1(){
        Map<String,Integer> map = new HashMap<>();
        map.put("hello",1);
        map.put("world",2);
        map.put("scala",3);
        map.forEach((x,y)->{
            if(x.equalsIgnoreCase("hello")){
                return;
            }
            System.out.println(x);
        });
    }
}
