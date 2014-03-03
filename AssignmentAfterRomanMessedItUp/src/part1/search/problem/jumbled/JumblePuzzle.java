package part1.search.problem.jumbled;

import java.util.ArrayList;
import java.util.Random;

import part1.utils.StringManipulator;

/**
 * 
 * A class that represents a jumbled string for example;
 * 
 * Can represent a jumbled string or a goal string.
 * 
 * @author michaelpearson
 *
 */

public class JumblePuzzle
{
    /**
     * State of the string currently.
     */
    private String m_state;
    
    /**
     * 
     * 
     */
    private ArrayList<JumbleMove> m_pos_moves;
    /**
     * Constructor when only the string is passed.
     * This stores an unjumbled string.
     * 
     * @param _string
     */
    public JumblePuzzle(String _string)
    {
	if(_string.trim().length() < 1)
	{
	    System.out.println("Attempted to create a puzzle with a string of 1 character or less.");
	    System.out.println("System will now exit.");
	    System.exit(0);
	}
	m_state = _string.trim();
    }
    
    public JumblePuzzle(String _string, boolean jumble)
    {
	if(_string.trim().length() <= 1)
	{
	    System.out.println("Attempted to create a puzzle with a string of 1 character or less.");
	    System.out.println("System will now exit.");
	    System.exit(0);
	}
	m_state = _string.trim();
	
	// Randomize the given string.
	if(jumble)
	    randomize();
	
    }
    
    public JumblePuzzle(JumblePuzzle puzzle)
    {
	m_pos_moves = puzzle.m_pos_moves;
	m_state = puzzle.m_state;
    }
    
    public void randomize()
    {	
	String[] random = new String[m_state.length()];
	ArrayList<String> chars = StringManipulator.stringToList(m_state);
	
	Random gen = new Random();
	int pos;
	
	for(int i = 0; i < m_state.length(); i++)
	{
	    pos = gen.nextInt(chars.size());
	    random[i] = chars.get(pos);
	    chars.remove(pos);
	}
	
	String builder = StringManipulator.arrayToString(random);
	
	if(builder.toString().equals(m_state))
	    randomize();
	else
	    m_state = builder;
    }
    
    /**
     * 
     * Checks against the current state and the goal to see if the positions passed
     * are not already in the correct place. It also checks they are not referencing the same
     * position.
     * 
     * @param a
     * @param b
     * @return boolean
     */
    public boolean isPossibleMove(JumbleMove move)
    {
	int a = move.getMoveA();
	int b = move.getMoveB();
	
	return 	(a >= 0 && a <= m_state.length()) 	
		&& 
		(b >= 0 && b <= m_state.length());
    }
    
    /**
     * 
     * Tests whether a move is possible, if it is, characters in the string are swapped.
     * Returns true if the swap was successful.
     * 
     * @param a
     * @param b
     * @return boolean
     */
    public boolean makeMove(JumbleMove move)
    {
	int a = move.getMoveA();
	int b = move.getMoveB();
	
	if(isPossibleMove(move))
	{
	    String[] random = StringManipulator.stringToArray(m_state);
	    
	    String hold = random[a];
	    random[a] = random[b];
	    random[b] = hold;
	    
	    m_state = StringManipulator.arrayToString(random);
	    
	    return true;
	}
	else
	    return false;
    }
  
    public ArrayList<JumbleMove> possibleMoves()
    {
	ArrayList<String> slist = StringManipulator.stringToList(m_state);
	ArrayList<JumbleMove> moves = new ArrayList<JumbleMove>();
	
	int size = slist.size();
	for(int i = 0; i < size - 1; i++)
	{
	    for(int a = i+1; a < size; a++)
	    {
		if(isPossibleMove(new JumbleMove(i, a)))
		    moves.add(new JumbleMove(i, a));
	    }
	}
	
	return moves;
    }
    
    @Override
    public String toString()
    {
	return m_state;
    }
    
    public int getManhattanDistance()
    {
	return 0;
    }
    
    public boolean equals(JumblePuzzle puzzle)
    {
	return m_state.toString().equals(puzzle.toString());
    }
}
