package day20230405;

/**
 * @author yangq
 * @date 2023-04-05
 * @Project Phase one
 * @Package day20230405
 * @Description TODO
 */
public class UnicodeDemo01 {
    public static void main(String[] args) {
        /**
         * Unicode 编码
         */
        String str = "好好学习，天天向上";
        try{
            byte[] bytes = str.getBytes("UTF-8");
            for (byte b:
                    bytes) {
                System.out.println(Integer.toBinaryString(b & 0xff));
            }

        }catch (Exception e){

        }


    }
}
