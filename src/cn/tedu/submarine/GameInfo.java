package cn.tedu.submarine;

import java.io.Serializable;

/**
 * 保存所有游戏信息的类
 * 使用这个类的实例作为存档对象
 */
public class GameInfo implements Serializable {
    Battleship ship = new Battleship();//声明一个战舰类型的变量
    //为数组写上{} 表示创建了数组对象 不过该数组对象并没有任何元素
    Bomb[] bombs = {}; //声明一个深水炸弹类型数组的变量
    SeaObject[] submarines = {};//代表三种潜艇
    SeaObject[] thunders = {};  //代表两种雷
    private int subEnterIndex = 0;//控制潜艇产生的速度
    private int thunderEnterIndex = 0;//控制雷产生的速度
    int score = 0;//默认游戏分数为 0

    public GameInfo(Battleship ship, Bomb[] bombs, SeaObject[] submarines, SeaObject[] thunders, int subEnterIndex, int thunderEnterIndex, int score) {
        this.ship = ship;
        this.bombs = bombs;
        this.submarines = submarines;
        this.thunders = thunders;
        this.subEnterIndex = subEnterIndex;
        this.thunderEnterIndex = thunderEnterIndex;
        this.score = score;
    }

    public void setShip(Battleship ship) {
        this.ship = ship;
    }

    public void setBombs(Bomb[] bombs) {
        this.bombs = bombs;
    }

    public void setSubmarines(SeaObject[] submarines) {
        this.submarines = submarines;
    }

    public void setThunders(SeaObject[] thunders) {
        this.thunders = thunders;
    }

    public void setSubEnterIndex(int subEnterIndex) {
        this.subEnterIndex = subEnterIndex;
    }

    public void setThunderEnterIndex(int thunderEnterIndex) {
        this.thunderEnterIndex = thunderEnterIndex;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Battleship getShip() {
        return ship;
    }

    public Bomb[] getBombs() {
        return bombs;
    }

    public SeaObject[] getSubmarines() {
        return submarines;
    }

    public SeaObject[] getThunders() {
        return thunders;
    }

    public int getSubEnterIndex() {
        return subEnterIndex;
    }

    public int getThunderEnterIndex() {
        return thunderEnterIndex;
    }

    public int getScore() {
        return score;
    }
}
