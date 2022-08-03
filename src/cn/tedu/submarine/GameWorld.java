package cn.tedu.submarine;
//1.

import javax.swing.*;
import java.awt.*;

import java.io.*;
import java.util.Arrays;
import java.util.TimerTask;   //任务模板
import java.util.Timer;      //定时器模板

import java.awt.event.KeyAdapter; //键盘侦听器
import java.awt.event.KeyEvent;  //键盘事件


/**
 * 游戏窗口类：负责运行游戏
 * 存放项目运行相关的代码逻辑
 */
public class GameWorld extends JPanel { //2.类继承 JPanel
    public static final int WIDTH = 641;/** 宽 */
    public static final int HEIGHT = 479;/** 高 */

    public static final int START = 0;//开始状态
    public static final int RUNNING = 1;//运行状态
    public static final int GAME_OVER = 2;//结束状态
    private int currentState = START;//默认是开始状态



    Battleship ship = new Battleship();//声明一个战舰类型的变量
    //为数组写上{} 表示创建了数组对象 不过该数组对象并没有任何元素
    Bomb[] bombs = {}; //声明一个深水炸弹类型数组的变量
    SeaObject[] submarines = {};//代表三种潜艇
    SeaObject[] thunders = {};  //代表两种雷

    public GameWorld() throws IOException {
    }

    /**
     * 生成潜艇的方法  返回值可以写具体潜艇类型吗？不可以！如果写了具体子类型
     * 方法则不通用
     * 返回值写父类型 SeaObject   实现父类型可以代表不同子类
     */
    public SeaObject createSubmarine() {

        //产生 0~20的随机数
        int type = (int) (Math.random() * 20);
        if (type < 10) {//如果生成的随机数在 0 ~ 9
            return new ObserverSubmarine();//返回侦察潜艇
        } else if (type < 15) {//如果生成的随机数在 10 ~ 14
            return new TorpedoSubmarine();//返回鱼雷潜艇
        } else {
            return new MineSubmarine();//返回水雷潜艇
        }
    }


    private int subEnterIndex = 0;//控制潜艇产生的速度

    /**
     * 潜艇入场的方法： 将随机产生的潜艇对象 装到  潜艇数组中
     */
    public void submarineEnterAction() {// 每10毫秒 (0.01s)调用一次
        subEnterIndex++;//自增  每10毫秒自增一次
        if (subEnterIndex % 40 == 0) { //每400毫秒走一次if (0.4s)
            //1. 调用生成潜艇的方法 返回一个随机潜艇对象  接收
            SeaObject obj = createSubmarine();
            //2. 为潜艇数组在原有基础上扩1个容量
            submarines = Arrays.copyOf(submarines, submarines.length + 1);
            //3. 将对象 赋值给数组中下标最后一个空间
            submarines[submarines.length - 1] = obj;
        }
    }

    private int thunderEnterIndex = 0;//控制雷产生的速度

    /**
     * 控制雷入场的方法 ---放到run中测试
     */
    public void thunderEnterAction() {//每0.01s执行
        thunderEnterIndex++;
        if (thunderEnterIndex % 100 == 0) {//控制每1000毫秒(1s)执行
//               1.for循环 遍历潜艇数组
            for (int i = 0; i < submarines.length; i++) {
                //2.在for循环体里面 访问潜艇数组的每个对象并调用shootThunder方法 声明一个SeaObject类型接收
                SeaObject obj = submarines[i].shootThunder();
                if (obj != null) {
//               3.为当前雷数组扩容
                    thunders = Arrays.copyOf(thunders, thunders.length + 1);
//               4.将接收的雷对象 装到雷数组中的最后一个元素中
                    thunders[thunders.length - 1] = obj;
                }
            }
        }
    }

    /**
     * 所有的潜艇、雷、深水炸弹的移动功能
     */
    public void stepAction() {
        for (int i = 0; i < submarines.length; i++) {
            submarines[i].step();//调用潜艇数组的每个对象的移动方法
        }
        for (int i = 0; i < thunders.length; i++) {
            thunders[i].step();//调用雷数组的每个对象的移动方法
        }
        for (int i = 0; i < bombs.length; i++) {
            bombs[i].step();//调用深水炸弹数组的每个对象的移动方法
        }
    }

