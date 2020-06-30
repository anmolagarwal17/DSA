// this implementation of priotity queue will work with all three programs of queue made using array/dynamic array & queue

import java.util.Scanner;

// 0 == highest priority
// 1 == medium priority
// 2 == lowest priority

class PriorityQueue {

    Queue queue[] = new Queue[3];

    PriorityQueue() {
        this.queue[0] = new Queue();
        this.queue[1] = new Queue();
        this.queue[2] = new Queue();
    }

    // PriorityQueue(int size) {
    //     this.queue[0] = new Queue(size);
    //     this.queue[1] = new Queue(size);
    //     this.queue[2] = new Queue(size);
    // }

    public void insert(int val, int priority) {
        switch (priority) {
            case 0:
            case 1:
            case 2:
                this.queue[priority].insert(val);
                break;
            default:
                System.out.println("Wrong priority entered!");
        }
    }

    public int delete() throws Exception {
        for (int i = 0; i < 3; i++)
            // delete and return anything found in queue[0] (highest priority) if not empty
            // else delete->return from queue[1]
            // and so on
            if (!this.queue[i].isEmpty())
                return this.queue[i].delete();

        // else throw Exception
        throw new Exception("Queue empty");
    }

    // this class is simple queue using array
    // this class can be replaces with class of queue made using
    //      dynamic array
    //      linked list
    //      etc
    // and will work just fine
    class Queue {
        int queue[];
        int front = -1;
        int rear = -1;

        Queue() {
            this.queue = new int[5];
        }

        // Queue(int size) {
        //     this.queue = new int[size];
        // }

        public void insert(int val) {

            if (this.front == this.rear && this.rear == -1) {
                this.front++;
                this.rear++;
                this.queue[this.rear] = val;
            } else if (this.front == this.rear) {
                if (this.rear < this.queue.length - 1)
                    this.rear++;
                else if (this.rear == this.queue.length - 1 && this.front > 0)
                    this.rear = 0;
                else {
                    System.out.println("Overflow!");
                    return;
                }
                this.queue[this.rear] = val;
            } else if (this.front < this.rear) {
                if (this.rear < this.queue.length - 1)
                    this.rear++;
                else if (this.rear == this.queue.length - 1 && this.front > 0)
                    this.rear = 0;
                else {
                    System.out.println("Overflow!");
                    return;
                }
                this.queue[this.rear] = val;
            }
            // when front > rear
            else {
                if (this.rear == this.front - 1) {
                    System.out.println("Overflow!");
                    return;
                }
                // else if(rear < front-1)
                this.rear++;
                this.queue[this.rear] = val;
            }

        }

        public int delete() throws Exception {

            int deleted = 0;
            if (this.front == this.rear) {
                if (this.rear == -1)
                    throw new Exception("Queue underflow!");
                else {
                    deleted = this.queue[this.front];
                    this.front = this.rear = -1;
                }
            } else if (this.front < this.rear) {
                deleted = this.queue[this.front];
                this.front++;
            }
            // when front > rear
            else {
                deleted = this.queue[this.front];
                if (this.front == this.queue.length - 1)
                    this.front = 0;
                else
                    this.front++;
            }
            return deleted;
        }

        // the functions that are commented are not used in the program

        // public void printFront() throws Exception {
        //     if (this.front == -1)
        //         throw new Exception("Queue empty!");
        //     else
        //         System.out.println("Front: " + this.queue[this.front]);
        // }

        // public void printRear() throws Exception {
        //     if (this.rear == -1)
        //         throw new Exception("Queue empty!");
        //     else
        //         System.out.println("Rear: " + this.queue[this.rear]);
        // }

        // // this is for testing
        // public void printQueue() {
        //     System.out.println("Front: " + this.front);
        //     System.out.println("Rear: " + this.rear + "\n");

        //     for (int i = 0; i < this.queue.length; i++) {
        //         System.out.println(i + ": " + this.queue[i]);
        //     }
        //     System.out.println();
        // }

        public boolean isEmpty() {
            // if front == -1 is true then empty then return true
            return front == -1;
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        PriorityQueue pQueue = new PriorityQueue();

        while (true) {
            try {

                System.out.println("Press enter to continue");
                sc.nextLine();
                sc.nextLine();
                clearScreen();
                System.out.println("1. Press 1 to insert in priority queue");
                System.out.println("2. Press 2 to delete from queue");
                System.out.println("3. Press 3 to exit");

                int choice = sc.nextInt();
                int val, priority;

                switch (choice) {
                    case 1:
                        System.out.println("Enter a number to insert in priority queue: ");
                        val = sc.nextInt();
                        System.out.println("Enter priority(0-2)");
                        priority = sc.nextInt();
                        pQueue.insert(val, priority);
                        break;
                    case 2:
                        System.out.println("Item deleted from queue is: " + pQueue.delete());
                        break;
                    case 3:
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