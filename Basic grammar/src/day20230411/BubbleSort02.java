package day20230411;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @author yangq
 * @date 2023-04-11
 * @Project Phase one
 * @Package day20230411
 * @Description 冒泡排序
 */
public class BubbleSort02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入数组长度：");
        int length = scanner.nextInt();
        int[] array = new int[length];
        Random random = new Random();
        //声明变量：统计对比次数
        int compareCount = 0;
        //声明变量：统计换位次数
        int swapCount = 0;

        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(100) - 50;
        }
        System.out.print("当前的数组为：");
        System.out.println(Arrays.toString(array));
        //记录排序之前的时间值
        long start = System.currentTimeMillis();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                compareCount++;
                if (array[i] < array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    swapCount++;
                }
            }
        }
        //记录排序之后的时间值
        long end = System.currentTimeMillis();
        System.out.print("排序后的数组为：");
        System.out.println(Arrays.toString(array));
        System.out.println("元素对比次数："+compareCount+",元素换位次数："+swapCount);
        System.out.println("冒牌排序耗时："+ (end - start) + "毫秒");
    }
}
