package com.kf.practice.hxjs1.unit8.collection.suanfa;

import java.util.Arrays;

/**
 * @author tangjinhui
 * @Description： 快速排序
 * @date 2018/3/20
 */
public class QuickSort {


    public static void sort(int[] a,int low,int high){
        int i,j,temp,t;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        //temp就是基准位
        temp = a[low];

        while (i<j) {

            //先看右边，依次往左递减
            while (temp<=a[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=a[i]&&i<j) {
                i++;
            }

            //如果满足条件则交换
            if (i<j) {
                t = a[j];
                a[j] = a[i];
                a[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        a[low] = a[i];
        a[i] = temp;

        //递归调用左半数组
        sort(a, low, j-1);
        //递归调用右半数组
        sort(a, j+1, high);

    }


    public static void main(String[] args) {

        int a[] = {11,22,12,9,10,3,8,18};
        sort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }

}
