


public class KnightsTour{
	
	//initializing the 8x8 board
	 int rows =8;
	 int cols =8;
	 
	 //creating the array
	 int chessBoard[][];
	 
	 
	    public KnightsTour()  //constructor begin
	    {
	        chessBoard = new int[rows][cols];
	    }
	 
	    public boolean grid(int r, int c)
	    {
	        if (r >= 0 && r < rows && c >= 0 && c < cols && chessBoard[r][c] == -1)
	            return true;
	        
	        else
	        	return false;
	    }
	 
	    public void calculate()
	    {
	        for (int r = 0; r < rows; r++)
	        {
	            for (int c = 0; c < cols; c++)
	            {
	                System.out.print("   " + chessBoard[r][c]);
	            }
	            System.out.println();
	        }
	    }
	 
	    public boolean knightPath(int presR, int presC, int nextMove, int turnA[],int turnB[])
	    {
	        int knight; 
	        int horizontal; 
	        int vert;
	        
	        if (nextMove == rows * cols)
	            return true;
	 
	        for (knight = 0; knight < rows; knight++)
	        {
	            horizontal = presR + turnA[knight];
	            vert = presC + turnB[knight];
	            if (grid(horizontal, vert))
	            {
	                chessBoard[horizontal][vert] = nextMove;
	                if (knightPath(horizontal, vert, (1 + nextMove) , turnA, turnB))
	                    return true;
	                else
	                    chessBoard[horizontal][vert] = -1;
	            }
	        }
	        return false;
	    }
	 
	    public boolean implementTheTour()
	    {
	    	int r2;   
	    	int c2;
	    	
	        for (r2 = 0; r2 < rows; r2++)
	        {
	            for (c2 = 0; c2 < cols; c2++)
	            {
	                chessBoard[r2][c2] = -1;
	            }
	        }
	        
	        //possible moves for the knight piece      
	        int arrayH[] = {-1,-2, -2,-1, 1,2, 2,1};
	        int arrayV[] = {2,1, -1,-2, -2,-1, 1,2};
	       
	        chessBoard[0][0] = 0;//starting position
	        
	        if (!knightPath(0, 0, 1, arrayH, arrayV))
	        {
	            return false;
	        }
	        else
	        {
	            calculate();
	        }
	        return true;
	    }
	 
	    //main method
	    public static void main(String[] args)
	    {
	    	System.out.println("A possible path for the Knight's Tour is:");
	    	System.out.println("");
	    	
	    	/*the tour takes a few seconds to output so I included this print
	    	to show that is running
	    	*/
	    	
	    	
	        KnightsTour chessPiece = new KnightsTour(); //new instance of KnightsTour class, constructor is now running
	        chessPiece.implementTheTour();
	    }
	}
    
	



	   
	


	 
	

	
	  
	
	
	
	

