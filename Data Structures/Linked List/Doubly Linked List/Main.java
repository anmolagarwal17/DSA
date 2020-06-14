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
        for (int i = val.length - 1; i >= 0; i--) {
            this.insertAtStart(val[i]);
        }
    }

    // insert item as first node
    public void insertAtStart(int val) {
        Node newNode = new Node(val);
        newNode.prev = null;
        newNode.next = head;

        if (head != null) {
            head.prev = newNode;
        }

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
            while (current.next != null) {
                current = current.next;
            }
            newNode.prev = current;
            current.next = newNode;
        }
    }

    // insert item at given index
    public void insertAt(int val, int index) throws Exception {
        if (index < 0)
            throw new Exception("Invalid index: " + index);
        else {
            int currIndex = 0;
            Node current = head;
            Node newNode = new Node(val);

            if (head == null && index > 0)
                throw new Exception("Invalid index: " + index);
            else if (index == 0) {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            } else {
                while (currIndex < index - 1) {
                    current = current.next;
                    currIndex++;
                }

                // setting all variables of newNode
                newNode.next = current.next;
                newNode.prev = current;

                // setting value of newNode's previous and next node's next and previous
                // variable's value respectively
                current.next = newNode;
                newNode.next.prev = newNode;
            }
        }

    }

    // delete first list item
    public void deleteAt(int index) throws Exception {
        Node current = head;
        int currIndex = 0;

        if (index < 0 || head == null)
            throw new Exception("Invalid index: " + index + " to delete item!");
        else if(index == 0)
        {
            
        }
    }
    // delete last list item

    // delete list item at given index

    // search list item and return index

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

        // ! delete this variable toooooo
        // ! delete this variable toooooo
        // ! delete this variable toooooo
        Node prev = null;

        if (current == null) {
            System.out.println("List is empty!");
            return;
        }
        // while there is a node in current variable
        while (current != null) {
            System.out.println(index + ": " + current.val);
            prev = current;
            index++;
            current = current.next;
        }
        System.out.println();

        // ! delete this section afterwards
        // ! delete this section afterwards
        // ! delete this section afterwards
        current = prev;
        while (current != null) {
            index--;
            System.out.println(index + ": " + current.val);
            current = current.prev;
        }
        System.out.println("---------------------\n");
    }

}

class Main {
    public static void main(String[] args) throws Exception {

        DoublyLinkedList dll = new DoublyLinkedList(5, 10, 15, 20);

        dll.showAll();

        dll.insertAtStart(0);
        dll.insertAtEnd(25);
        dll.insertAtEnd(35);
        dll.showAll();
        dll.insertAt(30, 6);
        dll.showAll();
        dll.insertAt(-5, 0);
        // dll.insertAt(, );

        dll.showAll();
    }
}