package file;

import java.io.File;

public class FileDemo {
    public static void main(String[] args) {
        File file=new File("./Demo.txt");

        String name=file.getName();
        System.out.println(name);

        long len=file.length();
        System.out.println(len);

        boolean a=file.canRead();
        boolean b=file.canWrite();
        System.out.println(a);
        System.out.println(b);
    }
}
