package part1.test;

import java.util.ArrayList;

import part1.search.problem.grid.GridNode;
import part1.search.problem.grid.GridPuzzle;
import part1.search.problem.grid.GridPuzzle.GridMove;
import part1.search.problem.grid.GridPuzzleNode;
import part1.search.problem.grid.NodeMovePair;
import part1.search.problem.structure.BreadthFirstAgenda;
import part1.search.problem.structure.DepthFirstAgenda;
import part1.search.problem.structure.UninformedSearch;


public class GridPuzzleTest
{
    public static void main(String[]args)
    {
	// Instantiate an ArrayList for blocked moves.
	ArrayList<NodeMovePair> blocked = new ArrayList<NodeMovePair>();
	
	// Add any blocked moves to the ArrayList.
	blocked.add(new NodeMovePair(GridMove.NORTH, new GridNode(0, 1)));
	
	// Create a puzzle for the starter position.
	GridPuzzle puzzle = new GridPuzzle(3, 3, blocked);
	
	// Create a puzzle for the GOAL state.
	GridPuzzle ordered = new GridPuzzle(3, 3, blocked);
	
	// Set the GOAL position.
	ordered.setPosition(2, 2);

	// Create a GridPuzzleNode to be added to the agenda.
	GridPuzzleNode node = new GridPuzzleNode(puzzle);
	
	// Create the BreadthFirstAgenda.
	// Uncomment/Comment the below lines for the two different searches.
		
	//DepthFirstAgenda agenda = new DepthFirstAgenda(); // May take A LOT longer than BreadthFirstSearch.
	BreadthFirstAgenda agenda = new BreadthFirstAgenda();
		
	// Push the GridPuzzleNode to the agenda.
	agenda.push(node);

	// Create a search object using the above objects.
	UninformedSearch<GridMove, GridPuzzle> search = new UninformedSearch<GridMove, GridPuzzle>(agenda, ordered);
	
	// Fetch the child node from the search.
	GridPuzzleNode newNode = (GridPuzzleNode)search.performSearch();
	
	// Loop through all of the child node's parents to find the moves made.
	for (GridPuzzleNode eightPuzzleNode : newNode.getParents())
	    if(eightPuzzleNode.getAction() != null)
	    {
		System.out.print(eightPuzzleNode.getAction() + " -> ");
		System.out.println(eightPuzzleNode.getState());
	    }

	System.out.print(newNode.getAction() + " -> ");
	System.out.println(newNode.getState());

    }
}
