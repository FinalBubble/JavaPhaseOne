package day20230403;

/**
 * @author yangq
 * @date 2023-04-03
 * @Project Phase one
 * @Package day20230403
 * @Description TODO
 */
public class LazySingletonDemo {
    public static void main(String[] args) {
        LazySingleton l1 = LazySingleton.getInstance();
        LazySingleton l2 = LazySingleton.getInstance();
        System.out.println(l1);
        System.out.println(l2);
    }
}

/**
 * 懒汉式单例实现   ------会被经常问到
 */
class LazySingleton{
    //2.只是声明了一个静态LazySingleton类型的变量
    private static LazySingleton lazySingleton;
    //1 .私有构造方法
    private LazySingleton(){}

    //3.在对外提供的对象方法内部 做创建对象的操作
    public static LazySingleton getInstance(){
        //如果当前lazySingleton 为 null  --->外部第一次访问获取当前类对象
        if (lazySingleton == null){
            //为当前静态变量 创建一次对象
            lazySingleton = new LazySingleton();
        }
        //返回对象
        return lazySingleton;
    }


}