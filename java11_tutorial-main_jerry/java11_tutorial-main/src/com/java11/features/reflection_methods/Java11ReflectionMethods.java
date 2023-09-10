package com.java11.features.reflection_methods;

import java.util.stream.Stream;

public class Java11ReflectionMethods {
    public class NestedClassA{

    }
    public class NestedClassB{

    }

    public static void main(String[] args) {
        //findNests(Java11ReflectionMethods.class);
        //findHost(NestedClassA.class);
        validNestMates(Java11ReflectionMethods.class,NestedClassA.class);
        validNestMates(Java11ReflectionMethods.class,NestedClassB.class);
        validNestMates(Java11ReflectionMethods.class,Test1.class);
        validNestMates(NestedClassA.class,NestedClassB.class);
    }
    private static void findNests(Class<?> className){
        System.out.println("Class Name :"+className.getSimpleName());
        System.out.println("***Nest Members Are ***");
        Class<?>[] members = className.getNestMembers();
        Stream.of(members).map(Class :: getSimpleName).forEach(System.out::println);
    }
    private static void findHost(Class<?> className){
        System.out.println("Class Name :"+className.getSimpleName());
        System.out.println("***Host Is ***");
        Class<?> hostClass = className.getNestHost();
        System.out.println("Host Class is :"+hostClass.getSimpleName());
    }

    private static void validNestMates(Class<?> class1,Class<?> class2){
        boolean nestCheck = class1.isNestmateOf(class2);
        System.out.println("Nest Check :"+nestCheck);
    }

}
class Test1{

}
