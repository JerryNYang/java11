package com.java11.features.httpclient;


import java.io.*;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Test {
    public static void main(String[] args)throws Exception {
        File folder = new File("/Users/arun/features/stringapis");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println(listOfFiles[i].getName());
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());
            }
        }
    }
    static void nullStreamReader() throws IOException {
        Reader reader1 = new StringReader("test string data");
        Reader reader2 = Reader.nullReader();//new method
        reader2 = new StringReader("Welcome to Java11");
        Reader reader3 = new CharArrayReader(new char[]{'a', 'b', 'c'});
        printData(List.of(reader1, reader2, reader3));
        reader1.close();
        reader2.close();
        reader3.close();
    }

    public static void printData(List<Reader> readers) {
        readers.stream()
                .map(BufferedReader::new)
                .map(BufferedReader::lines)
                .forEach(stream -> stream.forEach(System.out::println));
    }

    static void nullStreamWrite()throws Exception{
        Writer writer1 = new StringWriter();
        Writer writer2 = Writer.nullWriter();//new method
        Writer writer3 = new CharArrayWriter();

        try(writer1;writer2;writer3){
            List<Writer> list = List.of(writer1, writer2, writer3);
            writeData(list);
            list.forEach(writer -> {
                System.out.printf("Writer Type:%s , toString :%s%n",writer.getClass().getSimpleName(),writer.toString());
            });
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void writeData(List<Writer> writers) throws IOException {
        for (Writer writer : writers) {
            writer.write(Integer.toString(ThreadLocalRandom.current().nextInt()));
            writer.close();
        }
    }
}
