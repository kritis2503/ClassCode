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

   public static void main(String[] args) {
    
    Scanner scn=new Scanner(System.in);
    int t=scn.nextInt();
    while(t-->0)
    {
        solve();
    }
   } 
}