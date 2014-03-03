package part1.search.problem.jumbled;


/**
 * A class that represents a move for the JubmblePuzzle.
 * 
 * @author root
 *
 */
public class JumbleMove
{
    /**
     * Moves represented as int's.
     */
    private final int m_a;
    private final int m_b;
    
    /**
     * If the moves are not equal, setup the JumbleMove.
     * 
     * @param _a
     * @param _b
     */
    public JumbleMove(int _a, int _b)
    {
	if(_a == _b)
	{
	    System.out.println("Moves should not be equal: " + _a + ", " + _b);
	    System.exit(0);
	}
	m_a = _a;
	m_b = _b;
    }

    /**
     * Get move a.
     * 
     * @return
     */
    public int getMoveA(){ return m_a; }
    
    /**
     * Get move b.
     * 
     * @return
     */
    public int getMoveB(){ return m_b; }
    
    public boolean equals(JumbleMove move)
    {
	return this.equals(move.getMoveA(), move.getMoveB());
    }
    
    public boolean equals(int a, int b)
    {
	return (a == m_a && b == m_b) || (b == m_a && a == m_b);
    }
    
    @Override
    public String toString()
    {
	return new String("Swap positions: " + m_a + " AND " + m_b + ".");
    }
}