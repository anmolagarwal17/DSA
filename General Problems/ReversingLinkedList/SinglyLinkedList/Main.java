import java.util.Scanner;

class LinkedList {
    private Node head = null;

    LinkedList() {
    }

    LinkedList(int... val) {
        for (int i = val.length - 1; i >= 0; i--) {
            this.insertAtStart(val[i]);
        }
    }

    // insert at beginning
    public void insertAtStart(int val) {

        Node newNode = new Node(val);
        newNode.next = this.head;
        this.head = newNode;
    }

    // insert at end
    public void insertAtEnd(int val) {

        Node newNode = new Node(val);
        Node curr = this.head;

        if (this.head == null)
            this.head = newNode;
        else {
            // traversing to last element of LL
            while (curr.next != null) {
                curr = curr.next;
            }
            // inserting new node at end
            curr.next = newNode;
        }
    }

    // insert at index
    public void insertAt(int val, int index) throws Exception {
        Node curr = this.head;

        if (index == 0)
            insertAtStart(val);
        else {
            int currIndex = 0;
            // if we want to insert value at index then we have to access node at (index-1)
            // and then set its next value to our new node
            while (currIndex != index - 1) {
                // when curr == null then there is no further element left in LL, so cannot
                // insert element after that index
                if (curr == null)
                    throw new Exception("Invalid index: " + index + "\nCannot insert at given index!");
                currIndex++;
                curr = curr.next;
            }
            Node newNode = new Node(val);
            newNode.next = curr.next;
            curr.next = newNode;
        }
    }

    // delete first item
    public void deleteFirst() throws Exception {
        if (this.head == null)
            throw new Exception("Linked list empty.\nCannot delete first element of empty linked list!");
        else {
            this.head = this.head.next;
        }
    }

    // delete last item
    public void deleteLast() throws Exception {
        Node curr = this.head;

        if (this.head == null)
            throw new Exception("Linked list empty.\nCannot delete last element of empty linked list!");
        else {
            Node prev = curr;
            // traversing to last element
            while (curr.next != null) {
                prev = curr;
                curr = curr.next;
            }
            // to delete last element setting previous element's next node reference to null
            prev.next = null;
        }
    }

    // delete item at index
    public void deleteAt(int index) throws Exception {

        if (index < 0 || this.head == null)
            throw new Exception("Invalid index: " + index + "\nCannot delete from given index!");
        else if (index == 0) {
            this.head = this.head.next;
        } else {
            Node curr = this.head;
            int currIndex = 0;

            // traversing to (index-1) we want to delete
            while (currIndex != index - 1) {
                if (curr == null)
                    throw new Exception("Invalid index: " + index + "\nCannot delete from given index!");
                currIndex++;
                curr = curr.next;
            }

            // when there is no next element to delete the throw exception
            if (curr.next == null) {
                System.out.println(curr.val);
                throw new Exception("Invalid index: " + index + "\nCannot delete from given index!");
            } else {
                // assigning the reference of next element(at index+1)(of element we want to
                // delete) to the previous element(at index-1)(of element we want to delete)

                // also if the element we want to delete is the last element then it's next
                // node's reference, i.e, null will be assigned in place of next node's
                // reference
                curr.next = curr.next.next;
            }
        }

    }

    // view all list items
    public void showAll() {
        Node curr = this.head;

        System.out.println();
        // when LL is empty then print empty
        if (curr == null)
            System.out.println("Linked list empty!");
        else {
            // else traverse to every node one by one and print them
            while (curr != null) {
                System.out.println(curr.val);
                curr = curr.next;
            }
        }
        System.out.println();
    }

    // returns length of ll
    public int length() {
        int length = 0;
        Node curr = this.head;

        while (curr != null) {
            curr = curr.next;
            length++;
        }
        return length;
    }

    public void reverseLL() {
        // when list have only no element
        if (this.head == null)
            System.out.println("List empty!");
        // when list have only one element
        else if (this.head.next == null) {
        }
        // when list have more than one element
        else {
            Node current = this.head;
            Node prev = null;
            Node temp = null;

            while (current.next != null) {
                temp = current.next;
                current.next = prev;
                prev = current;
                current = temp;
            }

            current.next = prev;
            this.head = current;
        }
    }

    private class Node {
        int val;
        Node next = null;

        Node(int val) {
            this.val = val;
        }
    }
}

class Main {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {

        LinkedList ll = new LinkedList();

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
                System.out.println("7. Press 7 to show list length");
                System.out.println("8. Press 8 to show full list");
                System.out.println("9. Press 9 to reverse list");
                System.out.println("10. Press 10 to exit");

                int choice = sc.nextInt();
                int val, index;

                switch (choice) {
                    case 1:
                        System.out.println("Enter a number to insert at start: ");
                        val = sc.nextInt();
                        ll.insertAtStart(val);
                        break;
                    case 2:
                        System.out.println("Enter a number to insert at end: ");
                        val = sc.nextInt();
                        ll.insertAtEnd(val);
                        break;
                    case 3:
                        System.out.println("Enter a number to insert: ");
                        val = sc.nextInt();
                        System.out.println("Enter a index to insert " + val + " at: ");
                        index = sc.nextInt();
                        ll.insertAt(val, index);
                        break;
                    case 4:
                        ll.deleteFirst();
                        break;
                    case 5:
                        ll.deleteLast();
                        break;
                    case 6:
                        System.out.println("Enter a index from which you want to delete item: ");
                        index = sc.nextInt();
                        ll.deleteAt(index);
                        break;
                    case 7:
                        System.out.println("Length: " + ll.length());
                        break;
                    case 8:
                        ll.showAll();
                        break;
                    case 9:
                        ll.reverseLL();
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