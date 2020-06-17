import java.util.Scanner;

class CircularLinkedList {
    Node last = null;

    private class Node {
        int val;
        Node next = null;

        Node(int val) {
            this.val = val;
        }
    }

    CircularLinkedList() {
    }

    // insert as first node
    public void insertAtStart(int val) {
        Node newNode = new Node(val);

        // when list is empty
        if (this.last == null) {
            this.last = newNode;
            this.last.next = newNode;
        }
        // when list have atleast one node
        else {
            newNode.next = this.last.next;
            this.last.next = newNode;
        }
    }

    // insert as last node
    public void insertAtEnd(int val) {
        Node newNode = new Node(val);

        // when list is empty
        if (this.last == null) {
            this.last = newNode;
            this.last.next = newNode;
        }
        // when list have atleast one node
        else {
            newNode.next = this.last.next;
            this.last.next = newNode;
            this.last = newNode;
        }
    }

    // insert node at index
    public void insertAt(int val, int index) throws Exception {
        if (index < 0 || (this.last == null && index > 0))
            throw new Exception("Invalid index: " + index);
        else if (index == 0)
            this.insertAtStart(val);
        else {
            Node newNode = new Node(val);
            Node current = this.last.next;
            int currIndex = 0;
            while (currIndex < index - 1 && (current != this.last)) {
                current = current.next;
                currIndex++;
            }

            newNode.next = current.next;
            current.next = newNode;
            if (current == this.last)
                this.last = newNode;
        }
    }

    // delete first item
    public void deleteFirst() throws Exception {

        if (this.last == null)
            throw new Exception("No item to delete");
        // when there is only one node in the list
        else if (this.last.next == this.last)
            this.last = null;
        else
            this.last.next = this.last.next.next;
    }

    // delete last item
    public void deleteLast() throws Exception {
        if (this.last == null)
            throw new Exception("No item to delete");
        // when there is only one node in the list
        else if (this.last.next == this.last)
            this.last = null;
        else {
            Node current = this.last.next;
            while (current.next != this.last)
                current = current.next;
            current.next = this.last.next;
            this.last = current;
        }

    }

    // delete item at index
    public void deleteAt(int index) throws Exception {
        if (index < 0 || this.last == null)
            throw new Exception("Invalid index: " + index);
        else if (index == 0)
            this.deleteFirst();
        else {
            Node current = this.last.next;
            int currIndex = 0;

            while (currIndex < index - 1) {
                if (current.next == this.last)
                    throw new Exception("Invalid index: " + index);
                currIndex++;
                current = current.next;
            }
            if(current.next == this.last)
                this.last = current;
            current.next = current.next.next;
        }
    }

    // view all list items
    public void showAll() {

        System.out.println();
        if (this.last == null)
            System.out.println("List empty!");
        else {
            Node current = this.last.next;
            int index = 0;

            while (current != this.last) {
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

        if (this.last != null) {
            Node current = this.last.next;
            while (current != this.last) {
                length++;
                current = current.next;
            }
            length++;
        }
        return length;
    }

    // find index of a given item
    public int search(int val) {
        Node current = this.last.next;
        int index = -1;

        while(current != this.last)
        {
            index++;
            if(current.val == val)
                return index;
            current = current.next;
        }
        if(current.val == val)
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

        CircularLinkedList cll = new CircularLinkedList();

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
                        cll.insertAtStart(val);
                        break;
                    case 2:
                        System.out.println("Enter a number to insert at end: ");
                        val = sc.nextInt();
                        cll.insertAtEnd(val);
                        break;
                    case 3:
                        System.out.println("Enter a number to insert: ");
                        val = sc.nextInt();
                        System.out.println("Enter a index to insert " + val + " at: ");
                        index = sc.nextInt();
                        cll.insertAt(val, index);
                        break;
                    case 4:
                        cll.deleteFirst();
                        break;
                    case 5:
                        cll.deleteLast();
                        break;
                    case 6:
                        System.out.println("Enter a index from which you want to delete item: ");
                        index = sc.nextInt();
                        cll.deleteAt(index);
                        break;
                    case 7:
                        System.out.println("Enter a number to find index of: ");
                        val = sc.nextInt();
                        System.out.println("Index of " + val + " in the list is: " +
                        cll.search(val));
                        break;
                    case 8:
                        System.out.println("Length: " + cll.length());
                        break;
                    case 9:
                        cll.showAll();
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