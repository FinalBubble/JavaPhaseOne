package day20230403;

/**
 * @author yangq
 * @date 2023-04-03
 * @Project Phase one
 * @Package day20230403
 * @Description TODO
 */
public class ObjectDemo {
    public static void main(String[] args) {
        Object o1 = new Aoo();
        Object o2 = new Boo();

        Point p = new Point(1,2);
        Point p1 = new Point(1,2);
        System.out.println(p.getX());
        System.out.println(p.getY());
        System.out.println(Integer.toHexString(p.hashCode()));
        System.out.println(p);
        System.out.println(p.equals(p1));
    }

}
class Aoo{

}
class Boo extends Aoo{

}