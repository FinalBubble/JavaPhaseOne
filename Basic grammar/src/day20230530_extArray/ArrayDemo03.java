package day20230530_extArray;

public class ArrayDemo03 {
    public static void main(String[] args) {
        int[][] array = {{7, 1, 9, 6}, {4, 2, 8, 1}, {6, 0, 3, 5}};
        for (int i = 0; i < array.length; i++) {
            for (int i1 = 0; i1 < array[i].length; i1++) {
                System.out.println(array[i][i1]);
            }
        }
    }
}
