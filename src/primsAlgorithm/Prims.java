package primsAlgorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
 * 
 * This is gredy type algorithm. 
 * Vertex=v
 * Edge=v-1
 * minimum spaning tree
 */

class Edge {
    int src, dest, weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

public class Prims {
    int V;
    List<List<Edge>> adj;

    Prims(int V) {
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

    void primMST() {
        boolean[] inMST = new boolean[V];// isAdded into MST?

        //Edge type array to store edges information
        Edge[] edgeTo = new Edge[V];

        int[] distTo = new int[V];// destence 
        // this is for finding miminum element by heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(V, Comparator.comparingInt(o -> distTo[o]));

        for (int i = 0; i < V; i++) {
            //assign with height value
            distTo[i] = Integer.MAX_VALUE;
        }

        //manually start
        distTo[0] = 0;
        pq.add(0);

        while (!pq.isEmpty()) {
            //poll minimum value
            int u = pq.poll();
            inMST[u] = true;

            for (Edge edge : adj.get(u)) {

                int v = edge.dest;//dest means u to v
                if (!inMST[v] && edge.weight < distTo[v]) {
                    distTo[v] = edge.weight;
                    edgeTo[v] = edge;
                    pq.add(v);
                }
            }
        }

        printMST(edgeTo);
    }



    void printMST(Edge[] edgeTo) {
        int totalWeight = 0;
        for (int i = 1; i < V; i++) {
            if (edgeTo[i] != null) {
                System.out.println(edgeTo[i].src + " - " + edgeTo[i].dest + " : " + edgeTo[i].weight);
                totalWeight += edgeTo[i].weight;
            }
        }
        System.out.println("Total weight of MST: " + totalWeight);
    }

    public static void main(String[] args) {
        Prims graph = new Prims(5);
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 3, 6);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 8);
        graph.addEdge(1, 4, 5);
        graph.addEdge(2, 4, 7);
        graph.addEdge(3, 4, 9);

        graph.primMST();
    }
}
