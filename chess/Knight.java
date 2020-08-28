package chess;

public class Knight extends Piece {
  public int[][] moves = new int[][]{{2,1}, {2,-1}, {-2,1}, {-2,-1}, {1,2}, {1,-2}, {-1,2}, {-1,-2}};

  public Knight(PieceColour shade){
    colour = shade;
    if (colour == PieceColour.WHITE) {
      setSymbol("\u2658");
    }
    else{
      setSymbol("\u265E");
    }
  }

  public boolean isLegitMove(int starti, int startj, int endi, int endj) {
    int movei = endi - starti;
    int movej = endj - startj;
    if (Board.hasPiece(endi, endj)) {
			if ( (Board.getPiece(endi, endj).getColour() == Board.getPiece(starti, startj).getColour()) ) {
				return false;
				}
			}
    for (int i = 0; i < moves.length; i++) {
      if ( !( (movei == moves[i][0]) & (movej == moves[i][1]) ) ) {
        continue;
      }
      return true;
    };
    return false;
  }
}
