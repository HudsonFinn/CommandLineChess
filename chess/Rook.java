package chess;

public class Rook extends Piece {
  public Rook(PieceColour shade){
    colour = shade;
		if (colour == PieceColour.WHITE) {
			setSymbol("\u2656");
		}
		else{
			setSymbol("\u265C");
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
    if ( (movei == 0) | (movej == 0) ) {
      if (movei > 0) {
        // Down
        for (int i = (starti+1); i < endi; i++) {
          if (Board.hasPiece(i, startj)) {
            return false;
          }
        }
      } else if (movei < 0) {
        // Up
        for (int i = (starti-1); i > endi; i--) {
          if (Board.hasPiece(i, startj)) {
            return false;
          }
        }
      } else if (movej > 0) {
        // Right
        for (int i = (startj+1); i < endj; i++) {
          if (Board.hasPiece(starti, i)) {
            return false;
          }
        }
      } else {
        // Left
        for (int i = (startj-1); i > endj; i--) {
          if (Board.hasPiece(starti, i)) {
            return false;
          }
        }
      }
    } else {
      return false;
    }
    return true;
  }
}
