package chess;


//This class is partially implemented
public class Square {
	private int i;
	private int j;
	private boolean hasPiece;
	private Piece p;

	public Square(int iIn, int jIn){
		i=iIn;
		j=jIn;
		hasPiece = false;
	}

	public Piece getPiece(){
		return p;
	}

	public void setPiece(Piece type){
		hasPiece = true;
		p = type;
	}

	public void removePiece(){
		hasPiece = false;
		p = null;
	}

	public int getI(){
		return i;
	}

	public int getJ(){
		return j;
	}


	public boolean hasPiece(){
		return hasPiece;
	}

}
