package com.kf.practice.msfx.collection.lianbiao;

/**
 * @author tangjinhui
 * @Description： 单向链表测试类
 * @date 2018/3/5
 */
public class TestMyLink {

    public static void main(String[] args) {

        MyLink myLink = new MyLink();
        myLink.addNode(3);
        myLink.addNode(2);
        MyLink.Node sNode =  myLink.addNode(4);
        myLink.addNode(1);

        myLink.addNode(34);
        myLink.addNode(22);
        myLink.addNode(41);
        myLink.addNode(17);

        MyLink.Node node =  myLink.addNode(117);
        node.next = sNode;   //形成环

        System.out.println("isCircle:"+myLink.isCircle()+",circleLength:"+myLink.circleLength()
                +",meetNode:"+myLink.circleMeet().data+",joinNode:"+myLink.circleJoinNode().data+",linkLength:"+myLink.length());


        myLink.printListReversely(myLink.head);

//        myLink.printLink();
//        myLink.selectSortNode();
//        myLink.printLink();


    }

}
