package part1.search.problem.grid;

import part1.search.problem.grid.GridPuzzle.GridMove;

public class NodeMovePair
{
    private final GridNode m_node;
    private final GridMove m_move;
    
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
//	System.out.println(m_node.equals(nodeMovePair.getNode()));
//	System.out.println(m_move.equals(nodeMovePair.getMove()));
//	System.out.println(nodeMovePair);
//	System.out.println();
	
	return m_node.equals(nodeMovePair.getNode()) 
		&& 
		m_move.equals(nodeMovePair.getMove());
    }
    
    public String toString()
    {
	return new String(m_move + " : " + m_node.toString());
    }
}
