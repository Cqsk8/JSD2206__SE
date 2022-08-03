package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FOSDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos=new FileOutputStream("./fos.dat");
        fos.write(-1);
        fos.write(1);
        System.out.println("Files Output completed");
        fos.close();
    }
}
