// package DataStructures.Queue;

import java.util.Scanner;

class Queue {
    int queue[];
    int front = -1;
    int rear = -1;

    Queue() {
        this.queue = new int[5];
    }

    Queue(int size) {
        this.queue = new int[size];
    }

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
                doubleQueue();
                this.insert(val);
                return;
            }
            this.queue[this.rear] = val;
        } else if (this.front < this.rear) {
            if (this.rear < this.queue.length - 1)
                this.rear++;
            else if (this.rear == this.queue.length - 1 && this.front > 0)
                this.rear = 0;
            else {
                doubleQueue();
                this.insert(val);
                return;
            }
            this.queue[this.rear] = val;
        }
        // when front > rear
        else {
            if (this.rear == this.front - 1) {
                doubleQueue();
                this.insert(val);
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
        // half the queue if possible
        halfQueue();
        return deleted;
    }

    public void printFront() throws Exception {
        if (this.front == -1)
            throw new Exception("Queue empty!");
        else
            System.out.println("Front: " + this.queue[this.front]);
    }

    public void printRear() throws Exception {
        if (this.rear == -1)
            throw new Exception("Queue empty!");
        else
            System.out.println("Rear: " + this.queue[this.rear]);
    }

    // this is for testing
    public void printQueue() {
        System.out.println("Front: " + this.front);
        System.out.println("Rear: " + this.rear + "\n");

        // for (int i = 0; i < this.queue.length; i++) {
        // System.out.println(i + ": " + this.queue[i]);
        // }
        if (front != -1) {
            int i = front;
            while (i != rear) {
                System.out.print(this.queue[i] + "\t");
                if (i == (this.queue.length - 1))
                    i = 0;
                else
                    i++;
            }
            System.out.print(this.queue[i]);
        } else
            System.out.println("Queue empty!");
        System.out.println();
    }

    // double the size of array1
    private void doubleQueue() {
        int newArr[] = new int[this.queue.length * 2];
        if (this.front > this.rear) {
            int temp = 0;

            // copying from front to end and from start to rear
            for (int i = this.front; i < this.queue.length; i++) {
                temp = i - this.front;
                newArr[temp] = this.queue[i];
            }
            temp++;
            for (int i = 0; i <= this.rear; i++)
                newArr[i + temp] = this.queue[i];

            this.rear = this.queue.length - this.front + this.rear;
        }
        // when front < rear || front == rear
        else {
            for (int i = this.front; i <= this.rear; i++)
                newArr[i - this.front] = this.queue[i];

            this.rear = this.rear - this.front;
        }
        this.front = 0;
        this.queue = newArr;
    }

    private void halfQueue() {
        this.printQueue();
        int newArr[] = new int[this.queue.length / 2];
        int totalElements = -1;
        if (this.front > this.rear) {
            totalElements = this.queue.length - this.front + this.rear;
            if (totalElements < queue.length / 2) {
                int temp = 0;

                // copying from front to end and from start to rear
                for (int i = this.front; i < this.queue.length; i++) {
                    temp = i - this.front;
                    newArr[temp] = this.queue[i];
                }
                temp++;
                for (int i = 0; i <= this.rear; i++)
                    newArr[i + temp] = this.queue[i];

                this.rear = this.queue.length - this.front + this.rear;
            } else
                return;
        }
        // do nothing when only one element space is left in queue
        else if (front == rear)
            return;
        // when front < rear
        else if (rear - front < queue.length / 2) {
            for (int i = front; i <= rear; i++)
                newArr[i - front] = queue[i];
            rear = rear - front;
        } else
            return;

        front = 0;
        queue = newArr;
        this.printQueue();
    }
}

public class UsingDynamicArray {

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