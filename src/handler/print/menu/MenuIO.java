package handler.print.menu;

import util.Settings;

/**
 * MenuIO interface has method for creating a String representation of menu Use
 * this interface for menu that needs to input String from other sources than
 * app variables.
 */
public interface MenuIO {
	Settings settings = Settings.getInstance();

	/**
	 * Creates menu. Menu can be implemented diferent ways. But it must return a
	 * string representation of that menu.
	 * 
	 * @param data
	 *            is the String representation of IO data that user wants to
	 *            print out
	 * @return String representation of Menu
	 */
	public String createMenu(String data);
}
