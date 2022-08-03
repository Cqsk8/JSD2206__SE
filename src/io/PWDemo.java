package io;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.SQLOutput;

/**
 * 缓冲字符流
 */

public class PWDemo {
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter pw=new PrintWriter("pw.txt");
        pw.println("我祈祷拥有一颗透明的心灵,和会流泪的眼睛");
        pw.println("给我再去相信的勇气，越过谎言去拥抱你");
        System.out.println("写出完毕");
        pw.close();
    }
}
