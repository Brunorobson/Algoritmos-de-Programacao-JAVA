import java.util.*;

class Graph {
    private int V;
    private LinkedList<Integer>[] adj;

    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void DFS(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;

        for (Integer n : adj[v]) {
            if (!visited[n])
                DFS(n, visited, stack);
        }

        stack.push(v);
    }

    void transpose() {
        LinkedList<Integer>[] transposedAdj = new LinkedList[V];
        for (int i = 0; i < V; i++)
            transposedAdj[i] = new LinkedList<>();

        for (int v = 0; v < V; v++) {
            for (Integer n : adj[v])
                transposedAdj[n].add(v);
        }

        adj = transposedAdj;
    }

    void printStronglyConnectedComponents() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i])
                DFS(i, visited, stack);
        }

        transpose();

        Arrays.fill(visited, false);

        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (!visited[v]) {
                Stack<Integer> sccStack = new Stack<>();
                DFS(v, visited, sccStack);
                System.out.print("Component: ");
                while (!sccStack.isEmpty()) {
                    System.out.print(sccStack.pop() + " ");
                }
                System.out.println();
            }
        }
    }
}

public class algoritmo_de_kosaraju {
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        System.out.println("Strongly Connected Components:");
        g.printStronglyConnectedComponents();
    }
}
