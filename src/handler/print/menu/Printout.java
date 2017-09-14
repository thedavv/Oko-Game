package handler.print.menu;

/**
 * All clases that are printing out MenuCreation or MenuIO must implement this
 * interface.
 * 
 */
public interface Printout {
	/**
	 * Prints out menu to console
	 * 
	 * @param menu
	 *            is MenuCreation type menu
	 */
	void printOutMenu(MenuCreation menu);

	/**
	 * Prints out IOmenu to console
	 * 
	 * @param menu
	 *            is MenuIO type menu
	 * @param data
	 *            is the string representation of IO data
	 */
	void printOutIOMenu(MenuIO menu, String data);
}
