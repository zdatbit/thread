package com.zdatbit.strategy.listenerStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangdi21 on 2019/11/29.
 */
public class Subject {

    private Person person = new Person(12,"北京");

    private List<Observer> listeners = new ArrayList<>();

    public Subject(){

    }

    /**
     * 注册监听者
     * @param observer
     */
    public void register(Observer observer){
        listeners.add(observer);
    }

    /**
     * 孩子年龄变化
     * @param age
     */
    public void changeValue(int age){
        if(age!=person.getAge()){
            person.setAge(age);
            listeners.forEach(observer->observer.notice());
        }
    }


    public Person getPerson() {
        return person;
    }


    public class Person{
        int age;
        String address;

        public Person(int age,String address){
            this.age = age;
            this.address = address;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }
}
