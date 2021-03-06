package part1.test;

import java.util.ArrayList;

import part1.search.problem.grid.GridNode;
import part1.search.problem.grid.GridPuzzle;
import part1.search.problem.grid.GridPuzzle.GridMove;
import part1.search.problem.grid.GridPuzzleNode;
import part1.search.problem.grid.NodeMovePair;
import part1.search.problem.structure.BreadthFirstAgenda;
import part1.search.problem.structure.UninformedSearch;


public class GridPuzzleTest
{
    public static void main(String[]args)
    {
	ArrayList<NodeMovePair> blocked = new ArrayList<NodeMovePair>();
	blocked.add(new NodeMovePair(GridMove.NORTH, new GridNode(0, 1)));
	
	GridPuzzle puzzle = new GridPuzzle(9, 9, blocked);
	GridPuzzle ordered = new GridPuzzle(9, 9, blocked);
	ordered.setPosition(8, 6);

	
	
//	System.out.println(puzzle.getCurrentNode().toString());
//	
//	for (NodeMovePair nodeMovePair : puzzle.getCurrentNode().getPosMoves())
//	{
//	    System.out.println(nodeMovePair.toString());
//	}
	
//	puzzle.makeMove(GridMove.WEST);
	
//	System.out.println(puzzle.getCurrentNode().toString());
	
//	for (NodeMovePair nmp : puzzle.getCurrentNode().getPosMoves())
//	{
//	    System.out.println(nmp.toString());
//	}
	
	GridPuzzleNode node = new GridPuzzleNode(puzzle);
	
	BreadthFirstAgenda agenda = new BreadthFirstAgenda();
	agenda.push(node);

//	ArrayList<GridPuzzleNode> successors = new ArrayList<GridPuzzleNode>();
//	node.getSuccessors(successors);
//	
//	for (GridPuzzleNode jumblePuzzleNode : successors)
//	{
//	    System.out.println(jumblePuzzleNode.getState());
//	}

	// TODO Sort out difference between successors and possibleMoves in this test and their relevant places.
	UninformedSearch<GridMove, GridPuzzle> search = new UninformedSearch<GridMove, GridPuzzle>(agenda, ordered);
	
	GridPuzzleNode newNode = (GridPuzzleNode)search.performSearch();
	
	System.out.println("HERE2");
	
//	for (GridPuzzleNode eightPuzzleNode : newNode.getParents())
//	{
//	    if(eightPuzzleNode.getAction() != null)
//	    {
//		System.out.print(eightPuzzleNode.getAction());
//		System.out.println(eightPuzzleNode.getState());
//	    }
//	}
//
//	System.out.print(newNode.getAction());
//	System.out.println(newNode.getState());

    
    }
}
