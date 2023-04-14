package day20230405;

/**
 * @author yangq
 * @date 2023-04-05
 * @Project Phase one
 * @Package day20230405
 * @Description TODO
 */
public class Demo02 {

    public static void main(String[] args) {
        /**
         *  2进制与16进制
         *  - Java7 提供了2进制字面量前缀0b
         *    可以在数字中添加下划线，不影响数值
         *  - 2进制直接书写非常繁琐
         *  - 16进制缩写2进制非常方便
         *    从2进制的最低位开始，每4位数缩写为1位16进制数
         *  - 计算机内部没有10进制，没有16进制，只有2进制
         */
        int n = 0b110010;
        System.out.println(n);
        n = 0b11001111100010100001111110101;
        System.out.println(n);
    }
}
