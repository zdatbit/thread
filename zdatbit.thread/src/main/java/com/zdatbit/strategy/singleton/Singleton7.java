package com.zdatbit.strategy.singleton;

/**
 * Created by zhangdi21 on 2019/11/27.
 */
public class Singleton7 {

    public enum SingleEnum{
        INSTACE;
        private Singleton7 instace;

        SingleEnum(){
            this.instace = new Singleton7();
        }

        public Singleton7 getInstance(){
            return instace;
        }
    }

    public static Singleton7 getInstance(){
        return SingleEnum.INSTACE.getInstance();
    }
}
