import java.util.Scanner;

class Stack {
    int arr[];
    int top = -1;

    Stack() {
        this.arr = new int[5];
    }

    Stack(int size) {
        this.arr = new int[size];
    }

    public void push(int val) throws Exception {
        if (this.top < this.arr.length - 1) {
            this.top++;
            this.arr[this.top] = val;
        } else
            throw new Exception("Stack overflow!");
    }

    public int pop() throws Exception {
        if (this.top > -1) {
            this.top--;
            return this.arr[this.top + 1];
        } else
            throw new Exception("Stack underflow!");
    }

    public int peek() throws Exception {
        if (this.top > -1)
            return this.arr[this.top];
        else
            throw new Exception("No items in stack!");
    }

    public boolean isEmpty() {
        if (this.top < 0)
            return true;
        else
            return false;
    }
}

class Main {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of stack: ");
        int size = sc.nextInt();
        Stack stack = new Stack(size);

        while (true) {
            try {

                System.out.println("Press enter to continue");
                sc.nextLine();
                sc.nextLine();
                clearScreen();
                System.out.println("1. Press 1 to push element to stack");
                System.out.println("2. Press 2 to pop element from stack");
                System.out.println("3. Press 3 to see the top element of the stack");
                System.out.println("4. Press 4 to check if the stack is empty");
                System.out.println("5. Press 5 to exit");

                int choice = sc.nextInt();
                int val;

                switch (choice) {
                    case 1:
                        System.out.println("Enter a number to push to stack: ");
                        val = sc.nextInt();
                        stack.push(val);
                        break;
                    case 2:
                        val = stack.pop();
                        System.out.println("Popped element: " + val);
                        break;
                    case 3:
                        val = stack.peek();
                        System.out.println("Top element of stack is: " + val);
                        break;
                    case 4:
                        System.out.println("Stack empty: " + stack.isEmpty());
                        break;
                    case 5:
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