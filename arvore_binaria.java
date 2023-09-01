class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class arvore_binaria {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);  // Nó raiz
        root.left = new TreeNode(5);       // Filho esquerdo
        root.right = new TreeNode(20);     // Filho direito
        
        // Imprimir a estrutura da árvore
        System.out.println("     " + root.value);
        System.out.println("   /   \\");
        System.out.println(" " + root.left.value + "     " + root.right.value);
    }
}
