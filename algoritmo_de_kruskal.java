import java.util.*;
class Edge implements Comparable<Edge> {
    int src, dest, weight;

    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
    public int compareTo(Edge edge) {
        return this.weight - edge.weight;
    }
}
class KruskalAlgorithm {
    private int V, E; // Número de vértices e arestas
    private Edge[] edges;

    KruskalAlgorithm(int v, int e) {
        V = v;
        E = e;
        edges = new Edge[E];
        for (int i = 0; i < e; i++) {
            edges[i] = new Edge(0, 0, 0);
        }
    }
    // Encontra o conjunto de um elemento i (utiliza otimização de caminho)
    int find(int[] parent, int i) {
        if (parent[i] == i)
            return i;
        return find(parent, parent[i]);
    }
    // Realiza a união dos conjuntos de x e y
    void union(int[] parent, int[] rank, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);

        if (rank[rootX] < rank[rootY])
            parent[rootX] = rootY;
        else if (rank[rootX] > rank[rootY])
            parent[rootY] = rootX;
        else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }
    void kruskalMST() {
        Edge[] result = new Edge[V]; // Para armazenar as arestas da AGM
        int e = 0; // Índice para a próxima aresta adicionada à AGM
        int i = 0; // Índice para classificar as arestas

        for (i = 0; i < V; i++)
            result[i] = new Edge(0, 0, 0);

        Arrays.sort(edges);

        int[] parent = new int[V];
        int[] rank = new int[V];

        for (i = 0; i < V; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        i = 0;

        while (e < V - 1) {
            Edge nextEdge = edges[i++];
            int x = find(parent, nextEdge.src);
            int y = find(parent, nextEdge.dest);

            if (x != y) {
                result[e++] = nextEdge;
                union(parent, rank, x, y);
            }
        }

        System.out.println("Edges in the Minimum Spanning Tree:");
        for (i = 0; i < e; i++) {
            System.out.println(result[i].src + " - " + result[i].dest + " : " + result[i].weight);
        }
    }

    public static void main(String[] args) {
        int V = 4; // Número de vértices
        int E = 5; // Número de arestas
        KruskalAlgorithm graph = new KruskalAlgorithm(V, E);

        graph.edges[0] = new Edge(0, 1, 10);
        graph.edges[1] = new Edge(0, 2, 6);
        graph.edges[2] = new Edge(0, 3, 5);
        graph.edges[3] = new Edge(1, 3, 15);
        graph.edges[4] = new Edge(2, 3, 4);

        graph.kruskalMST();
    }
}
