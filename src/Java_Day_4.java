import java.util.Arrays;
import java.util.Scanner;

public class Java_Day_4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // System.out.println(arrays43(scanArray()));
    }

    public static int[] scanArray() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the amount of elements in the array: ");
        final int ELEMENTS = scanner.nextInt();

        // builds the array
        int[] array = new int[ELEMENTS];
        for (int i = 0; i < ELEMENTS; i++) {
            System.out.print(i + 1 + "st element: ");
            array[i] = scanner.nextInt();
        }

        return array;
    }

    private static String arrays43(int[] array) {
        // Проверьте, образует ли элементы массива в данном
        // порядке арифметическую или геометрическую прогрессии.

        if (array.length < 3) {
            return "Not enough information";
        }

        int commonDifference = array[1] - array[0];
        int commonRatio = array[0] == 0 ? 0 : array[1] / array[0];
        boolean isArithmetic = true;
        boolean isGeometric = commonRatio != 0;

        // sees if the given array is a progression
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i + 1] - array [i] != commonDifference) {
                isArithmetic = false;
            }
            if (array[i] != 0 && array[i + 1] / array [i] != commonRatio) {
                isGeometric = false;
            }
        }

        return isArithmetic && isGeometric  ? "Arithmetic AND Geometric" :
                               isArithmetic ? "Arithmetic" :
                               isGeometric  ? "Geometric" :
                                              "Not a progression";
    }
}