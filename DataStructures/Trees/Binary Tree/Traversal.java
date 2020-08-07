import java.util.LinkedList;
import java.util.Queue;

public class Traversal {

    class Node {
        Node left;
        int val;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    // BFS(Breath First Search):
    public void BFS(Node root){
        Queue<Node> queue = new LinkedList<>();

        Node current;
        queue.add(root);
        while(!queue.isEmpty()){
            current = queue.remove();
            System.out.println(current.val);
            queue.add(current.left);
            queue.add(current.right);
        }
    }


    // three varients of DFS(Depth First Search) are:

    // pre order
    // goto/print:
    // root node then,
    // left node/tree then,
    // right node/tree
    public void preOrder(Node root) {
        if (root != null) {
            System.out.println(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    // in order
    // goto/print:
    // left node/tree then,
    // root node then,
    // right node/tree
    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.val);
            inOrder(root.right);
        }
    }

    // post order
    // goto/print:
    // left node/tree then,
    // right node/tree then,
    // root node
    public void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.val);
        }
    }
}