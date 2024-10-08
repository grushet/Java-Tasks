import java.util.Scanner;

public class Java_Day_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // System.out.println(problem67(scanner.nextInt()));
        //                    problem69(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble());
        //                    problem71(scanner.nextInt(), scanner.nextInt());
        //                    problem72and73(72);
        //                    problem72and73(73);
        //                    problem99();
        //                    problem104();
        //                    problem105();
        // System.out.println(problem127(scanner.nextInt()));
        // System.out.println(websiteClockProblem(scanner.nextInt()));
        //                    problem128(scanner.nextInt(), scanner.nextInt());
    }
    

    private static int problem67(int num) {

        char[] numArray = Integer.toString(num).toCharArray();

        int greatestDigit = numArray[0];
        int placeOfGreatestDigit = 0;

        int smallestDigit = numArray[0];
        int placeOfSmallestDigit = 0;

        // finds the largest & smallest numbers as well as their positions in the array
        for (int i = 0; i < numArray.length; i++) {
            if (numArray[i] > greatestDigit) {
                greatestDigit = numArray[i];
                placeOfGreatestDigit = i;
            } else if (numArray[i] < smallestDigit) {
                smallestDigit = numArray[i];
                placeOfSmallestDigit = i;
            }
        }

        // swaps the positions of the smallest and greatest digits
        char temp = numArray[placeOfGreatestDigit];
        numArray[placeOfGreatestDigit] = numArray[placeOfSmallestDigit];
        numArray[placeOfSmallestDigit] = temp;

        return Integer.parseInt(new String(numArray));
    }

    private static void problem69(double a, double b, double c) {
        boolean exists = a + b > c &&
                         a + c > b &&
                         b + c > a;

        if (exists) {
            double s = (a + b + c) / 2;
            double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
            System.out.println(area);
        } else {
            System.out.println("Triangle does not exist");
        }
    }

    private static void problem71(int h, int m) {
        // hour hand moves 30 degrees every hour and 0.5 degrees every minute
        double hourHandDegrees = h * 30 + 0.5 * m;

        // minute hand moves 6 degrees every minute
        double minuteHandDegrees = m * 6;

        System.out.println(Math.abs(hourHandDegrees - minuteHandDegrees) + " degrees");
    }

    private static void problem72and73(int problem) {
        Scanner scanner = new Scanner(System.in);

        // gathering rectangle 1 data
        System.out.print("Rectangle 1 dimensions (length width): ");
        double rectangle1Length = scanner.nextDouble();
        double rectangle1Width = scanner.nextDouble();
        System.out.print("Rectangle 1 lower-left vertex coordinates (x y): ");
        double rectangle1LowerLeftVertexX = scanner.nextDouble();
        double rectangle1LowerLeftVertexY = scanner.nextDouble();

        // gathering rectangle 2 data
        System.out.print("Rectangle 2 dimensions (length width): ");
        double rectangle2Length = scanner.nextDouble();
        double rectangle2Width = scanner.nextDouble();
        System.out.print("Rectangle 2 lower-left vertex coordinates (x y): ");
        double rectangle2LowerLeftVertexX = scanner.nextDouble();
        double rectangle2LowerLeftVertexY = scanner.nextDouble();

        // calculating rectangle 1 upper right vertex coordinates
        double rectangle1UpperRightVertexX = rectangle1LowerLeftVertexX + rectangle1Length;
        double rectangle1UpperRightVertexY = rectangle1LowerLeftVertexY + rectangle1Width;

        // calculating rectangle 2 upper right vertex coordinates
        double rectangle2UpperRightVertexX = rectangle2LowerLeftVertexX + rectangle2Length;
        double rectangle2UpperRightVertexY = rectangle2LowerLeftVertexY + rectangle2Width;

        if (problem == 72) {
            // final rectangle lower left vertex coordinates
            double finalRectangleLowerLeftVertexX = Math.min(rectangle1LowerLeftVertexX, rectangle2LowerLeftVertexX);
            double finalRectangleLowerLeftVertexY = Math.min(rectangle1LowerLeftVertexY, rectangle2LowerLeftVertexY);

            // final rectangle upper right vertex coordinates
            double finalRectangleUpperRightVertexX = Math.max(rectangle1UpperRightVertexX, rectangle2UpperRightVertexX);
            double finalRectangleUpperRightVertexY = Math.max(rectangle1UpperRightVertexY, rectangle2UpperRightVertexY);

            // printing result
            System.out.println("Lower left vertex: (" + finalRectangleLowerLeftVertexX + ", " + finalRectangleLowerLeftVertexY + ")");
            System.out.println("Upper right vertex: (" + finalRectangleUpperRightVertexX + ", " + finalRectangleUpperRightVertexY + ")");
        }

        if (problem == 73) {
            boolean sameCoordinates =   rectangle1LowerLeftVertexX == rectangle2LowerLeftVertexX &&
                                        rectangle1LowerLeftVertexY == rectangle2LowerLeftVertexY &&
                                      rectangle1UpperRightVertexX == rectangle2UpperRightVertexX &&
                                      rectangle1UpperRightVertexY == rectangle2UpperRightVertexY;

            System.out.println("a) " + sameCoordinates);
            System.out.println("б) " + sameCoordinates);

            boolean intersect = rectangle1LowerLeftVertexX <= rectangle2LowerLeftVertexX && rectangle2LowerLeftVertexX <= rectangle1UpperRightVertexX ||
                                rectangle2LowerLeftVertexX <= rectangle1LowerLeftVertexX && rectangle1LowerLeftVertexX <= rectangle2UpperRightVertexX ||
                                rectangle1LowerLeftVertexY <= rectangle2LowerLeftVertexY && rectangle2LowerLeftVertexY <= rectangle1UpperRightVertexY ||
                                rectangle2LowerLeftVertexY <= rectangle1LowerLeftVertexY && rectangle1LowerLeftVertexY <= rectangle2UpperRightVertexY;

            System.out.println("в) " + intersect);
        }
    }

    private static void problem99() {
        for (int a = 1000; a <= 9999; a++) {
            boolean hasSameDigits = false;
            char[] array = Integer.toString(a).toCharArray();

            for (int k = 0; k < array.length - 1; k++) {
                for (int i = k; i < array.length - 1; i++) {
                    if (array[k] == array[i + 1]) {
                        hasSameDigits = true;
                        break;
                    }
                }
                if (hasSameDigits) {
                    break;
                }
            }

            if (!hasSameDigits) {
                System.out.print(a + " ");
            }
        }
    }

    private static void problem104() {
        int counter = 0;
        for (int i = 1000; i <= 9999; i++) {
            int thousands = i / 1000;
            int hundreds = i / 100 % 10;
            int tens = i / 10 % 10;
            int ones = i % 10;

            counter += 600 * (thousands + hundreds + tens + ones) == i ? 1 : 0;
        }

        System.out.println(counter);
    }

    private static void problem105() {
        int count = 11;
        boolean didNotFindNumber = true;
        while (didNotFindNumber) {
            if (count % 11 == 0) {
                int remainderIsOne = 0;
                for (int i = 2; i <= 10; i++) {
                    if (count % i == 1) {
                        remainderIsOne++;
                    } else {
                        break;
                    }
                }
                if (remainderIsOne == 9) {
                    System.out.println(count);
                    didNotFindNumber = false;
                }
            }
            count++;
        }
    }

    private static boolean problem127(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static String websiteClockProblem(int sec) {
        int days = sec / (3600 * 24) >= 1 ? sec / (3600 * 24) : 0;
        sec %= (3600 * 24);

        int hours = sec / 3600 >= 1 ? sec / 3600 : 0;
        sec %= 3600;

        int minutes = sec / 60 >= 1 ? sec / 60 : 0;
        sec %= 60;

        int seconds = sec;

        String digitalTime = "";
        if (days >= 1) {
            digitalTime += days < 10 ? ("0" + days + "d") : (days + "d");
        }
        if (hours >= 1 || days >= 1) {
            digitalTime += hours < 10 ? ("0" + hours + "h") : (hours + "h");
        }
        if (minutes >= 1 || hours >= 1 || days >= 1) {
            digitalTime += minutes < 10 ? ("0" + minutes + "m") : (minutes + "m");
        }
        if (seconds >= 1 || minutes >= 1 || hours >= 1 || days >= 1) {
            digitalTime += seconds < 10 ? ("0" + seconds + "s") : (seconds + "s");
        }

        return digitalTime;
    }



    private static void problem128(int a, int b) {
        int originalB = b;
        int originalA = a;
        for (; b > 0; b--) {
            for (; a <= originalB; a++) {
                if (addDivisors(a) == b && addDivisors(b) == a && a != b) {
                    System.out.println("a = " + a + ", b = " + b);
                }
            }
            a = originalA;
        }
    }

    static int addDivisors(int num) {
        int divisors = 1;
        for (int i = 2; i <= (num / 2); i++) {
            if (num % i == 0) {
                divisors += i;
            }
        }
        return divisors;
    }
}
