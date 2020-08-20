import java.util.*;

public class dpclass1 {
    public static int path_rec(int sr, int sc, int dr, int dc, int[][] dp) {
        if (sr == dr && sc == dc)
            return 1;
        if (dp[sr][sc] != 0)
            return dp[sr][sc];
        int count = 0;
        if (sr + 1 <= dr)
            count += path_rec(sr + 1, sc, dr, dc, dp);
        if (sc + 1 <= dc)
            count += path_rec(sr, sc + 1, dr, dc, dp);
        if (sr + 1 <= dr && sc + 1 <= dc)
            count += path_rec(sr + 1, sc + 1, dr, dc, dp);
        return dp[sr][sc] = count;
    }

    public static int path_tab(int sr, int sc, int dr, int dc, int[][] dp) {
        for (sr = dr; sr >= 0; sr--) {
            for (sc = dc; sc >= 0; sc--) {
                if (sr == dr && sc == dc) {
                    dp[sr][sc] = 1;
                    continue;
                }

                int count = 0;
                if (sr + 1 <= dr)
                    count += dp[sr + 1][sc];// path_rec(sr + 1, sc, dr, dc, dp);
                if (sc + 1 <= dc)
                    count += dp[sr][sc + 1];// path_rec(sr, sc + 1, dr, dc, dp);
                if (sr + 1 <= dr && sc + 1 <= dc)
                    count += dp[sr + 1][sc + 1];// path_rec(sr + 1, sc + 1, dr, dc, dp);
                dp[sr][sc] = count;
            }
        }
        return dp[0][0];

    }

    public static int path_rec_01(int sr, int sc, int dr, int dc, int[][] dp) {
        if (sr == dr && sc == dc)
            return 1;
        if (dp[sr][sc] != 0)
            return dp[sr][sc];
        int count = 0;
        for (int jump = 1; sr + jump <= dr; jump++)
            count += path_rec_01(sr + jump, sc, dr, dc, dp);
        for (int jump = 1; sc + jump <= dc; jump++)
            count += path_rec_01(sr, sc + jump, dr, dc, dp);
        for (int jump = 1; sr + jump <= dr && sc + jump <= dc; jump++)
            count += path_rec_01(sr + jump, sc + jump, dr, dc, dp);
        return dp[sr][sc] = count;
    }

    public static int path_tab_01(int sr, int sc, int dr, int dc, int[][] dp) {
        for (sr = dr; sr >= 0; sr--) {
            for (sc = dc; sc >= 0; sc--) {
                if (sr == dr && sc == dc) {
                    dp[sr][sc] = 1;
                    continue;
                }

                int count = 0;
                for (int jump = 1; sr + jump <= dr; jump++)
                    count += dp[sr + jump][sc];// path_rec_01(sr + jump, sc, dr, dc, dp);
                for (int jump = 1; sc + jump <= dc; jump++)
                    count += dp[sr][sc + jump];// path_rec_01(sr, sc + jump, dr, dc, dp);
                for (int jump = 1; sr + jump <= dr && sc + jump <= dc; jump++)
                    count += dp[sr + jump][sc + jump];// path_rec_01(sr + jump, sc + jump, dr, dc, dp);
                dp[sr][sc] = count;
            }
        }
        return dp[0][0];
    }

    public static int ludo_rec_01(int si, int ei, int[] dp) {
        if (si == ei)
            return 1;
        if (si > ei)
            return 0;
        if (dp[si] != 0)
            return dp[si];
        int count = 0;
        for (int i = 1; i <= 6; i++) {
            if (si + i <= ei)
                count += ludo_rec_01(si + i, ei, dp);
        }
        return dp[si] = count;

    }

    public static int ludo_tab_01(int si, int ei, int[] dp) {
        for (si = ei; si >= 0; si--) {
            if (si == ei) {
                dp[si] = 1;
                continue;
            }

            int count = 0;
            for (int i = 1; i <= 6; i++) {
                if (si + i <= ei)
                    count += dp[si + i];// ludo_rec_01(si+i, ei, dp);
            }
            dp[si] = count;

        }
        return dp[0];
    }

