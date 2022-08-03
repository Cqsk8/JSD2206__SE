package file;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        for(int i=0;i<100;i++) {
            File file = new File("test" + i + ".txt");
            file.createNewFile();
            //file.delete();
        }
    }
    }


