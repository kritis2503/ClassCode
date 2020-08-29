import java.util.*;
public class googleque {
    public static int xoropera(int n,int []a,int x)
    {
        int p=n*(n+1)/2;
        int []count=new int [p+1];
        for(int i=0;i<n;i++)
        {
            int xor=0;
            for(int j=i;j<n;j++)
            {
                xor^=a[j];
                // for(int k=i;k<=j;k++)
                //{
                   
                // }
                count[xor]++;
            }
        }
        int ctr=0;
        int ans=0;
        for(int i=0;i<p;i++)
        {
            ctr=count[i];
            if(x<ctr)
            {
                ans=i;
                break;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int x=scn.nextInt();
        int []a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=scn.nextInt();
        System.out.println(xoropera(n, a, x));
    }
    
}