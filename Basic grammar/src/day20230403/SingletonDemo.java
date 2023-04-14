package day20230403;

/**
 * @author yangq
 * @date 2023-04-02
 * @Project Phase one
 * @Package day20230402
 * @Description TODO
 */
public class SingletonDemo {
}

/**
 * 饿汉式单例模式的使用演示类:
 */
class HungrySingletonDemo {
    public static void main(String[] args) {
//        HungrySingleton hungrySingle = new HungrySingleton();
//        HungrySingleton hungrySingleton = HungrySingleton.getInstance();
//        hungrySingleton.getPI();
        HungrySingleton.getInstance().getPI();
    }
}

/** 饿汉式单例 :不管别人有没有调用获取对象的方法,我们自己已经创建好了.
 *  1.构造方法私有化
 *  2.在类中自己创建对象
 *  3.对外提供访问对象的静态方法.
 */
class HungrySingleton{//单例--------->饿汉式写法

    //2.本类创建一个用户共享的唯一的对象
    private static HungrySingleton hungrySingleton = new HungrySingleton();

    //1.私有类的构造方法
    private HungrySingleton(){}

    //3.对外提供一个获取本类对象的方法
    public static HungrySingleton getInstance(){
        return hungrySingleton;
    }

    public void getPI(){
        System.out.println(3.1415926);
    }
}

