/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class codechef
{
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner scn=new Scanner(System.in);
        //int t=scn.nextInt();
        int t=1;
		for(int k=0;k<t;k++)
		{
		    // int s=scn.nextInt();
            // int n=scn.nextInt();
            int s=31,n=4;
		    int q=0,r=0,dem=0;
		    while(s!=0)
		   {     q=s/n;
		         r=s%n;
		         dem+=q+r;
		         s=r;
		         if(n%2==0)
		           n=n-2;
		          else
		            n=n-3;
		   }
		    
		   
		    
		    System.out.println(q+"  "+r);
		    System.out.println(dem);
		}
	}
}


