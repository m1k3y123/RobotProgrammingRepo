/**
 * 
 */
package rp13.search.interfaces;

import java.util.ArrayList;

/**
 * 
 * Defines an interface that can be used by a search algorithm to get the
 * successor of a given state.
 * 
 * @author Nick Hawes
 * 
 */
public interface SuccessorFunction<SearchNode, StateT, ActionT> {

	/**
	 * Adds each successor of the given state to the end of the _successors
	 * list, along with the action that generated it. The _successors list is
	 * not cleared by this method.
	 * 
	 * @param _state
	 * @param _successors
	 */
	public void getSuccessors(SearchNode SearchNode, ArrayList<SearchNode> _successors, ArrayList<SearchNode> _parents);

}
