import java.util.*;
public  class slidingw{
    public static void printsubarray(int []a)
    {
        int n=a.length;
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                for(int k=i;k<=j;k++)
                    System.out.print(a[k]+" ");
                System.out.println();
            }
        }
    }
     public static void main(String[] args) {
        int []a={0,1,2,3,4,5,6,7,8,9,10};
         
        printsubarray(a);
        
    }


}