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

        for (int i = 1; i <= n; i++) {
            sum += firstTerm;
            firstTerm = nextTerm(i, x);
            if (firstTerm > epsilon) {
                sumE += firstTerm;
            }
        }
        System.out.println("Сумма членов, которые больше,чем e  = " + sumE);
        System.out.println("Сумма членов, которые больше,чем e/10 = " + sum);
        System.out.println("Сумма членов = " + sum);
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