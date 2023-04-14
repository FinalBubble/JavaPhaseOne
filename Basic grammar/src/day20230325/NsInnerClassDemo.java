package day20230325;

/**
 * @author yangq
 * @date 2023-03-25
 * @Project Phase one
 * @Package day20230325
 * @Description 匿名内部类
 */
public class NsInnerClassDemo {
    public static void main(String[] args) {
        int a = 1;
        //使用匿名内部类的方式：
        //1.创建SuperClass的子类 只不过没有名字(匿名内部类)
        //2.将当前创建的子类对象 赋值给 s1变量。
        //3.花括号则是子类的类体。
        SuperClass s1 = new SuperClass() { //匿名的这个类是SuperClass的子类
            //匿名的这个类是NsInnerClassDemo的内部类
            @Override
            public void show() { //内部类使用外部类的变量时,默认会用final修饰 不能二次修改
                System.out.println(a);
                System.out.println("通过匿名内部类"+this.getClass().getName()+"的方式来实现重写");
            }
        };
        s1.show();
//        SuperClass s = new SubClass();
//        s.show();//编译期间调用父  运行期 执行子
    }
}

class SuperClass { //父类
    public void show() {
        System.out.println("SuperClass类的show方法");
    }
}
//1.创建类
//2.实现继承
//3.实现重写
class SubClass extends SuperClass {//子类

    @Override
    public void show() {
        System.out.println("SubClass类的show方法");
    }
}

