package rp13.search.interfaces;

/**
 * An interface to define an agenda for use in a search implementation
 * 
 * @author Nick Hawes
 * 
 * @param <ItemT>
 *            The type of the item contained in the agenda.
 */
public interface Agenda<ItemT> extends Iterable<ItemT> {

	/**
	 * Adds the given item to the agenda.
	 * 
	 * @param _item
	 */
	void push(ItemT _item);

	/**
	 * Returns the next item from the agenda, removing it in the process.
	 * 
	 * @return
	 */
	ItemT pop();

	/**
	 * Returns true if the agenda is empty
	 * 
	 * @return
	 */
	boolean isEmpty();

	/**
	 * Returns true if the agenda contains the given item.
	 * 
	 * @param _item
	 * @return
	 */
	boolean contains(ItemT _item);

}
