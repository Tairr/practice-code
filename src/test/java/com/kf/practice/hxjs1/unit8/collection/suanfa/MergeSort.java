package com.kf.practice.hxjs1.unit8.collection.suanfa;

import java.util.Arrays;

/**
 * @author tangjinhui
 * @Description： 归并排序
 * @date 2018/3/20
 */
public class MergeSort {

    public static void mergeSort(int[] a, int left, int right) {
        int t = 1;// 每组元素个数
        int size = right - left + 1;
        while (t < size) {
            int s = t;// 本次循环每组元素个数
            t = 2 * s;
            int i = left;
            while (i + (t - 1) < size) {
                merge(a, i, i + (s - 1), i + (t - 1));
                i += t;
            }
            if (i + (s - 1) < right)
                merge(a, i, i + (s - 1), right);
        }
    }

    private static void merge(int[] data, int p, int q, int r) {
        int[] B = new int[data.length];
        int s = p;
        int t = q + 1;
        int k = p;
        while (s <= q && t <= r) {
            if (data[s] <= data[t]) {
                B[k] = data[s];
                s++;
            } else {
                B[k] = data[t];
                t++;
            }
            k++;
        }
        if (s == q + 1)
            B[k++] = data[t++];
        else
            B[k++] = data[s++];
        for (int i = p; i <= r; i++)
            data[i] = B[i];
    }


    public static void main(String[] args) {

        int []a=new int[10];
        for(int i=1;i<a.length;i++){
            //a[i]=(int)(new Random().nextInt(100));
            a[i]=(int)(Math.random()*100);
        }
        System.out.println("排序前的数组为："+ Arrays.toString(a));

        //排序方法测试

        mergeSort(a, 0, 10);

        System.out.println("排序后的数组为："+Arrays.toString(a));


    }

}
