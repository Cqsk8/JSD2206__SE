package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyDemo2 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream("Demo.txt");
        FileOutputStream fos=new FileOutputStream("Demo3.txt");
        byte[] data=new byte[1024*10];
        int len=0;
        long start=System.currentTimeMillis();
        while((len= fis.read(data))!=-1){
            fos.write(data,0,len);
        }
        long end=System.currentTimeMillis();
        System.out.println(end-start);
    }
}
