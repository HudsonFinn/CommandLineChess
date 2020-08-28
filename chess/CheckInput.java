package chess;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CheckInput {
	private static String REGEX = "[1-8][a-h]";
	private static Pattern pat;
	private static Matcher match;

	public CheckInput() {

	}

	public boolean checkCoordinateValidity(String input){
		if (input.equals("END")) {
			return true;
		} else {
		}
		pat = Pattern.compile(REGEX);
		match = pat.matcher(input);
		if ( !(match.matches())) {
			return false;
		}
		return true;
	}
}
