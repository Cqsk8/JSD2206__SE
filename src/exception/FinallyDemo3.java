package exception;



public class FinallyDemo3 {
    public static void main(String[] args) {
        System.out.println(
        test("0")+","+test(null)+","+test("")
        );
    }
    //定义int方法的时候默认建立一个int类型的return类型值
    public static int test(String str){
        try{
            return str.charAt(0)-'0';
        }catch (NullPointerException e){
            return 1;
        }catch (Exception e){
            return 2;
        }finally {
            return 3;
        }
    }
}

