package exception;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.FileOutputStream;
import java.io.IOException;

public class FinallyDemo2 {
    public static void main(String[] args) {
        System.out.println("start");
        FileOutputStream fos=null;
        try{
            fos=new FileOutputStream("fos.dat");
            fos.write(1);
        }catch (IOException e){
            System.out.println("A IOException problem occurred and was resolved");
        }finally {
            try {
                if(fos!=null)
                fos.close();
            }catch (IOException e){
                e.printStackTrace();
            }
            System.out.println("The code inside of finally has been executed");
        }
        System.out.println("end");
    }
}
