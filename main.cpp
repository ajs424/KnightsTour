//Aalap Shastri
//CS280
//31382098

#include<iostream>
#define rows 8
#define cols 8
//defining the 8x8 board


int grid(int r, int c, int chessBoard[rows][cols])
{
    if ( r >= 0 && r < rows && c >= 0 && c < cols && chessBoard[r][c] == -1)
        return true;
    else
        return 0;
}


void calculate(int chessBoard[rows][cols])  //include chessboard in parameters bc it wont run without it
{
    for (int r = 0; r < rows; r++)
    {
        for (int c = 0; c < cols; c++)
            printf(" %2d ", chessBoard[r][c]);
            printf("\n");
    }
   
}


int knightPath(int presR, int presC, int nextMove, int chessBoard[rows][cols], int turnA[rows],     int turnB[cols])
{
    int knight;
    int horizontal;
    int vert;
    
    if (nextMove == rows*cols)
        return true;
    
    
    for (knight = 0; knight < rows; knight++)
    {
        horizontal = presR + turnA[knight];
        vert = presC + turnB[knight];
        if (grid(horizontal, vert, chessBoard))
        {
            chessBoard[horizontal][vert] = nextMove;
            if (knightPath(horizontal, vert, (nextMove+1), chessBoard, turnA, turnB))
                return true;
            else
                chessBoard[horizontal][vert] = -1;
        }
    }
    return false;
}


bool implementTheTour()
{
    int r2;
    int c2;
    int chessBoard[rows][cols];
    
    for (r2 = 0; r2 < rows; r2++)
        for (c2 = 0; c2 < cols; c2++)
            chessBoard[r2][c2] = -1;
    
    
    int arrayH[] = {  -1,-2, -2,-1, 1,2, 2,1 };
    int arrayV[] = {  2,1, -1,-2, -2,-1, 1,2 };
    
    
    chessBoard[0][0]  = 0; //starting position
    
    
    if(!knightPath(0, 0, 1, chessBoard, arrayH, arrayV))
    {
        return false;
    }
    else
        calculate(chessBoard);
    
    return true;
}


//main method
int main()
{
    printf("A possible path for the Knight's Tour is:");
    printf("\n");
    
    
    implementTheTour();
    getchar();
    
    
    return 0;
}