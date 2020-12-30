import java.util.ArrayDeque;
import java.util.Deque;

public class Day7_Island_Perimeter {
    class Solution {

        int dRow[] = {0, -1, 0, 1};
        int dCol[] = {-1, 0, 1, 0};

        class Location{
            int row;
            int col;
        }

        public int islandPerimeter(int[][] grid) {
            int res = 0;

            int row = grid.length;
            int col = grid[0].length;

            Deque<Location> queue = new ArrayDeque<Location>();

            boolean visited[][] = new boolean[row][col];
            boolean found = false;

            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    if(grid[i][j] == 1){
                        Location start = new Location();
                        start.row = i;
                        start.col = j;
                        queue.push(start);
                        found = true;
                        break;
                    }
                }
                if(found) break;
            }

            while(!queue.isEmpty()){
                Location temp = queue.pop();
                if(visited[temp.row][temp.col]) continue;
                visited[temp.row][temp.col] = true;

                res += 4;

                for(int i = 0; i < 4; i++){
                    int tempRow = temp.row + dRow[i];
                    int tempCol = temp.col + dCol[i];

                    if(isRange(tempRow, tempCol, row, col) && grid[tempRow][tempCol] == 1){
                        res--;

                        if(!visited[tempRow][tempCol]){
                            Location child = new Location();
                            child.row = tempRow;
                            child.col = tempCol;
                            queue.push(child);
                        }
                    }
                }
            }
            return res;
        }

        public boolean isRange(int tempRow, int tempCol, int row, int col){
            if(tempRow >= 0 && tempCol >= 0 && tempRow < row && tempCol < col) return true;
            else return false;
        }
    }

    public static void main(String[] args) {
        Day7_Island_Perimeter.Solution sol = new Day7_Island_Perimeter().new Solution();
        // int tc[][] = {{0,1,0,0}, {1,1,1,0}, {0,1,0,0}, {1,1,0,0}};
        int tc[][] = {{1, 1}, {1, 1}};
        System.out.println(sol.islandPerimeter(tc));
    }
}
