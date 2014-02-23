package part1.search.structure;

import java.util.ArrayList;
import java.util.Iterator;

import rp13.search.interfaces.Agenda;

public class DepthFirstAgenda implements Agenda<SearchNode>
{
    private ArrayList<SearchNode> m_list;
    private ArrayList<SearchNode> m_popped_list;
    
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

    @Override
    public void push(SearchNode _item)
    {
	if(!contains(_item)) m_list.add(0, _item);	

    }

    @Override
    public SearchNode pop()
    {	
	System.out.println(m_list.size());
	m_popped_list.add(0, m_list.get(0));
	m_list.remove(0);
	System.out.println(m_list.size());
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
		if(node.getState().equals(_item.getState()))
		    return true;
	
	    for(SearchNode node : m_popped_list)
		if(node.getState().equals(_item.getState()))
		    return true;
	    
	return false;
    }
   
}
