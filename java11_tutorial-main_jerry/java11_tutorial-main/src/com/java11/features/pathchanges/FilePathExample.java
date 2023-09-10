package com.java11.features.pathchanges;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilePathExample {
    public static void main(String[] args) {
        //Path path = Path.of("/Users/arun/Desktop/test.txt");
        Path path = Path.of("/Users","/arun","/Desktop","/test.txt");
        System.out.println(path);
        boolean exists = Files.exists(path);
        System.out.println("Exists :"+exists);


        //URI uri = URI.create("d:/arun/test.txt");
        URI uri = URI.create("file:///" + "/Users/arun/Desktop/test1.txt");
        Path path1 = Path.of(uri);
        boolean exists1 = Files.exists(path1);
        System.out.println("Exists1 :" + exists1);
    }
}
// ClassLoader , FileInputStream, BufferedStream,Path,Scanner
