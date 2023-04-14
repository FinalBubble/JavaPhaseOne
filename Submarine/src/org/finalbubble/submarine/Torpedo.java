package org.finalbubble.submarine;

import javax.swing.*;

/**
 * @author yangq
 * @date 2023-03-23
 * @Project Phase one
 * @Package org.finalbubble.submarine
 * @Description 鱼雷类
 */
public class Torpedo extends SeaObject{

    Torpedo(int x, int y) {  //鱼雷类的有参构造方法
        super(x,y,5,18,2);
    }

    @Override
    protected void step() {
        y -= speed;
    }
    @Override
    protected ImageIcon getImage() {
        if(this.isLive()){
            return ImageResources.torpedo;//返回鱼雷图片
        }
        return null;
    }

    @Override
    protected boolean isOutBounds() {
        return this.y <= -this.height;//如果当前鱼雷对象的y 小于等于 -自身的高度
    }
}
