package day20230406;

import java.util.Arrays;

/**
 * @author yangq
 * @date 2023-04-06
 * @Project Phase one
 * @Package day20230406
 * @Description TODO
 */
public class UTF8Coding {
    /**
     * 手工编写UTF-8编码
     * Char. number range  |        UTF-8 octet sequence
     *       (hexadecimal)    |              (binary)
     *    --------------------+---------------------------------------------
     *    0000 0000-0000 007F | 0xxxxxxx
     *    0000 0080-0000 07FF | 110xxxxx 10xxxxxx
     *    0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
     *    0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
     *
     */
    /**
     * /**
     * 将一个字符串编码位 UTF-8字节数组
     * getBytes()
     * @param str 待编码的字符串
     * @return 经过UTF-8编码后的字节数组
     */
    public static byte[] getBytes(String str){
        //预估返回值的byte数组的最大长度
        byte[] bytes = new byte[str.length() << 2];
        //index代表bytes数组中数据的存储位置
        int index = 0;
        //遍历字符串中每个字符，根据字符的Unicode编码范围，进行UTF-8编码
        //将编码存储在 bytes中，bytes中就是返回值UTF-8数据
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            //判断c范围，根据范围进行编码
            if (c <= 0x7F) {
                // c 在 0 ~ 0x7F范围内，是1字节编码
                bytes[index++] = (byte)c;
            } else if (c <= 0x7FF) {
                // c 在 0x80 ~ 0x7FF范围内，是2字节编码
                // 110xxxxx 10xxxxxx
                // 截取字符的后6位
                int b2 = ( c & 0x3F ) | 0x80;
                int b1 = ( ( c >>> 6 ) & 0x1F ) | 0xC0;
                bytes[index++] = (byte) b1;
                bytes[index++] = (byte) b2;
            } else if (c <= 0xFFFF) {
                // c 在 0x800 ~ 0xFFFF范围内，是3字节编码
                // 1110xxxx 10xxxxxx 10xxxxxx
                int b3 = ( c & 0x3F ) | 0x80;
                int b2 = ( ( c >>> 6 ) & 0x3F ) | 0x80;
                int b1 = ( ( c >>> 12 ) & 0xF ) | 0xE0;
                bytes[index++] = (byte) b1;
                bytes[index++] = (byte) b2;
                bytes[index++] = (byte) b3;
            }
        }
        return Arrays.copyOf(bytes,index);
    }

    /**
     * 将UTF-8编码的字节数组解码为字符串（Unicode字符）
     * @param bytes UTF-8 编码的字节
     * @return 解码以后的字符串
     */
    public static String decode(byte[] bytes){
        char[] chs = new char[bytes.length];
        int index = 0;
        //遍历字节数据，检查每个字节
        // 1、 如果字节以0为开头，则是单字节编码
        // 2、 如果以110为开头，则是双字节编码
        // 3、 如果以1110为开头，则是三字节编码
        for (int i = 0; i < bytes.length;) {
            int b1 = bytes[i++] & 0xFF;
            if ( (b1 >>> 7) == 0x00 ) {
                chs[index++] = (char) b1;
            }else if ( (b1 >>> 5) == 0x06 ) {
                int b2 = bytes[i++] & 0xFF;
                chs[index++] = (char) ( b1 & 0x1F << 6 | b2 & 0x3F );
            }else if ( (b1 >>> 4) == 0x0E ) {
                int b2 = bytes[i++] & 0xFF;
                int b3 = bytes[i++] & 0xFF;
                chs[index++] = (char) ((b1 & 0x0F) << 12 | (b2 & 0x3F) << 6 | (b3 & 0x3F));
            }

        }
        return new String(chs,0,index);
    }

    public static void main(String[] args) {
        String str = "Javaλ表达式";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            System.out.print(c);
            System.out.print(":");
            System.out.println(Integer.toBinaryString(c));
        }
        //调用手写的UTF-8编码方法
        byte[] bytes = getBytes(str);
        for (byte b:
             bytes) {
            System.out.println(Integer.toBinaryString(b & 0xFF));
        }
        System.out.println(decode(bytes));
    }
}
