package day20230401;

/**
 * @author yangq
 * @date 2023-04-01
 * @Project Phase one
 * @Package day20230401
 * @Description TODO
 */
public class RegexDemo {
    public static void main(String[] args) {
        String mail = "bjzhangpeng@tedu.cn";
//        String regex= "[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-Z]+)+";
        String regex = "[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-z]+)+";
        //matches方法是通过传入正则表达式的格式 来匹配判断当前字符串对象中格式是否匹配上!
        if( mail.matches(regex)){
            System.out.println("是邮箱");
        }else {
            System.out.println("不是邮箱!");
        }
    }
}
