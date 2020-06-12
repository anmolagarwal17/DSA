class LinkedList {
    Node head = null;

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

    private class Node {
        int val;
        Node next = null;

        Node(int val) {
            this.val = val;
        }
    }
}

class Main {
    public static void main(String[] args) throws Exception {
        
        LinkedList ll = new LinkedList();
        LinkedList LL = new LinkedList(5, 10, 15, 20);
        
        System.out.println("There are " + ll.length() + " elements in ('ll') linked list.");
        System.out.println("There are " + LL.length() + " elements in ('LL') linked list.");
        ll.showAll();
        LL.showAll();

        for (int i = 0; i < 10; i++) {
            ll.insertAtEnd(i);
        }
        for (int i = 0; i < 10; i++) {
            ll.insertAtStart(i);
        }

        ll.insertAt(10, 0);
        ll.insertAt(20, 1);
        ll.insertAt(30, 2);
        ll.insertAt(40, 3);
        ll.insertAt(50, 0);
        ll.insertAt(100, 1);

        // // below lines will throw exception because of invalid index
        // ll.insertAt(300, 10);
        // ll.insertAt(200, -10);

        ll.showAll();
        LL.showAll();
        System.out.println();

        ll.deleteAt(9);
        ll.deleteAt(5);
        ll.deleteAt(0);

        ll.showAll();
        System.out.println();

        ll.deleteFirst();
        ll.deleteLast();

        ll.showAll();

        System.out.println("There are " + ll.length() + " elements in ('ll') linked list.");
        System.out.println("There are " + LL.length() + " elements in ('LL') linked list.");

    }
}