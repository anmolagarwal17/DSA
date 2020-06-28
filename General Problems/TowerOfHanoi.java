import java.util.Scanner;

public class TowerOfHanoi {

    public static void TOH(int n, char A, char B, char C) {
        if (n > 0) {
            TOH(n - 1, A, C, B);
            System.out.println(A + " -> " + C);
            TOH(n - 1, B, A, C);
        }
    }

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of disks in tower A:");
        int n = sc.nextInt();

        System.out.println("Steps to move disks from tower A to tower C are:\n");
        TOH(n, 'A', 'B', 'C');
        
        sc.close();
    }
}