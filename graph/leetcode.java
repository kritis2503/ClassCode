import java.util.*;
public class leetcode {

//Leetcode 200=======================================================
class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length==0 || grid[0].length==0)
            return 0;
        int r=grid.length;
        int c=grid[0].length;
        int count=0;
        boolean [][]vis=new boolean[r][c];
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(!vis[i][j] && grid[i][j]=='1')
                {
                    gcc(grid,vis,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public int [][]dir={{1,0},{-1,0},{0,-1},{0,1}};
    public void gcc(char[][]grid,boolean[][]vis,int r,int c)
    {
        vis[r][c]=true;
        for(int d=0;d<dir.length;d++)
        {
            int R=dir[d][0]+r;
            int C=dir[d][1]+c;
            if(R>=0 && R<grid.length && C>=0 && C<grid[0].length && grid[R][C]=='1' && !vis[R][C])
                gcc(grid,vis,R,C);
        }
    }
}
//Leetcode 695========================================================================
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    int m=gcc(grid,i,j);
                    max=Math.max(m,max);
                }
            }
        }
        return max;
    }
      public int [][]dir={{1,0},{-1,0},{0,-1},{0,1}};
    public int gcc(int [][]grid,int r,int c)
    {
        grid[r][c]=0;
        int ctr=0;
        for(int d=0;d<4;d++)
        {
             int R=dir[d][0]+r;
            int C=dir[d][1]+c;
            if(R>=0 && R<grid.length && C>=0 && C<grid[0].length && grid[R][C]==1)
                ctr+=gcc(grid,R,C);
        }
        return ctr+1;
    }
}
//Leetcode 463
class Solution {
    public:
        int islandPerimeter(vector<vector<int>>& grid) {
            int nbr=0, ctr=0;
            for(int i=0;i<grid.size();i++)
            {
                for(int j=0;j<grid[0].size();j++)
                {
                    if(grid[i][j]==1)
                    {
                        ctr++;
                        if(j+1<grid[0].size()&& grid[i][j+1]==1)
                        {
                            
                                nbr++;
                        }
                        if(i+1<grid.size() && grid[i+1][j]==1)
                            nbr++;
                    }
                }
            }
            return ctr*4-nbr*2;
        }
    };
//Leetcode 130
class Solution {
    public:
        vector<vector<int>> dir{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        void solve_(vector<vector<char>> &grid, int sr, int sc)
    {
    
        grid[sr][sc] = '#';
        for (int d = 0; d < 4; d++)
        {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
    
            if (r >= 0 && c >= 0 && r < grid.size() && c < grid[0].size() && grid[r][c] == 'O')
                solve_(grid, r, c);
        }
    }
    
        void solve(vector<vector<char>>& grid) {
            if (grid.size() == 0 || grid[0].size() == 0)
            return;
        int n = grid.size();
        int m = grid[0].size();
    
        for (int i = 0; i < grid.size(); i++)
        {
            if (grid[i][0] == 'O')
                solve_(grid, i, 0);
            if (grid[i][m - 1] == 'O')
                solve_(grid, i, m - 1);
        }
    
        for (int i = 0; i < grid[0].size(); i++)
        {
            if (grid[0][i] == 'O')
                solve_(grid, 0, i);
            if (grid[n - 1][i] == 'O')
                solve_(grid, n - 1, i);
        }
    
        for (int i = 0; i < grid.size(); i++)
        {
            for (int j = 0; j < grid[0].size(); j++)
            {
                if (grid[i][j] == 'O')
                    grid[i][j] = 'X';
                else if (grid[i][j] == '#')
                    grid[i][j] = 'O';
            }
        }
        }
    }
//Leetcode 
}