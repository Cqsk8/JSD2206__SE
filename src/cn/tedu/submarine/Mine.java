package cn.tedu.submarine;

import javax.swing.*;

/**
 * 水雷类模板
 */
public class Mine extends SeaObject {//继承水雷

    Mine(int x, int y) {
        super(x, y, 11, 11, 2);
    }

    @Override
    void step() {
        y -= speed;//水雷向上运动
    }


    @Override
    public ImageIcon getImage() {
        if (this.isLive()) { //如果当前对象是活着的话
            return ImageResources.mine; //返回水雷图片
        }
        return null;//执行到这里 则表示对象不是活着的 则返回null
    }

    @Override
    public boolean isoutBounds() {
        return this.y <= 150 - this.height;//如果水雷的高小于等于水平面-水雷图的高
    }

}
