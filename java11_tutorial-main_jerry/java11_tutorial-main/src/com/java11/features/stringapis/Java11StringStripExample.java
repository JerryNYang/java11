package com.java11.features.stringapis;

public class Java11StringStripExample {
    public static void main(String[] args) {
        stringStripExample();
    }
    static void stringStripExample(){
        String str1 ="   Welcome to Java11 Features   ";
        System.out.println("Length Before Strip :"+str1.length());
        System.out.println("Strip Str1:"+str1.strip());
        System.out.println("Length After Strip :"+str1.strip().length());

        String str2 ="   Welcome to Java11 Features   ";
        System.out.println("Length Before Strip :"+str2.length());
        System.out.println("Strip Str2:"+str1.stripLeading());
        System.out.println("Length After Strip :"+str2.strip().length());

        String str3 ="   Welcome to Java11 Features   ";
        System.out.println("Length Before Strip :"+str3.length());
        System.out.println("Strip Str3:"+str1.stripTrailing());
        System.out.println("Length After Strip :"+str3.strip().length());

    }
}
