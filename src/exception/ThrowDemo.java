package exception;

/**
 * 异常的抛出
 */
public class ThrowDemo {
    public static void main(String[] args) {
        Person p=new Person();

        try {
            p.setAge(1000);//满足语法，但不满足业务
        }  catch (IllegalAgeException e) {
            e.printStackTrace();
        }

        System.out.println("此人年龄为"+p.getAge()+"岁");
    }
}
