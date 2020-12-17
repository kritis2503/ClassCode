import java.util.*;
public class rahul {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int []a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=scn.nextInt();
        int []ans=new int [n];
        for(int i=0;i<n;i++)
        {
            while(a[i]>0)
            {
                int rem=a[i]%10;
                ans[i]+=rem;
                a[i]=a[i]/10;
            }
        }
        for(int i=0;i<n;i++)
        {
            System.out.println(ans[i]);
        }
    }
}
