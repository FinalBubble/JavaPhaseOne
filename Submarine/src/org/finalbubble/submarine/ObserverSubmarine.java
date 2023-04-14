package org.finalbubble.submarine;

import javax.swing.*;

/**
 * @author yangq
 * @date 2023-03-23
 * @Project Phase one
 * @Package org.finalbubble.submarine
 * @Description 侦察潜艇类
 */
public class ObserverSubmarine extends SeaObject implements EnemyScore{


    ObserverSubmarine(){//侦察潜艇的构造方法
        super(63,19);
    }

    @Override
    protected void step() {
        x += speed;
    }
    @Override
    protected ImageIcon getImage() {
        if(this.isLive()){
            return ImageResources.obsersubm;//返回侦察潜艇图片
        }
        return null;
    }

    @Override
    public int getScore() {
        return 10;
    }
}
