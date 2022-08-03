package io;

import java.io.*;

public class CopyDemo3 {
    public static void main(String[] args) throws IOException {
//        FileInputStream fis=new FileInputStream("Demo1.txt");
//        BufferedInputStream bis=new BufferedInputStream(fis);
//
//        FileOutputStream fos=new FileOutputStream("Demo6.txt");
//        BufferedOutputStream bos=new BufferedOutputStream(fos);
//        int d;
//        while((d=bis.read())!=-1){
//            bos.write(d);
//        }
//        bos.close();
//        bis.close();

        FileInputStream fis=new FileInputStream("Demo1.txt");
        BufferedInputStream bis=new BufferedInputStream(fis);
        FileOutputStream fos=new FileOutputStream("Demo6.txt");
        BufferedOutputStream bos=new BufferedOutputStream(fos);

        int d;
        while((d=fis.read())!=-1){
            fos.write(d);
        }

        bis.close();
        bos.close();
    }
}
