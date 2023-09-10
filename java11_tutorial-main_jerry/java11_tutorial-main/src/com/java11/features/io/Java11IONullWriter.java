package com.java11.features.io;

import java.io.CharArrayWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Java11IONullWriter {
    public static void main(String[] args) {
        nullStreamWrite();
    }
    static void nullStreamWrite(){
        Writer w1 = new StringWriter();
        Writer w2 = Writer.nullWriter();
        Writer w3 = new CharArrayWriter();
        try(w1;w2;w3){
            List<Writer> li = Arrays.asList(w1,w2,w3);
            writeData(li);
            li.forEach(writer -> {
                System.out.printf("Writer Type :%s , toString :%s%n",writer.getClass().getSimpleName(),writer.toString());
            });
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    static void writeData(List<Writer> li)throws Exception{
        for (Writer writer : li){
            writer.write(Integer.toString(ThreadLocalRandom.current().nextInt()));
        }
    }
}
