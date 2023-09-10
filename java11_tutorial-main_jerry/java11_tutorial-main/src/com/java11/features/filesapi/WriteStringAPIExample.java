package com.java11.features.filesapi;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class WriteStringAPIExample {
    static String location = System.getProperty("user.home")+"/Desktop/test.txt";

    public static void main(String[] args) {
        writeWithCharSet();
    }
    private static void writeString(){
        Path path = Paths.get(location);
        try {
            Files.writeString(path,"\n Welcome to Files", StandardOpenOption.APPEND);
        }catch(Exception e){
            e.printStackTrace();
        }
        ReadStringAPIExample.readString();
    }
    private static void writeWithCharSet(){
        Charset latin = Charset.forName("ISO-8859-3");
        Path path = Paths.get(location);
        try {
            Files.writeString(path,"\nWrite Using Latin Charset",latin, StandardOpenOption.APPEND);
            String data = Files.readString(path,latin);
            System.out.println(data);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
