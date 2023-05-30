package day20230530_UTF8;

public class UnicodeDemo01 {
    public static void main(String[] args) {
        /**
         * Unicode编码
         * - Java中的字符存储是一个符号的Unicode编码
         * - 可以显示为10进制或16进制形式
         * - Java的字符范围是 0 ~ 65535
         */
        char c1 = 'A';
        char c2 = '中';
        char c3 = 'ㅞ';
        char c4 = 'α';
        System.out.println((int) c1);
        System.out.println(Integer.toHexString(c1));
        System.out.println((int) c2);
        System.out.println(Integer.toHexString(c2));
        System.out.println((int) c3);
        System.out.println(Integer.toHexString(c3));
        System.out.println((int) c4);
        System.out.println(Integer.toHexString(c4));
    }
}
