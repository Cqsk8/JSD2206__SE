package file;

import java.io.File;

public class ListFileDemo {
    public static void main(String[] args) {
        File dir=new File(".");
        File[] files=dir.listFiles();
        for (int i=0;i<dir.length();i++){
            System.out.println(files[i].getName());
        }
    }
}
