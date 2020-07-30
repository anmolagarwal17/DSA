// package DataStructures.Queue;

import java.util.Scanner;

// old queue implementation

// class Queue {
//     int queue[];
//     int front = -1;
//     int rear = -1;

//     Queue() {
//         this.queue = new int[5];
//     }

//     Queue(int size) {
//         this.queue = new int[size];
//     }

//     public void insert(int val) {

//         if (this.front == this.rear && this.rear == -1) {
//             this.front++;
//             this.rear++;
//             this.queue[this.rear] = val;
//         } else if (this.front == this.rear) {
//             if (this.rear < this.queue.length - 1)
//                 this.rear++;
//             else if (this.rear == this.queue.length - 1 && this.front > 0)
//                 this.rear = 0;
//             else {
//                 System.out.println("Overflow!");
//                 return;
//             }
//             this.queue[this.rear] = val;
//         } else if (this.front < this.rear) {
//             if (this.rear < this.queue.length - 1)
//                 this.rear++;
//             else if (this.rear == this.queue.length-1 && this.front > 0)
//                 this.rear = 0;
//             else {
//                 System.out.println("Overflow!");
//                 return;
//             }
//             this.queue[this.rear] = val;
//         }
//         // when front > rear
//         else {
//             if (this.rear == this.front - 1) {
//                 System.out.println("Overflow!");
//                 return;
//             }
//             // else if(rear < front-1)
//             this.rear++;
//             this.queue[this.rear] = val;
//         }

//     }

// public int delete() throws Exception {

//     int deleted = 0;
//     if (this.front == this.rear) {
//         if (this.rear == -1)
//             throw new Exception("Queue underflow!");
//         else {
//             deleted = this.queue[this.front];
//             this.front = this.rear = -1;
//         }
//     } else if (this.front < this.rear) {
//         deleted = this.queue[this.front];
//         this.front++;
//     }
//     // when front > rear
//     else {
//         deleted = this.queue[this.front];
//         if (this.front == this.queue.length - 1)
//             this.front = 0;
//         else
//             this.front++;
//     }
//     return deleted;
// }

// public void printFront() throws Exception {
//     if (this.front == -1)
//         throw new Exception("Queue empty!");
//     else
//         System.out.println("Front: " + this.queue[this.front]);
// }

// public void printRear() throws Exception {
//     if (this.rear == -1)
//     throw new Exception("Queue empty!");
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
// }

// new better implementation
class Queue{

    int queue[];
    int front, rear, size;
    int capacity;

    Queue(){
        this(5);
    }
    Queue(int capacity){
        this.queue = new int[capacity];
        this.front = this.size = 0;
        this.rear = -1;
        this.capacity = capacity;
    }

//    queue is empty - T/F
    private boolean isEmpty(){
            return this.size == 0;
        }

//    queue is full - T/F
    private boolean isFull(){
        return this.size == this.capacity;
    }

//    insert in queue
    public void insert(int val){
        if(this.isFull()){
            System.out.println("Queue full!");
            return;
        }
        this.rear = (this.rear+1)%capacity;
        this.queue[this.rear] = val;
        this.size++;
    }

//    delete from queue
    public int delete(){
        if(this.isEmpty()){
            System.out.println("Queue is empty!");
            return Integer.MIN_VALUE;
        }
        int val = this.queue[this.front];
        this.front = (this.front+1)%this.capacity;
        size--;

        return val;
    }

//    print full queue with index - for testing
    public void printQueue(){
        if(this.isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        for (int i = front, count = 0; (i >= this.front || i <= this.rear) && count<this.size; i = i==(capacity-1)? 0 : i+1, count++) {
            System.out.println(this.queue[i]);
        }
    }

//    return front of queue
    public int front(){
        if(this.isEmpty()){
            System.out.println("Queue is empty!");
            return Integer.MIN_VALUE;
        }
        return this.queue[this.front];
    }

//    return rear of queue
    public int rear(){
        if(this.isEmpty()){
            System.out.println("Queue is empty!");
            return Integer.MIN_VALUE;
        }
        return this.queue[this.rear];
    }

}

public class UsingArray {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of queue: ");
        Queue queue = new Queue(sc.nextInt());

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
                        System.out.println(queue.front());
                        break;
                    case 4:
                        System.out.println(queue.rear());
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