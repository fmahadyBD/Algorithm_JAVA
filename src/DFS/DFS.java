package DFS;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class DFS {

    private int V;
    private LinkedList<Integer> adj[];
    private ArrayList<Integer> levels;
    private Stack<Integer> s;

    DFS(int v) {
        V = v;
        adj = new LinkedList[v];
        levels = new ArrayList<>(v);
        s = new Stack<>();
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
            levels.add(-1);
        }

    }

    void dfscode(int start) {
        s.push(start);
        boolean[] vis = new boolean[V];
        levels.set(start, 0);

        while (!s.isEmpty()) {
            int x = s.pop();
            if (!vis[x]) {
                vis[x] = true;
                System.out.println(x);
                for (int i : adj[x]) {
                    if (!vis[i]) {
                        s.push(i);
                        if (levels.get(i) == -1) {
                            levels.set(i, levels.get(x) + 1);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total vertex number: ");
        int v = sc.nextInt();
        DFS graph = new DFS(v);

        System.out.println("Enter the total edges: ");
        int e = sc.nextInt();
        for (int i = 0; i < e; i++) {
            System.out.println("Enter the x ,y :");
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph.adj[x].add(y);
            graph.adj[y].add(x);
        }
        graph.dfscode(0);
    }

}
