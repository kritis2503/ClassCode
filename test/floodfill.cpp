#include<iostream>
#include<vector>
using namespace std;

int n,m;
vector<vector<int>>dirA={{0,1},{-1,0},{0,-1},{1,0}};
vector<string>dirS={"R","U","L","D"};

int floodfillalgo_01(int sr,int sc,int er,int ec, vector<vector<int>>&board,string ans)
{
    if(sr==er && sc==ec)
    {
        cout<<ans<<endl;
        return 1;
    }
    int count=0;
    board[sr][sc]=1;

    for(int d=0;d<dirA.size();d++)
    {
        int r=sr+dirA[d][0];
        int c=sc+dirA[d][1];

        if(r>=0 && c>=0 && r<=er && c<=ec && board[r][c]==0)
            count+=floodfillalgo_01(r,c,er,ec,board,ans+dirS[d]);
    }
    board[sr][sc]=0;
    return count;
}
int floodfillalgojump(int sr,int sc,int er,int ec, vector<vector<int>>&board,string ans)
{
    if(sr==er && sc==ec)
    {
        cout<<ans<<endl;
        return 1;
    }
    int count=0;
    board[sr][sc]=1;

    for(int d=0;d<dirA.size();d++)
    {
        for(int rad=1;rad<max(m,n);rad++)
        {int r=sr+rad*dirA[d][0];
        int c=sc+rad*dirA[d][1];

        if(r>=0 && c>=0 && r<=er && c<=ec && board[r][c]==0)
            count+=floodfillalgojump(r,c,er,ec,board,ans+dirS[d]+to_string(rad));}
    }
    board[sr][sc]=0;
    return count;
}

int main()
{
    m=3,n=3;
    vector<vector<int>>board(n,vector<int>(m,0));
   // cout<<floodfillalgo_01(0,0,n-1,m-1,board,"");
     cout<<floodfillalgojump(0,0,n-1,m-1,board,"");
    return 0;
}