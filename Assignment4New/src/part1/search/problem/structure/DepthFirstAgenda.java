package part1.search.problem.structure;

import java.util.ArrayList;
import java.util.Iterator;

import rp13.search.interfaces.Agenda;

/**
 * Implementation of the Agenda interface to traverse a tree using Depth First Search.
 *
 * @author mike
 *
 */
public class DepthFirstAgenda implements Agenda<SearchNode>
{
    // List of SearchNode's in the agenda.
    private ArrayList<SearchNode> m_list;
    
    // List of popped SearchNode's (kept so that duplicate states are not reached).
    private ArrayList<SearchNode> m_popped_list;
    
    /**
     * Constructor for DepthFirstAgenda.
     */
    public DepthFirstAgenda()
    {
	m_popped_list = new ArrayList<SearchNode>();
	m_list = new ArrayList<SearchNode>();
    }

    @Override
    public Iterator<SearchNode> iterator()
    {
	return m_list.iterator();
    }

    /**
     * push method.
     * 
     * This method differentiates the two Agenda's.
     * This agenda type will append each new search node to the start of the list.
     * This means that the newest successor will be traversed first (Depth First Search).
     */
    @Override
    public void push(SearchNode _item)
    {
	// Check to see if the popped list or current list contain this state.
	if(!contains(_item)) m_list.add(0, _item);	
    }

    /**
     * Pops the first element in the list and adds it to the popped list.
     */
    @Override
    public SearchNode pop()
    {	
	m_popped_list.add(0, m_list.get(0));
	m_list.remove(0);
	return m_popped_list.get(0);
    }

    @Override
    public boolean isEmpty()
    {
	return m_list.isEmpty();
    }

    /**
     * contains method.
     * 
     * This method will check both private ArrayLists -
     * m_popped_list and m_list, to see whether either
     * of the contains an instance that equals the passed SearchNode.
     * 
     * This is done as to stop any duplicated states being added leading
     * to a graph type structure and loops.
     */
    @Override
    public boolean contains(SearchNode _item)
    {
	    for (SearchNode node : m_list)
		if(node.getState().toString().equals(_item.getState().toString()))
		    return true;
	
	    for(SearchNode node : m_popped_list)
		if(node.getState().toString().equals(_item.getState().toString()))
		    return true;
	    
	return false;
    }  
}