package chess;

abstract class Piece {
  int row;
  int column;
  String symbol;
  PieceColour colour;


  public String getSymbol(){
    return symbol;
  }

  public void setSymbol(String sym){
    symbol = sym;
  }

  public PieceColour getColour(){
    return colour;
  }

  public void updateCoordinates(int i, int j){
    row = i;
    column = j;
  }

  public abstract boolean isLegitMove(int starti, int startj, int endi, int endj);
}
