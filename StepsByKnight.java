//Given a square chessboard of n x n size, the position of the Knight and the position of a target are given. We need to find out the minimum steps a Knight will take to reach the target position.

import java.util.LinkedList;
import java.util.Queue;

class Cell{
    int x,y,dis;

    //Default constructor
    Cell(){
        this.x = 0;
        this.y = 0;
        this.dis = 0;
    }

    //Parametrized constructor
    Cell(int x, int y, int dis){
        this.x = x;
        this.y = y;
        this.dis = dis;
    }
}

class Test{

    //Utility method to check if(x,y) is inside the board
    static boolean isInside(int x, int y, int n){
        return x >= 1 && x <= n && y >= 1 && y <= n;
    }

    static int minSteps(int[] knightPos, int[] targetPos, int n){

        //x and y directions where a knight can move
        int[] dx = {-2,-1,1,2,-2,-1,1,2};
        int[] dy = {-1,-2,-2,-1,1,2,2,1};

        //Queue for storing knight's states
        Queue<Cell> q = new LinkedList<>();

        //Push starting position of knight with 0 distance
        q.add(new Cell(knightPos[0], knightPos[1],0));

        Cell t;
        int x,y;

        //Visit array initialized to false
        boolean[][] visit = new boolean[n + 1][n + 1];

        //Visit starting position
        visit[knightPos[0]][knightPos[1]] = true;

        //Loop until queue is empty
        while(q.isEmpty() == false){
            t = q.poll();

            //If target is reached ,return the distance
            if(t.x == targetPos[0] && t.y == targetPos[1]){
                return t.dis;
            }

            ///Explore all reachable positions
            for(int i =0; i < 8; i++){
                x = t.x + dx[i];
                y = t.y + dy[i];

                //If position is valid and not visited, push it to the queue
                if(isInside(x,y,n) && visit[x][y] == false){
                    visit[x][y] = true;
                    q.add(new Cell(x,y,t.dis+1));
                }
            }
        }
        //If no path found, return -1
        return -1;
    }

    public static void main(String[] args) {
        int n = 30;
        int[] knightPos = {1 ,1};
        int[] targetPos = {30 ,30};
        System.out.println(minSteps(knightPos, targetPos, n));
    }
}