package cn.tedu.submarine;

import javax.swing.*;

/**
 * 鱼雷潜艇类模板：
 */
public class TorpedoSubmarine extends SeaObject implements EnemyScore {//继承了父类

    TorpedoSubmarine() {
        super(64, 20);
    }

    @Override
    void step() {
        x += speed;
    }

    @Override
    public ImageIcon getImage() {
        if (this.isLive()) {//如果当前对象是活着的话
            return ImageResources.torpedosubm;//返回鱼雷潜艇图片
        }
        return null;//执行到这里 则表示对象不是活着的 则返回null
    }
    @Override
    public int getScore() {
        return 40;
    }
}
