import java.util.*;


public class amazon {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int []a=new int [n];
        for(int i=0;i<n;i++)
            a[i]=scn.nextInt();
        Arrays.sort(a);
        int min=(int)1e8;
        for(int i=1;i<n;i++)
        {
            min=Math.min(min, a[i]-a[i-1]);
        }
        System.out.println(min);
    }
    
}
