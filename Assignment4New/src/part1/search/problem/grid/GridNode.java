package part1.search.problem.grid;

import java.util.ArrayList;

import part1.search.problem.grid.GridPuzzle.GridMove;

/**
 * Represents a node on the GridPuzzle.
 * 
 * @author mike
 *
 */
public class GridNode
{
    // Stores the x position of the node.
    private int m_x;
    
    // Stores the y position of the node.
    private int m_y;
    
    // Stores a list of NodeMovePair's of possible moves from this node.
    private ArrayList<NodeMovePair> m_pos_moves;
    
    /**
     * Constructor for GridNode.
     * 
     * @param x
     * @param y
     */
    public GridNode(int x, int y)
    {
	m_x = x;
	m_y = y;
    }
    
    /**
     * Used to set the possible moves of the node.
     * It will be called once all of the nodes for a particular
     * GridPuzzle have been created.
     * 
     * @param pos_moves
     */
    public void setPossibleMoves(ArrayList<NodeMovePair> pos_moves)
    {
	m_pos_moves = pos_moves;
    }
    
    /**
     * equals method (GridNode).
     * 
     * This method tests for equality by using a passed GridNode.
     */
    public boolean equals(GridNode node)
    {
	int x = node.getPosX();
	int y = node.getPosY();
	
	if(m_x != x || m_y != y)
	    return false;
	else
	    return true;
    }
    
    /**
     * equals method (int, int).
     * 
     * This method tests for equality by using passed co-ordinates.
     */
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
    
    /**
     * addBlockedRoute method.
     * 
     * This method will search a passed ArrayList
     * for any nodes that match once of the nodes
     * possible moves and will block them.
     * 
     * It will then check the blocked ArrayList for any
     * NodeMovePair's that could be blocked by moving
     * from another node to this one.
     * 
     * The method makes sure that both directions for a 
     * blocked route are removed from the possible
     * moves of each GridNode.
     * 
     * @param blocked
     */
    public void addBlockedRoute(ArrayList<NodeMovePair> blocked)
    {
	// Loop through all of the blocked routes.
	for (int i = 0; i < blocked.size(); i++)
	{
	    NodeMovePair nodeMovePairB = blocked.get(i);
	    
	    // Loop through all of the possible moves for this grid node.
	    for (int a = 0; a < m_pos_moves.size(); a++)
	    {
		NodeMovePair nodeMovePair = m_pos_moves.get(a);
		
		// If the possible moves is equal to the blocked route remove it.
		if(nodeMovePair.equals(nodeMovePairB)) 
		{
		    m_pos_moves.remove(nodeMovePair);
		}
		else
		{
		    // Switch through the blocked move.
		    // If the blocked move would result in this node being visited, remove it.
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
