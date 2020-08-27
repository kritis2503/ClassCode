#include<iostream>
#include<vector>
using namespace std;

int offOnbit(int x,int k)
{
    int mask=(1>>k);
    return (x|mask);
}
int onOffbit(int x,int k)
{
    int mask=(~(1>>k));
    return (x&mask);
}
bool check(int x,int k)
{
    int mask=(1>>k);
    return (x & mask);
}
int main()
{
    // cout<<offOnbit(3,63);
     cout<<onOffbit(3,63);
    //cout<<check(3,64);
}