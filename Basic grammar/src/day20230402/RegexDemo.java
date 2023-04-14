package day20230402;

/**
 * @author yangq
 * @date 2023-04-02
 * @Project Phase one
 * @Package day20230402
 * @Description TODO
 */
public class RegexDemo {
    public static void main(String[] args) {

        String str = "abc123def456ghi789";
        String[] strings = str.split("\\d+");
//        System.out.println(strings.length);
//        for (String s:
//             strings) {
//            System.out.println(s);
//        }
        String str1 = "1-2-3-4-5-6-7-8";//分割出1 2 3 4 5 6 7 8 的数据装入数组中
        strings = str1.split("-");
        strings = str.split("[a-zA-z]+");
//        System.out.println(strings.length);
//        for (String s:
//                strings) {
//            System.out.println(s);
//        }
        //API 替换的功能
        String regex = "(sb|tmd|dsb|qnmd|nc|wr|fuck|mmp)"; //敏感词汇的正则
        String message = "qnmd!你这个dsb,你怎么这么nc,fuck!!";//用户聊天内容
        //replaceAll 替换全部的内容 :  1.放正则的格式  2.要替换的内容
        message = message.replaceAll(regex, "小可爱");//网络和谐用语
        System.out.println(message);

        str = "abc123def456ghi789";
        //需求 将str中内容 数值相关的内容 替换 NUMBER 来表示
        str = str.replaceAll("[0-9]+", "NUMBER");
        System.out.println(str);

        str1 = "abc123def456123123";
        // replace 不支持正则 :  1.要匹配替换的内容  2.替换的内容
        str1 = str1.replace("123", "***");
        System.out.println(str1);


        //身份证号码的使用演示:
        /**
         *  身份证号---- 15位 或 18 位
         *  123456789012345     ----15位
         *  123456789012345678  ----18位
         *  12345678901234567X
         *  12345678901234567x
         *  \d{15}  ----- 表示写15个  0-9的数据
         *  \d{18}  ----- 表示写18个  0-9的数据
         *  \d{17}[\dXx] ----表示的是前面是17个数字,后面的第18位可以是数字 ,也可以是X或x字母
         *  整体的正则: \d{15}|\d{17}[\dXx]
         */
        /**
         *  1234567   ---七位
         *  12345678  ---八位
         *  010-1234567  -----三位区号+七位电话
         *  010-12345678 -----三位区号+八位电话
         *  0101-1234567 -----四位区号+七位电话
         *  0101-12345678 -----四位区号+八位电话
         *  (010)1234567
         *  (010)12345678
         *  (0101)1234567
         *  (0101)12345678
         *  正则格式:
         *  \d 表示 数字
         *  ? 表示 0 或 1 次
         *  --------------------------------
         *  \d{7,8}   ---7位或八位的电话
         *  区号两种情况: \d{3,4}-?
         *  整体格式 \d{3,4}-?\d{7,8}
         *  () 在正则中表示 打组的意思  若需要表示是一个普通的,需要转义\\( \\)
         */
    }
}
