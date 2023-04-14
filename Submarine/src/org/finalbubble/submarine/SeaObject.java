package org.finalbubble.submarine;

import javax.swing.*;
import java.awt.*;

/**
 * @author yangq
 * @date 2023-03-23
 * @Project Phase one
 * @Package org.finalbubble.submarine
 * @Description 海洋对象类:当前7个模板类的父类,存放这些类共有的属性和行为
 */
public abstract class SeaObject {

    public static final int LIVE = 0;//活着的状态
    public static final int DEAD = 1;//死亡的状态

    public int currentState = LIVE;//默认的当前状态活着的

    //子类共有属性
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected int speed;
    protected /*
    * 此构造方法是专门为三种潜艇提供的构造方法
    * 因为潜艇的宽高不同，宽高做成形式参数，由具体用子类来传递具体的内容
    * x y speed 初始化数据是一样的,所以可以写死。
    * */
    SeaObject(int width, int height){
        this.width = width;
        this.height = height;
        x = -width;
        y = (int)(Math.random()*(479-height-150)+150);
        speed = (int)(Math.random()*(3 - 1)+1);
    }
    /**
     * 此构造方法是为战舰,深水炸弹,鱼雷,水雷提供的
     * 因为这4个类的数据都不同,所以数据全部做成形式参数,具体由使用此构造方法的类来提供数据
     */
    SeaObject(int x,int y,int width,int height,int speed){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
    }


    //子类共有行为
    protected abstract void step();

    /*
    * 父类中定义的所有子类共性行为  获取图片方法
    * 返回值未图片类型，具体子类重写完该方法后，需要将获取到的图片返回出去
    * */
    protected abstract ImageIcon getImage();

    /*
    * 生成雷对象的方法  ----返回值要写 父类型
    * shootSubmarine方法 只会被潜艇对象调用
    * */
    protected SeaObject shootThunders(){
        int x = this.x + this.width;//雷对象的x坐标
        int y = this.y - 5;//雷的y坐标
        //instanceof 用来判断 当前对象是否是 某个类型的判断语句
        if (this instanceof TorpedoSubmarine){//如果当前对象 是 鱼雷潜艇类型的话
            return new Torpedo(x,y);
        } else if (this instanceof MineSubmarine) {//如果当前对象 是 鱼雷潜艇类型的话
            return new Mine(x,y);//返回水雷对象
        }
        return null;//如果代码能走到当前这段代码,那么就返回null
    }


    /**
     * 因为每个子类都需要绘制,那么就将绘制的行为提取到父类中
     * 因为每个子类绘制逻辑都一样,所以设计一个普通方法
     * 参数需要一个画笔 让外部调用本方法时传递进入即可
     */
    public void paintImage(Graphics g) {
        //1.获取对象图片
        ImageIcon icon = this.getImage();//获取当前调用方法对象的图片
        //2.绘制对象图片
        if (icon != null) {
            // 1. null  2. g  3.x坐标  4.y坐标
            icon.paintIcon(null, g, this.x, this.y);
        }
    }


    /** 判断当前调用该方法的对象 是否是活着的状态 */
    protected boolean isLive(){
        return this.currentState == LIVE;
    }
    /** 判断当前调用该方法的对象 是否是死亡的状态 */
    protected boolean isDead(){
        return this.currentState == DEAD;
    }

    /**
     *是否越界的方法
     * 为什么不做抽象方法而做普通方法？
     *                          因为三种潜艇判断是否越界的标准是一样的.可以复用
     *                          其它不能复用,深水炸弹,鱼雷,水雷 不一样,则重写即可。
     */
    protected boolean isOutBounds(){
        return this.x >= GameWorld.WIDTH;//判断潜艇的x 是否超出屏幕的宽
    }

    //为所有子类提供的碰撞的行为
    protected boolean isHit(SeaObject other){
        //计算当前对象与 碰撞物(other)的碰撞领空
        int x1 = this.x - other.width;
        int x2 = this.x + this.width;
        int y1 = this.y - other.height;
        int y2 = this.y + this.height;
        //获取碰撞物的x 和 y
        int x = other.x;
        int y = other.y;
        //返回 条件  碰撞物的x在x1和x2之间 ,y在y1 和 y2 之间 ,如果成立 则表示撞到了当前对象 返回true
        return (x >= x1 && x <= x2) && (y >= y1 && y <= y2);
    }
    /**
     * 哪个对象打点调用该方法,则该对象会被标记为死亡状态
     */
    protected void goDead(){
        this.currentState = DEAD;//将当前对象的状态设置为死亡状态
    }

}
