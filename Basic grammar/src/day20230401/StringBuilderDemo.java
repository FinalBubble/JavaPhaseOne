package day20230401;

/**
 * @author yangq
 * @date 2023-04-01
 * @Project Phase one
 * @Package day20230401
 * @Description TODO
 */
public class StringBuilderDemo {
    public static void main(String[] args) {
        String a = "a";
        StringBuilder stringBuilder = new StringBuilder(a);
        long statr = System.currentTimeMillis();//获取 当前系统时间   单位毫秒
        for (int i = 0; i < 100000; i++) {
            stringBuilder.append(stringBuilder);
        }
        long end = System.currentTimeMillis();//获取 当前系统时间   单位毫秒
        System.out.println("运行时间为："+(end-statr)+"毫秒");

        String str = "好好学Java";
        StringBuilder builder = new StringBuilder(str);

        //append() 追加内容的方法,将需要追加的内容写入到小括号中
        builder.append("，为了找份好工作");
        System.out.println("str="+str);
        System.out.println("builder="+builder);
        //字符串修改
        //replace 替换的方法  1.开始替换的下标 2.结束替换的下标(包头不包尾) 3.要替换的内容
        builder.replace(8,16,"为了改变世界!");
        System.out.println("builder="+builder);

        //删除的使用
        //delete 删除方法: 1.开始删除的下标 2.结束删除的下标(包头不包尾)
        builder.delete(0,8);
        System.out.println("builder="+builder);
        //插入的方法
        //insert 插入的使用: 1.插入的开始下标 2,插入的内容
        builder.insert(0,"活着,");
        System.out.println("builder="+builder);
        //反转的方法
        builder.reverse();
        System.out.println("builder="+builder);
    }
}
