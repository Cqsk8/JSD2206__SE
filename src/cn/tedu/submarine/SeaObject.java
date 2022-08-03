package cn.tedu.submarine;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

/**
 * 海洋对象类：
 * 所有海洋对象的父类
 * 存放所有子类共有的属性和行为
 */
public abstract class SeaObject  implements Serializable {
    public static final int LIVE = 0;//活着的状态
    public static final int DEAD = 1;//死亡的状态
    //当前状态
    public int currentState = LIVE;//默认初始化对象都是活着的状态

    //共有的属性
    int x;
    int y;
    int width;
    int height;
    int speed;

    /**
     * 此构造方法是专门为三种潜艇提供构造的方法
     * 因为潜艇宽高不同,所以宽高不能写死,做成形式参数,由具体的子类传递它的宽高数据
     * x y  speed 初始化的数据都是一样的 则写死即可.
     */
    SeaObject(int width, int height) {//构造方法
        this.width = width;
        this.height = height;
        x = -width;//x坐标负一个图片的宽度  表示在屏幕左侧外面.
        y = (int) (Math.random() * (GameWorld.HEIGHT - height - 150) + 150); //随机y坐标
        speed = (int) (Math.random() * (3 - 1) + 1);//随机速度1~3
    }

    /**
     * 因为赋值的过程是重复的.
     * 此构造方法是为战舰.深水炸弹.鱼雷和水雷提供的
     * 因为这4个类的具体数据都不同,所以做成形式参数,具体由当前类使用时提供
     */
    SeaObject(int x, int y, int width, int height, int speed) {
        this.x = x;
        this.y = y;
        this.width = width; //图片的宽
        this.height = height;//图片的高
        this.speed = speed;//每次移动多少
    }

    /**
     * 判断当前调用方法这个对象 是否是 死亡状态
     */
    public boolean isDead() {
        return currentState == DEAD;
    }

    /**
     * 判断当前调用方法这个对象 是否是 活着状态
     */
    public boolean isLive() {
        return currentState == LIVE;
    }

    //共有的行为
    //抽象方法需要放到抽象类里才可以
     abstract void step();

    /**
     * 因为每个子类都需要进行获取图片,那么就将获取图片的行为提取到父类中
     * 因为每个子类获取图片的逻辑是不一样的 所以做一个抽象方法
     * 返回值是 图片类型
     * 获取图片的抽象方法  供具体子类重写实现返回对应的图片
     */
    public abstract ImageIcon getImage();

    /**
     * 因为每个子类都需要进行绘制,那么就将绘制的行为提取到父类中
     * 因为每个子类绘制的逻辑都是一样的 所以做一个普通方法
     * 参数需要一个画笔 通过外部调用方法时传递一个画笔
     */
    public void paintImage(Graphics g) {
        //如何表示调用该方法的对象
        if (this.getImage() != null) { //如果当前对象获取图片不为null
            ImageIcon icon = this.getImage();//获取当前对象图片
            //1.填null  2. 填 g   3.x坐标   4.y坐标
            icon.paintIcon(null, g, this.x, this.y);//绘制当前图片
            //+100是为了能看到潜艇 后续还是要删的
        }
    }


    /**
     * 生成雷的方法  返回值可以写具体雷类型吗？不可以！如果写了具体子类型
     * 方法则不通用
     * 返回值写父类型 SeaObject   实现父类型可以代表不同子类
     * 后续会被水雷潜艇或者鱼雷潜艇调用   侦察潜艇也可能会调用
     */
    public SeaObject shootThunder() {
        //创建雷对象之前  要先将雷对象的x 和y 坐标 算出来
        int x = this.x + this.width;//雷的x坐标
        int y = this.y - 5;//雷的y坐标
        //instanceof 关键字作用：判断 是否是某个类型的语法
        if (this instanceof MineSubmarine) {//判断this这个对象 是不是 水雷潜艇
            return new Mine(x, y);//返回水雷
        } else if (this instanceof TorpedoSubmarine) {//判断this这个对象 是不是 鱼雷潜艇
            return new Torpedo(x, y);//返回鱼雷
        } else {
            return null; //如果能走到这一行 说明侦察潜艇调用了发射雷的方法 那么返回null
        }
    }

    /**
     * 是否越界的方法：
     * 为什么不做抽象方法而做普通方法：
     * 因为三种潜艇的判断是否越界的标准是一样的,可以复用
     * 其它三个类,深水炸弹,鱼雷,水雷类 不一样,则自行重写实现即可
     */
    public boolean isoutBounds() {
        return this.x >= GameWorld.WIDTH;//判断潜艇是否超出屏幕的宽
    }

    /*
     * 检测碰撞的方法,这个方法由子类对象来进行调用。
     */
    public boolean isHit(SeaObject other) {
        //this
        //other
        /**
         x1：   this的x  - other的宽
         x2:   this的x +   this的宽
         y1:   this的y -  other的高
         y2:   this的y +  this的高
         */
        int x1 = this.x - other.width;
        int x2 = this.x + this.width;
        int y1 = this.y - other.height;
        int y2 = this.y + this.height;
        int x = other.x;
        int y = other.y;
        //如果传入对象的x 在 x1和x2之间 y在y1和y2之间 则返回为true 代表撞上了。
        return  (x >= x1 && x <= x2) && (y >= y1 && y <= y2);
    }

    /**
     * 哪个对象打点调用狗带方法,那么就将当前对象设置为si亡状态。
     *
     * */
    public void goDead(){
        this.currentState = DEAD;//设置状态为si亡状态。
    }
}
