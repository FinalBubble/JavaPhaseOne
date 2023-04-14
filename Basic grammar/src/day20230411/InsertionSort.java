package day20230411;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @author yangq
 * @date 2023-04-11
 * @Project Phase one
 * @Package day20230411
 * @Description 插入排序
 */
public class InsertionSort {
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

        for (int i = 1; i < length; i++) {
            int j = i;
            while (j > 0){
                if (array[j] < array[j - 1]){
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                    j--;
                }else {
                    break;
                }
            }
        }

        System.out.print("排序后的数组为：");
        System.out.println(Arrays.toString(array));
    }
}
