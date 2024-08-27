import java.util.Arrays;
import java.util.Scanner;

public class Java_Day_4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // System.out.println(arrays43(scanArray()));
        // System.out.println(arrays45(scanArray()));
        // System.out.println(arrays45NoSorting(scanArray()));
        // System.out.println(arrays47(scanArray()));
        // System.out.println(arrays55(scanArray()));
        //                    arrays69(scanArray(), scanArray());
        // System.out.println(arrays71(scanArray(), scanArray()));
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

    private static int arrays45NoSorting(int[] array) {
        // Найдите количество различных элементов данного массива (без Arrays.sort()).

        int numOfDifferentElements = 1;
        outerloop:
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] == array[j]) {
                    continue outerloop;
                }
            }
            numOfDifferentElements++;
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

    private static void arrays69(int[] array1, int[] array2) {
        // Даны два массива. Сформировать третий массив, состоящий из тех элементов, которые:
        // а) присутствуют в обоих массивах; б) присутствуют только в одном из массивов.

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input 1 for an array that contains elements that are in both arrays.");
        System.out.println("Input 2 for an array that contains elements that are not in both arrays.");

        Arrays.sort(array1);
        Arrays.sort(array2);

        switch (scanner.nextInt()) {
            case 1:
                System.out.println(Arrays.toString(arrays69A(array1, array2)));
                break;

            case 2:
                System.out.println(Arrays.toString(arrays69B(array1, array2)));
                break;

            default:
                System.out.println("Please enter the number 1 or 2");
        }
    }

    private static int[] arrays69A(int[] array1, int[] array2) {

        int newArrayIndex = 0;
        int[] newArray = new int[array1.length + array2.length];

        for (int i = 0; i < array1.length; i++) {
            if (i != 0 && array1[i] == array1[i - 1]) {
                continue;
            }
            for (int j = 0; j < array2.length; j++) {
                if (j != 0 && array2[j] == array2[j - 1]) {
                    continue;
                }
                if (array1[i] == array2[j]) {
                    newArray[newArrayIndex] = array1[i];
                    newArrayIndex++;
                }
            }
        }

        int[] trimmedArray = new int[newArrayIndex];

        for (int i = 0; i < trimmedArray.length; i++) {
            trimmedArray[i] = newArray[i];
        }

        return trimmedArray;
    }

    private static int[] arrays69B(int[] array1, int[] array2) {

        int newArrayIndex = 0;
        int[] newArray = new int[array1.length + array2.length];

        // searches for elements in array1 that are not in array2
        for (int i = 0; i < array1.length; i++) {
            if (i != 0 && array1[i] == array1[i - 1]) {
                continue;
            }
            boolean foundInArray2 = false;
            for (int k : array2) {
                if (array1[i] == k) {
                    foundInArray2 = true;
                    break;
                }
            }
            if (!foundInArray2) {
                newArray[newArrayIndex] = array1[i];
                newArrayIndex++;
            }
        }

        // searches for elements in array2 that are not in array1
        for (int i = 0; i < array1.length; i++) {
            if (i != 0 && array2[i] == array2[i - 1]) {
                continue;
            }
            boolean foundInArray1 = false;
            for (int k : array1) {
                if (array2[i] == k) {
                    foundInArray1 = true;
                    break;
                }
            }
            if (!foundInArray1) {
                newArray[newArrayIndex] = array2[i];
                newArrayIndex++;
            }
        }

        int[] trimmedArray = new int[newArrayIndex];

        for (int i = 0; i < trimmedArray.length; i++) {
            trimmedArray[i] = newArray[i];
        }

        return trimmedArray;
    }

    private static boolean arrays71(int[] array1, int[] array2) {
        // Даны два массива. Определите, существуют ли в первом массиве такие два элемента,
        // что их сумма равна сумме каких-либо трех элементов второго массива.

        // 2 for loops below sum all possible combinations of 2 elements in the first array
        for (int i = 0; i < array1.length; i++) {
            for (int j = i + 1; j < array1.length; j++) {
                int sumOfTwoElements = array1[i] + array1[j];

                // 3 for loops below sum all possible combinations of 3 elements in the second array
                for (int a = 0; a < array2.length; a++) {
                    for (int b = a + 1; b < array2.length; b++) {
                        for (int c = b + 1; c < array2.length; c++) {
                            int sumOfThreeElements = array2[a] + array2[b] + array2[c];

                            if (sumOfTwoElements == sumOfThreeElements) {
                                return true;
                            }
                        }
                    }
                }
            }
        }

        return false;
    }
}