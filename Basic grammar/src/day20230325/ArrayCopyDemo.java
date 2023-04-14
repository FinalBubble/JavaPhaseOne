package day20230325;

/**
 * @author yangq
 * @date 2023-03-25
 * @Project Phase one
 * @Package day20230325
 * @Description TODO
 */
import java.util.Arrays;

/**
 * 数组拷贝的使用演示类：
 * 1.Arrays.copyof();   -------------------更多是基于在源数组基础上实现扩容/缩容情况下使用。
 * 2.System.arraycopy();-------------------更多是在已存在两个数组基础上进行拷贝的工作.例如 将A数组的内容拷贝B数组中。
 */
public class ArrayCopyDemo {
    public static void main(String[] args) {
        //1.Arrays.copyof 方法的使用
        int[] array = {}; // 为array  = new  int[0];
        int a = 10;
        System.out.println("扩容之前数组长度为:" + array.length+"，扩容前数组地址："+array); //0
        //1.要处理的数组是哪个   2.基于源数组的长度 进行缩容或者扩容的容量
        array = Arrays.copyOf(array, array.length + 1);
        System.out.println("扩容以后的容量："+array.length+"，扩容后数组地址："+array);
        array[0] = a;//为扩容的这块地赋值
        System.out.println(array[0]);//10

//        int[] array2 = {10,50,60,70};
//        array2 = Arrays.copyOf(array2,array2.length+1);
//        array2[array2.length-1] = 80;//代表为数组最后一个元素赋值
//        for (int i = 0; i < array2.length; i++) {
//            System.out.println(array2[i]);
//        }

//        //2.System.arraycopy()的方法使用演示
//        int[] arr1 = {50,60,80,40,10};
//        int[] arr2 = {1 , 1, 1, 1, 1};
//
//        /*arraycopy方法需要五个参数
//         *   1.要拷贝的源数组
//         *   2.要拷贝的源数组开始的下标
//         *   3.要拷贝的目标数组
//         *   4.从目标数组下标的哪个下标开始装
//         *   5.拷贝过来的数量是多少。  (数组长度 - 不拷贝的元素数量)
//         * */
//        System.arraycopy(arr1,1,arr2,0,arr1.length-2);
//        for (int i = 0; i < arr2.length; i++) {
//            System.out.println(arr2[i]);
//        }

    }

}
