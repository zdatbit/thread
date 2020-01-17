package com.zdatbit.strategy.proxyStrategy.staticProxy;

import com.zdatbit.strategy.proxyStrategy.staticProxy.Program;

/**
 * Created by zhangdi21 on 2019/12/20.
 */
public class JavaProgramer implements Program {

    @Override
    public void code() {
        System.out.println("writing java");
    }
}
