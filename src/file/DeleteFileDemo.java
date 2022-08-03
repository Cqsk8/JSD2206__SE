package file;

import java.io.File;

public class DeleteFileDemo {
    public static void main(String[] args) {
        File file=new File("./test.txt");
        if(file.exists()){
            file.delete();
        }else {
            System.out.println("404not found");
        }
    }
}
