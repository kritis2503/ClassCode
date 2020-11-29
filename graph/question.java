import java.util.*;
public class question {
// d - x <= 10 ^ 7
// d [0, 10 ^ 18]
// public static int min=(int)1e8;
//n^ 2 - o(n)
public static int compute(int x,int d,int wt, int[] dp)
{
    if(x==d)
    {
        // min=Math.min(wt,min);
        return 0;
    }
    if(dp[x] != 0) return dp[x];
    int count=Integer.MAX_VALUE;
    for(int i=2;i<=x/2;i += 2)
    {
        if(x%i==0 && x + i <= d)
        {
            int w=x/i;
            count= Math.min( count,compute(x+i, d, wt+w, dp) + w);
        }
    }
    dp[x] = count;
    return count;
}

public static void solve()
{
    Scanner scn=new Scanner(System.in);
    //int n=scn.nextInt();
    int x=scn.nextInt();
    int d=scn.nextInt();
    if(x == d ) {
        System.out.println(0);
        return;
    } else if (d < x || (x & 1) == 1 || (d & 1) == 1) {
        System.out.println(-1);
        return;
    }
    int [] dp = new int[d + 1];
    int ans=compute(x, d, 0, dp);
    System.out.println(Arrays.toString(dp));
    System.out.println(ans);
}
public static int boardPath_opti(int ei) {
    LinkedList<Integer> ll = new LinkedList<>();

    for (int si = 0; si <= ei; si++) {
        if (si < 2) {
            ll.addFirst(1);
            continue;
        }

        if (ll.size() <= 6)
            ll.addFirst(2 * ll.getFirst());
        else {
            ll.addFirst(2 * ll.getFirst() - ll.getLast());
            int ans=ll.removeLast();
            
        }
    }

    return ll.getFirst();
}
public static int boardPath_DP_02(int si, int ei, int[] moves, int[] dp) {
    for (si = ei; si >= 0; si--) {
        if (si == ei) {
            dp[si] = 1;
            continue;
        }

        int count = 0;
        for (int i = 0; i <=ei; i++) {
            if (si + moves[i] <= ei)
                count += dp[si + moves[i]];// boardPath_Rec_01(si + moves[i], ei, dp);
        }

        dp[si] = count;
    }

    return dp[0];
}
public static int minCostClimbingStairs(int[] cost, int n, int[] dp) {
    if (n <= 1)
        return dp[n] = cost[n];
    if (dp[n] != 0)
        return dp[n];

    int minCost = Math.min(minCostClimbingStairs(cost, n - 1, dp), minCostClimbingStairs(cost, n - 2, dp));

    return dp[n] = minCost + (n == cost.length ? 0 : cost[n]);
}

public static int minCostClimbingStairs_Opti(int[] cost) {
    int a = cost[0];
    int b = cost[1];
    System.out.print(a+" ");
    
    for (int i = 2; i < cost.length; i++) {
        int ans = Math.min(a, b) + cost[i];
        a = b;
        b = ans;
        System.out.print(a+" ");
    }
    return Math.min(a, b);
}

public static int minCostClimbingStairs(int[] cost) {
    int[] dp = new int[cost.length + 1];

    return minCostClimbingStairs(cost, cost.length, dp);
}


   public static void main(String[] args) {
    
    Scanner scn=new Scanner(System.in);
    //int t=scn.nextInt();
    /*while(t-->0)
    {
        solve();
    }
   } */
   //System.out.println(boardPath_opti(10));
   //System.out.println(boardPath_DP_02(1,0 , moves, dp));
   int []dp=new int [10];
   
}
}