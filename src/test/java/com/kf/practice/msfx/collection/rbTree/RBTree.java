package com.kf.practice.msfx.collection.rbTree;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/3/7
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
     * 左旋示意图(对节点x进行左旋)： x左旋(成右子)： x成为右节点y的子节点，并成为lf的父节点成为
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
    public void leftRotate(RBTNode<T> x) {
        // 设置x的右孩子为y
        RBTNode<T> y = x.right;

        // 将 “y的左孩子” 设为 “x的右孩子”；
        // 如果y的左孩子非空，将 “x” 设为 “y的左孩子的父亲”
        x.right = y.left;
        if (y.left != null)
            y.left.parent = x;

        // 将 “x的父亲” 设为 “y的父亲”
        y.parent = x.parent;

        if (x.parent == null) {
            this.mRoot = y;            // 如果 “x的父亲” 是空节点，则将y设为根节点
        } else {
            if (x.parent.left == x)
                x.parent.left = y;    // 如果 x是它父节点的左孩子，则将y设为“x的父节点的左孩子”
            else
                x.parent.right = y;    // 如果 x是它父节点的左孩子，则将y设为“x的父节点的左孩子”
        }

        // 将 “x” 设为 “y的左孩子”
        y.left = x;
        // 将 “x的父节点” 设为 “y”
        x.parent = y;
    }

    /*
     * 对红黑树的节点(y)进行右旋转  :  y右旋（成左子）：成为左边x的子节点，并成为左子rx的ly
     *
     * 右旋示意图(对节点y进行左旋)：
     *            py                               py
     *           /                                /
     *          y                                x
     *         /  \      --(右旋)-.            /  \                     #
     *        x   ry                          lx   y
     *       / \                                   / \                   #
     *      lx  rx                                rx  ry
     *
     */
    public void rightRotate(RBTNode<T> y) {
        // 设置x是当前节点的左孩子。
        RBTNode<T> x = y.left;

        // 将 “x的右孩子” 设为 “y的左孩子”；
        // 如果"x的右孩子"不为空的话，将 “y” 设为 “x的右孩子的父亲”
        y.left = x.right;
        if (x.right != null)
            x.right.parent = y;

        // 将 “y的父亲” 设为 “x的父亲”
        x.parent = y.parent;

        if (y.parent == null) {
            this.mRoot = x;            // 如果 “y的父亲” 是空节点，则将x设为根节点
        } else {
            if (y == y.parent.right)
                y.parent.right = x;    // 如果 y是它父节点的右孩子，则将x设为“y的父节点的右孩子”
            else
                y.parent.left = x;    // (y是它父节点的左孩子) 将x设为“x的父节点的左孩子”
        }

        // 将 “y” 设为 “x的右孩子”
        x.right = y;

        // 将 “y的父节点” 设为 “x”
        y.parent = x;
    }



    public RBTNode<T> get(T key){

        RBTNode<T> temp = mRoot;

        while (true){
            int cp = key.compareTo(temp.key);
            if(cp<0){
                temp = mRoot.left;
            }else if(cp>0){
                temp = mRoot.right;
            }
            return temp;
        }



    }


    /**
     * 增加节点
     * @param key
     */
    public void put(T key){

        RBTNode<T> newNode = new RBTNode<>(key,RED,null,null,null);

        if(this.mRoot == null){
            newNode.color = BLACK;
            this.mRoot = newNode;
            return;
        }

        int cp = 0 ;

        RBTNode<T> x = this.mRoot;
        RBTNode<T> temp = null;

        while (x != null){

            temp = x;
            cp = newNode.key.compareTo(x.key);

            if(cp >0){
                x = x.right;
            }else if(cp<0){
                x = x.left;
            }else {
                newNode = temp;
                return;
            }
        }

        newNode.parent = temp;
        if(newNode.key.compareTo(temp.key)>0){
            temp.right = newNode;
        }else if(newNode.key.compareTo(temp.key)<0){
            temp.left = newNode;
        }

        newNode.color = RED;


        fixColorAfrerPut(newNode);

    }


    /**
     * 增加节点后的修复
     * @param node
     */
    public void fixColorAfrerPut(RBTNode<T> node){

        if(node == this.mRoot) {  // 1.加入为跟节点，修正为黑色 结束
            node.color = BLACK;
            return;
        }

        if(node.parent.color == BLACK) //2.父节点是黑色。直接结束
            return;

        if(node.parent.color == RED){ //3.父节点是红色  （则肯定存在黑色的祖父节点，则node.parent.parent!=null true

            if(node.parent.parent.left == node.parent && node.parent.parent.right != null
                    && node.parent.parent.right.color == RED){  //3.1.1 父节点是祖父的左子 且 叔叔也是红色
                node.parent.parent.left.color = BLACK;
                node.parent.parent.right.color =BLACK;
                node.parent.parent.color = RED;
                fixColorAfrerPut(node.parent.parent);

            }else if(node.parent.parent.right == node.parent && node.parent.parent.left != null
                    && node.parent.parent.left.color == RED){  //3.1.1 父节点是祖父的右子 且 叔叔也是红色
                node.parent.parent.left.color = BLACK;
                node.parent.parent.right.color =BLACK;
                node.parent.parent.color = RED;
                fixColorAfrerPut(node.parent.parent);
            }else if(node.parent.left == node && node.parent.parent.left == node.parent && isBlack(node.parent.parent.right)){
                //3.2.1 当前节点是左子  父节点是祖父的左子 且 叔叔是黑色
                node.parent.color =BLACK;
                node.parent.parent.color = RED;
                rightRotate(node.parent.parent);
            }else if(node.parent.left == node &&  node.parent.parent.right == node.parent && isBlack(node.parent.parent.left)){
                //3.2.2 当前节点是左子  父节点是祖父的右子 且 叔叔是黑色
                node.parent.color =BLACK;
                node.parent.parent.color = RED;
                rightRotate(node.parent.parent);
            }else if(node.parent.right == node && node.parent.parent.left == node.parent && isBlack(node.parent.parent.right)){
                //3.3.1 当前节点是右子  父节点是祖父的左子 且 叔叔是黑色
                //RBTNode temp = node.parent;
                leftRotate(node.parent);
                fixColorAfrerPut(node.parent);
            }else if(node.parent.right == node &&  node.parent.parent.right == node.parent && isBlack(node.parent.parent.left)){
                //3.2.2 当前节点是右子  父节点是祖父的右子 且 叔叔是黑色
                //RBTNode temp = node.parent;
                leftRotate(node.parent);
                fixColorAfrerPut(node.parent);
            }

        }


    }

    public boolean isBlack(RBTNode<T> node){

        if(node == null)
            return true;
        return node.color;

    }


    // 打印树：  先序遍历
    public void prinRBTree(RBTNode<T> root){

        if(root == null)
            return;
        System.out.println("key:"+root.key+",color:"+root.color);
        prinRBTree(root.left);
        prinRBTree(root.right);

    }


    public RBTNode getRoot(){
        return this.mRoot;
    }


    public void setmRoot(RBTNode node){

        this.mRoot = node;


    }
}
