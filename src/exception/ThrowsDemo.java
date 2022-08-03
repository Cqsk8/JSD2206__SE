package exception;

import java.awt.*;
import java.io.IOException;

/**
 * 子类重写超类含有throws声明异常抛出的方法时，对throws的重写规则
 */
public class ThrowsDemo {
    public void dosome()throws IOException, AWTException{}
}

class sub extends ThrowDemo{
    //1.
    //public void dosome() throws IOException,AWTEexception{}

    //2.
    //publice void dosome(){}

    //3.
    //public void dosome()throws IOException{}

    //4.
    //public void dosome()throws FileNotFoundException

    //5.
    //public void dosome()throws SQLException{}

    //6.
    //public void dosome()throws Exception{}
}