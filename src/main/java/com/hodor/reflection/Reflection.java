package com.hodor.reflection;

import com.hodor.common.Cat;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        Cat myCat = new Cat("Kroki",8);

        // get fields even if they are private
        Field[] fields = myCat.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            System.out.println(field.getName());



            if(field.getName().equals("name")) {
                System.out.println(field.get(myCat));
                field.set(myCat, "Kroki Update");
                System.out.println(field.get(myCat));
            }
        }

        // get methods even if they are private
        Method[] methods = myCat.getClass().getDeclaredMethods();
        for (Method method : methods) {

            System.out.println(method.getName());

            // invoke a method given a name
            if(method.getName().equals("meow")) { // public method
                method.invoke(myCat);
            } else if(method.getName().equals("privateMeow")) { // private method
                method.setAccessible(true);
                method.invoke(myCat);
            }else if(method.getName().equals("staticMeow")) { // static public method
                method.invoke(null);
            }else if(method.getName().equals("privateAndStaticMeow")) { // static private method
                method.setAccessible(true);
                method.invoke(null);
            }
        }

    }
}
