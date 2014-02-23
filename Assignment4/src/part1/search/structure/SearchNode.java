package part1.search.structure;

import java.util.ArrayList;

import rp13.search.util.ActionStatePair;

/**
 * Represents a search node in a search.
 * 
 * 
 * @author root
 *
 */
public interface SearchNode<ActionT, StateT> 
{
    /**
     * Will return a list of parent actions.
     * 
     * @return
     */
    public ArrayList<ActionStatePair<ActionT, StateT>> getParents();
   
    /**
     * Will add successors to a list.
     * 
     * @return
     */
    public void getSuccessors(ArrayList<ActionStatePair<ActionT, StateT>> successors);
    
    /**
     * Returns the state of the node.
     * 
     * @return
     */
    public StateT getState();
    
    /**
     * Returns the action that was performed on the previous state to get to the current state. 
     * NULL if state state.
     * 
     * @return
     */
    public ActionT getAction();
    
    /**
     * Returns whether or not this state is the goal.
     * 
     * @return
     */
    public boolean isGoal(StateT state);
}
