package cn.tedu.submarine;

import javax.swing.*;
import java.io.Serializable;

/**
 * 深水炸弹类模板：
 */
public class Bomb extends SeaObject{ //继承父类

    Bomb(int x, int y) {//构造方法
        super(x, y, 9, 12, 3);
    }

    @Override
    void step() {
        y += speed;//深水炸弹 y向下运动
    }

    @Override
    public ImageIcon getImage() {
        if (this.isLive()) {//如果当前这个对象是活着的
            return ImageResources.bomb;//返回深水炸弹图片
        }
        return null;//如果能执行这一行 说明当前对象是si亡状态 返回null
    }

    @Override
    public boolean isoutBounds() {
        return this.y >= GameWorld.HEIGHT;//如果当前深水炸弹对象的y大于等于窗口的高
    }
}
