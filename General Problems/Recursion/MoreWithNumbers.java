import java.util.Scanner;

public class MoreWithNumbers {

    // 1
    public static int sumOfDigits(int n) {
        if (n / 10 == 0)
            return n % 10;
        else
            return n % 10 + sumOfDigits(n / 10);
    }

    // 2
    public static void decimalToBinary(int n) {
        n = Math.abs(n);
        if (n / 2 == 0)
            System.out.print(n % 2);
        else {
            decimalToBinary(n / 2);
            System.out.print(n % 2);
        }
    }

    // 3
    public static void decimalToOctal(int n) {
        n = Math.abs(n);
        if (n / 8 == 0)
            System.out.print(n % 8);
        else {
            decimalToOctal(n / 8);
            System.out.print(n % 8);
        }
    }

    // 4
    public static void reverseOf(int n) {
        // this function will print 1 as reverse of 01 or 001
        // if we want to print 10 as reverse of 01 then we'll have to either take input
        // in string format or send the number of digits in input in a seperate argument
        n = Math.abs(n);
        if (n / 10 == 0)
            System.out.print(n % 10);
        else {
            System.out.print(n % 10);
            reverseOf(n / 10);
        }
    }

    // 4
    public static int nthTermOfFibonacci(int n) {
        n = Math.abs(n);
        // because 1st number of fibnocci will be 0
        if (n == 1)
            return 0;
        // because 1st number of fibnocci will be 1
        else if (n == 2)
            return 1;
        else
            return nthTermOfFibonacci(n - 1) + nthTermOfFibonacci(n - 2);
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        while (true) {

            Scanner sc = new Scanner(System.in);

            System.out.println("\nPress enter to continue");
            sc.nextLine();
            clearScreen();
            System.out.println("1. Press 1 to print sum of first N natural numbers");
            System.out.println("2. Press 2 to print binary equivalent of decimal number(N)");
            System.out.println("3. Press 3 to print octal equivalent of decimal number(N)");
            System.out.println("4. Press 4 to print reverse of number(N)");
            System.out.println("5. Press 5 to print Nth number of fibonacci series");
            System.out.println("6. Press 6 to exit");

            int choice = sc.nextInt();
            int n = -1;
                if (choice != 6) {
                    System.out.println("Enter value of N:");
                    n = sc.nextInt();
                }
            switch (choice) {
                case 1:
                    System.out.println(sumOfDigits(n));
                    break;
                case 2:
                    decimalToBinary(n);
                    break;
                case 3:
                    decimalToOctal(n);
                    break;
                case 4:
                    reverseOf(n);
                    break;
                case 5:
                    System.out.println(nthTermOfFibonacci(n));
                    break;
                case 6:
                    System.out.println("Press enter to exit!");
                    sc.nextLine();
                    sc.nextLine();
                    System.exit(0);
                default:
                    System.out.println("\nInvalid choice!\nTry again.\n");
            }
        }
    }
}