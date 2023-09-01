class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class filas_vinculadas {

    public static void main(String[] args) {
        Node head = new Node(10); // Criação do nó cabeça
        Node second = new Node(20); // Criação do segundo nó
        Node third = new Node(30); // Criação do terceiro nó
        
        // Ligando os nós
        head.next = second;
        second.next = third;
        
        // Percorrendo e imprimindo os elementos da lista
        Node current = head;
        while (current != null) {
            System.out.println("Node data: " + current.data);
            current = current.next;
        }
    }
}
