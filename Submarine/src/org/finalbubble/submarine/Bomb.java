package org.finalbubble.submarine;

import javax.swing.*;

/**
 * @author yangq
 * @date 2023-03-23
 * @Project Phase one
 * @Package org.finalbubble.submarine
 * @Description 深水炸弹类
 */
public class Bomb extends SeaObject {

    Bomb(int x, int y) {
        super(x, y, 9, 12, 3);
    }

    @Override
    protected void step() {
        y += speed;
    }

    @Override
    protected ImageIcon getImage() {
        //此方法一定会是深水炸弹对象调用的。那么就需要判断当前对象状态 再决定是否返回图片。
        if (this.isLive()) {//如果当前对象是或者的状态
            return ImageResources.bomb;//返回深水炸弹图片
        }
        return null;//如果能执行到这一行,则表示当前对象是死亡状态,返回null。
    }

    @Override
    protected boolean isOutBounds() {
        return this.y >= GameWorld.HEIGHT;//深水炸弹对象的y大于等于屏幕的高
    }
}