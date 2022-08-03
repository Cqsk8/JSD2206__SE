package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FISDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream("fos.dat");
        int d=fis.read();
        System.out.println(d);
        d= fis.read();
        System.out.println(d);
        d= fis.read();
        System.out.println(d);
        fis.close();
    }
}
