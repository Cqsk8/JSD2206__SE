package io;

import java.io.*;

public class OOSDemo {
    public static void main(String[] args) throws IOException {
        //讲一个Person对象写入文件person.obj中
        String name="刘桑";
        int age=55;
        String gender="男";
        String[] otherInfo={"技术好","拍片一流","大家的启蒙老师"};
        Person p=new Person(name,age,gender,otherInfo);

        FileOutputStream fos=new FileOutputStream("person.obj");
        ObjectOutputStream oos=new ObjectOutputStream(fos);

        oos.writeObject(p);
        System.out.println("写出完毕");
        oos.close();
    }
}
