package com.zdatbit.jdk8.lambda;

import org.junit.Test;

import java.util.function.Supplier;

/**
 * 供给型接口，没有入参，返回一个泛型
 */
public class SupplierPractice {


    public String get(){
        return "something";
    }


    public static String any(){
        return "any thing is ok";
    }

    @Test
    public void test(){
        Supplier<String> str = ()-> "String";

        System.out.println(str.get());

        //方法引用
        SupplierPractice supplier = new SupplierPractice();

        Supplier<String> supplier1 = supplier::get;
        System.out.println(supplier1.get());

        //静态方法引用
        Supplier<String> sup = SupplierPractice::any;
        System.out.println(sup.get());

    }
}
