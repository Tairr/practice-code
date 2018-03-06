package com.kf.practice.hxjs1.unit3;

import com.kf.practice.hxjs1.entity.Employe;
import com.kf.practice.hxjs1.entity.Manager;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/3/2
 */
public class TestArray {

    public static void main(String[] args) {

        int[][] a = {{1,2}};
        System.out.println(Arrays.deepToString(a));

        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        System.out.println(arrayLists.toString());

        ArrayList arrayList = new ArrayList();
        arrayList.ensureCapacity(100);
        System.out.println(arrayList.size());

        Employe[] ems = new Employe[100];
        ems[0] = new Manager("zs",11,"");


    }

}
