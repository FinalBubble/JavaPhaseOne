package org.finalbubble.submarine;


/**
 * 加分的接口  ---具体由需要加分的类 来具体实现
 */
public interface EnemyScore {
    /**
     *  提供获取分数的方法
     * @return  被打到时 返回的分数
     */
    int getScore();

}
