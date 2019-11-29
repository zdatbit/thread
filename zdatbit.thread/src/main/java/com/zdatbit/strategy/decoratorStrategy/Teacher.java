package com.zdatbit.strategy.decoratorStrategy;

/**
 * Created by zhangdi21 on 2019/11/29.
 */
public class Teacher{

    private Person person;

    public Teacher(Person person){
        this.person = person;
    }

    public void howToTalk() {
        System.out.println("老师告诉学生怎么说话");
        person.talk();
        System.out.println("其实学生并不想这么说话");
    }

    public void howToEat() {
        System.out.println("老是告诉学生怎么吃饭");
        person.eat();
        System.out.println("其实学生并不想这么吃法");
    }
}
