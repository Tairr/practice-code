package com.kf.practice.msfx.collection.lianbiao;

import java.util.Date;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/3/6
 */
public class TestMylinkNoCircle {

    public static void main(String[] args) {

        MyLink myLink = new MyLink();
        myLink.addNode(3);
        myLink.addNode(2);
        MyLink.Node sNode =  myLink.addNode(4);
        myLink.addNode(1);

        myLink.addNode(34);
        myLink.addNode(22);
        myLink.addNode(41);



        myLink.addNode(1);

        myLink.addNode(34);
        for (int i = 0; i <5000 ; i++) {
            myLink.addNode(34);
        }



//        myLink.printLink();
//
//        myLink.deleteRepeatNode();
//
//        myLink.printLink();
//
//        System.out.println("findReverK k=2:"+myLink.findReverK(myLink.head,2).data);
//        System.out.println("searchMid:"+myLink.searchMid().data);
//
//        myLink.printLink();

        MyLink lin2 = myLink;

        long  start = new Date().getTime();
        myLink.reversetNodeDgFix(myLink.head,myLink.head.next);
        System.out.println("cost:"+(new Date().getTime() - start));
        System.out.println("after reversetNodeDgFix: ");
      //  myLink.printLink();

//        long  start2 = System.currentTimeMillis();
//        lin2.reversetNode(lin2.head);
//        System.out.println("cost:"+(System.currentTimeMillis() - start2));
//        System.out.println("after reversetNodeDgFix: ");
//        myLink.printLink();
    }

}
