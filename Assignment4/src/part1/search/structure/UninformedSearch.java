package part1.search.structure;

import java.util.ArrayList;
import java.util.Iterator;

import part1.search.problem.eight.EightPuzzleNode;
import rp13.search.interfaces.Agenda;
import rp13.search.problem.puzzle.EightPuzzle;
import rp13.search.util.ActionStatePair;

/**
 * Perform a search.
 * 
 * @author root
 *
 */
public class UninformedSearch<ActionT, StateT>
{
    /**
     * Start node for the search.
     */
    private Agenda<SearchNode> m_agenda;
    
    /**
     * GOAL
     * 
     */
    private StateT m_goal;
    
    /**
     * @param _start
     */
    public UninformedSearch(Agenda _agenda, StateT _goal)
    {
	m_agenda 	= _agenda;
	m_goal  	= _goal;
    }
    
    /**
     * Perform a depth first search using the start node.
     * 
     * @return
     */
    public SearchNode performSearch()
    {
	ArrayList<ActionStatePair> nodes = new ArrayList<ActionStatePair>();
	while(!m_agenda.isEmpty())
	{
	    SearchNode node = m_agenda.pop();
	    
	    if(isGoal((StateT)node.getState()))
	    {
		return node;
	    }
	    else
	    {
		node.getSuccessors(nodes);
		for (ActionStatePair pair : nodes)
		{
		    m_agenda.push(new EightPuzzleNode((EightPuzzle)pair.getState()));
		}
	    }
	    nodes.clear();
	}
	    return null;
    }
    
    public boolean isGoal(StateT node)
    {
	return node.equals(m_goal);
    }
}