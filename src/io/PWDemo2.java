package io;

import java.io.*;
import java.util.Scanner;

/**
 * 记事本
 * 自行完成流连接的创建
 */

public class PWDemo2 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("pw2.txt");//文件流
        OutputStreamWriter osw = new OutputStreamWriter(fos);//转换流
        BufferedWriter bw = new BufferedWriter(osw);//缓冲字符流
        PrintWriter pw = new PrintWriter(bw);

        //写入
         Scanner s = new Scanner(System.in);
          while (true) {
              String a = s.nextLine();
             if ("exit".equals(a)) {
                break;
             }
             pw.println(a);
             pw.flush();
          }
         pw.close();
        }
    }