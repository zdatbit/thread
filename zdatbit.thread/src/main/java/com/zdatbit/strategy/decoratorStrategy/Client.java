package com.zdatbit.strategy.decoratorStrategy;

/**
 * Created by zhangdi21 on 2019/11/29.
 */
public class Client {

    public static void main(String[] args) {
        Student student = new Student();
        Teacher teacher = new Teacher(student);
        teacher.howToTalk();
        System.out.println("------------------------------");
        teacher.howToEat();
    }
}
