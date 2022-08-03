package cn.tedu.submarine;

import javax.swing.*;

/**
 * 水雷潜艇类模板
 */
public class MineSubmarine extends SeaObject implements EnemyLife{//继承了水雷潜艇
    MineSubmarine() {
      super(63,19);//调用父类的构造方法 传递当前潜艇的宽高即可
    }

    @Override
    void step() {
        x += speed;
    }

    @Override
    public ImageIcon getImage() {
        if(this.isLive()){//如果当前对象是活着的话
            return ImageResources.minesubm;//返回水雷潜艇图片
        }
        return  null;//执行到这里 则表示对象不是活着的 则返回null
    }

    @Override
    public int getLife() {
        return 1;
    }
}
