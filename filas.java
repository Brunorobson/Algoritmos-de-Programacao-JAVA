import java.util.Stack;

public class filas {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        
        stack.push(1); // Empilhar
        stack.push(2);
        stack.push(3);
        
        System.out.println("Top element: " + stack.peek()); // Consultar o topo
        
        while (!stack.isEmpty()) {
            System.out.println("Popped: " + stack.pop()); // Desempilhar
        }
    }
}

