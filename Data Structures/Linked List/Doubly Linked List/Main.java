import java.util.Scanner;

class DoublyLinkedList {

    Node head = null;

    private class Node {
        int val;
        Node prev = null;
        Node next = null;

        Node(int val) {
            this.val = val;
        }
    }

    DoublyLinkedList() {
    }

    DoublyLinkedList(int... val) {
        for (int i = val.length - 1; i >= 0; i--)
            this.insertAtStart(val[i]);
    }

    // insert item as first node
    public void insertAtStart(int val) {
        Node newNode = new Node(val);
        newNode.prev = null;
        newNode.next = head;

        if (head != null)
            head.prev = newNode;

        head = newNode;
    }

    // insert item as last node
    public void insertAtEnd(int val) {
        Node newNode = new Node(val);
        newNode.next = null;

        Node current = head;

        if (head == null) {
            newNode.prev = null;
            head = newNode;
        } else {
            while (current.next != null)
                current = current.next;
            newNode.prev = current;
            current.next = newNode;
        }
    }

    // insert item at given index
    public void insertAt(int val, int index) throws Exception {
        if (index < 0 || (head == null && index > 0))
            throw new Exception("Invalid index: " + index);
        else {
            int currIndex = 0;
            Node current = head;
            Node newNode = new Node(val);

            if (index == 0) {
                newNode.next = head;
                newNode.prev = null;
                if (head != null)
                    head.prev = newNode;
                head = newNode;
            } else {
                while (currIndex < index - 1) {
                    if (current == null)
                        throw new Exception("Invalid index: " + index);
                    current = current.next;
                    currIndex++;
                }

                // setting all variables of newNode
                newNode.next = current.next;
                newNode.prev = current;

                // setting value of newNode's previous and next node's next and previous
                // variable's value respectively
                if (current.next != null)
                    // when inserting as last node, there will be no current.next node hence
                    // current.next.prev will give nullpointerexception
                    current.next.prev = newNode;
                current.next = newNode;
            }
        }

    }

    // delete list item at given index
    public void deleteAt(int index) throws Exception {
        Node current = head;
        int currIndex = 0;

        if (index < 0 || head == null)
            throw new Exception("Invalid index: " + index + " to delete item!");
        else if (index == 0) {
            head = head.next;
            if (head != null)
                head.prev = null;
        } else {
            while (currIndex < index - 1) {
                // if either current is null or element we want to delete is null
                if (current == null || current.next == null)
                    throw new Exception("Invalid index: " + index + " to delete item!");
                current = current.next;
                currIndex++;
            }
            
            current.next = current.next.next;
            // if we are deleting last node then we donot have to set prev property of next node as there will be no next node else set its prev to current
            if(current.next != null)
                current.next.prev = current;

        }
    }

    // search list item and return index
    public int search(int val) {
        Node current = head;
        int index = 0;

        if (head == null)
            return -1;
        else {
            while (current.val != val) {
                if (current.next == null)
                    return -1;
                current = current.next;
                index++;
            }
            return index;
        }
    }

    // return length of list
    public int length() {
        int length = 0;
        Node current = head;

        while (current != null) {
            current = current.next;
            length++;
        }

        return length;
    }

    // view all list items
    public void showAll() {
        Node current = head;
        int index = 0;

        System.out.println();
        if (current == null) {
            System.out.println("List is empty!");
            return;
        }
        // while there is a node in current variable
        while (current != null) {
            System.out.println(index + ": " + current.val);
            index++;
            current = current.next;
        }
        System.out.println("\n---------------------\n");
    }

}

class Main {
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void main(String[] args) throws Exception {

        DoublyLinkedList dll = new DoublyLinkedList();

        while (true) {
            Scanner sc = new Scanner(System.in);

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
                    dll.insertAtStart(val);
                    break;
                case 2:
                    System.out.println("Enter a number to insert at end: ");
                    val = sc.nextInt();
                    dll.insertAtEnd(val);
                    break;
                case 3:
                    System.out.println("Enter a number to insert: ");
                    val = sc.nextInt();
                    System.out.println("Enter a index to insert " + val + " at: ");
                    index = sc.nextInt();
                    dll.insertAt(val, index);
                    break;
                case 4:
                    dll.deleteAt(0);
                    break;
                case 5:
                    dll.deleteAt(dll.length() - 1);
                    break;
                case 6:
                    System.out.println("Enter a index from which you want to delete item: ");
                    index = sc.nextInt();
                    dll.deleteAt(index);
                    break;
                case 7:
                    System.out.println("Enter a number to find index of: ");
                    val = sc.nextInt();
                    System.out.println("Index of " + val + " in the list is: " + dll.search(val));
                    break;
                case 8:
                    System.out.println("Length: " + dll.length());
                    break;
                case 9:
                    dll.showAll();
                    break;
                case 10:
                    System.out.println("Press enter to exit!");
                    sc.nextLine();
                    sc.nextLine();
                    System.exit(0);
                default:
                    System.out.println("\nInvalid choice!\nTry again.\n");
            }

            System.out.println("Press enter to continue");
            sc.nextLine();
            sc.nextLine();

        }
    }
}