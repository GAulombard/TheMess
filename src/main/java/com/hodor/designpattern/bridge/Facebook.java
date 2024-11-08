package com.hodor.designpattern.bridge;

public class Facebook implements App{

    private PhoneOS os;

    public Facebook(PhoneOS os) {
        this.os = os;
    }

    @Override
    public void runApp() {
        os.download("facebook.com");
        os.upload("mypic.jpg on Facebook");
        os.display("my journey !");
    }
}
