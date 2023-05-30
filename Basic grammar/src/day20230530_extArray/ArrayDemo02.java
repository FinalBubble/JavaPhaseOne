package day20230530_extArray;

public class ArrayDemo02 {
    public static void main(String[] args) {
        int[][] array = new int[3][];
        array[0] = new int[2];
        array[0][0] = 7;
        array[0][1] = 1;
        System.out.println(array[0][1]);
        array[1] = new int[4];
        array[1][0] = 4;
        array[1][1] = 2;
        array[1][2] = 8;
        array[1][3] = 1;
        System.out.println(array[1][2]);
    }
}
