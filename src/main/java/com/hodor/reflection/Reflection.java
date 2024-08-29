package com.hodor.reflection;

import com.hodor.common.Cat;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        Cat myCat = new Cat();

        // get fields even if they are private
        Field[] fields = myCat.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            System.out.println(field.getName());
        }

        // get methods even if they are private
        Method[] methods = myCat.getClass().getDeclaredMethods();
        for (Method method : methods) {
            method.setAccessible(true);
            System.out.println(method.getName());

            // invoke a method given a name
            if(method.getName().equals("meow")) {
                method.invoke(myCat);
            }
        }

    }
}
