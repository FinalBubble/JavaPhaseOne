package Test;

/**
 * @author yangq
 * @date 2023-04-06
 * @Project Phase one
 * @Package Test
 * @Description TODO
 */
public class Demo2 {
    public static void main(String[] args) {
        int n = -50;
        System.out.println(n);
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(n >>> 5));
        System.out.println(n >>> 5);
//        System.out.println((n & 0x0f) << 2);
    }
}
