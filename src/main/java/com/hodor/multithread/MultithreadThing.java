package com.hodor.multithread;

// prefer implements Runnable instead of extends Thread so you can still extend another class
public class MultithreadThing implements Runnable {

    private int pause;

    public MultithreadThing(int pause) {
        this.pause = pause;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i + " " + Thread.currentThread().getName());
            try {
                Thread.sleep(pause);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
