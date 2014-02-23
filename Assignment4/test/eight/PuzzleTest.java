import java.util.ArrayList;

import part1.search.problem.eight.EightPuzzleNode;
import part1.search.structure.DepthFirstAgenda;
import part1.search.structure.UninformedSearch;
import rp13.search.problem.puzzle.EightPuzzle;
import rp13.search.problem.puzzle.EightPuzzle.PuzzleMove;
import rp13.search.util.ActionStatePair;


public class PuzzleTest
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
	EightPuzzle puzzle = EightPuzzle.randomEightPuzzle();
	EightPuzzle ordered = EightPuzzle.orderedEightPuzzle();
	
	EightPuzzleNode node = new EightPuzzleNode(puzzle);
	ArrayList<ActionStatePair<PuzzleMove, EightPuzzle>>  successors = new ArrayList<ActionStatePair<PuzzleMove, EightPuzzle>>();
	node.getSuccessors(successors);
	
	DepthFirstAgenda agenda = new DepthFirstAgenda();
	agenda.push(node);
	UninformedSearch<PuzzleMove, EightPuzzle> search = new UninformedSearch<PuzzleMove, EightPuzzle>(agenda, ordered);
	System.out.println(search.performSearch().getState().toString());
	// TODO Add in parent passing.
	
    }

}
