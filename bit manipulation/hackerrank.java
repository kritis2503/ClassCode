java.util.*;
public class hackerrank {
    
    //https://www.hackerrank.com/challenges/maximizing-xor/problem
    static int maximizingXor(int l, int r) {
        int maxval=0;
        for(int i=l;i<=r;i++)
        {
            for(int j=i+1;j<=r;j++)
                maxval=Math.max(maxval,(i^j));
        }
        return maxval;
    }

    
}