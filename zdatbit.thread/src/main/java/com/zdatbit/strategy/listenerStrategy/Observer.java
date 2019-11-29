package com.zdatbit.strategy.listenerStrategy;

/**
 * Created by zhangdi21 on 2019/11/29.
 */
public abstract class Observer {

    private Subject subject;

    public Observer(){

    }

    protected Observer(Subject subject){
        this.subject = subject;
    }

    public abstract  void notice();

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
