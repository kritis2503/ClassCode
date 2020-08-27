#include<iostream>
#include<vector>
using namespace std;

//Leetcode 191===================================================================================================
class Solution {
public:
    int hammingWeight(uint32_t n) {
        int ctr=0;
        while(n!=0)
        {
            int y=(n &(n-1));
            ctr++;
            n=y;
        }
        return ctr;
        
    }
};
int hammingWeight_02(uint32_t n)
{
    int ctr=0,t=0;
    while(n!=0 && t<32)
    {
        if((n&1)!=0)
            ctr++;
        t++;
        n>>=`1;

    }
}
//leetcode 136=============================================================================
class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int ans=0;
        for(int i=0;i<nums.size();i++)
            ans^=nums[i];
        return ans;
            
        
    }
};
//Leetcode 231===============================================================
class Solution {
public:
    bool isPowerOfTwo(int n) {
        int ctr=0;
        if(n<0)
            return false;
        while(n!=0)
        {
            n&=(n-1);
            ctr++;
        }
        return ctr==1;
    }
};
//Leetcode 338===================================================================
class Solution {
    public int[] countBits(int num) {
        int []ans=new int[num+1];
        ans[0]=0;
        for(int i=1;i<=num;i++)
        {
            int y=(i& (i-1));
            ans[i]=ans[y]+1;
        }
        return ans;
    }
}
//LeetCode 342=============================================================
class Solution {
public:
    bool isPowerOfFour(int num) {
        if(num<=0)
            return false;
        int y=(num &(num-1)); 
        if( y!=0)
           return false;
       
        int bits=0;
        while(num>1 && bits<=32)
        {
            num=num>>1;
            bits++;
            
        }
        return (bits&1)==0;
    }
};
// Leetcode 268=================================================================
class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int s=1;
        for(int i=2;i<=nums.size();i++)
        {
            s=s^i;
        }
        int ans=nums[0];
        for(int i=1;i<nums.size();i++)
            ans^=nums[i];
        return (ans^s);
    }
};
//Leetcode 137====================================================================


