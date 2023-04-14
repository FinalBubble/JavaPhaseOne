package day20230325;

/**
 * @author yangq
 * @date 2023-03-25
 * @Project Phase one
 * @Package day20230325
 * @Description 成员内部类的使用演示类
 */
public class TestDemo {
    public static void main(String[] args) {
//        Boo b = new Boo(); 内部类对外部其他类不具备可见性
    }
}

class Aoo { //外部类
    private int a = 10;

    private void show() {
        Boo b = new Boo();//外部类中可创建Boo对象
    }
    class Boo {//内部类
        int a = 10;
        void test() {
            Aoo.this.a = 10; //--代表访问Aoo类的a
            Aoo.this.show();//代表访问Aoo类的show方法
            this.a = 20; //内部类共享外部类的属性和行为 ----包括私有成员
        }
    }

}
