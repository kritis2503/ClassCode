import java.util.*;

public class tcscodevita {
    public static int evensum(int sum,int k,int si,int ei)
    {
        if(k==0)
        {
            if(sum%2==0)
                return 1;
            return 0;
        }

        int ctr=0;
        for(int i=si;i<=ei;i++)
        {
            ctr+=evensum( sum+i, k-1, si, ei);
        }
        return ctr;
    }
    public static void main(String[] args) {
        System.out.println(evensum(0, 2, 1, 10));
        
    }
}