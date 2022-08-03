package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ISRDemo {
    public static void main(String[] args) throws IOException {
        //将当前源代码读取出来并输出到控制台上
        FileInputStream fis=new FileInputStream("./src/io/ISRDemo.java");
        InputStreamReader isr=new InputStreamReader(fis);
        int d;
        while((d=isr.read())!=-1){
            char c=(char)d;
            System.out.print(c);
        }
        isr.close();
    }
}
