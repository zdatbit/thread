package com.zdatbit.strategy.listenerStrategy;

/**
 * Created by zhangdi21 on 2019/11/29.
 */
public class FatherObserver extends Observer{

    public FatherObserver(Subject subject){
        super(subject);
    }

    @Override
    public void notice() {
        System.out.println("父亲得到通知，孩子长大了："+super.getSubject().getPerson().getAge());
    }
}
