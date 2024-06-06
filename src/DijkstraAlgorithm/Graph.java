package DijkstraAlgorithm;

import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

class Edge {
    int src, dest, weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

class Graph {
    int V;
    List<List<Edge>> adj;

    Graph(int V) {
        this.V = V;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    void addEdge(int src, int dest, int weight) {
        Edge edge1 = new Edge(src, dest, weight);
        Edge edge2 = new Edge(dest, src, weight);
        adj.get(src).add(edge1);
        adj.get(dest).add(edge2);
    }

    void dijkstra(int src) {
        //main cost from one source 
        int[] dist = new int[V];
        // is already done through pq?
        boolean[] inShortestPathTree = new boolean[V];
        PriorityQueue<Integer> pq = new PriorityQueue<>(V, Comparator.comparingInt(o -> dist[o]));

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[src] = 0;
        pq.add(src);

        while (!pq.isEmpty()) {
            int u = pq.poll();
            inShortestPathTree[u] = true;

            for (Edge edge : adj.get(u)) {
                //dest means cost
                int v = edge.dest;
                //already min(pq) visited? need to confirmed u are calculate or not && parent cost+ (u->v cost)< previous v's cost then update
                if (!inShortestPathTree[v] && dist[u] != Integer.MAX_VALUE && dist[u] + edge.weight < dist[v]) {
                    dist[v] = dist[u] + edge.weight;
                    // added  v into pq 
                    pq.add(v);
                }
            }
        }

        printShortestPath(dist);
    }

    void printShortestPath(int[] dist) {
        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 3, 6);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 8);
        graph.addEdge(1, 4, 5);
        graph.addEdge(2, 4, 7);
        graph.addEdge(3, 4, 9);

        graph.dijkstra(0);
    }
}
