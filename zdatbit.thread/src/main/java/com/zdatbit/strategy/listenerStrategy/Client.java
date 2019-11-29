package com.zdatbit.strategy.listenerStrategy;

/**
 * Created by zhangdi21 on 2019/11/29.
 */
public class Client {


    public static void main(String[] args) {
        Subject child = new Subject();

        MotherObserver motherObserver = new MotherObserver(child);
        FatherObserver fatherObserver = new FatherObserver(child);


        child.register(motherObserver);
        child.register(fatherObserver);

        child.changeValue(23);

    }
}
