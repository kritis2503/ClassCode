import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        for (int q = 0; q < t; q++) {
            int n = scn.nextInt();
            int flag=0;
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = scn.nextInt();

            int c5 = 0, c10 = 0, c15 = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] == 5)
                    c5++;
                else if (a[i] == 10)
                    c10++;
                else if (a[i] == 15)
                    c15++;

                int c = a[i] - 5;
                
                if (c == 5) {

                    if (c5 == 0) {
                        flag=1;
                    }
                    c5--;
                }  if (c == 10) {

                    if (c10> 0) 
                        c10--;
                    
                    else if(c5>2)
                        c5-=2;
                    else
                        flag=1;
                    }  
            }
            if(flag==1)
            System.out.println("NO");
            else
            System.out.println("YES");
        }
    }
}