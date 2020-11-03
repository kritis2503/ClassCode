import java.util.*;
public class dp_questions {

    //Leetcode 62 https://leetcode.com/problems/unique-paths/
    public class Solution {
        public int uniquePaths(int A, int B) {
            int [][]vis=new int [A][B];
            
            return uniquePath(0,0,A,B,vis);
        }
        public int uniquePath(int sr,int sc,int dr,int dc,int [][]dp)
        {
            if(sr==dr-1 && sc==dc-1)
             return 1;
            if(dp[sr][sc]!=0)
                return dp[sr][sc];
             
            int count=0;
           
            if(sr+1<dr)
                count+=uniquePath(sr+1,sc,dr,dc,dp);
            if(sc+1<dc)
                count+=uniquePath(sr,sc+1,dr,dc,dp);
            
            return dp[sr][sc]=count;
             
        }
    }
    //Leetcode 63 https://leetcode.com/problems/unique-paths-ii/ ===================================================================
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int [][]dp=new int[obstacleGrid.length][obstacleGrid[0].length];
            if(obstacleGrid[0][0]==1)
                return 0;
            return uniquePath(obstacleGrid,0,0,obstacleGrid.length,obstacleGrid[0].length,dp);
        }
        public int uniquePath(int [][]grid,int sr,int sc,int dr,int dc,int [][]dp)
        {
            if(sr==dr-1 && sc==dc-1 && grid[sr][sc]==0)
             return 1;
            else if(sr==dr-1 && sc==dc-1 && grid[sr][sc]==1)
                return 0;
            if(dp[sr][sc]!=0)
                return dp[sr][sc];
             
            int count=0;
           
            if(sr+1<dr && grid[sr+1][sc]==0)
                count+=uniquePath(grid,sr+1,sc,dr,dc,dp);
            if(sc+1<dc && grid[sr][sc+1]==0)
                count+=uniquePath(grid,sr,sc+1,dr,dc,dp);
            
            return dp[sr][sc]=count;
             
        }
    }

    
}