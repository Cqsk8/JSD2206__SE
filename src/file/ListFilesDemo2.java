package file;

import java.io.File;
import java.io.FileFilter;

/**
 *重载的listFiles方法
 *Files[] listFiles(FileFilter filter)
 * 该方法允许我们传入一个文件过滤器，然后将File对象表示的目录中所有子项返回
 */
public class ListFilesDemo2 {
    public static void main(String[] args) {
        File dir=new File("./src/file");

        if(dir.isDirectory()){
            File[] subs=dir.listFiles(file->file.getName().contains("o"));
            for (int i=0;i<dir.length();i++){
                System.out.println(subs[i].getName());
            }
        }
    }
}
