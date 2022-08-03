package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream  fis=new FileInputStream("./Demo.txt");
        FileOutputStream fos=new FileOutputStream("./Demo1.txt");
        int d;
        long start=System.currentTimeMillis();
        while((d=fis.read())!=-1){
            fos.write(d);
        }
        long end=System.currentTimeMillis();
        fos.close();
        fis.close();
        System.out.println("cost time "+(end-start)+" ms");
    }
}
