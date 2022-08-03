package io;

import java.io.*;

public class OISDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FileInputStream fis=new FileInputStream("person.obj");
        ObjectInputStream ois=new ObjectInputStream(fis);

        Object obj=ois.readObject();
        Person person=(Person) obj;
        System.out.println(person);
        ois.close();
    }
}
