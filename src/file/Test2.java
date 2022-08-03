package file;

import java.io.File;
import java.io.FileFilter;

public class Test2 {
    public static void main(String[] args) {
        FileFilter filter=new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.getName().startsWith("D");
            }
        };

        File file=new File("./src/file");
        if(file.isDirectory()){
            File[] subs=file.listFiles(filter);
            for(int i=0;i< subs.length;i++){
                System.out.println(subs[i].getName());
            }
        }
    }
}
