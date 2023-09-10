package com.java11.features.filesapi;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadStringAPIExample {
    public static void main(String[] args) {
        readString();
    }
    public static void readString(){
        String location = System.getProperty("user.home")+"/Desktop/test.txt";
        // "D:/File/test.txt"
        Path path = Paths.get(location);
        try{
            String data = Files.readString(path);
            System.out.println(data);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
