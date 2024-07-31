import java.util.Scanner;
import java.util.Arrays;


public class Java_Day_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // System.out.println(problem120(scanner.nextInt()));
        // System.out.println(problem130());
        //                    problem143();
        // System.out.println(problem138());
    }


    private static char problem120(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        Arrays.sort(digits);
        return digits[digits.length - 1];
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

    private static String problem138() {
        int randomNumber1 = (int) (Math.random() * 15);
        int randomNumber2 = (int) (Math.random() * 15);

        while (randomNumber1 == randomNumber2) {
            randomNumber2 = (int) (Math.random() * 15);
        }

        int randomNumber3 = (int) (Math.random() * 15);

        while (randomNumber3 == randomNumber2 || randomNumber3 == randomNumber1) {
            randomNumber3 = (int) (Math.random() * 15);
        }

        int[] array = new int[15];

        array[randomNumber1] = 1;
        array[randomNumber2] = 1;
        array[randomNumber3] = 1;

        return Arrays.toString(array);
    }
}


