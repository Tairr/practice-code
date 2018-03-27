package com.kf.practice.msfx.designmodel.singleton;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/3/12
 */
public class StaticInnerSingleton {

    private static class StaticInnerSingletonHandler{
        private static StaticInnerSingleton INSTANCE = new StaticInnerSingleton();
    }

    public StaticInnerSingleton getInstance(){
        return StaticInnerSingletonHandler.INSTANCE;
    }

}
