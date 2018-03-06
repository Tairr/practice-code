package com.kf.practice.msfx.collection.lianbiao;

/**
 * @author tangjinhui
 * @Description： 单向链表类
 * @date 2018/3/5
 */
public class MyLink {

    Node head =null;

    private static  int count = 1;
    private int reverPrintCount = 1;


    class Test{

        Test next = null;

        public Test(Test next) {
            this.next = next;
        }
    }

    class Node{

        Node next = null;
        int data;

        public Node(Node next, int data) {
            this.next = next;
            this.data = data;
        }
    }


    /**
     * 添加节点
     * @param data
     */
    public Node addNode(int data){
        Node newNode = new Node(null,data);
        if(head == null){
            this.head = newNode;
            return newNode;
        }
        Node pre = head;
        while (pre.next != null){
            pre = pre.next;
        }
        pre.next = newNode;
        return newNode;
    }

    /**
     * 打印
     */
    public void printLink(){
        Node node = this.head;
        while (node != null){
            System.out.print(node.data+",");
            node = node.next;
        }
        System.out.println();

    }

    /**
     * 统计长度
     * @return
     */
    public int length(){
        if(head == null)
            return 0;
        int length = 1;
        Node temp = head;
        if(!isCircle()) {  // 无环
            if (temp.next != null) {
                temp = temp.next;
                length++;
            }
        }else { //有环
            int circleL = this.circleLength();
            Node meetNode = this.circleJoinNode();
            while (temp != meetNode){
                temp = temp.next;
                length++;
            }
            length = length +circleL-1;
        }
        return length;

    }

    /**
     * 删除指定节点
     * @param index
     */
    public void deleteNode(int index){
        if(index<1 ||  index>length())
            return;
        if(index == 1){
            head = head.next;
        }
        int seq = 1;
        Node temp = head;
/*        while (index != seq){
            temp = head.next;
            seq ++;
        }
        temp.next = temp.next.next;*/

        while (temp != null){
            if(seq == index++){
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }

    }

    /**
     * 从小到大选择排序：两个while  相当于两个链表,拿第一个链表的元素依次与另一个链表对比;
     */
    public void selectSortNode(){
        if(length()<2) {
            System.out.println("长度小于2  不用排序");
            return;
        }

        Node temp = head;
        while (temp.next != null){
            Node secondTemp = temp.next;
            while (secondTemp != null){
                if(secondTemp.data < temp.data){
                    int tempData = temp.data;
                    temp.data = secondTemp.data;
                    secondTemp.data = tempData;
                }
                secondTemp = secondTemp.next;
            }
            temp = temp.next;
        }

        System.out.println("排序结束");
    }


    public boolean isCircle(){
        if(circleMeet() != null)
            return true;
        return false;
    }

    /**
     * 环第一次相遇点
     * @return
     */
    public Node circleMeet(){
        if(head == null || head.next == null || head.next.next == null)
            return null;
        Node p = head.next;
        Node q = head.next.next;
        count = 1;
        while (q != null){
            System.out.println("p:"+p.data+",q:"+q.data);
            if(p == q){
                System.out.println("p step:"+count);
                return p;
            }
            p = p.next;
            if(q.next == null)
                return null;
            q = q.next.next;
            count ++;
        }

        return null;
    }


    /**
     * 环长度
     * @return
     */
    public int circleLength(){
        Node node = this.circleMeet();
        if(node == null)
            return 0;
        Node p = head.next;
        Node q = head.next.next;
        count = 1;
        while (true){
            if(p == q)
                return count;
            p = p.next;
            q = q.next.next;
            count++;
        }


    }


    /**
     * 环接入点
     * @return
     */
    public Node circleJoinNode(){

        Node p = head;
        Node q = this.circleMeet();

        while (p!=q){
            p = p.next;
            q = q.next;
        }
        return p;

    }


    /**
     * 递归实现 倒序输出
     * @param plistHead
     */
    public void printListReversely(Node plistHead){
        if(!(isCircle())) {
            if (plistHead != null) {
                printListReversely(plistHead.next);
                System.out.println(plistHead.data + ",");
            }
        }else {  //有环时的输出   第二次到达入环点结束
            if (plistHead != circleJoinNode()) {
                printListReversely(plistHead.next);
                System.out.print(plistHead.data + ",");
            }else{
                if(reverPrintCount<2){
                    reverPrintCount++;
                    printListReversely(plistHead.next);
                    System.out.print(plistHead.data + ",");
                }else {
                    return;
                }

            }

        }

    }

    /**
     * 删除重复节点  无环;
     */
    public void deleteRepeatNode(){
        Node p = head;
        while (p != null){
            Node q = p;
            while (q.next != null){
                if(q.next.data == p.data){
                    q.next = q.next.next;
                }else
                    q = q.next;
            }

            p = p.next;
        }


    }


    //倒数第k个
    public Node findReverK(Node head,int k){
        if(k>length())
            return null;
        Node p1 = head;
        Node p2 = head;
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        while (p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;

    }


    /**
     *
     * 查询中间节点
     * @return
     */
    public Node searchMid(){

        Node p = head;
        Node q = head;

        while (p.next != null && q.next != null && q.next.next !=null){
            p = p.next;
            q = q.next.next;
        }

        return p;

    }

    /**
     * 非递归实现
     * @param head
     * @return
     */
    public Node reversetNode(Node head){

        Node pre = null;
        while (head != null){
            Node temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        this.head = pre;
        return  pre;

    }


    /**
     * 递归实现====有问题
     * @param head
     * @return
     */
    public Node reversetNodeDg(Node head){

        if(head==null||head.next ==null)
            return head;
        Node prev = reversetNodeDg(head.next);
        head.next.next = head;
        head.next = null;
        return prev;

    }


    /**
     * 递归实现  传入第一第二节点
     * @param head
     * @return
     */
    public Node reversetNodeDgFix(Node head,Node next){
        if(next == null)
            return head;
        if(head.next == next) //第一次进来
            head.next = null;
        if(next.next != null){
            Node next2 = next.next;
            next.next = head;
            return reversetNodeDgFix(next,next2);
        }
        next.next = head;
        this.head = next;   //将最后一个节点设置为头节点;
        return next;

    }
}
