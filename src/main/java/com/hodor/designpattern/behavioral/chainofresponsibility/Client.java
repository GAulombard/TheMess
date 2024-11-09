package com.hodor.designpattern.behavioral.chainofresponsibility;

public class Client {
    public static void main(String[] args) {
        AuthenticationHandler auth = new AuthenticationHandler("123456token");
        ContentTypeHandler type = new ContentTypeHandler("JSON");
        PayloadHandler payload = new PayloadHandler("Body: {\n\"username\":\"john\"\n}");

        auth.next = type;
        type.next =payload;

        String withAuth = auth.addHandler("Headers WITH authentication");
        System.out.println(withAuth);

        System.out.println();

        String withoutAuth = type.addHandler("Headers WITHOUT authentication");
        System.out.println(withoutAuth);


    }
}
