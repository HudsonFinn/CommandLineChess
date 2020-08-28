package chess;

public class Queen extends Piece {
  public double sqri;
  public double sqrj;
  public Queen(PieceColour shade){
    colour = shade;
    if (colour == PieceColour.WHITE) {
      setSymbol("\u2655");
    }
    else{
      setSymbol("\u265B");
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
    sqri = Math.sqrt( (movei * movei) );
    sqrj = Math.sqrt( (movej * movej) );
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
    } else if (sqri == sqrj ) {
      if (movei > 0) {
        // Down
        if (movej > 0) {
          //Down and right
          for (int i = 1; i < sqri; i++) {
            if (Board.hasPiece(starti + i, startj + i)) {
              return false;
            }
          }
        } else {
          //Down and left
          for (int i = 1; i < sqri; i++) {
            if (Board.hasPiece(starti + i, startj - i)) {
              return false;
            }
          }
        }
      } else if (movei < 0) {
        // Up
        if (movej > 0) {
          //Up and right
          for (int i = 1; i < sqri; i++) {
            if (Board.hasPiece(starti - i, startj + i)) {
              return false;
            }
          }
        } else {
          //Up and left
          for (int i = 1; i < sqri; i++) {
            if (Board.hasPiece(starti - i, startj - i)) {
              return false;
            }
          }
        }
      }
    } else {
      return false;
    }
    return true;
  }
}
