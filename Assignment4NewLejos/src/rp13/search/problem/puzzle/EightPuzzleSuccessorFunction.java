package rp13.search.problem.puzzle;

import java.util.ArrayList;

import part1.search.problem.eight.EightPuzzleNode;
import rp13.search.interfaces.SuccessorFunction;
import rp13.search.problem.puzzle.EightPuzzle.PuzzleMove;

/**
 * An example eight-puzzle successor function.
 * 
 * @author Nick Hawes
 * 
 * @param <ActionT>
 * @param <StateT>
 */
public class EightPuzzleSuccessorFunction implements
		SuccessorFunction<EightPuzzleNode, EightPuzzle, PuzzleMove> {

	/**
	 * 
	 * Get the possible successors of an eight-puzzle state. Only returns legal
	 * moves.
	 * @param  
	 * @param m_parents 
	 * 
	 */
	@Override
	public void getSuccessors(EightPuzzleNode node,
		ArrayList<EightPuzzleNode> _successors, ArrayList<EightPuzzleNode> _parents)
	{
	    assert (_successors != null);

	    // for each of the moves that are available
		for (PuzzleMove move : PuzzleMove.values()) {

			// check if it is possible
			if (node.getState().isPossibleMove(move)) {

				// create a copy of the input state as we don't want to change
				// it
				EightPuzzle successor = new EightPuzzle(node.getState());
				// apply the move
				successor.makeMove(move);
				// store the move and action together in a pair and add to
				// successor list
				_successors
						.add(new EightPuzzleNode(successor, move, _parents));
			}

		}
 
	}

}
