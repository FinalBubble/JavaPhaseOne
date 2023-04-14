package day20230328;

/**
 * @author yangq
 * @date 2023-03-28
 * @Project Phase one
 * @Package day20230325
 * @Description 接口的使用演示类
 */
public class InterfaceDemo {
    public static void main(String[] args) {
//        Inter1 i = new Inter1(); 接口不能 被实例化对象
        Inter1 i = new Inter1() { //接口同样可以使用匿名内部类
            @Override
            public void test() {
                System.out.println("创建匿名内部类");
            }
        };
    }
}

//接口1
interface Inter1{
    //接口中声明的变量 默认为常量
    public static final int NUMBER = 10;
    //接口中声明的放过默认为抽象方法
    public abstract void test();
}
interface Inter2 extends Inter1{//接口可以继承接口

}
class Aoo {

}
class Boo extends Aoo implements Inter2{
    @Override
    public void test() {

    }
}
/*
 *           类    与   类   -----可以继承 (继承关系)
 *           接口  与   接口  ---- 可以继承 (继承关系)
 *           类    与  接口  ----- 实现关系！
 * */