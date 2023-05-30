package day20230530_UTF8;

import java.nio.charset.StandardCharsets;

public class UTF8Demo {
    public static void main(String[] args) {
        /**
         * 测试UTF-8编解码API
         */
        String str = "Java表达式";
        //将字符串中的文字进行UTF-8编码
        //str.getBytes(StandardCharsets.UTF_8) 也可以写成 str.getBytes("UTF_8")
        //经过getBytes方法的转换得到了 UTF-8 编码的字节数组
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        //bytes就可以利用网络进行传输
        //将字节数组中的UTF-8 编码的字符进行解码
        //new String(bytes,"UTF_8")
        String s = new String(bytes,StandardCharsets.UTF_8);
        System.out.println(s);

        /**
         * 输出字符串中的每个字符的Unicode
         */
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            System.out.print(c);
            System.out.print(":");
            System.out.println(Integer.toBinaryString(c));
        }
        System.out.println("UTF-8");
        for (byte aByte : bytes) {
            System.out.println(Integer.toBinaryString(aByte & 0xff));
        }
    }
}
