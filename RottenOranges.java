//Java Program to find the minimum time in which all oranges will get rotten

//Given a matrix of dimension m * n, where each cell in the matrix can have values 0, 1 or 2 which has the following meaning:  

/* 0: Empty cell
1: Cells have fresh oranges
2: Cells have rotten oranges */

//The task is to find the minimum time required so that all the oranges become rotten. A rotten orange at index (i,j ) can rot other fresh oranges which are its neighbors (up, down, left, and right).

//Note : If it is impossible to rot every orange then simply return -1.

import java.util.LinkedList;
import java.util.Queue;

class Test{

    static int orangesRotting(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int i, j , ans = 0;
        int[][] ti = new int[n][m];
        boolean[][] vis = new boolean[n][m];

        //Queue to store cell positions
        Queue<int[]> q = new LinkedList<>();

        //finding all rotten oranges
        for(i =0 ; i<n ; i++){
            for(j = 0; j < m; j++){
                vis[i][j] = false;
                //if the orange is a rotten orange
                if(grid[i][j] == 2){
                    ti[i][j] = 0; //0th unit of time take to rot the orange as it is already rotten
                    vis[i][j] = true; //mark the cell as visited; 
                    q.add(new int[] {i , j}); // add the rotten orange to the queue
                }
            }
        }

        while(q.isEmpty() == false){
           
            int[] curr = q.poll(); //dequeue the current rotten orange
            i = curr[0];
            j = curr[1];

            if(grid[i][j] == 1){
                ans = Math.max(ans, ti[i][j]);// storing the maximum unit of time
            }

            //Checking all the four direction
            if(i-1>=0 && vis[i-1][j]==false && grid[i-1][j]==1){
                vis[i -1][j] = true; // Mark as visited
                ti[i -1][j] = 1+ ti[i][j];//Increase the time taken
                q.add(new int[] {i -1,j});//add the newly rotten orange to queue
            }

            if(i+1<n && vis[i+1][j]== false && grid[i+1][j]==1){
                vis[i+1][j] = true;
                ti[i+1][j] = 1+ ti[i][j];
                q.add(new int[] {i +1,j});
            }

            if(j-1>=0 && vis[i][j -1]== false && grid[i][j-1] ==1){
                vis[i][j-1] = true;
                ti[i][j -1] = 1 + ti[i][j];
                q.add(new int[] {i, j -1});
            }

            if(j+1<m && vis[i][j+1]== false && grid[i][j+1] == 1){
                vis[i][j+1] = true;
                ti[i][j+1] = 1+ ti[i][j];
                q.add(new int[] {i, j+1});
            }
        }

        //Checking if any fresh orange is remaining
        for(i =0; i<n;i++){
            for(j =0; j<m;j++){
                if(vis[i][j] == false && grid[i][j] == 1){
                    ans = -1;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[][] mat = {{0 , 1 , 2},
                        {0 ,1, 2},
                        {2, 1, 1}};

        System.out.println(orangesRotting(mat));
    }
}

/*Input:  arr[][] = [ [2, 1, 0, 2, 1], [1, 0, 1, 2, 1], [1, 0, 0, 2, 1] ];
Output: 2
Explanation: At 0th time frame:
[2, 1, 0, 2, 1]
[1, 0, 1, 2, 1]
[1, 0, 0, 2, 1]
At 1st time frame:
[2, 2, 0, 2, 2]
[2, 0, 2, 2, 2]
[1, 0, 0, 2, 2]
At 2nd time frame:
[2, 2, 0, 2, 2]
[2, 0, 2, 2, 2]
[2, 0, 0, 2, 2] */