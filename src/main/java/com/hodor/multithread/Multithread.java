package com.hodor.multithread;

public class Multithread {

    public static void main(String[] args) throws InterruptedException {

        MultithreadThing firstThing = new MultithreadThing(1000);
        MultithreadThing secondThing = new MultithreadThing(2000);

        Thread t1 = new Thread(firstThing);
        Thread t2 = new Thread(secondThing);

        // use start method not run method otherwise it won't be multithreading
        t1.start();
        t2.start();

        // to wait until thread finish before continue the program use join method
        t1.join();
        t2.join();

        System.out.println("The end !");
    }
}
