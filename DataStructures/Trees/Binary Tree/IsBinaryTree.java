class IsBinaryTree{
    
    class Node{
        int val;
        Node left;
        Node right;
    }

    private boolean isBSTUtil(Node root, int minVal, int maxVal){
        if(root == null) return true;

        return (
                root.val>minVal                                 // root value is greater than min val
                && root.val<maxVal                              // root value is smaller than max val
                && isBSTUtil(root.left, minVal, root.val)       // left tree is a BST and all values in left BT is smaller than current root(so max val = root.val)
                && isBSTUtil(root.right, root.val, maxVal)      // right tree is a BST and all values in right BT is greater than current root(so min val = root.val)
        );
    }

    public boolean isBST(Node root){
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}