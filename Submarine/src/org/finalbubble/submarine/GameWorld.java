package org.finalbubble.submarine;

/**
 * @author yangq
 * @date 2023-03-23
 * @Project Phase one
 * @Package org.finalbubble.submarine
 * @Description 游戏窗口类： 负责加载并运行游戏存放的就是运行时对象交互的逻辑
 */

import javax.swing.*;
import java.awt.*;

import java.security.PublicKey;
import java.util.Arrays;
import java.util.TimerTask;//任务模板
import java.util.Timer;//定时器模板

import java.awt.event.KeyEvent;//键盘事件
import java.awt.event.KeyAdapter;//键盘侦听事件

public class GameWorld extends JPanel{

    public static final int WIDTH = 641;/** 窗口的宽 */
    public static final int HEIGHT = 479;/** 窗口的高 */

    public static final int GAME_START = 0;//开始状态
    public static final int RUNNING = 1;//运行状态
    public static final int GAME_OVER = 2;//结束状态

    private int gameCurrentState = GAME_START;//默认游戏运行是开始状态

    private Battleship battleship = new Battleship();//创建一个战舰对象  并将对象赋值 //声明了一个ship   -----成员变量
    private Bomb[] bombs = {};//声明一个深水炸弹组的变量
    private SeaObject[] submarines = {};//代表三种潜艇的父类型数组
    private SeaObject[] thunders = {};//代表二种雷的父类型数组.

    //private SeaObject[] submarines = {};  等价于new 数组名[0];   创建了数组对象，但没有开辟数组下的空间

    private int score = 0;//代表游戏分数

    /**
     * 生成潜艇对象的方法 返回值可以写具体潜艇类型吗？不可以
     * 如果写了具体的潜艇类型 方法就不通用了。
     * 返回值应该写SeaObject类型   父类型代表不同的子类行。兼容。
     */
    public SeaObject createSubmarine(){
        /**
         *  1. 产生0~20的随机数
         *  2.如果生成随机数 在0~9区间 返回侦察潜艇对象OS
         *    如果生成随机数 在10~14区间 返回水雷潜艇对象 MS
         *    如果生成随机数 在15~19区间 返回鱼雷潜艇对象 TS
         * */
        int type = (int) (Math.random() * 20);//0~19
        if (type < 10) {//在0~9区间
            return new ObserverSubmarine();//返回侦察潜艇对象OS
        } else if (type < 15) {//10~14
            return new MineSubmarine();
        } else {
            return new TorpedoSubmarine();
        }
    }

    private int submarineEnterIndex = 0;//潜艇生成速度的索引

    /*
    * 潜艇入场方法
    * */
    public void submarineEnterAction(){
        /*
         *    1.调用生成潜艇的方法 并接收潜艇对象
         *    2.将潜艇数组扩一个容量
         *    3.将生成的潜艇对象 赋值给 潜艇数组 扩容的位置
         * */
        submarineEnterIndex++;//自增  ------------每10毫秒自增一次
        if (submarineEnterIndex % 40 == 0){ // 0.4秒执行一次
            submarines = Arrays.copyOf(submarines,submarines.length + 1);
            submarines[submarines.length - 1] = createSubmarine();
        }

    }


    private int thunderEnterIndex = 0;//控制雷产生的速度
    /**
     * 雷入场的方法   ------------放到run执行
     */
    public void thunderEnterAction() {
        /**
         *   1. 循环遍历潜艇数组并调用数组中每个对象的shootThunder方法 并接收雷对象
         *   2. 判断雷对象是否为空
         *   3. 不为空, 才能将雷数组扩容
         *   4. 将雷对象赋值给 扩容的位置。
         */
        thunderEnterIndex++;
        if (thunderEnterIndex % 100 == 0) { //1000毫秒 1秒
            for (int i = 0; i < submarines.length; i++) {
                if (submarines[i].shootThunders() != null) {
                    thunders = Arrays.copyOf(thunders, thunders.length + 1);
                    thunders[thunders.length - 1] = submarines[i].shootThunders();
                }
            }
        }
    }

    /**
     * 实现调用需要自动移动的对象step方法 ------------放在run中调用
     */
    public void stepAction(){
        //遍历潜艇数组   调用每个对象的step方法
        for (int i = 0; i < submarines.length; i++) {
            submarines[i].step();
        }
        //遍历雷数组     调用每个对象的step方法
        for (int i = 0; i < thunders.length; i++) {
            thunders[i].step();
        }
        //遍历深水炸弹数组  调用每个对象的step方法
        for (int i = 0; i < bombs.length; i++) {
            bombs[i].step();
        }
    }

    /**
     * 深水炸弹入场方法  ----自动发生 应放在当按下键盘空格键的语句中调用
     */
    public void bombEnterAction() {
        //1.调用发射深水炸弹方法 接收对象
        Bomb b = battleship.shootBomb();
        //2.为深水炸弹数组扩容
        bombs = Arrays.copyOf(bombs, bombs.length + 1);
        //3.将对象 赋值给数组扩容的位置.
        bombs[bombs.length - 1] = b;
    }

