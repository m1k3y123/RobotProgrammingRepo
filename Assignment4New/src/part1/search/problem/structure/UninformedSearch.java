package part1.search.problem.structure;

import java.util.ArrayList;
import java.util.Iterator;

import rp13.search.interfaces.Agenda;

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
	ArrayList<SearchNode> nodes = new ArrayList<SearchNode>();

	while(!m_agenda.isEmpty())
	{
	    SearchNode node = m_agenda.pop();
	    if(node.isGoal(m_goal))
		return node;
	    else
	    {
		node.getSuccessors(nodes);
		for (SearchNode sNode : nodes)
		    m_agenda.push(sNode);
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