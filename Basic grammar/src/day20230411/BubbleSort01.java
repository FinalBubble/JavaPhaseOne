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
public class BubbleSort01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入数组长度：");
        int length = scanner.nextInt();
        int[] array = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(100) - 50;
        }
        System.out.print("当前的数组为：");
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (array[i] < array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.print("排序后的数组为：");
        System.out.println(Arrays.toString(array));
    }
}
