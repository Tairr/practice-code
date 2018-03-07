package com.kf.practice.msfx.collection.btree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/3/7
 */
public class BTree {


    private TreeNode root;

    public static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public BTree(int[] array){
        root=makeBinaryTreeByArray(array,1);
    }

    /**
     * 采用递归的方式创建一颗二叉树
     * 传入的是二叉树的数组表示法
     * 构造后是二叉树的二叉链表表示法
     */
    public static TreeNode makeBinaryTreeByArray(int[] array,int index){
        if(index<array.length){
            int value=array[index];
            if(value!=0){
                TreeNode t=new TreeNode(value);
                array[index]=0;
                t.left=makeBinaryTreeByArray(array,index*2);
                t.right=makeBinaryTreeByArray(array,index*2+1);
                return t;
            }
        }
        return null;
    }

    /**
     * 深度优先遍历，相当于先根遍历
     * 采用非递归实现
     * 需要辅助数据结构：栈
     */
    public void depthOrderTraversal(){
        if(root==null){
            System.out.println("empty tree");
            return;
        }
        ArrayDeque<TreeNode> stack=new ArrayDeque<TreeNode>();
        stack.push(root);
        while(stack.isEmpty()==false){
            TreeNode node=stack.pop();
            System.out.print(node.value+"    ");
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
        }
        System.out.print("\n");
    }


    // 递归求深度
    public int depthOfTree(TreeNode node){

        if(node == null)
            return 0;
        return (depthOfTree(node.left)>depthOfTree(node.right) ? depthOfTree(node.left):depthOfTree(node.right))+1;


    }

    public int[] widthdepthOfTree(TreeNode node){

        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.push(node);

        int[] result =  new int[2];
        int cur,last;
        int width =0;
        int depth = 0;
        TreeNode current = null;
        while (!deque.isEmpty()){

            cur = 0;
            last = deque.size();
            width = last>width ? last :width;
            while (cur<last){
                current = deque.poll();
                if(current.left !=null){
                    deque.offer(current.left);
                }
                if(current.right != null){
                    deque.offer(current.right);
                }
                cur++;
            }
            depth++;
        }

        result[0] = width;
        result[1] = depth;
        return result;
    }


    public TreeNode getRoot(){
        return root;
    }

}
