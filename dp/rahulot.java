import java.util.*;
public class rahulot{
    static void numbersWith3Divisors(int n) 
    { 
        boolean[] prime = new boolean[n+1]; 
        Arrays.fill(prime, true); 
        prime[0] = prime[1] = false; 
   
        for (int p=2; p*p<=n; p++) 
        { 
            // If prime[p] is not changed, then it is a prime 
            if (prime[p] == true) 
            { 
                // Update all multiples of p 
                for (int i=p*2; i<=n; i += p) 
                    prime[i] = false; 
            } 
        } 
   
        // print squares of primes upto n 
        System.out.println("Numbers with 3 divisors : "); 
        for (int i=0;  i*i <= n ; i++) 
            if (prime[i]&& (i*i)%2==0) 
                System.out.println(i*i + " "); 
    } 
      
    // driver program 
    public static void main (String[] args)  
    { 
        int n = 100000;
        numbersWith3Divisors(n);  
    } 
}