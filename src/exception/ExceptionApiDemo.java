package exception;

import java.sql.SQLOutput;

/**
 * 异常常用方法
 */
public class ExceptionApiDemo {
    public static void main(String[] args) {
        System.out.println("start");

        try {
            String str="abc";
            System.out.println(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            System.out.println("Error!");
            e.printStackTrace();
            String message=e.getMessage();
            System.out.println(message);
        }
        System.out.println("end");
    }
}
