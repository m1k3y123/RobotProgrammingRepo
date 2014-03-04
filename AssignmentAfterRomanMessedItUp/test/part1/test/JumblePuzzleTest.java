package part1.test;

import lejos.util.Delay;
import part1.search.problem.jumbled.JumbleMove;
import part1.search.problem.jumbled.JumblePuzzle;
import part1.search.problem.jumbled.JumblePuzzleNode;
import part1.search.problem.structure.BreadthFirstAgenda;
import part1.search.problem.structure.UninformedSearch;


public class JumblePuzzleTest
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
	JumblePuzzle ordered = new JumblePuzzle("depth");
	JumblePuzzle puzzle = new JumblePuzzle("depth", true);
	
	System.out.println(puzzle.toString());
	
	JumblePuzzleNode node = new JumblePuzzleNode(puzzle);
	
	BreadthFirstAgenda agenda = new BreadthFirstAgenda();
	agenda.push(node);
	
//	ArrayList<JumblePuzzleNode> successors = new ArrayList<JumblePuzzleNode>();
//	node.getSuccessors(successors);
//	
//	for (JumblePuzzleNode jumblePuzzleNode : successors)
//	{
//	    System.out.println(jumblePuzzleNode.getState());
//	}
	
	UninformedSearch<JumbleMove, JumblePuzzle> search = new UninformedSearch<JumbleMove, JumblePuzzle>(agenda, ordered);
	
	JumblePuzzleNode newNode = (JumblePuzzleNode)search.performSearch();
	
	for (JumblePuzzleNode eightPuzzleNode : newNode.getParents())
	{
	    if(eightPuzzleNode.getAction() != null)
	    {
		System.out.println(eightPuzzleNode.getAction());
		System.out.println(eightPuzzleNode.getState());
	    }
	}

	System.out.println(newNode.getAction());
	System.out.println(newNode.getState());
	Delay.msDelay(300000);

    }

}
