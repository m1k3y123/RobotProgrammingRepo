package part1.test;

import part1.search.problem.eight.EightPuzzleNode;
import part1.search.problem.structure.BreadthFirstAgenda;
import part1.search.problem.structure.DepthFirstAgenda;
import part1.search.problem.structure.UninformedSearch;
import rp13.search.problem.puzzle.EightPuzzle;
import rp13.search.problem.puzzle.EightPuzzle.PuzzleMove;


public class EightPuzzleTest
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
	// Creates a random EightPuzzle.
	EightPuzzle puzzle = EightPuzzle.randomEightPuzzle();
	
	// Creates an ordered EightPuzzle (GOAL).
	EightPuzzle ordered = EightPuzzle.orderedEightPuzzle();
	
	// Outputs the original puzzle to apply moves to.
	System.out.println(puzzle.toString());
	
	// Create a new EightPuzzleNode using the puzzle.
	EightPuzzleNode node = new EightPuzzleNode(puzzle);
	
	// Create an instance of the BreadthFirstAgenda.
	// Uncomment/Comment the below lines for the two different searches.
		
	//DepthFirstAgenda agenda = new DepthFirstAgenda(); // May take A LOT longer than BreadthFirstSearch.
	BreadthFirstAgenda agenda = new BreadthFirstAgenda();
		
	// Push the puzzle node to the agenda.
	agenda.push(node);
	
	// Create a search object using the above objects.
	UninformedSearch<PuzzleMove, EightPuzzle> search = new UninformedSearch<PuzzleMove, EightPuzzle>(agenda, ordered);
	
	// Fetch the final child from the search.
	EightPuzzleNode newNode = (EightPuzzleNode)search.performSearch();
	
	// Loop through all parents of the child and print them.
	for (EightPuzzleNode eightPuzzleNode : newNode.getParents())
	    if(eightPuzzleNode.getAction() != null)
		System.out.println(eightPuzzleNode.getAction());

	// Print out the final move made to reach the GOAL state.
	System.out.println(newNode.getAction());
    }

}
