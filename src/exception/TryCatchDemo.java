package exception;

/**
 * Java 异常处理机制
 * Java中所有的异常的顶级超类为：Throwable
 * 而Throwable下面定义了两个子类型：Error和Exception
 * Error不可处理
 * Exception可以处理
 * 我们通常仅在异常处理机制中处理Exception
 *
 *  异常处理机制中的：try-catch
 *
 *  语法
 *      try{
 *      可能出现异常的代码片段
 *          }catch(XXXException e){
 *              处理try中出现XXXException的代码
 *          }
 */

public class TryCatchDemo {
    public static void main(String[] args) {
        System.out.println("Start");

        try {
//            String str = null;
//            System.out.println(str.length());

            String str="";
            System.out.println(str.charAt(0));
            System.out.println("!!!!!!!!");
        }catch (StringIndexOutOfBoundsException|NullPointerException e){
            System.out.println("出现了字符串下标越界或空指针，并解决了");
       }
        System.out.println("end");
    }
}
