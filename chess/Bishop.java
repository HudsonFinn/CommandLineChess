package chess;
import java.lang.Math;

public class Bishop extends Piece {
  public double sqri;
  public double sqrj;
  public Bishop(PieceColour shade){
    colour = shade;
    if (colour == PieceColour.WHITE) {
      setSymbol("\u2657");
    }
    else{
      setSymbol("\u265D");
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
    if (sqri == sqrj ) {
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
