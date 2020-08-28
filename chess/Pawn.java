package chess;

public class Pawn extends Piece {
	public boolean firstMove;
	public int[][] moves;
	public int startingi;

	public Pawn(PieceColour shade){
		colour = shade;
		if (colour == PieceColour.WHITE) {
			setSymbol("\u2659");
			moves = new int[][]{{-1,0}, {-2,0}, {-1,1}, {-1,-1}};
			startingi = 6;
		}
		else{
			setSymbol("\u265F");
			moves = new int[][]{{1,0}, {2,0}, {1,1}, {1,-1}};
			startingi = 1;
		}
	}

	public boolean isLegitMove(int starti, int startj, int endi, int endj) {
		if (starti == startingi) {
			firstMove = true;
		}
		int movei = endi - starti;
		int movej = endj - startj;
		if (Board.hasPiece(endi, endj)) {
			if ( (Board.getPiece(endi, endj).getColour() == Board.getPiece(starti, startj).getColour()) ) {
				return false;
			}
			if ( (movei == moves[2][0]) & (movej == moves[2][1]) ) {
				return true;
			} else if ( (movei == moves[3][0]) & (movej == moves[3][1]) ) {
				return true;
			}
			return false;
		}
		if (firstMove) {
			if ( ( (movei == moves[1][0]) & (movej == moves[1][1]) ) | ( (movei == moves[0][0]) & (movej == moves[0][1]) ) ) {
				firstMove = false;
				return true;
			}
		} else {
			if ( (movei == moves[0][0]) & (movej == moves[0][1]) ) {
				return true;
			}
		}
		return false;
	}
}
