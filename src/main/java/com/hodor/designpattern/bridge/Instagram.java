package com.hodor.designpattern.bridge;

public class Instagram implements App {

    private PhoneOS os;

    public Instagram(PhoneOS os) {
        this.os = os;
    }

    @Override
    public void runApp() {
        os.download("instagram.com");
        os.upload("mypic.jpg on Instagram");
        os.display("my journey !");
    }
}
