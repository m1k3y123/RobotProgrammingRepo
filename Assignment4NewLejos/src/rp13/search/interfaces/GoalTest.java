/**
 * 
 */
package rp13.search.interfaces;

/**
 * 
 * Interface to encode a test if a state equals a goal
 * 
 * @author Nick Hawes
 * 
 */
public interface GoalTest<StateT> {

	/**
	 * Tests whether or not the given state is the goal for search or not.
	 * 
	 * @param _state
	 * @return
	 */
	public boolean isGoal(StateT _state);

}
