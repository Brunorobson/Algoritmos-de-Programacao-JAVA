class TreeNode {
    int key;
    TreeNode left;
    TreeNode right;

    public TreeNode(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }
}
public class arvore_binaria_de_busca {
    public static TreeNode insert(TreeNode root, int key) {
        if (root == null) {
            return new TreeNode(key);
        }

        if (key < root.key) {
            root.left = insert(root.left, key);
        } else if (key > root.key) {
            root.right = insert(root.right, key);
        }

        return root;
    }
    public static TreeNode search(TreeNode root, int key) {
        if (root == null || root.key == key) {
            return root;
        }

        if (key < root.key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }
    public static void inOrderTraversal(TreeNode root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.key + " ");
            inOrderTraversal(root.right);
        }
    }
    public static void main(String[] args) {
        TreeNode root = null;
        root = insert(root, 50);
        root = insert(root, 30);
        root = insert(root, 70);
        root = insert(root, 20);
        root = insert(root, 40);

        System.out.println("In-order traversal:");
        inOrderTraversal(root);

        int searchKey = 40;
        TreeNode result = search(root, searchKey);
        if (result != null) {
            System.out.println("\nFound " + searchKey + " in the tree.");
        } else {
            System.out.println("\n" + searchKey + " not found in the tree.");
        }
    }
}
