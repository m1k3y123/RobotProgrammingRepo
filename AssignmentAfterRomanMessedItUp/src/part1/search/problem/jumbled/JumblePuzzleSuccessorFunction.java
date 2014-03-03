package part1.search.problem.jumbled;

import java.util.ArrayList;
import rp13.search.interfaces.SuccessorFunction;

public class JumblePuzzleSuccessorFunction implements
	SuccessorFunction<JumblePuzzleNode, JumbleMove, JumblePuzzle>
{
    /**
	 * 
	 * Get the possible successors of an eight-puzzle state. Only returns legal
	 * moves.
	 * @param  
	 * @param m_parents 
	 * 
	 */
	@Override
	public void getSuccessors(JumblePuzzleNode node,
		ArrayList<JumblePuzzleNode> _successors, ArrayList<JumblePuzzleNode> _parents)
	{
	    assert (_successors != null);
	    
	    // for each of the moves that are available
		for (JumbleMove move : node.getState().possibleMoves()) {

			// check if it is possible
			if (node.getState().isPossibleMove(move)) {

				// create a copy of the input state as we don't want to change
				// it
				JumblePuzzle successor = new JumblePuzzle(node.getState());
								
				// apply the move
				successor.makeMove(move);
				
				// store the move and action together in a pair and add to
				// successor list
				_successors
						.add(new JumblePuzzleNode(successor, move, _parents));
			}

		}

	}

}
