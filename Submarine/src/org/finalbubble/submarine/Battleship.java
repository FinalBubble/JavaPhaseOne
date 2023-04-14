package org.finalbubble.submarine;

import javax.swing.*;

/**
 * @author yangq
 * @date 2023-03-23
 * @Project Phase one
 * @Package org.finalbubble.submarine
 * @Description 战舰类
 */
public class Battleship extends SeaObject{
    //属性
    private int life;

    public int getLife() {//对外提供获取战舰命数的方法  ------用于画命
        return life;
    }

    public void subtractLife() {//提供减命
        this.life--;
    }

    public void setLife(int life) {//对外提供修改战舰命数的方法  ------用于加命
        this.life += life;
    }

    Battleship(){
        super(270,124,66,26,20);
        life = 5;
    }
    @Override
    public void step(){
        System.out.println("左右移动");
    }

    public void leftMove() {//左移方法
        this.x -= speed;
    }
    public void rightMove() {//右移方法
        this.x += speed;
    }

    /**
     * 当战舰对象调用了该方法 则返回一个深水炸弹
     */
    public Bomb shootBomb(){
        return new Bomb(this.x,this.y);//返回深水炸弹对象  生成的坐标取决于战舰的坐标
    }


    @Override
    protected ImageIcon getImage() {
        //战舰比较特殊,并不是一打就死,而且当战舰死亡的时候游戏就结束了。
        return ImageResources.battleship;
    }
}
