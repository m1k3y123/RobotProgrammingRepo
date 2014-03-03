package part1.search.problem.grid;

import java.util.ArrayList;

public class GridPuzzle
{
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

    private final int 			WIDTH;
    private final int 			HEIGHT;
    private int 			m_cur_x;
    private int 			m_cur_y;
    private int 			m_size;
    private ArrayList<GridNode> 	m_nodes;
    private ArrayList<NodeMovePair> 	m_blocked;
    
    public GridPuzzle(int height, int width)
    {
	WIDTH 		= width;
	HEIGHT 		= height;
	m_nodes 	= new ArrayList<GridNode>();
	m_cur_y 	= 1;
	m_cur_x 	= 0;
	m_size 		= WIDTH * HEIGHT;
	
	for(int i = 0; i < HEIGHT; i++)
	    for(int a = 0; a < WIDTH; a++)
		m_nodes.add(new GridNode(a, i));
	
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
    }
    
    public GridPuzzle(GridPuzzle puzzle)
    {
	WIDTH 		= puzzle.WIDTH;
	HEIGHT 		= puzzle.HEIGHT;
	m_nodes 	= puzzle.m_nodes;
	m_cur_y 	= puzzle.m_cur_x;
	m_cur_x 	= puzzle.m_cur_y;
	m_size 		= WIDTH * HEIGHT;
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
    
    public void addBlockedRoutes(ArrayList<NodeMovePair> blocked)
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
