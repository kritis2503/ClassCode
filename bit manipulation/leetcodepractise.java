import java.util;

public class leetcodepractise {

    //Leetcode 807=====================================================================
    class Solution {
        public int maxIncreaseKeepingSkyline(int[][] grid) {
            int []row_max=new int[grid.length];
            int []col_max=new int[grid[0].length];
            
            for(int i=0;i<grid.length;i++)
            {
                for(int j=0;j<grid[0].length;j++)
                {
                    row_max[i]=Math.max(row_max[i],grid[i][j]);
                }
            }
            for(int i=0;i<grid.length;i++)
            {
                for(int j=0;j<grid[0].length;j++)
                {
                    col_max[i]=Math.max(col_max[i],grid[j][i]);
                }
            }
            int sum=0;
            for(int i=0;i<grid.length;i++)
            {
                for(int j=0;j<grid[0].length;j++)
                {
                    int min=Math.min(row_max[i],col_max[j]);
                    int sub=min-grid[i][j];
                    grid[i][j]+=sub;
                    sum+=sub;
                }
            }
            return sum;
        }
    }
    //Leetcode 1302==============================================================================
    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode>que=new ArrayDeque<>();
        que.add(root);
        ArrayList<Integer>al=new ArrayList<>();
        //int level=0;
        while(que.size()!=0)
        {
            al=new ArrayList<>();
            int size=que.size();
            while(size-->0)
            {
                TreeNode rvtx=que.peek();
                que.remove();
                al.add(rvtx.val);
                
                if(rvtx.left!=null)
                    que.add(rvtx.left);
                if(rvtx.right!=null)
                    que.add(rvtx.right);
            }
        }
        int sum=0;
        for(int ele:al)
        {
            sum+=ele;
        }
        return sum;
    }
}
//https://www.interviewbit.com/problems/count-total-set-bits/=============================
public class Solution {
    public int solve(int num) {
         int []ans=new int[num+1];
        ans[0]=0;
        for(int i=1;i<=num;i++)
        {
            int y=(i& (i-1));
            ans[i]=ans[y]+1;
        }
        int sum=0;
        for(int ele:ans)
           { sum+=ele;
           sum=sum%100000007;
           }
        return sum;
    }
}
//https://www.interviewbit.com/problems/min-xor-value/====================================
public class Solution {
    public int findMinXor(int[] A) {
        Arrays.sort(A);
        int ans=2147483647;
        for(int i=0;i<A.length-1;i++)
            ans=Math.min(ans,A[i]^A[i+1]);
        return ans;
    }
}
//https://www.interviewbit.com/problems/number-of-1-bits/=========================================
public class Solution {
    public int numSetBits(long a) {
        int ctr=0;
        while(a>0)
        {
            a=(a&(a-1));
            ctr++;
        }
        return ctr;
    }
}

}