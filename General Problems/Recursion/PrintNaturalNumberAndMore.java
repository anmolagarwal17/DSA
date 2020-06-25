import java.util.Scanner;

class PrintNaturalNumberAndMore {
    
    // 1
    public static void printFristNNaturalNumbers(int n) {

        if (n == 0)
            System.out.println(0);
        else if (n > 0) {
            printFristNNaturalNumbers(n - 1);
            System.out.println(n);
        } else {
            System.out.println("Negative number!");
        }
    }
    
    // 2
    public static void printFristNNaturalNumbersReverseOrder(int n) {
        if (n == 0)
            System.out.println(0);
        else if (n > 0) {
            System.out.println(n);
            printFristNNaturalNumbersReverseOrder(n - 1);
        } else {
            System.out.println("Negative number!");
        }
    }
    
    // 3
    public static void printFristNEvenNaturalNumbers(int n) {
        if (n == 0)
            System.out.println(0);
        else if (n > 0) {
            printFristNEvenNaturalNumbers(n - 1);
            if (n % 2 == 0)
                System.out.println(n);
        } else {
            System.out.println("Negative number!");
        }
    }
    
    // 4
    public static void printFristNEvenNaturalNumbersReverseOrder(int n) {
        if (n == 0)
            System.out.println(0);
        else if (n > 0) {
            if (n % 2 == 0)
                System.out.println(n);
            printFristNEvenNaturalNumbersReverseOrder(n - 1);
        } else {
            System.out.println("Negative number!");
        }
    }

    // 5
    public static void printFristNOddNaturalNumbers(int n) {
        if (n == 0)
            System.out.println(0);
        else if (n > 0) {
            printFristNOddNaturalNumbers(n - 1);
            if (n % 2 == 1)
                System.out.println(n);
        } else {
            System.out.println("Negative number!");
        }
    }

    // 6
    public static void printFristNOddNaturalNumbersReverseOrder(int n) {
        if (n == 0)
            System.out.println(0);
        else if (n > 0) {
            if (n % 2 == 1)
                System.out.println(n);
            printFristNOddNaturalNumbersReverseOrder(n - 1);
        } else {
            System.out.println("Negative number!");
        }
    }

    // 7
    public static int printSumOfFirstNNaturalNumbers(int n) {
        int sum = -1;
        if (n == 0)
            return 0;
        else if (n > 0)
            sum = n + printSumOfFirstNNaturalNumbers(n - 1);
        else
            System.out.println("Negative number!");
        return sum;
    }

    // 8
    public static int printSumOfFirstNEvenNaturalNumbers(int n) {
        int sum = -1;
        if (n == 0)
            return 0;
        else if (n > 0) {
            if (n % 2 == 0)
                sum = n + printSumOfFirstNEvenNaturalNumbers(n - 1);
            else
                sum = 0 + printSumOfFirstNEvenNaturalNumbers(n - 1);
        } else
            System.out.println("Negative number!");
        return sum;
    }

    // 9
    public static int printSumOfFirstNOddNaturalNumbers(int n) {
        int sum = -1;
        if (n == 0)
            return 0;
        else if (n > 0) {
            if (n % 2 == 1)
                sum = n + printSumOfFirstNOddNaturalNumbers(n - 1);
            else
                sum = 0 + printSumOfFirstNOddNaturalNumbers(n - 1);
        } else
            System.out.println("Negative number!");
        return sum;
    }
    
    // 10
    public static int printSumOfSquaresOfFirstNNaturalNumbers(int n) {
        int sum = -1;
        if (n == 0)
            return 0;
        else if (n > 0)
            sum = (n*n) + printSumOfSquaresOfFirstNNaturalNumbers(n - 1);
        else
            System.out.println("Negative number!");
        return sum;
    }
    
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        while (true) {

            Scanner sc = new Scanner(System.in);

            System.out.println("Press enter to continue");
            sc.nextLine();
            clearScreen();
            System.out.println("1. Press 1 to print first N natural numbers");
            System.out.println("2. Press 2 to print first N natural numbers in reverse order");
            System.out.println("3. Press 3 to print first N even natural numbers");
            System.out.println("4. Press 4 to print first N even natural numbers in reverse order");
            System.out.println("5. Press 5 to print first N odd natural numbers");
            System.out.println("6. Press 6 to print first N odd natural numbers in reverse order");
            System.out.println("7. Press 7 to print the sum of first N natural numbers");
            System.out.println("8. Press 8 to print the sum of first N even natural numbers");
            System.out.println("9. Press 9 to print the sum of first N odd natural numbers");
            System.out.println("10. Press 10 to print the sum of squares of first N natural numbers");
            System.out.println("11. Press 11 to exit");

            int choice = sc.nextInt();
            int n = -1;
            
                if (choice != 11) {
                    System.out.println("Enter value of N:");
                    n = sc.nextInt();
                }
            switch (choice) {
                case 1:
                    printFristNNaturalNumbers(n);
                    break;
                case 2:
                    printFristNNaturalNumbersReverseOrder(n);
                    break;
                case 3:
                    printFristNEvenNaturalNumbers(n);
                    break;
                case 4:
                    printFristNEvenNaturalNumbersReverseOrder(n);
                    break;
                case 5:
                    printFristNOddNaturalNumbers(n);
                    break;
                case 6:
                    printFristNOddNaturalNumbersReverseOrder(n);
                    break;
                case 7:
                    System.out.println(printSumOfFirstNNaturalNumbers(n));
                    break;
                case 8:
                    System.out.println(printSumOfFirstNEvenNaturalNumbers(n));
                    break;
                case 9:
                    System.out.println(printSumOfFirstNOddNaturalNumbers(n));
                    break;
                case 10:
                    System.out.println(printSumOfSquaresOfFirstNNaturalNumbers(n));
                    break;
                case 11:
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