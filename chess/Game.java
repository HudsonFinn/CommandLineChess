package chess;
//import java.util.Scanner;
import java.io.Console;

public class Game {
	private static boolean gameEnd = false;
	private static String winner;

	public Game(){
		CheckInput checker = new CheckInput();
		String s;
		PieceColour turn = PieceColour.WHITE;
		int i0;
		int j0;
		int i1;
		int j1;
		//Scanner sc = new Scanner(System.in);
		Console sc = System.console();
		//Need to check input has piece in position and colour is correct
		//Make sure coords are not the same
		Board b = new Board();
		b.initialisePieces();
    b.printBoard();
		while (!gameEnd){
			//s = sc.nextLine();
			if (turn == PieceColour.BLACK){
				System.out.println("\n------ Blacks move ------\n");
			} else {
				System.out.println("\n------ Whites move ------\n");
			}
			s = sc.readLine("> Enter origin: \n");
			if (checker.checkCoordinateValidity(s)) {
				if (s.equals("END")) {
					System.out.println("\nGame has been forfeit");
					if (turn == PieceColour.BLACK){
						turn = PieceColour.WHITE;
					} else {
						turn = PieceColour.BLACK;
					}
					gameEnd = true;
					break;
				}
				i0 = (s.charAt(0) - 49);
				j0 = (s.charAt(1) - 97);
				if (b.hasPiece(i0, j0)) {
					if (b.getPiece(i0, j0).getColour() == turn) {
						//s = sc.nextLine();
						s = sc.readLine("> Enter destination: \n");
						if (checker.checkCoordinateValidity(s)) {
							if (s.equals("END")) {
								System.out.println("\nGame has been forfeit");
								if (turn == PieceColour.BLACK){
									turn = PieceColour.WHITE;
								} else {
									turn = PieceColour.BLACK;
								}
								gameEnd = true;
								break;
							}
							i1 = (s.charAt(0) - 49);
							j1 = (s.charAt(1) - 97);
							if (b.getPiece(i0, j0).isLegitMove(i0, j0, i1, j1)) {
								if (b.movePiece(i0, j0, i1, j1, b.getPiece(i0, j0))) {
									gameEnd = true;
									break;
								}
								b.printBoard();
								if (turn == PieceColour.BLACK){
									turn = PieceColour.WHITE;
								} else {
									turn = PieceColour.BLACK;
								}
							} else {
								System.out.println("\nInvalid move!");
							}
						} else {
							System.out.println("\nInvalid coordinate");
						}
					} else {
						System.out.println("\nThats not your piece!");
					}
				} else {
					System.out.println("\nNo piece selected!");
				}
			} else {
				System.out.println("\nInvalid coordinate");
			}
		}
		if (turn == PieceColour.BLACK){
			winner = "Black";
		} else {
			winner = "White";
		}
		System.out.println("\n" + winner + " is the winner!");
	}


	public static void main (String args[]){
		Game g  = new Game();
	}
}
