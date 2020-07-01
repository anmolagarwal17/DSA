import java.util.Scanner;

class BST {
    Node root;

    private class Node {
        Node left = null;
        int val;
        Node right = null;

        Node(int val) {
            this.val = val;
        }
    }

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
    public void delete(int val) {
        Node parent = null;
        Node current = root;

        while (true) {
            if (current.val == val) {
                if (current.left == null && current.right == null) {
                    if (parent.right == current)
                        parent.right = null;
                    else
                        parent.left = null;
                }
                else if (current.left == null) {
                    if (parent.right == current)
                        parent.right = current.left;
                    else
                        parent.left = current.left;
                } else if (current.right == null) {
                    if (parent.right == current)
                        parent.right = current.right;
                    else
                        parent.left = current.right;
                } else {
                }
            } 
        }

    }

    // pre order tree traversal
    // root->left->right
    public void preOrder(Node root) {
        if (root != null) {
            System.out.println(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    // in order tree traversal
    // left->root->right
    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.val);
            inOrder(root.right);
        }
    }

    // post order tree traversal
    // left->right->root
    public void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.val);
        }
    }
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
                System.out.println("5. Press 5 to exit");

                int choice = sc.nextInt();
                int val;

                switch (choice) {
                    case 1:
                        System.out.println("Enter a number to insert in BST: ");
                        val = sc.nextInt();
                        bst.insert(val);
                        break;
                    case 2:
                        bst.preOrder(bst.root);
                        break;
                    case 3:
                        bst.inOrder(bst.root);
                        break;
                    case 4:
                        bst.postOrder(bst.root);
                        break;
                    case 5:
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