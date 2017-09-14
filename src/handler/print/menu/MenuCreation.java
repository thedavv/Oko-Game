package handler.print.menu;

import app.Screen;
import util.Settings;

public interface MenuCreation {
	Settings settings = Settings.getInstance();
	Screen model = Screen.getInstance();
	
	String createMenu();
}
