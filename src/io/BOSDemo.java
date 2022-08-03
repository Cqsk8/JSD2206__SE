package io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class BOSDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos=new FileOutputStream("bos.txt");
        BufferedOutputStream bos=new BufferedOutputStream(fos);
        String line="天青色等烟雨，而我在等你";
        byte[] data=line.getBytes(StandardCharsets.UTF_8);
        bos.write(data);
        /*
            void flush()
            会将缓冲区的数据一次性写出
         */
        bos.flush();
        bos.close();
        System.out.println("写出完毕");
    }
}
