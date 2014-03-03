package part1.search.problem.jumbled;

import java.util.ArrayList;
import part1.search.problem.structure.SearchNode;

public class JumblePuzzleNode implements SearchNode<JumblePuzzleNode, JumbleMove, JumblePuzzle> 
{
    /**
     * Contains a list of EightPuzzleNodes of previous states.
     */
    private final ArrayList<JumblePuzzleNode> m_parents;

    /**
     * Contains the current state.
     */
    private final JumblePuzzle m_state;

    /**
     * Contains the move used to get to this state from the previous.
     */
    private final JumbleMove m_move;

    public JumblePuzzleNode(JumblePuzzle _state)
    {
	m_parents = new ArrayList<JumblePuzzleNode>();
	m_move = null;
	m_state = _state;
    }

    public JumblePuzzleNode(JumblePuzzle _state, JumbleMove _move,
	    ArrayList<JumblePuzzleNode> _parents)
    {
	m_parents = _parents;
	m_state = _state;
	m_move = _move;
    }

    @Override
    public ArrayList<JumblePuzzleNode> getParents()
    {
	return m_parents;
    }

    @Override
    public void getSuccessors(ArrayList<JumblePuzzleNode> successors)
    {
	JumblePuzzleSuccessorFunction successorF = new JumblePuzzleSuccessorFunction();

	ArrayList<JumblePuzzleNode>_parents = new ArrayList<JumblePuzzleNode>(m_parents);
	_parents.add(this);
	
	successorF.getSuccessors(this, successors, _parents);
    }

    @Override
    public JumblePuzzle getState()
    {
	return m_state;
    }

    @Override
    public JumbleMove getAction()
    {
	return m_move;
    }

    @Override
    public boolean isGoal(JumblePuzzle state)
    {
	return m_state.toString().equals(state.toString());
    }
    
    @Override
    public int compareTo(JumblePuzzleNode that)
    {
	return this.getState().getManhattanDistance() - that.getState().getManhattanDistance();
    }


}
