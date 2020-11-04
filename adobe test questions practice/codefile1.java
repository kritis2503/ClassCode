import java.util.*;

public class codefile1{

    public static void printleaders(int []arr)
    {
        int size=arr.length;
        int max=arr[size-1];

        for(int i=size-2;i>=0;i--)
        {
            if(arr[i]>=max)
            {
                System.out.println(max);
                max=arr[i];
            }
        }
    }
    public static void printspiral(int [][]arr)
    {
        int minrow=0;
        int maxrow=arr.length-1;
        int mincol=0;
        int maxcol=arr[0].length-1;
        int count=0;
        int tot=arr.length*arr[0].length;
        while(maxrow>=minrow && maxcol>=mincol && count<tot)
        {
            for(int i=mincol;i<=maxcol && count<tot;i++)
               { System.out.print(arr[minrow][i]+" ");
                count++;
                }
                //System.out.println();
                minrow++;
            for(int i=minrow;i<=maxrow && count<tot;i++)
               { System.out.print(arr[i][maxcol]+" ");
                count++;
                }
                //System.out.println();
                maxcol--;
            for(int i=maxcol;i>=mincol && count<tot;i--)
              {  System.out.print(arr[maxrow][i]+" ");
              count++;
            }
                maxrow--;
                //System.out.println();
            for(int i=maxrow;i>=minrow && count<tot; i--)
              {  System.out.print(arr[i][mincol]+" ");
                count++;
            }
                mincol++;
                //System.out.println();
        }
        return;
    }
    public static class Node{
        int data;
        Node left;
        Node right;
        Node()
        {
            this.data=0;
            this.left=this.right=null;
        }
        
         Node(int data)
        {
            this.data=data;
            this.left=null;
            this.right=null;
        }        
    }
    public static void MirrorTree(Node node)
    {
        if(node==null)
            return;
        MirrorTree(node.left);
        MirrorTree(node.right);
        Node temp=new Node();
        temp=node.left;
        node.left=node.right;
        node.right=temp;
    }
    public static int secondMax(int []arr)
    {
        int max=(int)-1e8;
        int smax=(int)-1e8;
        for(int i=0;i<arr.length;i++)
            max=Math.max(max, arr[i]);
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]<max && arr[i]>smax)
            {
                smax=arr[i];
            }

        }
        return smax;
    }
    public static void displayInorder(Node node)
    {
        if(node==null)
            return;
        displayInorder(node.left);
        System.out.print(node.data+" ");
        displayInorder(node.right);
    }
    public static int maxSubarraySum(int []arr)
    {
        int maxendinghere=0, maxsofar=(int)-1e8;
        for(int i=0;i<arr.length;i++)
        {
            maxendinghere+=arr[i];
            if(maxendinghere>maxsofar)
                maxsofar=maxendinghere;
            if(maxendinghere<0)
                maxendinghere=0;
        }
        return maxsofar;
    }
    public static boolean armstrong(int n)
    {
        int sum=0;
        int num=n;
        while(num>0)
        {
            int rem=num%10;
            num=num/10;
            int ad=rem*rem*rem;
            sum+=ad;
        }
        if(sum==n)
            return true;
        return false;
    }
    public static int sumofprime(int n)
    {
        int sum=0;
        for(int i=2;i*i<=n;i+=2)
        {
            if(n%i==0)
             {   sum+=i;
                n=n/i;
             }
        }
        if(n>2)
            sum+=n;
        return sum;
    }
    public static int LongestIncreasingSubsequence(int []arr,int ei,int[]dp)
    {
        if(dp[ei]!=0)
            return dp[ei];

        int maxLen=1;
        for(int i=ei;i>=0;i--)
        {
            if(arr[i]<arr[ei])
            {
                int len=LongestIncreasingSubsequence(arr, i, dp);
                maxLen=Math.max(maxLen,len+1);
            }
        }
        return dp[ei]=maxLen;
    }
    public static int weeks(int []arr)
    {
        int sum=0;
        Arrays.sort(arr);
        int si=0;
        int ei=arr.length-1;
        while(si<=ei)
        { 
            int temp=arr[si];
            arr[si]=arr[ei]-arr[si];;
            if(arr[si]<=0)
            {
                arr[ei]=arr[ei]-arr[si];
                sum+=(temp*2);
                arr[si]=0;
                si++;
            }
            Arrays.sort(arr);
        }
        return sum+1;
    }
    public static void main(String[] args) {
        int ar[] = new int[]{16, 17, 4, 3, 5, 2}; 
        //printleaders(arr);
        int arrr[][] = { { 1, 2, 3, 4, 5, 6 },
        { 7, 8, 9, 10, 11, 12 },
        { 13, 14, 15, 16, 17, 18 } };
        //printspiral(a);
        Node root=new Node(1);
        root.left = new Node(2); 
        root.right = new Node(3); 
        root.left.left = new Node(4); 
        root.left.right = new Node(5); 
        //MirrorTree(root);
        //displayInorder(root);
        //System.out.println(secondMax(arr));
        int [] a = {-2, -3, 4, -1, -2, 1, 5, -3}; 
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 }; 
        int []dp=new int [arr.length];

        //System.out.println(LongestIncreasingSubsequence(arr, arr.length-1, dp));
        //System.out.println(maxSubarraySum(arr));
        // System.out.println(armstrong(267));
        // System.out.println(armstrong(153));
        //System.out.println(sumofprime(14594));
        int []ab={7,3,2};
        System.out.println(weeks(ab));
    }
} 