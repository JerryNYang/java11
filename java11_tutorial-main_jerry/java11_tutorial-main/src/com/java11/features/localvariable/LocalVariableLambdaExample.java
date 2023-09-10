package com.java11.features.localvariable;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class LocalVariableLambdaExample {
    int x = 25;
    //var y = 75;
    public static void main(String[] args) {
        //earlierVersion();
        java11Changes();
    }
    static void java11Changes(){
        Consumer<String> con1 = (String s) -> System.out.println(s);
        con1.accept("Java11 Con1");
        Consumer<String> con2 = (var s) -> System.out.println(s);
        con2.accept("Java11 Con2");
        Consumer<String> con3 = s -> System.out.println(s);
        con3.accept("Java11 Con3");

        BiConsumer<String,String> bi1 = (a,b) -> System.out.println(a+b);
        bi1.accept("Hello", " World");
        BiConsumer<String,String> bi2 = (String a,String b) -> System.out.println(a+b);
        bi2.accept("Hello", " World");
        BiConsumer<String,String> bi3 = (var a,var b) -> System.out.println(a+b);
        bi3.accept("Hello", " World");

        BiConsumer<String,String> bi4 = (a,b) -> System.out.println(a+b);
        bi1.accept("Hello", " World");

        var arrInt = new Integer[]{1,2,3,4,5,6,7};
        Object[] object;
        var stream = Arrays.stream(arrInt);
        stream.forEach(System.out::println);

    }

    static void earlierVersion(){
        String s1 = "Java11";
        var s2 = "Java10"; // String
        var s3 = 25;
        int s4 = 50;
        System.out.println("Sum :"+(s3+s4));
        System.out.println("Concat :"+(s1+s2));
        List<String> li = Arrays.asList("Sam","Nancy","John");
        var li1 = Arrays.asList("Sam","Nancy","John");
        li.forEach(System.out :: println);
        for(var i=0;i<=5;i++){
            System.out.println(i);
        }
        var obj = new LocalVariableLambdaExample();
        for(var l : li){
            System.out.println(l);
        }

        File file;
        try(var fio = new FileInputStream(new File("test.txt"))){

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
