package file;

import java.io.File;

public class DeleteDirDemo {
    public static void main(String[] args) {
        File dir= new File("Demo2/a/b/c/d");
        if(dir.exists()){
            dir.delete();
            System.out.println("Delete!");
        }else {
            System.out.println("Not exist!");
        }
    }
}
