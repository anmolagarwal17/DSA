import java.util.Scanner;

public class TwoWayStack {

    static class Stack {
        int arr[];
        int top1 = -1;
        int top2;

        Stack() {
            arr = new int[10];
            top2 = 10;
        }

        Stack(int size) {
            arr = new int[size];
            top2 = size;
        }

        // push to stack 1
        public void push1(int val) throws Exception {
            if ((top1 + 1) < top2) {
                top1++;
                arr[top1] = val;
            } else
                throw new Exception("Stack overflow");
        }

        // push to stack 2
        public void push2(int val) throws Exception {
            if ((top1 + 1) < top2) {
                top2--;
                arr[top2] = val;
            } else
                throw new Exception("Stack overflow");
        }

        // pop from stack 1
        public int pop1() throws Exception {
            int val;
            if (top1 <= -1)
                throw new Exception("Stack empty");
            else {
                val = arr[top1];
                top1--;
            }
            return val;
        }

        // pop from stack 2
        public int pop2() throws Exception {
            int val;
            if (top2 >= arr.length)
                throw new Exception("Stack empty");
            else {
                val = arr[top2];
                top2++;
            }
            return val;
        }

        // peek stack 1
        public int peek1() throws Exception {
            int val;
            if (top1 <= -1)
                throw new Exception("Stack empty");
            else
                val = arr[top1];
            return val;
        }

        // peek stack 2
        public int peek2() throws Exception {
            int val;
            if (top2 >= arr.length)
                throw new Exception("Stack empty");
            else
                val = arr[top2];
            return val;
        }

        // stack 1 isEmpty
        public boolean isEmpty1() {
            if (top1 < 0)
                return true;
            else
                return false;
        }

        // stack 2 isEmpty
        public boolean isEmpty2() {
            if (top2 >= arr.length)
                return true;
            else
                return false;
        }
    }
    
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Stack stack = new Stack();

        while (true) {
            try {

                System.out.println("Press enter to continue");
                sc.nextLine();
                sc.nextLine();
                clearScreen();
                System.out.println("1. Press 1 to push element to stack 1");
                System.out.println("2. Press 2 to push element to stack 2");
                System.out.println("3. Press 3 to pop element from stack 1");
                System.out.println("4. Press 4 to pop element from stack 2");
                System.out.println("5. Press 5 to see the top element of stack 1");
                System.out.println("6. Press 6 to see the top element of stack 2");
                System.out.println("7. Press 7 to check if stack 1 is empty");
                System.out.println("8. Press 8 to check if stack 2 is empty");
                System.out.println("9. Press 9 to exit");

                int choice = sc.nextInt();
                int val;

                switch (choice) {
                    case 1:
                        System.out.println("Enter a number to push to stack 1: ");
                        val = sc.nextInt();
                        stack.push1(val);
                        break;
                    case 2:
                        System.out.println("Enter a number to push to stack 2: ");
                        val = sc.nextInt();
                        stack.push2(val);
                        break;
                    case 3:
                        val = stack.pop1();
                        System.out.println("Popped element from stack 1: " + val);
                        break;
                    case 4:
                        val = stack.pop2();
                        System.out.println("Popped element from stack 2: " + val);
                        break;
                    case 5:
                        val = stack.peek1();
                        System.out.println("Top element of stack 1 is: " + val);
                        break;
                    case 6:
                        val = stack.peek2();
                        System.out.println("Top element of stack 2 is: " + val);
                        break;
                    case 7:
                        System.out.println("Stack 1 empty: " + stack.isEmpty1());
                        break;
                    case 8:
                        System.out.println("Stack 2 empty: " + stack.isEmpty2());
                        break;
                    case 9:
                        System.out.println("Press enter to exit!");
                        // sc.nextLine();
                        // sc.nextLine();
                        System.exit(0);
                    default:
                        System.out.println("\nInvalid choice!\nTry again.\n");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        }
    }

}