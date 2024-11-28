public class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private TreeNode insertRecursive(TreeNode current, int value) {
        if (current == null) {
            return new TreeNode(value);
        }
        if (value < current.value) {
            current.left = insertRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = insertRecursive(current.right, value);
        }
        return current;
    }

    public boolean search(int value) {
        return searchRecursive(root, value);
    }

    private boolean searchRecursive(TreeNode current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        return value < current.value
                ? searchRecursive(current.left, value)
                : searchRecursive(current.right, value);
    }

    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    private TreeNode deleteRecursive(TreeNode current, int value) {
        if (current == null) {
            return null;
        }
        if (value == current.value) {
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.right == null) {
                return current.left;
            }
            if (current.left == null) {
                return current.right;
            }
            int smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
        }
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
        } else {
            current.right = deleteRecursive(current.right, value);
        }
        return current;
    }

    private int findSmallestValue(TreeNode root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    public void inorderTraversal() {
        inorderTraversalRecursive(root);
        System.out.println();
    }

    private void inorderTraversalRecursive(TreeNode node) {
        if (node != null) {
            inorderTraversalRecursive(node.left);
            System.out.print(node.value + " ");
            inorderTraversalRecursive(node.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        // Insert nodes into the BST
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        // Perform in-order traversal
        System.out.println("In-order traversal of the BST:");
        bst.inorderTraversal();

        // Search for a node
        boolean found = bst.search(30);
        System.out.println("Is 30 in the BST? " + found);

        // Delete a node
        bst.delete(30);
        System.out.println("In-order traversal after deleting 30:");
        bst.inorderTraversal();
    }
}
