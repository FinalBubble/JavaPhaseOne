package day20230405;

/**
 * @author yangq
 * @date 2023-04-05
 * @Project Phase one
 * @Package day20230405
 * @Description TODO
 */
public class Demo01 {
    /**
     * 如何查看整数的二进制存储情况
     *  - java 编译时候，将数字编译为2进制数字
     *  - 运行期间变量中存储的是2进制数
     *  - 输出变量时候，Java利用API方法，讲2进制转换为10进制字符串
     *    利用valueOf方法转换
     *  - Integer.toBinaryString(n) 将整数n在内存中2进制情况显示出来
     * @param args
     */
    public static void main(String[] args) {
        int n = 50; // 110010
        System.out.println(n);
        System.out.println(Integer.toBinaryString(n));
        for (int i = 0; i < 200; i++) {
            System.out.println(Integer.toBinaryString(i));
        }
    }
}
