package exception;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 自动关闭特性是编译器认可的，而非虚拟机，编译器在编译时将代码改为FinallyDemo2的样子，
 */
public class AutoCloseableDemo {
    public static void main(String[] args) {
        try (
            FileOutputStream fos=new FileOutputStream("fos.dat");

            ) {
            int d=1;
            fos.write(d);
            fos.close();
        }catch (IOException e){

        }
            System.out.println("IOException occurred and was resolved");
        }
    }

