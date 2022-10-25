import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double x = inputValue("Введите x = ");
        if (isXMatchInterval(x)) {
            System.out.println("Введите коректное значение (-R,R) : (-1 < x < 1)");
            return;
        }

        int n = (int) inputValue("Введите n = ");
        if (isNPositive(n)) {
            System.out.println("Введите n > 0");
            return;
        }

        double epsilon = inputValue("Введите эпсилон = ");

        printResults(x, n, epsilon);

    }

    static double inputValue(String text) {
        System.out.print(text);
        Scanner scn = new Scanner(System.in);
        return scn.nextDouble();
    }

    static boolean isXMatchInterval(double num) {
        return (num <= -1 || num >= 1);
    }

    static boolean isNPositive(int num) {
        return !(num > 0);
    }

    static double nextTerm(int i, double x) {
        return -((Math.pow(x, i + 1)) / (i + 1));
    }

    static void calculateSumOfSequence(double x, int n, double epsilon) {
        double firstTerm = -x;
        double sum = 0;
        double sumE = 0;
        double sumE10 = 0;
        double firstTerm1 = -x;
        double firstTerm2 = -x;
        for (int i = 1; i <= n; i++) {
            sum += firstTerm;
            firstTerm = nextTerm(i, x);
            if (Math.abs(firstTerm1) > epsilon) {
                sumE += firstTerm1;
                firstTerm1 = nextTerm(i, x);
            }
            if (Math.abs(firstTerm2) > epsilon/10) {
                sumE10 += firstTerm2;
                firstTerm2 = nextTerm(i, x);
            }
        }
        System.out.println("Сумма членов = " + sum);
        System.out.println("Сумма членов, которые больше,чем e  = " + sumE);
        System.out.println("Сумма членов, которые больше,чем e/10 = " + sumE10);
    }

    static double calculateLogarithm(double x) {
        return Math.log(1 - x);
    }

    static void writeLogarithm(double SumLogarithm) {
        System.out.println("Значение функции через метод Math  = " + SumLogarithm);
    }

    static void printResults(double num1, int num2, double num3) {

        double x = num1;
        int n = num2;
         double epsilon = num3;
         calculateSumOfSequence(x, n, epsilon);
        writeLogarithm(calculateLogarithm(x));
    }
}