package exception;

public class FinallyDemo {
    public static void main(String[] args) {
        System.out.println("Start");
        try{
            String str=null;
            System.out.println(str.length());
        }catch (NullPointerException e){
            System.out.println("NullPointerException");
        }finally {
            System.out.println("The code inside of finally has been executed");
        }
        System.out.println("End");
    }
}
