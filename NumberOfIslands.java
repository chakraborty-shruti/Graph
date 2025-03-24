//Java Program to  find the number of islands usinf dfs with additional matrix

class Test{

    static void dfs(int r, int c, char[][] grid, int row, int col, boolean visited[][]){
        visited[r][c] = true;
        int i, j;

        //These arrays are used to get  combination for r and c of its 8 neighbours in any given cell.
        for(i = -1; i<= 1; i++){
            for(j = -1; j <= 1; j++){
                if(i != j || i != 0){
                    if( r + i < row && r + i >= 0 && c + j <col && c+j >= 0){
                        if(visited[r + i][c + j] == false && grid[r +i][c + j] == '1'){
                            dfs(r +i, c+j, grid, row, col, visited);
                        }
                    }
                }
            }
        }
    }

    //The main function that returns count of islands
    static int numIslands(char[][] grid){
        int row = grid.length;
        int col = grid[0].length;

        //Make a bool array to mark visited cells, Initially all cells are unvisited
        boolean[][] visited = new boolean[row][col];

        //Initialize count as 0 and traverse through all cells of the given matrix
        int count = 0;
        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                //If a cell with value 1 is not visited yet, then a new island is found
                if(grid[r][c] == '1' && !visited[r][c]){
                    //Visit all cells in this island
                    dfs(r,c,grid,row,col,visited);

                    //increment the island count
                    count++;
                }
            }
        }
        return count;
    }
 
    public static void main(String[] args) {
        char[][] grid = {
            {'1', '1', '0','0','0'},
            {'0','1','0','0','1'},
            {'1','0','0','1','1'},
            {'0','0','0','0','0'},
            {'1','0','1','1','0'}
        };

        System.out.println(numIslands(grid));
    }
}

/*Time complexity: O(n*m)
Auxiliary Space: O(n*m) due to stack space. */

/*Given a binary 2D matrix of size n*m, find the number of islands. A group of connected 1s forms an island.

Example:

Input: M[][] = {{‘1’, ‘1’, ‘0’, ‘0’, ‘0’},
                {‘0’, ‘1’, ‘0’, ‘0’, ‘1’},
                {‘1’, ‘0’, ‘0’, ‘1’, ‘1’},
                {‘0’, ‘0’, ‘0’, ‘0’, ‘0’},
                {‘1’, ‘0’, ‘1’, ‘1’, ‘0’}}
Output: 4 */