package com.zdatbit.jdk8.lambda;

public class Person {

    private int id;
    private String name;
    private int age;

    public Person(){

    }


    public Person(int id){
        this.id = id;
    }


    public Person(int id,String name){
        this.id = id;
        this.name = name;
    }

    public Person(int id,String name,int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "[id:"+this.id+",name:"+this.name+",age:"+this.age +"]";
    }
}
