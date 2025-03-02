//BFS Traversal of a Graph

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Test{

    static void bfsOfGraph(ArrayList<ArrayList<Integer>> adj,int v, int s ){
        boolean vis[] = new boolean[v+1];
        Queue<Integer> q = new LinkedList<Integer>();
        vis[s] = true;
        q.add(s);

        while(q.isEmpty() == false){
            int u = q.poll();
            System.out.println(u+ " ");
            for(int rs : adj.get(u)){
                if(vis[rs] == false){
                    vis[rs] = true;
                    q.add(rs);
                }
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(2,3,1)));
        adj.add(new ArrayList<>(Arrays.asList(0)));
        adj.add(new ArrayList<>(Arrays.asList(0,4)));
        adj.add(new ArrayList<>(Arrays.asList(0)));
        adj.add(new ArrayList<>(Arrays.asList(2)));

        int v = 4;
        int s = 0;

        bfsOfGraph(adj,  v,  s);
    }
}