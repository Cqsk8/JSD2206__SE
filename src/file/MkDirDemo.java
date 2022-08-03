package file;

import java.io.File;

public class MkDirDemo {
    public static void main(String[] args) {
        File dir=new File("Demo2/a/b/c/d");
        if(dir.exists()){
            System.out.println("exists!");
        }else{
            dir.mkdirs();
            System.out.println("successful");
        }
    }
}
