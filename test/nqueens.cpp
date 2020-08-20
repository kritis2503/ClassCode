#include<iostream>
#include<vector>
using namespace std;
vector<bool>rowA;
vector<bool>colA;
vector<bool>diagA;
vector<bool>adiagA;

bool isSafeToPlaceQueen_(vector<vector<bool>> &boxes,int row,int col)
{
    vector<vector<int>> dir={{0,-1},{-1,-1},{-1,0},{-1,1}};

    for(int d=0;d<dir.size();d++)
    {
        for(int rad=1;rad<=boxes.size();rad++)
        {
            int r=row+rad*dir[d][0];
            int c=col+rad*dir[d][1];

            if(r>=0 && c>=0 && r<boxes.size() && c<boxes.size())
            {
                if(boxes[r][c])
                    return false;
            }
            else 
                break;
        }
        return true;
    }
}
int Nqueen_01(vector<vector<bool>>&boxes,int tnq,int idx,string ans)
{
    if(tnq==0)
    {
        cout<<ans<<endl;
        return 1;
    }

    int count=0;
    for(int i=idx;i<boxes.size()*boxes[0].size();i++)
    {
        int r=i/boxes[0].size();
        int c=i%boxes[0].size();
        if(isSafeToPlaceQueen_(boxes,r,c))
        {
            boxes[r][c]=true;
            count+=Nqueen_01(boxes,tnq-1,i+1,ans+"("+to_string(r)+","+to_string(c)+")");
            boxes[r][c]=false;
        }
        return count;

    }
}

int Nqueen_02(vector<vector<bool>>&boxes,int tnq,int idx,string ans)
{
    if(tnq==0)
    {
        cout<<ans<<endl;
        return 1;
    }

    int count=0;
    int m=boxes[0].size();
    for(int i=idx;i<boxes.size()*boxes[0].size();i++)
    {
        int r=i/boxes[0].size();
        int c=i%boxes[0].size();
        if(!rowA[r] && !colA[c] && !diagA[r+c] && !adiagA[r-c+m-1] )
        {
            rowA[r]=true;
            colA[c]=true;
            diagA[r+c]=true;
            adiagA[r-c+m-1]=true;
            count+=Nqueen_02(boxes,tnq-1,i+1,ans+"("+to_string(r)+","+to_string(c)+")");
           
             rowA[r]=false;
            colA[c]=false;
            diagA[r+c]=false;
            adiagA[r-c+m-1]=false;
        }

    }
        return count;
}
int Nqueen_03(vector<vector<bool>>&boxes,int tnq,int idx,string ans)
{
    if(tnq==0)
    {
        cout<<ans<<endl;
        return 1;
    }

    int count=0;
    int m=boxes[0].size();
    for(int i=0;i<boxes.size()*boxes[0].size();i++)
    {
        int r=i/boxes[0].size();
        int c=i%boxes[0].size();
        if(!boxes[r][c] && !rowA[r] && !colA[c] && !diagA[r+c] && !adiagA[r-c+m-1] )
        {
            rowA[r]=true;
            colA[c]=true;
            diagA[r+c]=true;
            adiagA[r-c+m-1]=true;
            boxes[r][c]=true;
            count+=Nqueen_03(boxes,tnq-1,0,ans+"("+to_string(r)+","+to_string(c)+")");
           
             rowA[r]=false;
            colA[c]=false;
            diagA[r+c]=false;
            adiagA[r-c+m-1]=false;
            boxes[r][c]=false;
        }

    }
        return count;
}


int Nqueen_04(int n, int m, int tnq, int r, string ans) // tnq is equal to target.
{
    if (tnq == 0)
    {
        cout << ans << endl;
        return 1;
    }

    int count = 0;
    
    for (int c = 0; c < m; c++)
    {
        if (!rowA[r] && !colA[c] && !diagA[r + c] && !adiagA[r - c + m - 1])
        {
            rowA[r] = true;
            colA[c] = true;
            diagA[r + c] = true;
            adiagA[r - c + m - 1] = true;

            count += Nqueen_04(n, m, tnq - 1, r + 1, ans + "(" + to_string(r) + "," + to_string(c) + ") ");

            rowA[r] = false;
            colA[c] = false;
            diagA[r + c] = false;
            adiagA[r - c + m - 1] = false;
        }
    }
    return count;
}

int row = 0;
int col = 0;
int diag = 0;
int adiag = 0;

int Nqueen_05(int n, int m, int tnq, int r, string ans) // tnq is equal to target.
{
    if (tnq == 0)
    {
        cout << ans << endl;
        return 1;
    }

    int count = 0;
    for (int c = 0; c < m; c++)
    {
        if ((row & (1 << r)) == 0 && (col & (1 << c)) == 0 && (diag & (1 << (r + c))) == 0 && (adiag & (1 << (r - c + m - 1))) == 0)
        {
            row ^= (1 << r);
            col ^= (1 << c);
            diag ^= (1 << (r + c));
            adiag ^= (1 << (r - c + m - 1));

            count += Nqueen_05(n, m, tnq - 1, r + 1, ans + "(" + to_string(r) + "," + to_string(c) + ") ");

            row ^= (1 << r);
            col ^= (1 << c);
            diag ^= (1 << (r + c));
            adiag ^= (1 << (r - c + m - 1));
        }
    }
    return count;
}

//=====================================================================================
void Nqueen()
{
    // rowA=new boolean[n];

    int n = 4;
    int m = 4;
    rowA.resize(n, false);
    colA.resize(m, false);
    diagA.resize(n + m - 1, false);
    adiagA.resize(n + m - 1, false);

    vector<vector<bool>> boxes(n, vector<bool>(m, false));
    // cout << Nqueen_03(boxes, n, 0, "") << endl;
     cout<<Nqueen_05(n,m,0,0,"")<<endl;
    // cout << Nqueen_02(n, m, n, 0, "") << endl;
    // cout << Nqueen_03(boxes, m, n, 0, "") << endl;
    // cout << Nqueen_04(n, m, 4, 0, "") << endl;
    // cout << Nqueen_03_sub(n, m, 4, 0, "") << endl;
    //cout << Nqueen_04_sub(n, m, 4, 0, "") << endl;
}


int main()
{
    Nqueen();
    return 0;
}

 
