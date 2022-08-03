package lambda;

import java.io.File;
import java.io.FileFilter;

public class LambdaDemo {
    public static void main(String[] args) {
        FileFilter filter=new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.getName().contains("t");
            }
        };

        FileFilter f1=(File file)->{
            return file.getName().contains("");
        };

        FileFilter f2=file->{
            return file.getName().contains("");
        };

        FileFilter f3=file->file.getName().contains("");
    }
}
