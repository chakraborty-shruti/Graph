//DFS Traversal Of Graph

import java.util.ArrayList;
import java.util.Arrays;

class Test{

    static void DFSRec(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int s){
        vis[s] = true;
        System.out.println(s+" ");
        for(int u : adj.get(s)){
            if(vis[u] == false){
                DFSRec(adj, vis, u);
            }
        }
    }

    static void DFS(ArrayList<ArrayList<Integer>> adj, int v, int s){
        boolean vis[] = new boolean[v+1];
        DFSRec(adj,vis,s);
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        adj.add(new ArrayList<>(Arrays.asList(1,4)));
        adj.add(new ArrayList<>(Arrays.asList(0,2)));
        adj.add(new ArrayList<>(Arrays.asList(1,3)));
        adj.add(new ArrayList<>(Arrays.asList(2)));
        adj.add(new ArrayList<>(Arrays.asList(0,5,6)));
        adj.add(new ArrayList<>(Arrays.asList(4,6)));
        adj.add(new ArrayList<>(Arrays.asList(4,5)));

        int v = 6;
        int s = 0;

        DFS(adj, v, s);
    }
}