package cn.tedu.submarine;

import javax.swing.*;

/**
 *  鱼雷类模板：
 * */
public class Torpedo  extends SeaObject{//继承了父类

    Torpedo(int x, int y){
        super(x,y,5,18,2);
    }

    @Override
    void step() {
       y -= speed;
    }
    @Override
    public ImageIcon getImage() {
        if(this.isLive()){//如果当前对象是活着的话
            return ImageResources.torpedo;//返回鱼雷图片
        }
        return  null;//执行到这里 则表示对象不是活着的 则返回null
    }

    @Override
    public boolean isoutBounds() {
        return this.y <= -this.height;//如果当前鱼雷对象的y 小于等于 负自身图片的高度
    }
}
