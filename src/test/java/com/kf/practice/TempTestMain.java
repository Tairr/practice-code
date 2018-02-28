package com.kf.practice;

import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/1/31
 */
public class TempTestMain {


    public static void main(String[] args) {

        int h =11;
        String key = "test";
        System.out.println(" key.hashCode():"+ key.hashCode());
        System.out.println("h >>> 16:"+(h >>> 16));
        System.out.println("(h = key.hashCode()) ^ (h >>> 16):"+((h = key.hashCode()) ^ (h >>> 16)));
        System.out.println((key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16));

        //Class.forName("");
//        Semaphore

//        SynchronousQueue

    }

    public static int findSmallestInt(int[] args) {
        int result = args[0];
        for(int i=1;i<args.length;i++){
            if(args[i]<result){
                result = args[i];
            }
        }
        return  result;
    }
}
