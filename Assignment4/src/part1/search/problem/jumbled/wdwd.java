package part1.search.problem.jumbled;

import java.util.ArrayList;

public class wdwd
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
	String a = "elephant";
	JumblePuzzle puzzle = new JumblePuzzle("elephant");
	ArrayList<JumbleMove> moves = puzzle.possibleMoves();
	
	
	for (JumbleMove move : moves)
	{
	   // System.out.println(a.substring(move.getMoveA(), move.getMoveA() + 1) + ", " + a.substring(move.getMoveB(), move.getMoveB() + 1));
	}
	
    }

}
