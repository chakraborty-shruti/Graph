//Graph Adjacency List Representation in java

import java.util.ArrayList;

class Test{
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static void printGraph(ArrayList<ArrayList<Integer>>adj){
        for(int i=0;i<adj.size(); i++){
            for(int j=0;j<adj.get(i).size(); j++){
                System.out.println(adj.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(v); //adj is an adjacency list, represented as an ArrayList of ArrayLists

        //Initializes the adjacency list: Adds an empty ArrayList for each vertex.
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<Integer>());
        }
        addEdge(adj,0,1);
        addEdge(adj,0,2); 
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        printGraph(adj);
    }
}