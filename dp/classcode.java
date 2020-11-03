import java.util.*;

public class classcode {
    public static void display(int []arr)
    {
        for(int ele:arr)
            System.out.print(ele+" ");
        System.out.println();
    }

    public static void display2D(int [][]arr)
    {
        for(int []a:arr)
            display(a);
    }
public static int mazePath_01(int n,int m, int [][]dp)
    {
        if(n==0 && m==0)
            return 1;
        if(n<0 || m<0)
        return 0;
        if(dp[n][m]!=0)
            return dp[n][m];
        int count=0;
        count+=mazePath_01(n-1, m, dp);
        count+=mazePath_01(n, m-1, dp);
        return dp[n][m]=count;
    }
    public static int mazePath_02(int n,int m, int [][]dp)
    {
    if(n==0 && m==0)
        return 1;
    if(n<0 || m<0)
    return 0;
    if(dp[n][m]!=0)
        return dp[n][m];
    int count=0;
    count+=mazePath_02(n-1, m, dp);
    count+=mazePath_02(n, m-1, dp);
    count+=mazePath_02(n-1, m-1, dp);
    return dp[n][m]=count;
    }
   public static int mazePath_01rec(int sr,int sc,int dr,int dc,int [][]dp)
   {
       if(sr==dr && sc==dc)
            return 1;
        if(dp[sr][sc]!=0)
            return dp[sr][sc];
        int count=0;
        if(sr+1<=dr)
           count+= mazePath_01rec(sr+1, sc, dr, dc, dp);
        if(sc+1<=dc)
            count+=mazePath_01rec(sr, sc+1, dr, dc, dp);
        return dp[sr][sc]=count;
   }
   public static int mazePath_01tab(int sr,int sc,int dr,int dc,int [][]dp)
   {
       for(sr=dr;sr>=0;sr--)
       {
           for(sc=dc;sc>=0;sc--)
           {
            if(sr==dr && sc==dc){
                dp[sr][sc]=1;
                continue;
            }
            int count=0;
            if(sr+1<=dr)
                count+= dp[sr+1][sc];//mazePath_01rec(sr+1, sc, dr, dc, dp);
            if(sc+1<=dc)
                count+=dp[sr][sc+1];//mazePath_01rec(sr, sc+1, dr, dc, dp);
            dp[sr][sc]=count;
           }
       }
        return dp[0][0]; 
   }
   public static int mazePath_02rec(int sr,int sc,int dr,int dc,int [][]dp)
   {
       if(sr==dr && sc==dc)
        return 1;
        if(dp[sr][sc]!=0)
            return dp[sr][sc];
        int count=0;
        if(sr+1<=dr)
            count+=mazePath_02rec(sr+1, sc, dr, dc, dp);
        if(sc+1<=dc)
            count+=mazePath_02rec(sr, sc+1, dr, dc, dp);
        if(sr+1<=dr && sc+1<=dc)
            count+=mazePath_02rec(sr+1, sc+1, dr, dc, dp);
        return dp[sr][sc]=count;
   }
   public static int mazePath_02tab(int sr,int sc,int dr,int dc,int [][]dp)
{
    for(sr=dr;sr>=0;sr--)
    {
        for(sc=dc;sc>=0;sc--)
        {
         if(sr==dr && sc==dc){
             dp[sr][sc]=1;
             continue;
         }
         int count=0;
         if(sr+1<=dr)
             count+= dp[sr+1][sc];//mazePath_01rec(sr+1, sc, dr, dc, dp);
         if(sc+1<=dc)
             count+=dp[sr][sc+1];//mazePath_01rec(sr, sc+1, dr, dc, dp);
        if(sr+1<=dr && sc+1<=dc)
                count+=dp[sr+1][sc+1];
         dp[sr][sc]=count;
        }
    }
     return dp[0][0]; 
}
   public static int mazePath_03rec(int sr,int sc,int dr,int dc,int [][]dp)
   {
       if(sr==dr && sc==dc)
        return dp[sr][sc]=1;
        if(dp[sr][sc]!=0)
            return dp[sr][sc];
        int count=0;
        for(int jump=1;jump+sr<=dr;jump++)
           count+=mazePath_03rec(sr+jump, sc, dr, dc, dp);
        for(int jump=1;sc+jump<=dc;jump++)
            count+=mazePath_03rec(sr, sc+jump, dr, dc, dp);
        for(int jump=1;sr+jump<=dr && sc+jump<=dc;jump++)
            count+=mazePath_03rec(sr+jump, sc+jump, dr, dc, dp);
        return dp[sr][sc]=count;
   }
   public static int mazePath_03tab(int sr,int sc,int dr,int dc,int [][]dp)
   {
       for(sr=dr;sr>=0;sr--)
       {
           for(sc=dc;sc>=0;sc--)
           {
                if(sr==dr && sc==dc)
                {   dp[sr][sc]=1;
                     continue;
                }
                int count=0;
                for(int jump=1;jump+sr<=dr;jump++)
                    count+=dp[sr+jump][sc];//mazePath_02rec(sr+jump, sc, dr, dc, dp);
                for(int jump=1;sc+jump<=dc;jump++)
                    count+=dp[sr][sc+jump];//mazePath_02rec(sr, sc+1, dr, dc, dp);
                for(int jump=1;sr+jump<=dr && sc+jump<=dc;jump++)
                    count+=dp[sr+jump][sc+jump];//mazePath_02rec(sr+1, sc+1, dr, dc, dp);
                
                dp[sr][sc]=count;
           }
       }
       return dp[0][0];
   }
   public static int boardPath_01rec(int si,int ei,int []dp)
   {
       if(si==ei)
        return dp[si]=1;
        if(dp[si]!=0)
            return dp[si];
        int count=0;
        for(int i=1;i<=6;i++)
        {
            if(si+i<=ei)
            count+=boardPath_01rec(si+i, ei, dp);
        }
        return dp[si]=count;
   }
   public static int boardPath_01tab(int si,int ei,int []dp)
   {
       for(si=ei;si>=0;si--)
       {
           if(si==ei)
           {
               dp[si]=1;
               continue;
           }
           int count=0;
           for(int i=1;i<=6;i++)
        {
            if(si+i<=ei)
                count+=dp[si+i];
        }
        dp[si]=count;
       }
       return dp[0];
   }
   public static int boardPath_01opti(int ei)
   {
       LinkedList<Integer> li=new LinkedList<>();
       
        for(int si=0;si<=ei;si++)
        {
            if(si<2)
                {li.addFirst(1);
                    continue;
                }
           
            if(li.size()<=6)
                li.addFirst(li.getFirst()*2);
            else
             {   
                 li.addFirst(li.getFirst()*2-li.getLast());
                 li.removeLast();
             }
        }
        return li.getFirst();  
   }
   public static int boardPath_02rec(int si,int ei,int []moves,int []dp)
   {
       if(si==ei)
        return dp[si]=1;
        if(dp[si]!=0)
            return dp[si];
        int count=0;
        for(int i=0;i<moves.length;i++)
        {
            if(si+moves[i]<=ei)
                count+=boardPath_02rec(si+moves[i], ei, moves, dp);
        }
        return dp[si]=count;

   }
   public static int boardPath_02tab(int si,int ei,int []moves,int []dp)
   {
       for(si=ei;si>=0;si--)
       {
            if(si==ei)
            {
                dp[si]=1;
                continue;
            }
            int count=0;
            for(int i=0;i<moves.length;i++)
            {
                if(si+moves[i]<=ei)
                    count+=dp[si+moves[i]];
            }
            dp[si]=count;
       }
       return dp[0];
   }
  
