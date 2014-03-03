package part1.search.problem.grid;

import java.util.ArrayList;

import part1.search.problem.grid.GridPuzzle.GridMove;


public class GridNode
{
    private int m_x;
    private int m_y;
    private ArrayList<NodeMovePair> m_pos_moves;
    
    public GridNode(int x, int y)
    {
	m_x = x;
	m_y = y;
    }
    
    public void setPossibleMoves(ArrayList<NodeMovePair> pos_moves)
    {
	m_pos_moves = pos_moves;
    }
    
    public boolean equals(GridNode node)
    {
	int x = node.getPosX();
	int y = node.getPosY();
	
	if(m_x != x || m_y != y)
	    return false;
	else
	    return true;
    }
    
    public boolean equals(int x, int y)
    {
	if(m_x != x || m_y != y)
	    return false;
	else
	    return true;
    }
    
    public ArrayList<NodeMovePair> getPosMoves()
    {
	return m_pos_moves;
    }
    
    public int getPosX()
    {
	return m_x;
    }
    
    public int getPosY()
    {
	return m_y;
    }
    
    public boolean isPossibleMove(GridMove move)
    {
	for (NodeMovePair nmp : m_pos_moves)
	{
	    if(nmp.getMove() == move)
	    	return true;
	}
	
	return false;
    }
    
    public String toString()
    {
	return new String("X: " + m_x + ", Y: " + m_y);
    }
    
    public void addBlockedRoute(ArrayList<NodeMovePair> blocked)
    {
	for (int i = 0; i < blocked.size(); i++)
	{
	    NodeMovePair nodeMovePairB = blocked.get(i);
	    
	    for (int a = 0; a < m_pos_moves.size(); a++)
	    {
		NodeMovePair nodeMovePair = m_pos_moves.get(a);
		
		if(nodeMovePair.equals(nodeMovePairB)) 
		{
		    m_pos_moves.remove(nodeMovePair);
		}
		else
		{
		    switch(nodeMovePairB.getMove())
		    {
		    	case NORTH:
		    	    if(nodeMovePair.equals(
		    		    new NodeMovePair(GridMove.SOUTH, 
		    			    new GridNode(nodeMovePair.getNode().getPosX(), nodeMovePair.getNode().getPosY()))))
		    		m_pos_moves.remove(nodeMovePair);
		    	    break;
		    	case EAST:
		    	    if(nodeMovePair.equals(
		    		    new NodeMovePair(GridMove.WEST, 
		    			    new GridNode(nodeMovePair.getNode().getPosX(), nodeMovePair.getNode().getPosY()))))
		    		m_pos_moves.remove(nodeMovePair);
		    	    break;
		    	case SOUTH:
		    	    if(nodeMovePair.equals(
		    		    new NodeMovePair(GridMove.NORTH, 
		    			    new GridNode(nodeMovePair.getNode().getPosX(), nodeMovePair.getNode().getPosY()))))
		    		m_pos_moves.remove(nodeMovePair);
		    	    break;
		    	case WEST:
		    	    if(nodeMovePair.equals(
		    		    new NodeMovePair(GridMove.EAST, 
		    			    new GridNode(nodeMovePair.getNode().getPosX(), nodeMovePair.getNode().getPosY()))))
		    		m_pos_moves.remove(nodeMovePair);
		    	    break;
		    }
		}
	    }
	}
    }
}
