package part1.search.problem.structure;

import java.util.ArrayList;

/**
 * Represents a search node in a search.
 * 
 * 
 * @author root
 *
 */
@SuppressWarnings("hiding")
public interface SearchNode<SearchNode, ActionT, StateT>  extends Comparable<SearchNode>
{
    /**
     * Will return a list of parent actions.
     * 
     * @return
     */
    public ArrayList<SearchNode> getParents();
   
    /**
     * Will add successors to a list.
     * 
     * @return
     */
    public void getSuccessors(ArrayList<SearchNode> successors);
    
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
