import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {

    private int V;
    private LinkedList<Integer> adj[];
    private ArrayList<Integer> level;
    private Queue<Integer> q;
    BFS(int v){
        V=v;
        level=new ArrayList<>(V);
        q=new LinkedList<>();
        adj=new LinkedList[V];
        for(int i=0;i<v;i++){
            adj[i]=new LinkedList<>();
            level.add(-1);
        }
    }


    // BFS(int v) {
    //     V = v;
    //     adj = new LinkedList[V];
    //     for (int i = 0; i < v; i++) {
    //         adj[i] = new LinkedList<>();
    //     }
    //     queue = new LinkedList<>();
    //     levels = new ArrayList<>(V);
    //     for (int i = 0; i < V; i++) {
    //         levels.add(-1); 
    //     }
    // }
    void codeBfs(int start){
        boolean[] vis =new boolean[V];
        q.add(start);
        level.set(start,0);
        while (!q.isEmpty()) {
            int x=q.poll();
            vis[x]=true;
            System.out.println(x+" ");
            for(int i:adj[x]){
                if(!vis[i]){
                    vis[i]=true;
                    q.add(i);
                    level.set(i, level.get(x+1));
                }
            }
            
        }
    }
    public static void main(String[] args) {
        System.out.println("Enter the total vertex:");
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        System.out.println("Enter Total Edges: ");
        BFS graph=new BFS(v);

        int e=sc.nextInt();
        for(int i=0;i<e;i++){
            System.out.println("Enter two connected edges: ");
            int x=sc.nextInt();
            int y=sc.nextInt();
            graph.adj[x].add(y);

        }
        graph.codeBfs(0);
    }
    
}
