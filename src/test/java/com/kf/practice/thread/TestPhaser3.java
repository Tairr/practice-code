package com.kf.practice.thread;

import java.util.concurrent.Phaser;

/**
 * @author tangjinhui
 * @Description：  Todo 没太看懂。。。
 * @date 2018/2/1
 */
public class TestPhaser3 {



    public static void main(String[] args) {

        Phaser phaser = new Phaser(3){
            protected boolean onAdvance(int phase,int registeredParties){
                System.out.println("执行onAdvance方法。。。phase："+phase+",registeredParties"+registeredParties);
                return phase == 3;
            }
        };


        for (int i = 0; i <3 ; i++) {
            new Thread(new Task3(phaser)).start();
        }

        while (!phaser.isTerminated()){
            phaser.arriveAndAwaitAdvance();
        }

        System.out.println("主线程结束");

    }


    static class Task3 implements Runnable{

        private  final  Phaser phaser ;

        public Task3(Phaser phaser) {
            this.phaser = phaser;
        }

        @Override
        public void run() {
            do{
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" 开始执行任务");
                phaser.arriveAndAwaitAdvance();
            }while (!phaser.isTerminated());

        }
    }

}
