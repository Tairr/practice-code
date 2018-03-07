package com.kf.practice.msfx.collection.btree;

import java.util.Arrays;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/3/7
 */
public class TestBtree {

    /**
     *                  13
     *                 /  \
     *               65    5
     *              /  \    \
     *             97  25   37
     *            /    /\   /
     *           22   4 28 32
     */
    public static void main(String[] args) {
        int[] arr={0,13,65,5,97,25,0,37,22,0,4,28,0,0,32,0};
        BTree tree=new BTree(arr);
        tree.depthOrderTraversal();
        System.out.println(tree.depthOfTree(tree.getRoot()));

        System.out.println(Arrays.toString(tree.widthdepthOfTree(tree.getRoot())));
//        tree.levelOrderTraversal();
    }

}
