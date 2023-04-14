package day20230405;

import java.nio.charset.StandardCharsets;

/**
 * @author yangq
 * @date 2023-04-05
 * @Project Phase one
 * @Package day20230405
 * @Description TODO
 */
public class UTF8Demo {
    public static void main(String[] args) throws Exception{
        /**
         * 测试UTF-8编解码 API
         */
        String str = "Javaλ表达式";
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        String s = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(s);

    }
}
