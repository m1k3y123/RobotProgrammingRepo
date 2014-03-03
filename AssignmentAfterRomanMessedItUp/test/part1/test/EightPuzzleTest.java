package part1.test;

import part1.search.problem.eight.EightPuzzleNode;
import part1.search.problem.structure.BreadthFirstAgenda;
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
	EightPuzzle puzzle = EightPuzzle.randomEightPuzzle();
	EightPuzzle ordered = EightPuzzle.orderedEightPuzzle();
	
	System.out.println(puzzle.toString());
	
	EightPuzzleNode node = new EightPuzzleNode(puzzle);
	
	BreadthFirstAgenda agenda = new BreadthFirstAgenda();
	agenda.push(node);
	
	UninformedSearch<PuzzleMove, EightPuzzle> search = new UninformedSearch<PuzzleMove, EightPuzzle>(agenda, ordered);
	
	EightPuzzleNode newNode = (EightPuzzleNode)search.performSearch();
	
	for (EightPuzzleNode eightPuzzleNode : newNode.getParents())
	{
	    if(eightPuzzleNode.getAction() != null)
	    {
		System.out.println(eightPuzzleNode.getAction());
		System.out.println(eightPuzzleNode.getState());
		System.out.println();
	    }
	}

	System.out.println(newNode.getAction());
	System.out.println(newNode.getState());

    }

}
