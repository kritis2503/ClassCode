#include <iostream>
#include <vector>

using namespace std;

class Edge
{
public:
    int v;
    int w;

    Edge(int v, int w)
    {
        this->v = v;
        this->w = w;
    }
};

int N;
vector<vector<Edge>> graph;

void display()
{
    for (int i = 0; i < graph.size(); i++)
    {
        cout << i << " -> ";
        for (Edge e : graph[i])
            cout << "(" << e.v << ", " << e.w << ") ";
        cout << endl;
    }

    cout << endl;
}

void addEdge(int u, int v, int w)
{
    graph[u].push_back(Edge(v, w));
    graph[v].push_back(Edge(u, w));
}

int searchVrtx(int u, int v)
{
    int idx = -1;
    for (int i = 0; i < graph[u].size(); i++)
    {
        Edge e = graph[u][i];
        if (e.v == v)
        {
            idx = i;
            break;
        }
    }

    return idx;
}

void removeEdge(int u, int v)
{
    int idx = -1;
    idx = searchVrtx(u, v);
    graph[u].erase(graph[u].begin() + idx);

    idx = searchVrtx(v, u);
    graph[v].erase(graph[v].begin() + idx);
}

void removeVtx(int u)
{
    int size = graph[u].size();
    while (size-- > 0)
    {
        Edge e = graph[u].back();
        removeEdge(u, e.v);
    }

    // graph.erase(graph.begin() + u);
}

bool hasPath(int src, int dest, vector<bool> &vis)
{
    if (src == dest)
        return true;

    vis[src] = true;
    bool res = false;
    for (Edge e : graph[src])
        if (!vis[e.v])
            res = res || hasPath(e.v, dest, vis);

    return res;
}

int allPath(int src, int dest, string path, vector<bool> &vis)
{
    if (src == dest)
    {
        cout << path << dest << endl;
        return 1;
    }

    vis[src] = true;
    bool res = false;
    int count = 0;
    for (Edge e : graph[src])
        if (!vis[e.v])
            count += allPath(e.v, dest, path + to_string(src) + " ", vis);

    vis[src] = false;
    return count;
}
int hamiltonPath(int src, int osrc,string path, vector<bool> &vis,int ctr)
{
    if (src == dest)
    {
        if(ctr==N-1)
        {
            if()
            cout << path << dest << endl;
        return 1;
    }

    vis[src] = true;
    bool res = false;
    int count = 0;
    for (Edge e : graph[src])
        if (!vis[e.v])
            count += hamiltonPath(e.v, dest, path + to_string(src) + " ", vis,ctr+1);

    vis[src] = false;
    return count;
}

void preorder(int src, string path, vector<bool> &vis)
{
    vis[src] = true;
    cout << to_string(src) + " @ " + path + to_string(src) << endl;
    for (Edge e : graph[src])
        if (!vis[e.v])
            preorder(e.v, path + to_string(src) + " ", vis);

    vis[src] = false;
}

int allPath(int src, int dest, int weight, string path, vector<bool> &vis)
{
    if (src == dest)
    {
        cout << path << dest << " @ " << weight << endl;
        return 1;
    }

    vis[src] = true;
    bool res = false;
    int count = 0;
    for (Edge e : graph[src])
        if (!vis[e.v])
            count += allPath(e.v, dest, weight + e.w, path + to_string(src) + " ", vis);

    vis[src] = false;
    return count;
}

class pathPair
{
public:
    int len = 0;
    string path = "";

    pathPair(int a, string b)
    {
        len = a;
        path = b;
    }
};

pathPair smallestPath(int src, int dest, vector<bool> &vis)
{
    if (src == dest)
    {
        return pathPair(0, to_string(src));
    }

    vis[src] = true;
    pathPair myAns(1e8, "");
    for (Edge e : graph[src])
    {
        if (!vis[e.v])
        {
            pathPair recAns = smallestPath(e.v, dest, vis);
            if (recAns.len + 1 < myAns.len)
            {
                myAns.len = recAns.len + 1;
                myAns.path = to_string(src) + " " + recAns.path;
            }
        }
    }

    vis[src] = false;
    return myAns;
}

int kthSmal = 1e8;
void KthSmallest_(int src, int dest, int weight, int floor, vector<bool> &vis)
{
    if (src == dest)
    {
        if (weight > floor)
            kthSmal = min(kthSmal, weight);
        return;
    }

    vis[src] = true;
    for (Edge e : graph[src])
        if (!vis[e.v])
            KthSmallest_(e.v, dest, weight + e.w, floor, vis);

    vis[src] = false;
}

void KthSmallest(int src, int dest, int k)
{
    int floor = -1e8;
    vector<bool> vis(N, false);
    while (k-- > 0)
    {
        kthSmal = 1e8;
        KthSmallest_(src, dest, 0, floor, vis);
        floor = kthSmal;
    }
}

//int KthSmallest02_(int src, int dest, int floor, vector<bool> &vis)
//{
//}

void KthSmallest02(int src, int dest, int k)
{
    int floor = -1e8;
    vector<bool> vis(N, false);
    int ans = 1e8;
    while (k-- > 0)
    {
        ans = KthSmallest02_(src, dest, floor, vis);
        floor = ans;
    }
    cout << ans << endl;
}


void constructGraph()
{
    N = 7;
    graph.resize(N, vector<Edge>());
    // for (int i = 0; i < N; i++)
    // {
    //     vector<Edge> g;
    //     graph.push_back(g);
    // }

    addEdge(0, 1, 10);
    addEdge(1, 2, 10);
    addEdge(2, 3, 40);
    addEdge(3, 0, 10);
    addEdge(3, 4, 2);
    addEdge(4, 5, 2);
    addEdge(4, 6, 8);
    addEdge(5, 6, 3);

    display();
}


void solve()
{
    constructGraph();
    // removeVtx(3);
    // display();

    vector<bool> vis(N, false);
    N=6;
    hamiltonPath(0,6,"",vis,0);

    // preorder(0, "", vis);
    // cout << allPath(0, 6, "", vis) << endl;
    cout << allPath(0, 6, 0, "", vis) << endl;

    // pathPair p = smallestPath(0, 6, vis);
    // cout << p.path << " @ " << p.len << endl;
}

int main()
{
    solve();
    return 0;
}