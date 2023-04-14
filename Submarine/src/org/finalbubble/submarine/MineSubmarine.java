package org.finalbubble.submarine;

import javax.swing.*;

/**
 * @author yangq
 * @date 2023-03-23
 * @Project Phase one
 * @Package org.finalbubble.submarine
 * @Description 水雷潜艇类
 */
public class MineSubmarine extends SeaObject implements EnemyLife{



    MineSubmarine() {//水雷潜艇类的构造方法
        super(63,19);
    }

    @Override
    protected void step() {
        x += speed;
    }
    @Override
    protected ImageIcon getImage() {
        if(this.isLive()){
            return ImageResources.minesubm;//返回水雷潜艇图片
        }
        return null;
    }


    @Override
    public int getLife() {
        return 1;
    }
}
