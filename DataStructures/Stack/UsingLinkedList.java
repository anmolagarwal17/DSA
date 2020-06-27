import java.util.Scanner;

class Stack {
    Node top = null;

    private class Node {
        int val;
        Node next = null;
        Node(int val) {
            this.val = val;
        }
    }

    Stack() {
    }

    public void push(int val) throws Exception {
        Node newNode = new Node(val);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    public int pop() throws Exception {
        if (top == null)
            throw new Exception("Stack underflow!");
        else {
            int val = top.val;
            top = top.next;
            return val;
        }
    }

    public int peek() throws Exception {
        if (top == null)
            throw new Exception("No items in stack!");
        else
            return top.val;
    }

    public boolean isEmpty() {
        if (top == null)
            return true;
        else
            return false;
    }
}

class UsingLinkedList {

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