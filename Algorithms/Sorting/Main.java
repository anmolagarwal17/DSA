import java.util.Scanner;

public class Main {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {

                System.out.println("Press enter to continue");
                sc.nextLine();
                sc.nextLine();
                clearScreen();
                System.out.println("1. Bubble sort");
                System.out.println("2. Selection sort");
                System.out.println("3. Insertion sort");
                System.out.println("4. Bubble sort");
                System.out.println("5. Bubble sort");
                System.out.println("6. Press 6 to exit");

                int choice = sc.nextInt();
                int val;

                int arr[] = new int[100];
                for (int i = 0; i < arr.length; i++)
                    arr[i] = (int) (100.0 * Math.random());

                if (choice != 6) {
                    System.out.println("\n\nArray before sorting:\n");
                    for (int i = 0; i < arr.length; i++)
                        System.out.println(i + ": " + arr[i]);
                }

                switch (choice) {
                    case 1:
                        BubbleSort s = new BubbleSort();
                        s.sort(arr);
                        break;
                    case 2:
                        SelectionSort s = new SelectionSort();
                        s.sort(arr);
                        break;
                    case 6:
                        System.out.println("Press enter to exit!");
                        // sc.nextLine();
                        // sc.nextLine();
                        System.exit(0);
                    default:
                        System.out.println("\nInvalid choice!\nTry again.\n");
                }

                System.out.println("\n\nArray after sorting:\n");
                for (int i = 0; i < arr.length; i++)
                    System.out.println(i + ": " + arr[i]);
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        }
    }
}