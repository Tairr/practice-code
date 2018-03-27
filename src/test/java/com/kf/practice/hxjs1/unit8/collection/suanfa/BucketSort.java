package com.kf.practice.hxjs1.unit8.collection.suanfa;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/3/20
 */
public class BucketSort {


    public static void sort(int[] a){


        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=0;i<a.length;i++){
            if(a[i]>max){
                max = a[i];
            }
            if(a[i]<min){
                min = a[i];
            }
        }

        int bucketNum = (max-min)/a.length +1;

        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<>(bucketNum);
        for (int i = 0; i <bucketNum ; i++) {
            bucketList.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < a.length; i++) {
            int num = (a[i]-min)/a.length;
            bucketList.get(num).add(a[i]);
        }

        for (int i = 0; i < bucketList.size(); i++) {
            Collections.sort(bucketList.get(i));
        }


        for(ArrayList<Integer> arr:bucketList){

            for (Integer num : arr){

                System.out.print(num+",");
            }

        }


    }


    public static void main(String[] args) {
        sort(new int[]{111,2,33,46,923,1123});
    }

}
