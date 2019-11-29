package com.zdatbit.strategy.decoratorStrategy;

/**
 * Created by zhangdi21 on 2019/11/29.
 */
public class Student implements Person{

    @Override
    public void talk() {
        System.out.println("学会的是学生的语言");
    }

    @Override
    public void eat() {
        System.out.println("在学校学会的吃饭方式");
    }
}
