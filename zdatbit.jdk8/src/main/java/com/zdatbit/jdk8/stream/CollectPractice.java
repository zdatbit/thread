package com.zdatbit.jdk8.stream;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class CollectPractice {

    @Test
    public void test11(){
        IntSummaryStatistics collect = Arrays.asList(1, 2, 3, 4, 5, 6).stream().collect(Collectors.summarizingInt(x -> x));
        System.out.println(collect.getSum());
    }
    /**
     * collect
     */
    @Test
    public void test10(){
        Set<Integer> collect = Arrays.asList(1, 2, 3, 4, 5, 6).stream().collect(Collectors.toSet());
        collect.forEach(System.out::println);
    }

    /**
     * reduce
     */
    @Test
    public void test9(){
        Integer reduce = Arrays.asList(1, 2, 3, 4, 5, 6).stream().reduce(0, (x, y) -> {
            return x + y;
        });
        System.out.println(reduce);
    }

    /**
     * count
     */
    @Test
    public void test8(){
        long count = Arrays.asList(1, 2, 3, 4, 5, 6).stream().count();
        System.out.println(count);
    }

    /**
     * sort
     */
    @Test
    public void test7(){
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6);
        integers.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }

    /**
     * flatMap
     */
    @Test
    public void test6(){
        List<String> strs = new ArrayList<>();
        strs.add("hello world");
        strs.add("hello world");
        strs.add("hello scala");
        strs.add("hello spark");
        strs.stream().distinct().
                flatMap(x->Arrays.stream(x.split(" ")))
                .map(x->new HashMap(){
                    {
                        put(x,1);
                    }
                }).limit(1).forEach(System.out::println);
    }

    /**
     * map
     */
    @Test
    public void test5(){
        String[] strs = new String[]{"hello", "world","a","b","c"};
        Arrays.stream(strs).filter(x->x.length()>2).map(str->{
            Map<String,Integer> map = new HashMap<>();
            map.put(str,1);
            return map;
        }).forEach(item->{
            item.forEach((x,y)->{
                System.out.println(x+"----->"+y);
            });
        });
    }

    /**
     * filter
     */
    @Test
    public void test4(){
        String[] strs = new String[]{"hello", "world","a","b","c"};
        Arrays.stream(strs).filter(x->
            x.length()>2).forEach(System.out::println);
    }

    /**
     * stream
     */
    @Test
    public void test3() {
        String[] strs = new String[]{"hello", "world"};
        Arrays.stream(strs).forEach(System.out::println);
    }
    @Test
    public void test2(){
        Set<String> set = new HashSet<>();
        set.add("hello");
        set.add("world");

        set.stream().forEach(System.out::println);
    }
    @Test
    public void test1(){
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        integers.stream().forEach(System.out::println);
    }

}
