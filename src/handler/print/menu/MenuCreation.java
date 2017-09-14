package handler.print.menu;

import app.Screen;
import util.Settings;

/**
 * MenuCreation interface has method for creating a String representation of menu
 * It also has instances of Screen and Settings for accessing game settings and variables from app
 */
public interface MenuCreation {
	Settings settings = Settings.getInstance();
	Screen	 model	  = Screen.getInstance();

	/**
	 * Creates menu. Menu can be implemented diferent ways. But it must return a
	 * string representation of that menu.
	 * 
	 * @return String representation of menu
	 */
	String createMenu();
}
