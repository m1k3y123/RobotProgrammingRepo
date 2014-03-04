package part1.search.problem.grid;

import part1.search.problem.grid.GridPuzzle.GridMove;

/**
 * This class represents a move and node pair.
 * 
 * @author mike
 *
 */
public class NodeMovePair
{
    private final GridNode m_node;
    private final GridMove m_move;
    
    /**
     * Constructor for NodeMovePair.
     * 
     * @param move
     * @param node
     */
    public NodeMovePair(GridMove move, GridNode node)
    {
	m_move = move;
	m_node = node;
    }
    
    public GridMove getMove()
    {
	return m_move;
    }
    
    public GridNode getNode()
    {
	return m_node;
    }
    
    public boolean equals(NodeMovePair nodeMovePair)
    {
	return m_node.equals(nodeMovePair.getNode()) 
		&& 
		m_move.equals(nodeMovePair.getMove());
    }
    
    public String toString()
    {
	return new String(m_move + " : " + m_node.toString());
    }
}
