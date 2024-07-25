import java.util.Scanner;

public class Java-hw1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // System.out.println(problem8());
        // System.out.println(problem9());
        // System.out.println(problem16(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble()));
        //                    problem26(scanner.nextDouble(), scanner.nextDouble());
        //                    problem33(scanner.nextDouble(), scanner.nextDouble());
        // System.out.println(problem35(scanner.nextDouble()));
        // System.out.println(problem38(scanner.nextDouble(), scanner.nextDouble()));
        // System.out.println(problem55(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble()));
        // System.out.println(problem61(scanner.nextDouble()));
        //                    problem68(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble());
    }

    private static int problem8() {
        int a = 2;
        int b = 3;

        return (a + 4 * b)*(a - 3 * b) + a*a;
    }

    private static int problem9() {
        int x = -2;

        return (int) (Math.abs(x) + Math.pow(x, 5));
    }

    private static double problem16(double a, double b, double c) {
        return (2 * a) + (b - 3) + (c * c);
    }

    private static void problem26(double a, double b){
        double temp = a;
        a = b;
        b = temp;

        System.out.println(a + " " + b);
    }

    private static void problem33(double x, double y) {
        boolean exists = false;

        exists = y >= 0 && x - Math.sqrt(y) >= 0;

        if (exists) {
            System.out.println(Math.sqrt(x - Math.sqrt(y)));
        } else {
            System.out.println("No real roots");
        }
    }

    private static String problem35(double a) {
        return   (a == 9) ? "Error" :
                 (a < 7)  ? "Yes" :
                 (a > 10) ? "No" :
                             null;
    }

    private static String problem38(double a, double b) {
        return  (a + 100 == b) ? "yes" :
                (a - 100 == b) ? "yes" :
                                  "No";
    }

    private static int problem55(double a, double b, double c) {
        int positives = 0;
        positives += a > 0 ? 1 : 0;
        positives += b > 0 ? 1 : 0;
        positives += c > 0 ? 1 : 0;

        return positives;
    }

    private static boolean problem61(double a) {
        char[] array = Double.toString(a).toCharArray();

        boolean hasSameDigits = false;
        for (int k = 0; k < 3; k++) {
            for (int i = k; i < 3; i++) {
                if (array[k] == array[i + 1]) {
                    hasSameDigits = true;
                    break;
                }
            }
        }

        return hasSameDigits;
    }

    private static void problem68(double a, double b, double c) {
        double discriminant = b*b - 4 * a * c;

        if (discriminant < 0) {
            System.out.println("No real roots");
        } else if (discriminant == 0) {
            System.out.println(-b / (2 * a));
        } else {
            double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println(x1 + "; " + x2);
        }
    }
}