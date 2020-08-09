import java.util.Scanner;

class Node {
    Node left = null;
    int val;
    Node right = null;

    Node(int val) {
        this.val = val;
    }
}

class BST {
    Node root;

    BST() {
    }

    BST(int val) {
        root.val = val;
    }

    // insert node
    public void insert(int val) throws Exception {
        Node newNode = new Node(val);

        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            while (true) {
                if (current.val == val)
                    throw new Exception("Cannot insert duplicate value");
                    // when root is bigger than val then
                    // insert somewhere in left subtree
                else if (current.val > val) {
                    if (current.left == null) {
                        current.left = newNode;
                        return;
                    } else
                        current = current.left;
                }
                // when root is smaller than val then
                // insert somewhere in right subtree
                else {
                    if (current.right == null) {
                        current.right = newNode;
                        return;
                    } else
                        current = current.right;

                }
            }
        }
    }

    // delete node
    public void delete(int val) throws Exception {
        this.root = delete(this.root, val);
    }

    private Node delete(Node root, int val) throws Exception {
        if(root == null) return root;
        else if(val > root.val){
            root.right = delete(root.right, val);
        }
        else if(val < root.val){
            root.left = delete(root.left, val);
        }
        else if(val == root.val){
           if(root.left == null)
               return root.right;
           else if(root.right == null)
               return  root.left;
           else {
               root.val = minVal(root.right);

               root.right = delete(root.right, root.val);
           }
        }
        else {
            throw new Exception("Value to be deleted does not exist in tree!");
        }
        return root;
    }

    private int minVal(Node root){
//        int min = root.val;
        while (root.left != null)
            root = root.left;
        return root.val;
    }

    // tree traversal code in Traversal.java file
}

class BinarySearchTree {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {

        BST bst = new BST();
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {

                System.out.println("Press enter to continue");
                sc.nextLine();
                sc.nextLine();
                clearScreen();
                System.out.println("1. Press 1 to insert item in BST");
                System.out.println("2. Press 2 to print BST in pre order format");
                System.out.println("3. Press 3 to print BST in in order format");
                System.out.println("4. Press 4 to print BST in post order format");
                System.out.println("5. Press 5 to delete a value");
                System.out.println("6. Press 6 to exit");

                int choice = sc.nextInt();
                int val;

                switch (choice) {
                    case 1:
                        System.out.println("Enter a number to insert in BST: ");
                        val = sc.nextInt();
                        bst.insert(val);
                        break;
                    case 2:
                        Traversal.preOrder(bst.root);
                        break;
                    case 3:
                        Traversal.inOrder(bst.root);
                        break;
                    case 4:
                        Traversal.postOrder(bst.root);
                        break;
                    case 5:
                        System.out.println("Enter a value to delete");
                        val = sc.nextInt();
                        bst.delete(val);
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