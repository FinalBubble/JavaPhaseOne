package org.finalbubble.submarine;

import javax.swing.*;

/**
 * @author yangq
 * @date 2023-03-23
 * @Project Phase one
 * @Package org.finalbubble.submarine
 * @Description 鱼雷潜艇类
 */
public class TorpedoSubmarine extends SeaObject implements EnemyScore{

    TorpedoSubmarine(){//鱼雷潜艇的构造方法
        super(63,19);
    }

    @Override
    protected void step() {
        x += speed;
    }
    @Override
    protected ImageIcon getImage() {
        if(this.isLive()){
            return ImageResources.torpesubm;//返回鱼雷潜艇图片
        }
        return null;
    }

    @Override
    public int getScore() {
        return 40;
    }
}
