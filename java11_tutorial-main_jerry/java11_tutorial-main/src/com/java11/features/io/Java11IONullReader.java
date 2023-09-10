package com.java11.features.io;

import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.List;

public class Java11IONullReader {
    public static void main(String[] args) {
       /*
       Reader reader = null;
       try{
            reader = new StringReader("Hello");
            int i = reader.read();
            System.out.println((char)i);
        }catch (Exception e){
            e.printStackTrace();
        }*/
        nullStreamReader();
    }
    static void nullStreamReader(){
        Reader r1 = new StringReader("Welcome to Java11");
        Reader r2 = Reader.nullReader();// New Method
        Reader r3 = new CharArrayReader(new char[]{'A','B','C'});
        displayData(Arrays.asList(r1,r2,r3));
    }
    static void displayData(List<Reader> li){
        li.stream()
                .map(BufferedReader::new)
                .map(BufferedReader::lines)
                .forEach(stream -> stream.forEach(System.out :: println));
    }
}
