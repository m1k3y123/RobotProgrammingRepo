package part1.search.problem.grid;

import java.util.ArrayList;

import part1.search.problem.grid.GridPuzzle.GridMove;
import part1.search.problem.jumbled.JumbleMove;
import part1.search.problem.jumbled.JumblePuzzle;
import part1.search.problem.jumbled.JumblePuzzleSuccessorFunction;
import part1.search.problem.structure.SearchNode;

public class GridPuzzleNode implements SearchNode<GridPuzzleNode, GridMove, GridPuzzle> 
{
    /**
     * Contains a list of EightPuzzleNodes of previous states.
     */
    private final ArrayList<GridPuzzleNode> m_parents;

    /**
     * Contains the current state.
     */
    private final GridPuzzle m_state;

    /**
     * Contains the move used to get to this state from the previous.
     */
    private final GridMove m_move;

    public GridPuzzleNode(GridPuzzle _state)
    {
	m_parents = new ArrayList<GridPuzzleNode>();
	m_move = null;
	m_state = _state;
    }

    public GridPuzzleNode(GridPuzzle _state, GridMove _move,
	    ArrayList<GridPuzzleNode> _parents)
    {
	m_parents = _parents;
	m_state = _state;
	m_move = _move;
    }

    @Override
    public ArrayList<GridPuzzleNode> getParents()
    {
	return m_parents;
    }

    @Override
    public void getSuccessors(ArrayList<GridPuzzleNode> successors)
    {
	GridPuzzleSuccessorFunction successorF = new GridPuzzleSuccessorFunction();

	ArrayList<GridPuzzleNode>_parents = new ArrayList<GridPuzzleNode>(m_parents);
	_parents.add(this);
	
	successorF.getSuccessors(this, successors, _parents);
    }

    @Override
    public GridPuzzle getState()
    {
	return m_state;
    }

    @Override
    public GridMove getAction()
    {
	return m_move;
    }

    @Override
    public boolean isGoal(GridPuzzle state)
    {
	return m_state.toString().equals(state.toString());
    }
    
    @Override
    public int compareTo(GridPuzzleNode that)
    {
	return 0;
//	return this.getState().getManhattanDistance() - that.getState().getManhattanDistance();
    }


}
