package part1.search.problem.grid;

import java.util.ArrayList;

/**
 * This class represents a grid layout of size WIDTH * HEIGHT.
 * 
 * @author mike
 *
 */
public class GridPuzzle
{
    // enum moves.
    public enum GridMove
    {
	NORTH(-3), EAST(3), SOUTH(-1), WEST(1);

	private final int m_move;

	private GridMove(int _move)
	{
	    m_move = _move;
	}
	
	public GridMove getOppositeMove(GridMove move)
	{
	    switch(move)
	    {
	    case NORTH:
		return SOUTH;
	    case SOUTH:
		return NORTH;
	    case EAST:
		return WEST;
	    case WEST:
		return EAST;
	    default:
		return NORTH;
		
	    }
	}

    }

    // Stores the width of the grid (nodes).
    private final int 			WIDTH;
    
    // Stores the height of the grid (nodes).
    private final int 			HEIGHT;

    // Stores the x position of the agent on the grid.
    private int 			m_cur_x;

    // Stores the y position of the agent on the grid.
    private int 			m_cur_y;
    
    // Stores the size of the grid for ease of access.
    private int 			m_size;
    
    // Stores an ArrayList of nodes (no. of nodes = WIDTH * HEIGHT)
    private ArrayList<GridNode> 	m_nodes;
    
    // Stores an ArrayList of blocked NodeMovePairs.
    private ArrayList<NodeMovePair> 	m_blocked;
    
    /**
     * Constructor for GridPuzzle.
     * 
     * @param height
     * @param width
     * @param blocked
     */
    public GridPuzzle(int height, int width, ArrayList<NodeMovePair> blocked)
    {
	// Set private variables.
	WIDTH 		= width;
	HEIGHT 		= height;
	m_nodes 	= new ArrayList<GridNode>();
	m_cur_y 	= 0;
	m_cur_x 	= 0;
	m_size 		= WIDTH * HEIGHT;
	m_blocked 	= blocked;
	
	// Create new grid nodes for the grid puzzle.
	for(int i = 0; i < HEIGHT; i++)
	    for(int a = 0; a < WIDTH; a++)
		m_nodes.add(new GridNode(a, i));
	
	// Set the possible moves for each GridNode.
	for(int i = 0; i < HEIGHT; i++)
	{
	    for(int a = 0; a < WIDTH; a++)
	    {
		ArrayList<NodeMovePair> pos_moves = new ArrayList<NodeMovePair>();
				
		if(i != 0) pos_moves.add(new NodeMovePair(GridMove.SOUTH, getNodeByCoords(a, i - 1)));
		if(i != HEIGHT - 1) pos_moves.add(new NodeMovePair(GridMove.NORTH, getNodeByCoords(a, i + 1)));
		if(a != 0) pos_moves.add(new NodeMovePair(GridMove.WEST, getNodeByCoords(a - 1, i)));
		if(a != WIDTH - 1) pos_moves.add(new NodeMovePair(GridMove.EAST, getNodeByCoords(a + 1, i)));
	
		getNodeByCoords(a, i).setPossibleMoves(pos_moves);		
	    }
	}
	
	// Add the blocked routes to the grid nodes.
	addBlockedRoutes(m_blocked);
    }
    
    /**
     * Constructor for GridPuzzle(GridPuzzle)
     * 
     * This will be used to duplicate a GridPuzzle object.
     * 
     * @param puzzle
     */
    public GridPuzzle(GridPuzzle puzzle)
    {
	WIDTH 		= puzzle.WIDTH;
	HEIGHT 		= puzzle.HEIGHT;
	m_cur_y 	= puzzle.m_cur_y;
	m_cur_x 	= puzzle.m_cur_x;
	m_size 		= WIDTH * HEIGHT;
	m_nodes 	= puzzle.m_nodes;
	m_blocked 	= puzzle.m_blocked;
    }
    
    public GridNode getNodeByCoords(int x, int y)
    {
	for (GridNode node : m_nodes)
	{   
	    if(node.equals(x, y))
		return node;
	}
	    
	return null;
    }
    
    public ArrayList<GridNode> getNodes()
    {
	return m_nodes;
    }
    
    public boolean isPossibleMove(GridMove move)
    {
	return getNodeByCoords(m_cur_x, m_cur_y).isPossibleMove(move) ? true : false;
    }
    
    /**
     * makeMove method.
     * 
     * This method simply increments/decrements the x/y value of this
     * object to emulate a move.
     * 
     * @param move
     * @return
     */
    public boolean makeMove(GridMove move)
    {
	if(isPossibleMove(move))
	{
	    switch(move)
	    {
		case NORTH:
		    m_cur_y++;
	    	    break;
		case SOUTH:
		    m_cur_y--;
		    break;
		case WEST:
		    m_cur_x--;
		    break;
		case EAST:
		    m_cur_x++;
		    break;
	    }
	    
	    return true;
	}
	else 
	    return false;
	    
    }
    
    public GridNode getCurrentNode()
    {
	return getNodeByCoords(m_cur_x, m_cur_y);
    }
    
    private void addBlockedRoutes(ArrayList<NodeMovePair> blocked)
    {
	for (GridNode node : m_nodes)
	    node.addBlockedRoute(blocked);
    }
    
    public void setPosition(int x, int y)
    {
	if((x >= 0 && x <= WIDTH)
		&&
		(y >= 0 && y <= HEIGHT))
	{
	    m_cur_x = x;
	    m_cur_y = y;
	}
    }
    
    public String toString()
    {
	return new String(m_cur_x + ", " + m_cur_y);
    }
}
