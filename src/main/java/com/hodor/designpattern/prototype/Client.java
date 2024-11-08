package com.hodor.designpattern.prototype;

public class Client {
    public static void main(String[] args) {
        Vehicle c1 = new Car(4,3000,"red");
        Vehicle c2 = c1.clone();

        c2.isclone(c1);
        c1.isclone(c2);

        Vehicle b1 = new Bicycle(2,200,true);
        Vehicle b2 = b1.clone();

        b2.isclone(b1);
        b1.isclone(b2);

        b1.isclone(c1);
    }
}
