package org.finalbubble.submarine;

import javax.swing.*;

/**
 * @author yangq
 * @date 2023-03-23
 * @Project Phase one
 * @Package org.finalbubble.submarine
 * @Description 图片资源加载类：负责加载并初始化项目中所有需要用到的图片。
 */
public class ImageResources {


    //ImageIcon 类型  用来存储图片资源的类型
    public static ImageIcon battleship;//用来存储战舰图片的变量
    public static ImageIcon bomb;//用来存储深水炸弹图片的变量
    public static ImageIcon gameover;//用来存储游戏结束图片的变量
    public static ImageIcon mine;//用来存储水雷图片的变量
    public static ImageIcon minesubm;//用来存储水雷潜艇图片的变量
    public static ImageIcon obsersubm;//用来存储侦察潜艇图片的变量
    public static ImageIcon sea;//用来存储海洋背景图片的变量
    public static ImageIcon start;//用来存储开始游戏图片的变量
    public static ImageIcon torpedo;//用来存储鱼雷图片的变量
    public static ImageIcon torpesubm;//用来存储鱼雷潜艇图片的变量

    static {//静态代码块,当类被首次加载时,执行代码块中的内容,完成所有图片初始化工作
        battleship = new ImageIcon("img/battleship.png");
        bomb = new ImageIcon("img/bomb.png");
        gameover = new ImageIcon("img/gameover.png");
        mine = new ImageIcon("img/mine.png");
        minesubm = new ImageIcon("img/minesubm.png");
        obsersubm = new ImageIcon("img/obsersubm.png");
        sea = new ImageIcon("img/sea.png");
        start = new ImageIcon("img/start.png");
        torpedo = new ImageIcon("img/torpedo.png");
        torpesubm = new ImageIcon("img/torpesubm.png");
    }
    public static void main(String[] args) {//-----main 测试 后删掉即可 数据为8代表正常
        System.out.println(battleship.getImageLoadStatus());
        System.out.println(bomb.getImageLoadStatus());
        System.out.println(gameover.getImageLoadStatus());
        System.out.println(mine.getImageLoadStatus());
        System.out.println(minesubm.getImageLoadStatus());
        System.out.println(obsersubm.getImageLoadStatus());
        System.out.println(sea.getImageLoadStatus());
        System.out.println(start.getImageLoadStatus());
        System.out.println(torpedo.getImageLoadStatus());
        System.out.println(torpesubm.getImageLoadStatus());

    }
}
