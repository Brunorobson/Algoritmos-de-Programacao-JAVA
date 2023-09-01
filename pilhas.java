import java.util.Stack;

public class pilhas {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Empilhar elementos na pilha
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.peek()); // Consultar o elemento do topo

        // Desempilhar elementos da pilha e imprimir
        while (!stack.isEmpty()) {
            int popped = stack.pop();
            System.out.println("Popped: " + popped);
        }
    }
}