    /**
     * 判断并删除越界对象的方法   -----------在run中调用
     */
    public void outOfBounds() {
        submarines = reconstruction(submarines);
        thunders = reconstruction(thunders);
        bombs = (Bomb[])reconstruction(bombs);
//        for (int i = 0; i < submarines.length; i++) {
//            if (submarines[i].isOutBounds()) { //2.在循环里一次访问并判断每个对象的isOutBounds方法
//                //4.可以将当前数组中最后一个元素 赋值给 当前越界对象位置 (submarine[i])
//                submarines[i] = submarines[submarines.length - 1];
//                //5. 缩容 ---所最后一个元素  数组.length-1  影响原数组。
//                submarines = Arrays.copyOf(submarines, submarines.length - 1);
//            }
//        }
//        //遍历删除越界的雷数组中 的对象
//        for (int i = 0; i < thunders.length; i++) {
//            if (thunders[i].isOutBounds()) {
//                thunders[i] = thunders[thunders.length - 1];
//                thunders = Arrays.copyOf(thunders, thunders.length - 1);
//            }
//        }
//        //遍历删除越界的深水炸弹数组中 的对象
//        for (int i = 0; i < bombs.length; i++) {
//            if (bombs[i].isOutBounds()) {
//                bombs[i] = bombs[bombs.length - 1];
//                bombs = Arrays.copyOf(bombs, bombs.length - 1);
//            }
//        }
    }

    public SeaObject[] reconstruction(SeaObject[] seaObjects){
        for (int i = 0; i < seaObjects.length; i++) {
            if (seaObjects[i].isOutBounds() || seaObjects[i].isDead()) {
               seaObjects[i] = seaObjects[seaObjects.length - 1];
               seaObjects = Arrays.copyOf(seaObjects, seaObjects.length - 1);
            }
        }
        return seaObjects;
    }

    /**
     * 此方法 处理 深水炸弹与潜艇碰撞的行为使用实现 ------run中
     */
    public void bombBangAction() {
        for (int i = 0; i < bombs.length; i++) { //控制轮数
            Bomb b = bombs[i]; //获取当前需要参与与每个潜艇对象碰撞检测的 炸弹对象！
            for (int j = 0; j < submarines.length; j++) {//控制次数
                if (b.isHit(submarines[j])) {//依次拿当前炸弹对象 与潜艇数组中的每个对象来进行碰撞检测
//                    System.out.println("撞上了！");
                    b.goDead();
                    submarines[j].goDead();
//                    b ---对象   标记为死亡
//                    submarines[j] -----对象  标记为死亡
                    /**
                     * 通过 instanceof 来判断 submarines[j] 到底是哪个具体类型潜艇
                     * 因为 当前submarines数组类型是SeaObject类型，没有加分加命的操作
                     * 需要向下转型，转换为具体的嵌套类型才可以调用对的加分加命的方法
                     */

//                    if (submarines[j] instanceof ObserverSubmarine){
//                        ObserverSubmarine observerSubmarine = (ObserverSubmarine) submarines[j];
//                        score += observerSubmarine.getScore();
//                    } else if (submarines[j] instanceof MineSubmarine) {
//                        MineSubmarine mineSubmarine = (MineSubmarine) submarines[j];
//                        battleship.setLife(mineSubmarine.getLife());
//                    } else if (submarines[j] instanceof TorpedoSubmarine) {
//                        TorpedoSubmarine torpedoSubmarine = (TorpedoSubmarine) submarines[j];
//                        score += torpedoSubmarine.getScore();
//                    }
                    //好处：新增加命 加分等行为的潜艇,以下代码不需要改变了.  提高程序复用性,扩展性
                    if (submarines[j] instanceof EnemyScore) { //判断当前潜艇对象是否实现 EnemyScore 接口
                        EnemyScore obj = (EnemyScore) submarines[j];
                        score += obj.getScore();//调父(接口) 执行子
                    } else if (submarines[j] instanceof EnemyLife) {//判断当前潜艇对象是否实现 EnemyLife 接口
                        EnemyLife obj = (EnemyLife) submarines[j];
                        int life = obj.getLife();
                        battleship.setLife(life);
                    }
                }
            }
        }
    }

    /**
     * 雷与战舰的碰撞检测具体实现    ---------放在run中调用
     */
    public void thunderBangAction(){
        /**
         * 遍历当前 雷数组,依次拿数组中的每个对象 与战舰对象进行碰撞检测,若碰上了 当前雷对象标记死亡。
         */
        for (int i = 0; i < thunders.length; i++) {
            if (thunders[i].isHit(battleship)){
//                System.out.println("撞上了！");
                thunders[i].goDead();//当前雷对象标记为死亡状态
                battleship.subtractLife();
                checkGameOver();//判断游戏是否结束
            }
        }
    }

