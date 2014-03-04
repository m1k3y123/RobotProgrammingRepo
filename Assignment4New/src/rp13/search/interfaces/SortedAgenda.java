package rp13.search.interfaces;

/**
 * An interface to define a sorted agenda for use in a search implementation
 * 
 * @author Nick Hawes
 * 
 * @param <ItemT>
 *            The type of the item contained in the agenda.
 */
public interface SortedAgenda<ItemT extends Comparable<ItemT>> extends
		Agenda<ItemT> {

	/**
	 * Sort the agenda.
	 */
	public void sort();

}
