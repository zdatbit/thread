package com.zdatbit.jdk8.lambda;


import org.junit.Test;

/**
 * 语法格式一：无参数，无返回值
 *          ()->System.out.println("Hello world");
 *
 * 语法格式二：有一个参数，无返回值
 *          (x)->System.out.println(x);
 *
 * 语法格式三：若只有一个参数，小括号可以省略不写
 *          x->System.out.println(x);
 *
 * 语法格式四：有两个以上的参数，有返回值，并且lamda体中有多条语句
 *          Comparator<Integer>  com =(x,y)->{
 *              System.out.println("函数式接口");
 *              return Integer.compare(x,y);
 *          }
 *
 * 语法格式五：若lamda体中只有一个语句，大括号和return语句都可以省略
 *          Comparator<Integer> com =Integer.compare(x,y)
 *
 * 语法格式六：lamda表达式的参数列表的数据类型可以不写
 *
 *
 * 二、Lambda表达式需要“函数式接口”的支持
 * 函数式接口：有且只有一个抽象方法，称为函数式接口，可以用@FunctionInterface来注解
 *
 */
public class LamdaPractice {

    @Test
    public void test1(){

    }

    @Test
    public void test2(){

    }

    @Test
    public void test3(){

    }

    @Test
    public void test4(){

    }

    @Test
    public void test5(){

    }
}
