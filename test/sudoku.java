package test;

public class sudoku {
    public static boolean isValidToPlaceNumber(int [][]board,int x,int y,int num)
    {
        //row
        for(int i=0;i<9;i++)
        {
            if(board[x][i]==num)
                return false;
        }
        for(int i=0;i<9;i++)
        {
            if(board[i][y]==num)
                return false;
        }

        //3X3
        x=x/3;
        x=x*3;
        y=y/3;
        y=y*3;
        for(int i=x;i<x+3;i++)
        {
            for(int j=y;j<y+3;j++)
            {
                if(board[i][j]=num)
                    return false;
            }
        }
        return true;

    }
    public static boolean sudokuSolver(char [][]board,int idx)
    {
        if(idx==81)
            return true;
        
        int x=idx/9;
        int y=idx%9;

        if(board[x][y]=='.')
        {
            for(int num=1;num<=9;num++)
            {
                if(isValidToPlaceNumber(board,x,y,num))
                {
                    board[x][y]=(char)(num);
                    if(sudokuSolver(board, idx+1))
                        return true;
                    board[x][y]='.';
                }
            }
        }
        else
            return sudokuSolver(board, idx+1);
        return false;
    }
    public static boolean 
}