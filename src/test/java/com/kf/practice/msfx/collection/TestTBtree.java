package com.kf.practice.msfx.collection;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/3/7
 */
public class TestTBtree {

    public static void main(String[] args) {

        RBTree<Integer> tree = new RBTree<>();

        RBTree.RBTNode node = tree.new RBTNode<>(11,true,null,null,null);

        tree.setmRoot(node);

        RBTree.RBTNode node1 = tree.new RBTNode<>(22,false,node,null,null);
        node.right = node1;

        RBTree.RBTNode node2 = tree.new RBTNode<>(24,false,node1,null,null);
        node1.right = node2;

        tree.leftRotate(node1);

//        tree.put(11);
//        tree.put(22);
//
//        tree.put(13);



        tree.prinRBTree(tree.getRoot());



    }

}
