package day20230401;

/**
 * @author yangq
 * @date 2023-04-01
 * @Project Phase one
 * @Package day20230401
 * @Description TODO
 */
public class StringDemo {
    public static void main(String[] args) {
        //"123" 是字符串字面量,本质上就发生了创建String对象的操作
        String  a = "123";
        String  c = new String("123");
        String  b = a;
        System.out.println("a?=b:"+( a==b ));
        System.out.println("a更改赋值后");
        a = "456";
        System.out.println("a："+a);
        System.out.println("b："+b);
        System.out.println("c："+c);
        String e = "120";
        String f = "120";
        System.out.println("e?=f:"+( e == f ));
        String g = "120";
        String h = new String("120");
        System.out.println("e?=f:"+( g == h ));
    }
}
