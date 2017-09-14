package handler.print.menu;

import util.Settings;

public interface MenuIO {
	Settings settings = Settings.getInstance();
	
	public String createMenu(String data);
}
