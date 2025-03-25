//Detecting cycle in a directed graph
//Given a root of a directed graph , the task is to check whether the graph contains a cycle or not

import java.util.ArrayList;
import java.util.Arrays;

class Test{

    //Utility function to detect cycle in a directed graph
    static boolean isCyclicUtil(ArrayList<ArrayList<Integer>> adj, int src, boolean[] visited, boolean[] recStack){

        //If already present in the recursion call stack, then there is a cycle
        recStack[src] = true;
        visited[src] = true;

        for(int next : adj.get(src)){
            if(visited[next] == false && isCyclicUtil(adj, src, visited, recStack)){
                return true;
            }else if(recStack[next]){
                return true;
            }
        }
        recStack[src] = false;
        return false;
    }

    static boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int V){

        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        //Check each unvisited node to detect cycles
        for(int i =0; i < V; i++){
            if(!visited[i] && isCyclicUtil(adj,i,visited,recStack)){
                return true;
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        adj.add(new ArrayList<>(Arrays.asList(1,2)));
        adj.add(new ArrayList<>(Arrays.asList(2)));
        adj.add(new ArrayList<>(Arrays.asList(0,3)));
        adj.add(new ArrayList<>(Arrays.asList(3)));
        
        int V = 4;

        //Function call to check for cycle
        if(isCyclic(adj,V)){
            System.out.println("Contains cycle");
        }else{
            System.out.println("No cycle");
        }
    }
}