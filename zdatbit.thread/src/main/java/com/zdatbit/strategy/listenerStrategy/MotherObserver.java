package com.zdatbit.strategy.listenerStrategy;

/**
 * Created by zhangdi21 on 2019/11/29.
 */
public class MotherObserver extends Observer{

    public MotherObserver(Subject subject){
        super(subject);
    }

    @Override
    public void notice() {
        System.out.println("母亲得到通知，孩子长大了："+super.getSubject().getPerson().getAge());
    }
}
