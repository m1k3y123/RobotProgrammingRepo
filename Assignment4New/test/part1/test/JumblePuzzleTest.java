package part1.test;

import part1.search.problem.jumbled.JumbleMove;
import part1.search.problem.jumbled.JumblePuzzle;
import part1.search.problem.jumbled.JumblePuzzleNode;
import part1.search.problem.structure.BreadthFirstAgenda;
import part1.search.problem.structure.DepthFirstAgenda;
import part1.search.problem.structure.UninformedSearch;


public class JumblePuzzleTest
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
	// Create an ordered puzzle for the GOAL.
	JumblePuzzle ordered = new JumblePuzzle("depth");
	
	// Create a puzzle as the start state.
	JumblePuzzle puzzle = new JumblePuzzle("depth", true);
	
	System.out.println(puzzle.toString());
	
	// Create a new JumblePuzzleNode.
	JumblePuzzleNode node = new JumblePuzzleNode(puzzle);
	
	// Create an Agenda.
	// Uncomment/Comment the below lines for the two different searches.
	
	//DepthFirstAgenda agenda = new DepthFirstAgenda(); // May take A LOT longer than BreadthFirstSearch.
	BreadthFirstAgenda agenda = new BreadthFirstAgenda();
	
	// Add the start node to the Agenda.
	agenda.push(node);
	
	// Create a search object using the above objects.
	UninformedSearch<JumbleMove, JumblePuzzle> search = new UninformedSearch<JumbleMove, JumblePuzzle>(agenda, ordered);
	
	// Fetch the last child from the search to find the moves made.
	JumblePuzzleNode newNode = (JumblePuzzleNode)search.performSearch();
	
	// Loop through the child's parents.
	for (JumblePuzzleNode eightPuzzleNode : newNode.getParents())
	    if(eightPuzzleNode.getAction() != null)
	    {
		System.out.println(eightPuzzleNode.getAction());
		System.out.println(eightPuzzleNode.getState());
	    }

	System.out.println(newNode.getAction());
	System.out.println(newNode.getState());
    }

}