    /**
     * 深水炸弹入场的方法        放在当按下空格键的if内调用
     */
    public void bombEnterAction() {
        //1.通过战舰对象调用 shootBobm方法 并用深水炸弹类型来接收
        Bomb obj = ship.shootBomb();
        //2.为bombs数组扩1个容
        bombs = Arrays.copyOf(bombs, bombs.length + 1);
        //3.将接收的对象赋值给bombs数组最后一个元素
        bombs[bombs.length - 1] = obj;
    }

    /**
     * 此方法是用来自动判断并删除越界对象的方法   放到run中调用
     */
    public void outOfBounds() {
        //1.遍历潜艇数组,并在循环里
        for (int i = 0; i < submarines.length; i++) {
            if (submarines[i].isoutBounds() || submarines[i].isDead()) {//判断当前潜艇数组的每个对象是否越界或者是否死亡
                //2.若成立则将当前对象剔除出数组中。
                submarines[i] = submarines[submarines.length - 1];//将数组最后的元素赋值给当前越界的元素空间 (替换)
                submarines = Arrays.copyOf(submarines, submarines.length - 1);//删除最后一个空间 (缩容)
            }
        }
        //遍历雷数组
        for (int i = 0; i < thunders.length; i++) {
            if (thunders[i].isoutBounds() || thunders[i].isDead()) {
                thunders[i] = thunders[thunders.length - 1];
                thunders = Arrays.copyOf(thunders, thunders.length - 1);
            }
        }
        //遍历深水炸弹数组
        for (int i = 0; i < bombs.length; i++) {
            if (bombs[i].isoutBounds() || bombs[i].isDead()) {
                bombs[i] = bombs[bombs.length - 1];
                bombs = Arrays.copyOf(bombs, bombs.length - 1);
            }
        }
    }

    //    public SeaObject[] isOut(SeaObject[] seaObjects){
//        for (int i = 0; i < seaObjects.length; i++) {
//            if(seaObjects[i].isoutBounds()){
//                seaObjects[i] = seaObjects[seaObjects.length-1];
//                seaObjects = Arrays.copyOf(seaObjects,seaObjects.length-1);
//            }
//        }
//        return seaObjects;
//    }
    int score = 0;//默认游戏分数为 0

    /**
     * 深水炸弹与潜艇碰撞检测的具体使用。  放run中调用。
     */
    public void bombBangAction() {
        for (int i = 0; i < bombs.length; i++) {//控制轮数
            Bomb b = bombs[i];//获取当前深水炸弹对象
            for (int j = 0; j < submarines.length; j++) {//次数
                SeaObject s = submarines[j];//获取当前潜艇数组中的对象
                //如果当前深水炸弹对象是活的 并且 当前潜艇对象也是活的 最后再去调用互相检测
                if (b.isLive() && s.isLive() && b.isHit(s)) {//当前深水炸弹对象调用检测的方法 将 潜艇对象传递进去
                    b.goDead();
                    s.goDead();
                    if (s instanceof EnemyScore) {//判断当前s这个潜艇对象 有没有实现EnemyScore接口
                        EnemyScore addScore = (EnemyScore) s;//直接把s强转成EnemyScore接口类型
                        //编译期间调父  运行时执行子。
                        score += addScore.getScore();//具体运行时使用的是侦察潜艇还是鱼雷潜艇 要看 地址指向的是哪个对象
                    } else if (s instanceof EnemyLife) {//判断当前s这个潜艇对象 有没有实现EnemyLife接口
                        EnemyLife addLife = (EnemyLife) s;
                        ship.setLife(addLife.getLife());
                    }


//                    以下代码的问题：
//                    复用性差   扩展性差    维护性差 （代码要遵循开闭原则 对扩展开放,对修改关闭）
//                    加分  加命的方法
//                    判断s是不是 侦察潜艇类型
//                    if (s instanceof ObserverSubmarine) {//如果s对象是侦察潜艇的话
//                        //则强转侦察潜艇类型  因为 s是SeaObject类型 不强转则无法调用getScore方法
//                        ObserverSubmarine os = (ObserverSubmarine) s;
//                        score += os.getScore();
//                    } else if (s instanceof TorpedoSubmarine) {//如果s对象是鱼雷潜艇的话
//                        TorpedoSubmarine ts = (TorpedoSubmarine) s;
//                        score += ts.getScore();
//                    } else if (s instanceof MineSubmarine) {
//                        MineSubmarine ms = (MineSubmarine) s;
//                        ship.setLife(ms.getLife());
//                    }else if(s instanceof  以后的潜艇类型？){
//                        ???
//                    }
                }
            }
        }
    }

