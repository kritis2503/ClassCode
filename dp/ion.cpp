#include<iostream>
#include<vector>
using namespace std;
vector<int> graph;

void addNode(int u,int v)
{
    graph[u].push_back(v);
}
int GCC_(int src, vector<bool> &vis)
{
    vis[src] = true;
    int count=0;
    for (int e : graph[src])
    {
        if (!vis[e])
            {count++;
                GCC_(e, vis);
            }
    }
    return count;
}

int  GCC(int N)
{
    vector<bool> vis(N, false);
    int max = 0;
    int ans=-1;
    for (int i = 0; i < N; i++)
    {
        if (!vis[i])
        {
            int res=GCC_(i, vis);
            if(res>max)
            {
                max=res;
                ans=i;
            }
            //int res=count++;
        }

    }
    return ans;
}

int main()
{
    int user,pair;
    cin>>user>>pair;
    int p1,p2;
    for(int i=0;i<pair;i++)
    {
        
        cin>>p1>>p2;
        addNode(p1,p2);
    }
    vector<bool>vis(user,false);
    cout<<GCC(user);
}