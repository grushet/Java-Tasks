import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;


public class Java_Day_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // System.out.println(problem120(scanner.nextInt()));
        // System.out.println(problem130());
        // problem143();
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
        // problem142();
    }


    private static int problem120(int num) {
        // Найдите наибольшую цифру в данном натуральном числе.
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
        // Назовем автобусный билет несчастливым, если сумма цифр его шестизначного номера
        // делится на 13. Могут ли два идущих подряд билета оказаться несчастливыми?
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
        // Вывести 3 случайных числа от 0 до 100 без повторений.
        int randomNumber1 = (int) (Math.random() * 101);
        int randomNumber2 = (int) (Math.random() * 101);

        while (randomNumber1 == randomNumber2) {
            randomNumber2 = (int) (Math.random() * 101);

            int randomNumber3 = (int) (Math.random() * 101);

            while (randomNumber3 == randomNumber2 || randomNumber3 == randomNumber1) {
                randomNumber3 = (int) (Math.random() * 101);
            }

            System.out.print(randomNumber1 + ", " + randomNumber2 + ", " + randomNumber3);
        }
    }

    private static String problem138(int num) {
        // Сгенерировать случайную серию из 15 чисел, в которой ровно 3 единицы, остальные нули.
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

    private static void problem142() {
        // Компьютер загадывает число от 1 до 100. У пользователя три попытки отгадать.
        // После каждой неудачной попытки компьютер сообщает меньше или больше загаданное число.
        Scanner scanner = new Scanner(System.in);

        final int RANDOM_NUMBER = (int) (Math.random() * 100);
        for (int i = 0; i < 3; i++) {
            int guess = scanner.nextInt();
            if (guess > RANDOM_NUMBER) {
                System.out.println("Lower");
            } else if (guess < RANDOM_NUMBER) {
                System.out.println("Higher");
            } else {
                System.out.println("Correct!");
                break;
            }
        }
        System.out.println("The number was " + RANDOM_NUMBER);
    }

    private static void problem144() {
        // Найдите количество прямоугольных треугольников с целочисленными сторонами, меньшими 100.

        // понимаю задачу, но не понимаю что делать
    }

    private static boolean arrays19(int x) {
        // Определить, содержит ли массив данное число x
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
        // Найти наибольший элемент массива.
        int[] array = {(int) (Math.random() * 100), (int) (Math.random() * 100), (int) (Math.random() * 100)};
        System.out.println(Arrays.toString(array));

        int greatestNumber = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > greatestNumber) {
                greatestNumber = array[i];
            }
        }

        return greatestNumber;
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
        // Дан массив. Найдите два соседних элемента, сумма которых минимальна.

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
        // Проверьте, содержит ли данный массив из n чисел, все числа от 1 до n
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