    /*
    * 检测游戏是否结束  -----放在run中调用
    * */
    public void checkGameOver(){
        if (battleship.getLife() <= 0){//当战舰命数为0
            gameCurrentState = GAME_OVER;//切换设置游戏结束状态
        }
    }


    private void action(){ //将声明的变量对应  的  对象都创建出来
        //实现侦听  侦听的内容(条件)也需要实现
        KeyAdapter keyAdapter = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {//当运行按下键盘任意键 执行...
                //当按下了键盘的空格键.   ------1.用户当前按下的键   2.键盘空格键
                //参数 e 代表用户按下的键  ---> e.getKeyCode(); 获取用户按下空格键
                //                     ---->KeyEvent.VK_SPACE 键盘空格键
                if(e.getKeyCode() == KeyEvent.VK_SPACE){
                    if (gameCurrentState == GAME_START){
                        gameCurrentState = RUNNING;
                    }else if (gameCurrentState == RUNNING){
                        bombEnterAction();
                    } else if (gameCurrentState == GAME_OVER) {
                        gameCurrentState = GAME_START;
                        battleship.setLife(5);
                        repaint();//重新绘制
                    }

                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT){
                    if ( battleship.x >= 0 ){
                        battleship.leftMove();
                    }

                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT){
                    if ( battleship.x + battleship.width <= WIDTH ){
                        battleship.rightMove();
                    }
                }

//                System.out.println("按下了键盘!!");
            }
        };
        this.addKeyListener(keyAdapter);
        Timer timer = new Timer();//创建具体的定时器对象
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
//                System.out.println("run()方法执行了");
                if (gameCurrentState == RUNNING){
                    submarineEnterAction();//调用潜艇入场的逻辑
                    thunderEnterAction();//调用雷入场的逻辑
                    stepAction();//调用移动
                    bombBangAction();//调用深水炸弹与潜艇碰撞检测的方法
                    thunderBangAction();
                    outOfBounds();
//                System.out.println("潜艇数量为："+ submarines.length);
                    repaint();//重新绘制
                }
            }
        };
        //1.具体执行的任务 2.延时多久开始执行 3.执行一次后距下一次的间隔时间。
        timer.schedule(timerTask,5000,10);
    }



    /**
     * 绘制窗口的方法
     */
    private void paintWorld() {
        //1.要做一个画框
        JFrame frame = new JFrame();//创建一个具体的画框
        this.setFocusable(true);
        frame.add(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点击关闭按钮时释放程序
        frame.setSize(WIDTH + 16, HEIGHT + 39);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);//设置是否可见
    }

    @Override
    public void paint(Graphics g) {//系统提供的绘制方法，g是画笔
//        ImageIcon icon = ImageResources.battleship;//获取战舰图片
//        //1. null
//        //2. g
//        //3. x坐标
//        //4. y左边
//        icon.paintIcon(null, g, battleship.x, battleship.y);//绘制图片
//        System.out.println("绘制对象的方法执行了");
        switch (gameCurrentState){
            case GAME_START :
                ImageResources.start.paintIcon(null,g,0,0);
                break;
            case RUNNING :
                ImageResources.sea.paintIcon(null,g,0,0);//绘制背景
                battleship.paintImage(g);
                for (int i = 0; i < submarines.length; i++) {
                    submarines[i].paintImage(g);
                }
                for (int i = 0; i < thunders.length; i++) {
                    thunders[i].paintImage(g);
                }
                for (int i = 0; i < bombs.length; i++) {
                    bombs[i].paintImage(g);
                }

                g.setFont(new Font("",Font.BOLD,20));//设置当前字体
                g.drawString("Score:"+score,200,50);
                g.drawString("Life:"+ battleship.getLife(),400,50);
                break;
            case GAME_OVER :
                ImageResources.gameover.paintIcon(null,g,0,0);
                g.setFont(new Font("",Font.BOLD,50));//设置当前字体
                g.drawString("请按空格返回开始界面！",0,HEIGHT / 2);
                break;
        }


    }

    public static void main(String[] args) {
        GameWorld gameWorld = new GameWorld();
        gameWorld.action();
        gameWorld.paintWorld();
    }


    /**
     *  1.为什么要将各类型变量的声明写到main的外面？
     *    答：在main方法中声明的变量为局部变量,但是后期当前类中还有很多方法需要用到这些类型的变量
     *       所以应该设计为成员变量,作用域在整个类中。
     *  2.为什么要单独写一个action方法做测试？
     *    答:因为main比较特殊,用static修饰的方法,那么普通的成员(成员变量,普通方法)是无法被main直接
     *      访问的,所以单独做一个普通的方法,来进行测试。
     *  3.为什么要创建GameWorld对象去调用action方法？
     *    答：因为main比较特殊,用static修饰的方法,那么普通的成员(成员变量,普通方法)是无法被main直接
     *       访问的,我们可以通过创建对象,通过对象打点可以进行调用action方法。
     *
     * */

}
