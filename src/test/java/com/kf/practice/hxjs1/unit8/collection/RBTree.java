package com.kf.practice.hxjs1.unit8.collection;

/**
 * @author tangjinhui
 * @Description： 红黑树类： x左旋： x成为右节点y的子节点，并成为lf的父节点成为
 * @date 2018/3/2
 */
public class RBTree<T extends Comparable<T>> {

    private RBTNode<T> mRoot;    // 根结点

    private static final boolean RED   = false;
    private static final boolean BLACK = true;

    public class RBTNode<T extends Comparable<T>> {
        boolean color;        // 颜色
        T key;                // 关键字(键值)
        RBTNode<T> left;    // 左孩子
        RBTNode<T> right;    // 右孩子
        RBTNode<T> parent;    // 父结点

        public RBTNode(T key, boolean color, RBTNode<T> parent, RBTNode<T> left, RBTNode<T> right) {
            this.key = key;
            this.color = color;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

    }

    /*
     * 对红黑树的节点(x)进行左旋转
     *
     * 左旋示意图(对节点x进行左旋)：
     *      px                              px
     *     /                               /
     *    x                               y
     *   /  \      --(左旋)-.           /  \                #
     *  lx   y                          x   ry
     *     /   \                       / \
     *    ly   ry                     lx ly
     *
     *
     */
    public void leftRotate(RBTNode<T> x){

        RBTNode<T> y = x.right;

        x.right = y.left;
        if(y.left !=null)
            y.left.parent = x;

        y.parent = x.parent;

        if(y.parent ==null){
            this.mRoot = y;
        }else {
            if(x.parent.left == x)
                x.parent.left = y;
            else{
                x.parent.right = y;
            }

        }

        y.left = x;
        x.parent = y;

    }

    /*
     * 对红黑树的节点(y)进行右旋转
     *
     * 右旋示意图(对节点y进行左旋)：
     *            py                               py
     *           /                                /
     *          y                                x
     *         /  \      --(右旋)-.            /  \                     #
     *        x   ry                           lx   y
     *       / \                                   / \                   #
     *      lx  rx                                rx  ry
     *
     */
    public void rightRotate(RBTNode<T> y){


    }




}
