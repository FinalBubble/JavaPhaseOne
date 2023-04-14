package org.finalbubble.submarine;

import javax.swing.*;

/**
 * @author yangq
 * @date 2023-03-23
 * @Project Phase one
 * @Package org.finalbubble.submarine
 * @Description 水雷类
 */
public class Mine extends SeaObject{


    Mine(int x, int y){
        super(x,y,11,11,2);
    }

    @Override
    protected void step() {
        y -= speed;
    }
    @Override
    protected ImageIcon getImage() {
        if(this.isLive()){
            return ImageResources.mine;//返回水雷图片
        }
        return null;
    }

    @Override
    protected boolean isOutBounds() {
        return this.y <= 150 - this.height;//如果水雷对象的y小于或等于150 - 自身的高,说明到水面上了
    }
}
