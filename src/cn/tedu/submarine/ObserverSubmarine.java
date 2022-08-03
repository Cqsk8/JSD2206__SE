package cn.tedu.submarine;

import javax.swing.*;

/**
 * 侦察潜艇类模板
 */
public class ObserverSubmarine extends SeaObject implements EnemyScore {//继承父类

    ObserverSubmarine() {
        super(63, 19);
    }

    @Override
    void step() {
        x += speed;
    }
    @Override
    public ImageIcon getImage() {
        if (this.isLive()) {//如果当前对象是活着的话
            return ImageResources.obsersubm;//返回侦察潜艇图片
        }
        return null;//执行到这里 则表示对象不是活着的 则返回null
    }

    @Override
    public int getScore() {
        return 10;
    }
}
