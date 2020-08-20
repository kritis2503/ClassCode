#include<iostream>
#include<vector>
using namespace std;

vector<vector<int>>dirA{{0,1},{-1,0},{0,-1},{1,0}};
vector<string>dirS{"R","u","l","d"};
int floodfillalgo(int sr,int sc,int er,int ec,vector<vector<int>>&board,string ans)
{
    if(sr==er && sc==ec)
    {
        cout<<ans<<endl;
        return 1;
    }
    board[sr][sc]=1;
    for(int i=0;i<dirA.size();i++)
    {
        int r=sr+dirA[i][0];
        int c=sc+dirA[i][0];
        if(r<=er && c<=ec && r>=0 && c>=0)
            floodfillalgo(r,c,er,ec,board,ans+dirS[i]);
    }
    board[sr][sc]=0;
}

int main(){
    int m=4;
    int n=4;
    vector<vector<int>>board(n,vector<int>(m,0));
    floodfillalgo(0,0,m,n,board,"");
}