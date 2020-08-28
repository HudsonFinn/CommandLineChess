package chess;


//This class is partially implemented. Some methods need to have their body written, some other are fine as they are and other may need to be extended.

public class Board {
	private static Square [][] board = new Square[8][8];

	public Board(){
		for (int i=0; i<board[0].length; i++){
			for (int j=0; j<board[1].length; j++)
					board[i][j]=new Square(i,j);
		}
	}

	public static Square[][] getBoard(){
		return board;
	}

	public void initialisePieces(){
		setPiece(6, 0, new Pawn(PieceColour.WHITE));
		setPiece(6, 1, new Pawn(PieceColour.WHITE));
		setPiece(6, 2, new Pawn(PieceColour.WHITE));
		setPiece(6, 3, new Pawn(PieceColour.WHITE));
		setPiece(6, 4, new Pawn(PieceColour.WHITE));
		setPiece(6, 5, new Pawn(PieceColour.WHITE));
		setPiece(6, 6, new Pawn(PieceColour.WHITE));
		setPiece(6, 7, new Pawn(PieceColour.WHITE));
		setPiece(1, 0, new Pawn(PieceColour.BLACK));
		setPiece(1, 1, new Pawn(PieceColour.BLACK));
		setPiece(1, 2, new Pawn(PieceColour.BLACK));
		setPiece(1, 3, new Pawn(PieceColour.BLACK));
		setPiece(1, 4, new Pawn(PieceColour.BLACK));
		setPiece(1, 5, new Pawn(PieceColour.BLACK));
		setPiece(1, 6, new Pawn(PieceColour.BLACK));
		setPiece(1, 7, new Pawn(PieceColour.BLACK));

		setPiece(7, 0, new Rook(PieceColour.WHITE));
		setPiece(7, 7, new Rook(PieceColour.WHITE));
		setPiece(7, 1, new Knight(PieceColour.WHITE));
		setPiece(7, 6, new Knight(PieceColour.WHITE));
		setPiece(7, 2, new Bishop(PieceColour.WHITE));
		setPiece(7, 5, new Bishop(PieceColour.WHITE));
		setPiece(7, 3, new Queen(PieceColour.WHITE));
		setPiece(7, 4, new King(PieceColour.WHITE));

		setPiece(0, 0, new Rook(PieceColour.BLACK));
		setPiece(0, 7, new Rook(PieceColour.BLACK));
		setPiece(0, 1, new Knight(PieceColour.BLACK));
		setPiece(0, 6, new Knight(PieceColour.BLACK));
		setPiece(0, 2, new Bishop(PieceColour.BLACK));
		setPiece(0, 5, new Bishop(PieceColour.BLACK));
		setPiece(0, 3, new Queen(PieceColour.BLACK));
		setPiece(0, 4, new King(PieceColour.BLACK));
	}

	public void printBoard(){
		System.out.print("\n  a b c d e f g h \n");
		System.out.print("  -----------------\n");
		String wsp=" ";String bar="|";

		for (int i=0; i<board[0].length; i++){
			int row=i+1;
				for (int j=0; j<board[1].length; j++){
					if ((j==0) && board[i][j].hasPiece())
						System.out.print(row+" "+board[i][j].getPiece().getSymbol());
					else if ((j==0) && !board[i][j].hasPiece())
						System.out.print(row+"  " );
					else if (board[i][j].hasPiece())
						//System.out.print("Knight");
						System.out.print("|" + board[i][j].getPiece().getSymbol());
					else
						System.out.print("| ");
				}
				System.out.print("  "+row+"\n");
		}
		System.out.print("  -----------------");
		System.out.print("\n  a b c d e f g h \n");
	}


	public boolean movePiece(int i0, int j0, int i1, int j1, Piece p){
		//Already know its valid, passed to validity checker
		//Is legit move will check if it can move to that position (valid move and collisions)
		if (hasPiece(i1, j1)) {
			if ((board[i1][j1].getPiece().getSymbol().equals("\u2654")) | (board[i1][j1].getPiece().getSymbol().equals("\u265A"))) {
				board[i0][j0].removePiece();
				board[i1][j1].setPiece(p);
				return true;
			} else {
				board[i0][j0].removePiece();
				board[i1][j1].setPiece(p);
				return false;
			}
		} else {
			board[i0][j0].removePiece();
			board[i1][j1].setPiece(p);
			return false;
		}
	}

	public void setPiece(int iIn, int jIn, Piece p){
		board[iIn][jIn].setPiece(p);
	}

	public static Piece getPiece(int iIn, int jIn){
		return board[iIn][jIn].getPiece();
	}

	public static boolean hasPiece(int i, int j){
		return board[i][j].hasPiece();
	}

}
