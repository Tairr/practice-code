package com.kf.practice.thread;

import java.util.HashMap;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/2/27
 */
public class CasCounter {

    private SimulatedCAS simulatedCAS = null;

    public int getValue(){
        return simulatedCAS.getValue();
    }

    public int increment(){
        synchronized(simulatedCAS) {
            int oldValue = simulatedCAS.getValue();
            while (simulatedCAS.compareAndSwap(oldValue, oldValue + 1) != oldValue)
                oldValue = simulatedCAS.getValue();
            System.out.println(Thread.currentThread().getName()+":"+oldValue);
            return oldValue;
        }
    }

    public CasCounter(SimulatedCAS cas){
        this.simulatedCAS = cas;
    }

    public static void main(String[] args) throws InterruptedException {

        CasCounter counter = new CasCounter(new SimulatedCAS());
        Thread[] ts = new Thread[1000];
        for(int i = 0; i <1000; i++){
            ts[i] = new CounterThread(counter);

        }
        for(Thread t : ts){
            t.start();
        }

        for(Thread t : ts){
            t.join();
        }


        System.out.println("counter: "+ counter.getValue());
    }
}

 class CounterThread extends Thread {
    CasCounter counter = null;

    public CounterThread(CasCounter counter) {

        this.counter = counter;
    }

    @Override
    public void run() {
        counter.increment();
    }
}

  class SimulatedCAS {
    private volatile int value = 0;
    public synchronized int getValue(){
        return value;

    }
    public synchronized int compareAndSwap(int expectedValue, int newValue){
        if(value == expectedValue)
            value = newValue;
        return expectedValue;
    }
}
