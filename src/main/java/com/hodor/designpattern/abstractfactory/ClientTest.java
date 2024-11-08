package com.hodor.designpattern.abstractfactory;

public class ClientTest {

    public static void main(String[] args) {

        Client client1 = new Client(new DatabaseFactory());
        Client client2 = new Client(new NetworkFactory());

        client1.communicate();
        client2.communicate();
    }
}
