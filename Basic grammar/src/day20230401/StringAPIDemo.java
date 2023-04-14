package day20230401;

/**
 * @author yangq
 * @date 2023-04-01
 * @Project Phase one
 * @Package day20230401
 * @Description TODO
 */
public class StringAPIDemo {
    //练习题：请编写一段程序 将"Thinking in Java是一本好书"内容中字符 i 存在次数 统计出来！
    public static void main(String[] args) {
        StringAPIDemo stringAPIDemo = new StringAPIDemo();
//        stringAPIDemo.Demo2();
//        stringAPIDemo.Demo3();
        stringAPIDemo.Demo4();
    }

    public void Demo1(){
        String str = "Thinking in Java是一本好书";
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'i'){
                count++;
            }
        }
        System.out.println("i存在的次数为："+count);
        System.out.println("indexOf(char c)方法的使用：i第一次出现的索引="+str.indexOf('i'));
        System.out.println("indexOf(String str)方法的使用，“Java”出现的下标="+str.indexOf("Java"));
    }
    public void Demo2(){
        String name = "   Tom   ";
        System.out.println(name.toString());
        name = name.trim();
        System.out.println(name.toString());

        System.out.println(name.startsWith("T"));
        System.out.println(name.endsWith("m"));
    }

    public void Demo3(){
        //截取字符串
        String mail = "fdlafjsdh@qq.com";
        mail = mail.substring(0,9);
        System.out.println(mail);

        //练习: 如果想要截取一个通用的用户名的程序,那代码应该怎么写??
        //例如: 传递  liucs@tedu.cn   ----截取到 liucs
        //例如: 传递  bjzhangpeng@tedu.cn   ----截取到 bjzhangpeng

        //如果@仅出现一次
        String mail1 = "liucs@tedu.cn";
        String mail2 = "bjzhangpeng@tedu.cn";

        System.out.println("liucs@tedu.cn的用户名为："+Demo3Test(mail1));
        System.out.println("bjzhangpeng@tedu.cn的用户名为："+Demo3Test(mail2));
        System.out.println("==================================");
        System.out.println("liucs@tedu.cn的用户名为："+mail1.substring(0,mail1.indexOf('@')));
        System.out.println("bjzhangpeng@tedu.cn的用户名为："+mail2.substring(0,mail2.indexOf('@')));

    }

    public String Demo3Test(String mail){
        int index = 0;
        for (int i = 0; i < mail.length(); i++) {
            if (mail.charAt(i) == '@'){
                index = i;
                break;
            }
        }
        return mail.substring(0,index);
    }

    public void Demo4(){

        //判断字符串中是否包含某个字符串的内容
        String a = "AOP";
        boolean b = a.contains("O");
        System.out.println(b);

        System.out.println(a.isEmpty());
        String c = "";
        System.out.println(c.isEmpty());
        String d = "abcdef";
        char[] r1 = d.toCharArray();
        for (char x:
             r1) {
            System.out.println(x);
        }
    }

}