    public static int ludovar_rec_01(int si, int ei, int[] moves, int[] dp) {
        if (si == ei)
            return 1;
        if (si > ei)
            return 0;
        if (dp[si] != 0)
            return dp[si];
        int count = 0;
        for (int i = 0; i < moves.length; i++) {
            if (si + moves[i] <= ei)
                count += ludovar_rec_01(si + moves[i], ei, moves, dp);
        }
        return dp[si] = count;

    }

    public static int ludovar_tab_01(int si, int ei, int[] moves, int[] dp) {
        for (si = ei; si >= 0; si--) {
            if (si == ei) {
                dp[si] = 1;
                continue;

            }

            int count = 0;
            for (int i = 0; i < moves.length; i++) {
                if (si + moves[i] <= ei)
                    count += ludovar_rec_01(si + moves[i], ei, moves, dp);
            }
            dp[si] = count;

        }
        return dp[0];
    }

    public static void display(int[] dp) {
        for (int i = 0; i < dp.length; i++)
            System.out.print(dp[i] + " ");
        System.out.println();
    }

    // public static int ludo_tab_02(int si,int ei,int dp[])
    // {
    // for(int i=1;i<dp.length;i++)
    // {
    // if(i<=6)
    // dp[i]
    // }
    // }
    public static int longestpalindromicsubsequence(String str, int i, int j, int[][] dp) {
        if (i == j)
            return dp[i][j] = 1;

        if (dp[i][j] != 0)
            return dp[i][j];

        int maxLen = 0;
        if (str.charAt(i) == str.charAt(j))
            maxLen = longestpalindromicsubsequence(str, i + 1, j - 1, dp) + 2;
        else {
            maxLen = Math.max(longestpalindromicsubsequence(str, i + 1, j, dp),
                    longestpalindromicsubsequence(str, i, j - 1, dp));
        }
        return dp[i][j] = maxLen;

    }

    public static int CoinChangePer(int[] arr, int tar, int[] dp) {
        if (tar == 0)
            return 1;
        if (dp[tar] != 0)
            return dp[tar];
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (tar - arr[i] >= 0)
                ans += CoinChangePer(arr, tar - arr[i], dp);
        }
        return dp[tar] = ans;
    }

    public static int coinChangePer_dp(int []arr, int tar)
    {
        int []dp=new int [tar+1];
        for(int j=0;j<dp.length;j++)
        {
            if(tar==0)
            {
                dp[tar]= 1;
                continue;
            }

        int ans=0;
        for(int i=0;i<arr.length;i++)
        {
            if(tar-arr[i]>=0)
            ans+=dp[tar-arr[i]];//CoinChangePer(arr, tar-arr[i], dp);
        }
        dp[j]=ans;
        }
        return dp[tar];
    }

    public static void main(String[] args) {
        // int dp[][] = new int[4][4];
        // System.out.println(path_rec(0, 0, 3, 3,dp));
        // System.out.println(path_tab(0, 0, 3, 3, dp));
        // System.out.println(path_rec_01(0, 0, 3, 3, dp));
        // System.out.println(path_tab_01(0, 0, 3, 3, dp));
        // int dp[] = new int[11];
        // System.out.println(ludo(0, 10, dp));
        // System.out.println(ludo_tab_01(0, 10, dp));
        // int[] moves = { 2, 4, 1, 5 };
        // System.out.println(ludovar_rec_01(0, 10, moves, dp));
        // System.out.println(ludovar_tab_01(0, 10, moves, dp));
        int[] arr = { 2, 3, 5, 7 };
        int tar = 10;
        int[] dp = new int[tar + 1];
        System.out.println(CoinChangePer(arr, tar, dp));

    }
}