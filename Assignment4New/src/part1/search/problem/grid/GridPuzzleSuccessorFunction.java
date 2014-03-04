package part1.search.problem.grid;

import java.util.ArrayList;

import part1.search.problem.grid.GridPuzzle.GridMove;
import rp13.search.interfaces.SortedAgenda;
import rp13.search.interfaces.SuccessorFunction;

public class GridPuzzleSuccessorFunction implements
	SuccessorFunction<GridPuzzleNode, GridMove, GridPuzzle>
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
	public void getSuccessors(GridPuzzleNode node,
		ArrayList<GridPuzzleNode> _successors, ArrayList<GridPuzzleNode> _parents)
	{
	    assert (_successors != null);
	    	// for each of the moves that are available
		for (NodeMovePair move : node.getState().getCurrentNode().getPosMoves()) {
		    	// check if it is possible
			if (node.getState().isPossibleMove(move.getMove())) {
			    // create a copy of the input state as we don't want to change it
			    GridPuzzle successor = 
				    new GridPuzzle(node.getState());
				
			    	// apply the move
				successor.makeMove(move.getMove());
				
				// store the move and action together in a pair and add to
				// successor list
				_successors
						.add(new GridPuzzleNode(successor, move.getMove(), _parents));
			}

		}

	}

}
