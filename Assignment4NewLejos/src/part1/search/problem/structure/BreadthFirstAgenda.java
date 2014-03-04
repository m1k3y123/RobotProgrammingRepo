package part1.search.problem.structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import rp13.search.interfaces.Agenda;

public class BreadthFirstAgenda implements Agenda<SearchNode>
{
    protected ArrayList<SearchNode> m_list;
    private ArrayList<SearchNode> m_popped_list;
    
    public BreadthFirstAgenda()
    {
	m_popped_list = new ArrayList<SearchNode>();
	m_list = new ArrayList<SearchNode>();
    }

    @Override
    public Iterator<SearchNode> iterator()
    {
	return m_list.iterator();
    }

    @Override
    public void push(SearchNode _item)
    {
	if(!contains(_item)) m_list.add(_item);	

    }

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

    @Override
    public boolean contains(SearchNode _item)
    {
	for (SearchNode node : m_list)
	    {
		    if(node.getState().toString().equals(_item.getState().toString()))
		    return true;   
	    }
	
	    
	    for(SearchNode node : m_popped_list)
		{
		if(node.getState().toString().equals(_item.getState().toString()))
		    return true;
		}
	    
	return false;
    }
}
