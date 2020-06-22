import java.util.Scanner;

class CircularDoublyLinkedList {
    Node head = null;

    private class Node {
        int val;
        Node next = null;
        Node prev = null;

        Node(int val) {
            this.val = val;
        }
    }

    CircularDoublyLinkedList() {
    }

    // insert as first node
    public void insertAtStart(int val) {
        Node newNode = new Node(val);

        // when list is empty
        if (this.head == null) {
            newNode.next = newNode;
            newNode.prev = newNode;
            this.head = newNode;
        }
        // when list have atleast one node
        else {
            newNode.next = this.head;
            newNode.prev = this.head.prev;

            this.head.prev.next = newNode;
            this.head.prev = newNode;

            this.head = newNode;
        }
    }

    // insert as last node
    public void insertAtEnd(int val) {
        Node newNode = new Node(val);

        // when list is empty
        if (this.head == null) {
            newNode.next = newNode;
            newNode.prev = newNode;
            this.head = newNode;
        }
        // when list have atleast one node
        else {
            newNode.next = this.head;
            newNode.prev = this.head.prev;

            this.head.prev.next = newNode;
            this.head.prev = newNode;
        }
    }

    // insert node at index
    public void insertAt(int val, int index) throws Exception {
        if (index < 0 || (this.head == null && index > 0))
            throw new Exception("Invalid index: " + index);
        else if (index == 0)
            this.insertAtStart(val);
        else {
            Node newNode = new Node(val);
            Node current = this.head;
            int currIndex = 0;

            while (currIndex < index - 1) {
                if (current == this.head.prev)
                    throw new Exception("Invalid index: " + index);
                current = current.next;
                currIndex++;
            }

            newNode.prev = current;
            newNode.next = current.next;

            current.next.prev = newNode;
            current.next = newNode;
        }
    }

    // delete first item
    public void deleteFirst() throws Exception {

        if (this.head == null)
            throw new Exception("No item to delete");
        // when there is only one node in the list
        else if (this.head.next == this.head)
            this.head = null;
        else {
            this.head.prev.next = this.head.next;
            this.head.next.prev = this.head.prev;
            this.head = this.head.next;
        }
    }

    // delete last item
    public void deleteLast() throws Exception {
        if (this.head == null)
            throw new Exception("No item to delete");
        // when there is only one node in the list
        else if (this.head.next == this.head)
            this.head = null;
        else {
            this.head.prev = this.head.prev.prev;
            this.head.prev.next = this.head;
        }

    }

    // delete item at index
    public void deleteAt(int index) throws Exception {
        if (index < 0 || this.head == null)
            throw new Exception("Invalid index: " + index);
        else if (index == 0)
            this.deleteFirst();
        else if (index == 1 && this.head.next == this.head)
            throw new Exception("Invalid index: " + index);
        else {
            Node current = this.head;
            int currIndex = 0;

            while (currIndex < index - 1) {
                if (current.next == this.head.prev)
                    throw new Exception("Invalid index: " + index);
                currIndex++;
                current = current.next;
            }
            current.next = current.next.next;
            current.next.prev = current;
        }
    }

    // view all list items
    public void showAll() {

        System.out.println();
        if (this.head == null)
            System.out.println("List empty!");
        else {
            Node current = this.head;
            int index = 0;

            while (current != this.head.prev) {
                System.out.println(index + ": " + current.val);
                current = current.next;
                index++;
            }
            System.out.println(index + ": " + current.val);
        }
        System.out.println("\n-----------------------------\n");
    }

    // find length of list
    public int length() {
        int length = 0;

        if (this.head != null) {
            Node current = this.head;
            while (current != this.head.prev) {
                length++;
                current = current.next;
            }
            length++;
        }
        return length;
    }

    // find index of a given item
    public int search(int val) {
        Node current = this.head;
        int index = -1;

        while (current != this.head.prev) {
            index++;
            if (current.val == val)
                return index;
            current = current.next;
        }
        if (current.val == val)
            return ++index;

        return -1;
    }
}

public class Main {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) throws Exception {

        CircularDoublyLinkedList cdll = new CircularDoublyLinkedList();

        while (true) {
            try {
                Scanner sc = new Scanner(System.in);

                System.out.println("Press enter to continue");
                sc.nextLine();
                clearScreen();
                System.out.println("1. Press 1 to insert at start");
                System.out.println("2. Press 2 to insert at end ");
                System.out.println("3. Press 3 to insert at index");
                System.out.println("4. Press 4 to delete first item");
                System.out.println("5. Press 5 to delete last item");
                System.out.println("6. Press 6 to delete item at index");
                System.out.println("7. Press 7 to search index of item");
                System.out.println("8. Press 8 to show list length");
                System.out.println("9. Press 9 to show full list");
                System.out.println("10. Press 10 to exit");

                int choice = sc.nextInt();
                int val, index;

                switch (choice) {
                    case 1:
                        System.out.println("Enter a number to insert at start: ");
                        val = sc.nextInt();
                        cdll.insertAtStart(val);
                        break;
                    case 2:
                        System.out.println("Enter a number to insert at end: ");
                        val = sc.nextInt();
                        cdll.insertAtEnd(val);
                        break;
                    case 3:
                        System.out.println("Enter a number to insert: ");
                        val = sc.nextInt();
                        System.out.println("Enter a index to insert " + val + " at: ");
                        index = sc.nextInt();
                        cdll.insertAt(val, index);
                        break;
                    case 4:
                        cdll.deleteFirst();
                        break;
                    case 5:
                        cdll.deleteLast();
                        break;
                    case 6:
                        System.out.println("Enter a index from which you want to delete item: ");
                        index = sc.nextInt();
                        cdll.deleteAt(index);
                        break;
                    case 7:
                        System.out.println("Enter a number to find index of: ");
                        val = sc.nextInt();
                        System.out.println("Index of " + val + " in the list is: " + cdll.search(val));
                        break;
                    case 8:
                        System.out.println("Length: " + cdll.length());
                        break;
                    case 9:
                        cdll.showAll();
                        break;
                    case 10:
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