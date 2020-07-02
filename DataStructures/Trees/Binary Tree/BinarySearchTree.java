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
    public void delete(int val) throws Exception {
        if (root == null)
            throw new Exception("BST empty!\nNo item to delete.");

        Node parent = null;
        Node current = root;

        if (current.val == val) {
            // when the root node of tree is to be deleted
            // i.e, a node that does not have a parent node

            if (current.left == null && current.right == null) {
                // when node do not have any child node
                root = null;
            } else if (current.left == null) {
                // when node have only right child node
                root = current.right;
            } else if (current.right == null) {
                // when node have only left child node
                root = current.left;
            } else {
                // when node have 2 child nodes
                Node temp = current;
                while (true) {
                    if (temp.right != null)
                        temp = temp.right;
                    else
                        break;
                }
                this.delete(temp.val);
                root.val = temp.val;
            }
        } else {
            while (current != null) {
                if (current.val == val) {
                    // when the node we want to delete is found022
                    if (current.left == null && current.right == null) {
                        // when node do not have any child node
                        if (parent.right == current)
                            parent.right = null;
                        else
                            parent.left = null;
                    } else if (current.left == null) {
                        // when node have only right child node
                        if (parent.right == current)
                            parent.right = current.left;
                        else
                            parent.left = current.left;
                    } else if (current.right == null) {
                        // when node have only left child node
                        if (parent.right == current)
                            parent.right = current.right;
                        else
                            parent.left = current.right;
                    } else {
                        // when node have 2 child nodes
                        Node temp = current;
                        while (true) {
                            if (temp.right != null)
                                temp = temp.right;
                            else
                                break;
                        }
                        if (parent.right == current) {
                            this.delete(temp.val);
                            parent.right.val = temp.val;
                        } else {
                            this.delete(temp.val);
                            parent.left.val = temp.val;
                        }
                    }
                    break;
                } else if (current.val > val) {
                    parent = current;
                    current = current.left;
                } else {
                    parent = current;
                    current = current.right;
                }
            }
        }
        if (current != null)
            System.out.println("Node deleted!");
        else
            System.out.println("Node with " + val + " do not exist!");

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
                        bst.preOrder(bst.root);
                        break;
                    case 3:
                        bst.inOrder(bst.root);
                        break;
                    case 4:
                        bst.postOrder(bst.root);
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