    /**
     * 雷与战舰检测的逻辑     放 run中调用。
     */
    public void thunderBangAction() {
        for (int i = 0; i < thunders.length; i++) {
            SeaObject t = thunders[i];//当前雷对象
            if (t.isLive() && t.isHit(ship)) {//如果雷对象是活着的状态并且 雷对象与战舰碰到的话
                t.goDead();//当前雷对象消失
                //战舰减命
                ship.subtractLife();
            }
        }
    }

    /**
     * 检测游戏是否结束的方法  ----实时检测 放 run中调用
     */
    public void checkGameOverAction() {
        if (ship.getLife() <= 0) {//如果战舰命数小于等于 0
            currentState = GAME_OVER;//切换状态为 游戏结束状态
        }
    }

    //用来测试的方法
    void action(){

        //游戏一开始，先询问是否存档
        File file=new File("game.sav");
        //判断存档文件是否存在
        //若文件存在，则询问用户是否读取存档
        if(file.exists()){

            int r=JOptionPane.showConfirmDialog(
                    GameWorld.this,
                    "读取存档吗?"
            );
            if(r==JOptionPane.YES_OPTION){//如果用户点击的为“是”这个按钮
                //读取存档
                try {
                    FileInputStream fis = new FileInputStream(file);
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    Object obj=ois.readObject();
                    GameInfo gameInfo=(GameInfo) obj;
                    ship=gameInfo.getShip();
                    bombs=gameInfo.getBombs();
                    submarines=gameInfo.getSubmarines();
                    thunders=gameInfo.getThunders();
                    subEnterIndex=gameInfo.getSubEnterIndex();
                    thunderEnterIndex=gameInfo.getThunderEnterIndex();
                    score=gameInfo.getScore();
                    ois.close();
                }catch(Exception ex){

                }
            }
        }

        //实现键盘侦听事件相关逻辑代码
        KeyAdapter adapter = new KeyAdapter() { //创建具体侦听对象
            @Override
            public void keyPressed(KeyEvent e) { //重写实现按下键盘键的事件


                //可以通过KeyEvent类直接访问键盘的按键
                if(e.getKeyCode()==KeyEvent.VK_P){
                    currentState=START;
                    int r=JOptionPane.showConfirmDialog(
                            GameWorld.this,
                            "保存游戏吗？"
                    );
                    if(r==JOptionPane.YES_OPTION){
                        GameInfo gameInfo=new GameInfo(ship,bombs,submarines,thunders,subEnterIndex,thunderEnterIndex,score);

                        try {
                            FileOutputStream fos = new FileOutputStream("game.sav");
                            ObjectOutputStream oos = new ObjectOutputStream(fos);
                            oos.writeObject(gameInfo);
                            oos.close();
                        }catch(Exception ex){}
                    }
                    currentState=RUNNING;//当确认窗口消失后，让游戏恢复运行
                }

                //可以通过参数e里面提供一个方法 getKeyCode() 来获取用户当下按下的按键是什么
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {//判断用户按下的按键是不是空格键
                    if (currentState == START) { //当前状态是不是开始状态
                        currentState = RUNNING;//切换当前状态为运行状态
                    } else {//否则
                        bombEnterAction(); //发射深水炸弹
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {//判断用户按下的按键是不是左移键
                    ship.leftMove();//调用战舰对象左移动
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {////判断用户按下的按键是不是右移键
                    ship.rightMove();//调用战舰对象右移动
                }
            }
        };
        this.addKeyListener(adapter);//将键盘侦听器添加到检测当中


        Timer timer = new Timer();//创建具体 定时器对象
        TimerTask task = new TimerTask() {
            @Override
            public void run() { //自定义的任务逻辑方法
                if (currentState == RUNNING) { //如果当前状态是运行状态
                    submarineEnterAction();//调用潜艇入场的方法
                    thunderEnterAction();//调用雷入场的方法
                    stepAction();//调用移动的方法
                    outOfBounds();//调用删除优化对象的方法
                    bombBangAction();//调用深水炸弹与潜艇检测碰撞的方法
                    thunderBangAction();//调用雷与战舰的检测碰撞的方法
                    checkGameOverAction();//调用检测是否游戏结束的方法
                    // System.out.println(submarines.length + "当前潜艇在内存中的数量" + ",雷在内存中的数量" + thunders.length);
                    repaint();//刷新绘制 每0.01s 执行一次
                }
            }
        };
        //1.具体执行的任务  2.延时多久开始第一次执行(毫秒) 3.执行第一次以后下次执行的间隔时间(毫秒)
        timer.schedule(task, 5000, 10);// 0.01s
    }

    //绘制界面的方法
    void paintWorld() {
        //1.创建一个画框
        JFrame frame = new JFrame();
        this.setFocusable(true);
        frame.add(this);//将当前类 添加到画框里
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口时释放程序
        frame.setSize(WIDTH + 16, HEIGHT + 39);//画框的大小
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);//设置窗口可见
    }

    @Override               //g 可以理解为画笔
    public void paint(Graphics g) { //JPanle 提供了绘制图片的方法
        //              1.填null 2.填g 3.0 4.0
        if (currentState == START) { //当前状态如果是开始状态
            ImageResources.start.paintIcon(null, g, 0, 0);
        } else if (currentState == RUNNING) {//当前状态如果是运行状态
            ImageResources.sea.paintIcon(null, g, 0, 0);
            ship.paintImage(g);//绘制战舰

            for (int i = 0; i < submarines.length; i++) {
                submarines[i].paintImage(g); //绘制潜艇数组中所有对象
            }
            for (int i = 0; i < thunders.length; i++) {
                thunders[i].paintImage(g);//绘制雷数组中 所有的对象
            }
            for (int i = 0; i < bombs.length; i++) {
                bombs[i].paintImage(g);//绘制深水炸弹数组中的所有对象
            }
            //绘制命数
            g.drawString("Life:" + ship.getLife(), 400, 50);
            //绘制分数
            g.drawString("Score:" + score, 200, 50);
        } else if (currentState == GAME_OVER) {
            ImageResources.gameover.paintIcon(null, g, 0, 0);
        }
    }


    public static void main(String[] args) throws IOException {
        GameWorld gw = new GameWorld();
        gw.paintWorld();//调用绘制窗口的功能
        gw.action();//调用了测试的方法
    }
    /**
     *   1.为什么要将各类的变量声明在main的外面呢？
     *      答：在main方法中声明的变量作用域只在main中,后期当前类其它的地方也需要用到这些变量,
     *          所以应设计为成员变量。
     *   2.为什么要单独写一个action方法做测试？
     *      答：因为main是static修饰的方法，比较特殊,普通成员变量无法方法main中使用,所以需要单独
     *          定义普通的action方法,来进行测试。
     *   3.为什么要创建GameWorld类对象再调用action方法？
     *      答：因为main是static修饰的方法，比较特殊,普通方法是无法放到main中使用,所以我们可以通过
     *         创建GameWorld类对象 因为对象可以调用action方法。
     **/

}
