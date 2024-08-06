import java.util.Scanner;
import java.util.Arrays;


public class Java_Day_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // System.out.println(problem120(scanner.nextInt()));
        // System.out.println(problem130());
        //                    problem143();
        // System.out.println(problem138(scanner.nextInt()));
        // System.out.println(arrays19(scanner.nextInt()));
        // System.out.println(arrays32());
        /*
        int[] array = createCustomArray();
        int elem = array.length;
        arrays38(array, elem);
        */
        /*
        int[] array = createCustomArray();
        int elem = array.length;
        System.out.println(arrays42(array, elem));
        */
    }


    private static int problem120(int num) {
        int greatestDigit = 0;
        while (num > 0) {
            if (num % 10 > greatestDigit) {
                greatestDigit = num % 10;
            }
            num /= 10;
        }

        return greatestDigit;
    }

    private static boolean problem130() {
        for (int ticket1 = 100000; ticket1 < 1000000; ticket1++) {
            if (sumOfDigits(ticket1) % 13 == 0 && sumOfDigits(ticket1 + 1) % 13 == 0) {
                return true;
            }
        }
        return false;
    }

    static int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    private static void problem143() {
        int randomNumber1 = (int) (Math.random() * 101);
        int randomNumber2 = (int) (Math.random() * 101);

        while (randomNumber1 == randomNumber2) {
            randomNumber2 = (int) (Math.random() * 101);
        }

        int randomNumber3 = (int) (Math.random() * 101);

        while (randomNumber3 == randomNumber2 || randomNumber3 == randomNumber1) {
            randomNumber3 = (int) (Math.random() * 101);
        }

        System.out.print(randomNumber1 + ", " + randomNumber2 + ", " + randomNumber3);
    }

    private static String problem138(int num) {
        int[] array = new int[15];
        for (int i = 0; i < num; i++) {
            int randomNumber = (int) (Math.random() * 15);
            while (array[randomNumber] == 1) {
                randomNumber = (int) (Math.random() * 15);
            }
            array[randomNumber] = 1;
        }

        return Arrays.toString(array);
    }

    private static boolean arrays19(int x) {
        int[] array = {(int) (Math.random() * 100), (int) (Math.random() * 100), (int) (Math.random() * 100)};
        System.out.println(Arrays.toString(array));

        boolean foundNumber = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == x) {
                foundNumber = true;
                break;
            }
        }

        return foundNumber;
    }

    private static int arrays32() {
        int[] array = {(int) (Math.random() * 100), (int) (Math.random() * 100), (int) (Math.random() * 100)};
        System.out.println(Arrays.toString(array));

        int greatestDigit = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > greatestDigit) {
                greatestDigit = array[i];
            }
        }

        return greatestDigit;
    }

    public static int[] createCustomArray() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Amount of elements in the array: ");
        int elem = scanner.nextInt();
        int[] array = new int[elem];

        // creates an array based off user input
        for (int i = 0; i < elem; i++) {
            System.out.print("element " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }

        return array;
    }
    private static void arrays38(int[] array, int elem) {

        // finds the smallest sum of two connected elements in the array
        int minSum = Integer.MAX_VALUE;
        int[] minSumPair = new int[2];
        for (int i = 0; i < elem; i++) {
            int sum = array[i] + array[i + 1];
            if (sum < minSum) {
                minSum = sum;
                minSumPair[0] = array[i];
                minSumPair[1] = array[i + 1];
            }
        }

        System.out.println("Numbers " + Arrays.toString(minSumPair) + " give the smallest sum of " + minSum);
    }

    private static boolean arrays42(int[] array, int elem) {
        boolean isCountingUp = false;
        for (int i = 0; i < elem; i++) {
            if (array[i] == i + 1) {
                isCountingUp = true;
            } else {
                isCountingUp = false;
                break;
            }
        }

        return isCountingUp;
    }
}


