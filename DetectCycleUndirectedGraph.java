//Java program to detect cycle in an undirected graph

import java.util.ArrayList;
import java.util.Arrays;

class Test{

    //A recursive function that uses visited[] and parent to detect cycle in subgraph reachable from vertex v.
    static boolean isCyclicUtil(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int parent){
        
        //Mark the current node as visited
        visited[v] = true;

        //Recur for all the vertices adjacent to this vertex
        for(int i : adj.get(v)){
            //If an adjacent vertex is not visited, then recur for that adjacent
            if(visited[i] == false){

                if(isCyclicUtil(v, adj, visited, parent)) return true;
            }
            // // If an adjacent vertex is visited and
            // is not parent of current vertex,
            // then there exists a cycle in the graph
            else if(i != parent) return true;
        }
        return false;
    }

    //Return true if the graph contains a cycle, else false
    static boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int V){
       
       //Mark all the vertices as not visited
        boolean[] visited = new boolean[V];
        
        //Call the recursive helper function to detect cycle in different DFS trees
        for(int u = 0; u < V; u++){
            //Don;t recur for u if it is already visited
            if(visited[u] == false){
                if(isCyclicUtil(u,adj,visited,-1)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 3;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);

        adj.add(new ArrayList<>(Arrays.asList(1,2)));
        adj.add(new ArrayList<>(Arrays.asList(0,2)));
        adj.add(new ArrayList<>(Arrays.asList(0,1)));

        if(isCyclic(adj,V)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}