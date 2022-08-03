package io;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class OSWDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos=new FileOutputStream("./osw.txt");
        OutputStreamWriter osw=new OutputStreamWriter(fos,StandardCharsets.UTF_8);

        String line="super idol的笑容都没你的甜";
       // byte[] data=line.getBytes(StandardCharsets.UTF_8);
       // fos.write(data);
        osw.write(line);
        osw.write("八月正午的阳光都没你耀眼");

        System.out.println("写出完毕");
        osw.close();
    }
}
