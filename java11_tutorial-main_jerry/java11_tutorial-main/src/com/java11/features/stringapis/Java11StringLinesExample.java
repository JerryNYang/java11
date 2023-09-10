package com.java11.features.stringapis;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Java11StringLinesExample {
    public static void main(String[] args) {
        stringLinesExample();
    }

    static void stringLinesExample(){
        String str1 ="Welcome to Java11 Features";
        Stream lines = str1.lines();
        //System.out.println("Length :"+lines.toArray().length);
        //lines.forEach(System.out::println);

        String str2 ="Welcome \nto Java11 \nFeatures";
        Stream lines1 = str2.lines();
        //System.out.println("Length Str2:"+lines1.toArray().length);
        //lines1.forEach(System.out::println);
        String str3 = readFile();
        str3.lines().forEach(System.out::println);
    }
    static String readFile(){
        String st = null;
        String path = System.getProperty("user.home")+"/Desktop/test.txt";
        try{
            st = new String(Files.readAllBytes(Paths.get(path)));
        }catch(Exception e){
            e.printStackTrace();
        }
        return st;
    }
}
