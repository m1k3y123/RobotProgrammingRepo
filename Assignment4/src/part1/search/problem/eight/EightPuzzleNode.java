package part1.search.problem.eight;

import java.util.ArrayList;

import part1.search.structure.SearchNode;
import rp13.search.problem.puzzle.EightPuzzle;
import rp13.search.problem.puzzle.EightPuzzle.PuzzleMove;
import rp13.search.problem.puzzle.EightPuzzleSuccessorFunction;

public class EightPuzzleNode implements SearchNode<EightPuzzleNode, PuzzleMove, EightPuzzle>
{
    /**
     * Contains a list of EightPuzzleNodes of previous states.
     */
    private final ArrayList<EightPuzzleNode> m_parents;

    /**
     * Contains the current state.
     */
    private final EightPuzzle m_state;

    /**
     * Contains the move used to get to this state from the previous.
     */
    private final PuzzleMove m_move;

    public EightPuzzleNode(EightPuzzle _state)
    {
	m_parents = null;
	m_move = null;
	m_state = _state;
    }

    public EightPuzzleNode(EightPuzzle _state, PuzzleMove _move,
	    ArrayList<EightPuzzleNode> _parents)
    {
	m_parents = _parents;
	m_state = _state;
	m_move = _move;
    }

    @Override
    public ArrayList<EightPuzzleNode> getParents()
    {
	return m_parents;
    }

    @Override
    public void getSuccessors(ArrayList<EightPuzzleNode> successors)
    {
	EightPuzzleSuccessorFunction successorF = new EightPuzzleSuccessorFunction();
	successorF.getSuccessors(m_state, successors);
    }

    @Override
    public EightPuzzle getState()
    {
	return m_state;
    }

    @Override
    public PuzzleMove getAction()
    {
	return m_move;
    }

    @Override
    public boolean isGoal(EightPuzzle state)
    {
	return m_state.equals(state);
    }
}