   public static int goldmine01_driver(int [][]mine,int [][]dp)
   {
       int maxGold=0;
       //int [][]dp=new int [mine.length][mine[0].length];
       for(int i=0;i<mine.length;i++)
       {
           maxGold=Math.max(maxGold,goldmine_01(mine, i, 0,dp));
       }
       return maxGold;
   }
   public static int goldmine_01(int [][]mine,int r,int c,int[][]dp)
   {
        if( c==mine[0].length-1)
            return mine[r][c];
        if(dp[r][c]!=0)
            return dp[r][c];
        int [][]dirA={{0,1},{1,1},{-1,1}};  
        int gold=0; 
        for(int d=0;d<3;d++)
        {
            int sr=r+dirA[d][0];
            int sc=c+dirA[d][1];
            if(sr>=0 && sc>=0 && sr<mine.length && sc<mine[0].length)
                gold=Math.max(gold,goldmine_01(mine, sr, sc, dp));
        }
        return dp[r][c]=gold+mine[r][c];
   }
   
   public static void solve()
    {
        //Pathset();
        //linearboardset();
        goldmineSet();
    }
    public static void Pathset()
    {
        //int [][]dp=new int [6][6];
        //System.out.println(mazePath_01rec(5, 5, dp));
        //display2D(dp);
        //dp=new int [6][6];
        //System.out.println(mazePath_02(5, 5, dp));
        //System.out.println(mazePath_01rec(0, 0, 5, 5, dp));
        // System.out.println(mazePath_02rec(0, 0, 5, 5, dp));
        //System.out.println(mazePath_03rec(0, 0, 5, 5, dp));
        //display2D(dp);
        //dp=new int [6][6];
        // System.out.println(mazePath_01tab(0, 0, 5, 5, dp));
        // System.out.println(mazePath_02tab(0, 0, 5, 5, dp));
        //System.out.println(mazePath_03tab(0, 0, 5, 5, dp));
        //display2D(dp);
    }
    public static void linearboardset()
    {
        int []dp=new int [11];
        System.out.println(boardPath_01rec(0, 10, dp));
        display(dp);
        // dp=new int [11];
        // System.out.println(boardPath_01tab(0, 10, dp));
        // display(dp);
        // int []moves={2,3,6,7};
        // System.out.println(boardPath_02rec(0, 10, moves, dp));
        // display(dp);
        // dp=new int [11];
        //System.out.println(boardPath_02tab(0, 10, moves, dp));
        //display(dp);
        System.out.println(boardPath_01opti( 10));
    }
    public static void goldmineSet()
    {
        int gold[][]=  {{10, 33, 13, 15},
        {22, 21, 04, 1},
        {5, 0, 2, 3},
        {0, 6, 14, 2}};
                      
        int [][]dp=new int [gold.length][gold[0].length];

        System.out.println(goldmine01_driver(gold,dp));
        display2D(dp);
    }
             public static void main(String[] args) {
        solve();
    }
}
