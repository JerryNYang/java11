package com.java11.features.stringapis;

import java.util.function.Predicate;

public class Java11StringIsBlankExample {
    public static void main(String[] args) {
        //beforeJava11();
        stringIsBlankExample();
    }
    static void stringIsBlankExample(){
        //Before java11
        String content = "java11";
        if(!content.equals("") || content.trim().length() !=0){
            System.out.println("String is not Empty");
        }

        String str1 ="";
        System.out.println("java11 str1 isBlank : "+str1.isBlank());
        String str2 ="       ";
        System.out.println("java11 str2 isBlank : "+str2.isBlank());
        String str3 ="java11";
        System.out.println("java11 str3 isBlank : "+str3.isBlank());

        Predicate<String> str4 = s -> s.isBlank();
        System.out.println("isBlank Lambda Expression :"+str4.test("Java 11 Features"));

        Predicate<String> str5 = String :: isBlank;
        System.out.println("isBlank Method Ref Expression :"+str5.test(""));

    }
    static void beforeJava11(){
        String content = "   java11   ";
        System.out.println(">>>>> :"+content.trim());
        String npSpaceStr = content.replaceAll("\\s","");
        System.out.println(npSpaceStr);
    }
}
