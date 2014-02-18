package rp13.search.problem.puzzle;

import java.util.List;

import rp13.search.interfaces.SuccessorFunction;
import rp13.search.problem.puzzle.EightPuzzle.PuzzleMove;
import rp13.search.util.ActionStatePair;

/**
 * An example eight-puzzle successor function.
 * 
 * @author Nick Hawes
 * 
 * @param <ActionT>
 * @param <StateT>
 */
public class EightPuzzleSuccessorFunction implements
		SuccessorFunction<PuzzleMove, EightPuzzle> {

	/**
	 * 
	 * Get the possible successors of an eight-puzzle state. Only returns legal
	 * moves.
	 * 
	 */
	@Override
	public void getSuccessors(EightPuzzle _state,
			List<ActionStatePair<PuzzleMove, EightPuzzle>> _successors) {

		assert (_successors != null);

		// for each of the moves that are available
		for (PuzzleMove move : PuzzleMove.values()) {

			// check if it is possible
			if (_state.isPossibleMove(move)) {

				// create a copy of the input state as we don't want to change
				// it
				EightPuzzle successor = new EightPuzzle(_state);
				// apply the move
				successor.makeMove(move);
				// store the move and action together in a pair and add to
				// successor list
				_successors
						.add(new ActionStatePair<EightPuzzle.PuzzleMove, EightPuzzle>(
								move, successor));
			}

		}

	}

}
