package file;

import java.io.File;
import java.io.IOException;

public class CreatNewFileDemo {
    public static void main(String[] args) throws IOException {
        File file=new File("./test.txt");
        if(file.exists()){
            System.out.println(" cun zai");
        }else {
            file.createNewFile();
        }
    }
}
