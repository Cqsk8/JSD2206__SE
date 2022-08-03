package cn.tedu.submarine;

import javax.jnlp.ClipboardService;
import javax.swing.*;
import java.io.Serializable;

/**
 * 战舰类：
 * 是模板 放战舰对象所共有的属性和行为
 */
public class Battleship extends SeaObject{//继承海洋对象类

    //----命数
    private int life;

    public int getLife() { //提供获取战舰命数的方法
        return life;
    }

    public void setLife(int life) {//提供设置战舰命的方法。
        if (life > 0) { //如果外部传递命数大于0
            this.life += life;//为当前对象的life 累加命数
        }
    }
    public void subtractLife(){//提供减命的方法
        this.life--;
    }

    Battleship() {//当前这个类模板的无参数构造方法
        super(270, 124, 66, 26, 20);
        life = 5;//游戏开始5条命
    }

    //左移
    public void leftMove() {
        this.x -= speed;
    }

    //右移
    public void rightMove() {
        this.x += speed;
    }

    @Override
    void step() {
        System.out.println("战舰通过键盘左右运动");
    }

    //该方法被对象调用
    @Override//战舰比较特殊 并不是一打就si亡 所以在这里直接返回图片的就可以了
    public ImageIcon getImage() {
        return ImageResources.battleShip;//返回战舰图片
    }

    /**
     * 当外部的战舰对象调用发射深水炸弹这个方法时,返回一个深水炸弹对象
     * 返回值 写深水炸弹类型
     */
    public Bomb shootBomb() {
        return new Bomb(this.x, this.y);//返回深水炸弹对象 坐标位置是战舰的坐标
    }
}
