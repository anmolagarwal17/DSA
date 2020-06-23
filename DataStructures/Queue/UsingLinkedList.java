import java.util.Scanner;

class Queue {
    Node front = null;
    Node rear = null;

    private class Node {
        int val;
        Node next = null;

        Node(int val) {
            this.val = val;
        }
    }

    Queue() {
    }

    public void insert(int val) {
        Node newNode = new Node(val);
        if (this.front == null) {
            this.front = newNode;
            this.rear = newNode;
        } else {
            this.rear.next = newNode;
            this.rear = newNode;
        }
    }

    public int delete() throws Exception {
        int deleted = 0;

        if (this.front == null)
            throw new Exception("Queue emppty!\nNothing to delete.");
        else {
            deleted = this.front.val;
            this.front = this.front.next;
            if(this.front == null)
                this.rear = null;
        }

        return deleted;
    }

    public void printFront() throws Exception {
        if (this.front == null)
            throw new Exception("Queue empty!");
        else
            System.out.println("Front: " + this.front.val);
    }

    public void printRear() throws Exception {
        if (this.front == null)
            throw new Exception("Queue empty!");
        else {
            System.out.println("Rear: " + this.rear.val);
        }
    }

    // this is for testing
    public void printQueue() {

        if (this.front == null)
            System.out.println("Queue empty!");
        else {
            Node current = this.front;
            while (current != null) {
                System.out.print(current.val + "\t");
                current = current.next;
            }
            System.out.println();
        }
    }
}

public class UsingLinkedList {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        Queue queue = new Queue();

        while (true) {
            try {

                System.out.println("Press enter to continue");
                sc.nextLine();
                sc.nextLine();
                clearScreen();
                System.out.println("1. Press 1 to insert in queue");
                System.out.println("2. Press 2 to delete from queue");
                System.out.println("3. Press 3 to print front of queue");
                System.out.println("4. Press 4 to print end of queue");
                System.out.println("5. Press 5 to print whole queue");
                System.out.println("6. Press 6 to exit");

                int choice = sc.nextInt();
                int val;

                switch (choice) {
                    case 1:
                        System.out.println("Enter a number to insert in queue: ");
                        val = sc.nextInt();
                        queue.insert(val);
                        break;
                    case 2:
                        System.out.println("Item deleted from queue is: " + queue.delete());
                        break;
                    case 3:
                        queue.printFront();
                        break;
                    case 4:
                        queue.printRear();
                        break;
                    case 5:
                        queue.printQueue();
                        break;
                    case 6:
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