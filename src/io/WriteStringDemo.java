package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class WriteStringDemo {
    public static void main(String[] args) throws IOException {
        //向文件fos.txt中写入字符串
        FileOutputStream fos=new FileOutputStream("fos.txt",true);
        String line="爱你";
        String line2="孤身走安乡";
        byte[] data=line.getBytes(StandardCharsets.UTF_8);
        byte[] data1=line2.getBytes(StandardCharsets.UTF_8);
        fos.write(data);
        fos.write(data1);
        fos.close();
    }
}
