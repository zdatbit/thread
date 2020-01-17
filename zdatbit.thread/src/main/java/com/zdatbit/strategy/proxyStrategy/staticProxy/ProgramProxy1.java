package com.zdatbit.strategy.proxyStrategy.staticProxy;

/**
 * Created by zhangdi21 on 2019/12/20.
 */
public class ProgramProxy1 implements Program{

    Program program;

    public ProgramProxy1(Program program){
        this.program = program;
    }

    @Override
    public void code() {
        program.code();
        System.out.println("这是我血肉至亲啊，得加钱。。。");
    }
}
