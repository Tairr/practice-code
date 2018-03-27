package com.kf.practice.hxjs1.unit8.collection.suanfa;

import java.util.Arrays;

/**
 * @author tangjinhui
 * @Description：冒泡排序
 * @date 2018/3/20
 */
public class TestShuZu {


    public static void sorted(int[]before){

        for (int i=0;i<before.length;i++){
            for (int j=i+1;j<before.length;j++){
                if(before[i]<before[j]){
                    int temp = before[i];
                    before[i] = before[j];
                    before[j] = temp;
                }
            }

        }

        System.out.println(Arrays.toString(before));
    }

    public static void main(String[] args) {

        sorted(new int[]{11,21,3,14,9,19});

    }
}
