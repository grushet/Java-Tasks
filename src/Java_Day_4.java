import java.util.Arrays;
import java.util.Scanner;

public class Java_Day_4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // System.out.println(arrays43(scanArray()));
        // System.out.println(arrays45(scanArray()));
        // System.out.println(arrays47(scanArray()));
        // System.out.println(arrays55(scanArray()));
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

    private static int arrays45(int[] array) {
        // Найдите количество различных элементов данного массива.

        // finds the amount of different elements in the array
        Arrays.sort(array);
        int numOfDifferentElements = 1;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] != array[i + 1]) {
                numOfDifferentElements++;
            }
        }

        return numOfDifferentElements;
    }

    private static int arrays47(int[] array) {
        // В данном массиве найти максимальное количество одинаковых элементов.

        int currentChainOfSameElements = 1;
        int largestChainOfSameElements = 1;
        int mostRepeatedNumber = array[0];

        // finds the most recurring element in the array
        Arrays.sort(array);
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i + 1]) {
                currentChainOfSameElements++;
            } else if (currentChainOfSameElements > largestChainOfSameElements) {
                largestChainOfSameElements = currentChainOfSameElements;
                mostRepeatedNumber = array[i];
                currentChainOfSameElements = 1;
            } else { currentChainOfSameElements = 1; }
        }

        return mostRepeatedNumber;
    }

    private static boolean arrays55(int[] array) {
        // Определите, можно ли вычеркнуть из данного массива одно число так,
        // чтобы оставшиеся числа оказались упорядоченными по возрастанию.

        // sees is the array is compliant with the instructions given above
        boolean isAscending = false;
        for (int i = 0; i < array.length - 1; i++) {
            int replacedNumber = array[i];
            array[i] = 0;

            // checks if the array is ascending, ignoring the replaced number
            for (int j = 0; j < array.length - 1; j++) {
                isAscending = true;

                // skips replaced number
                if (j + 1 == i || j == i) {
                    continue;
                }

                if (array[j] >= array[j + 1]) {
                    isAscending = false;
                    break;
                }
            }
            if (isAscending) {
                break;
            }

            // puts replaced number back into place
            array[i] = replacedNumber;
        }

        return isAscending;
    }
}