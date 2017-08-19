package handler.printhandler.menu;

import model.Player;

public interface Menu {
	void createMenu(int menuType);

	void createMenu(int menuType, int finalScore);

	void createMenu(int menuType, Player player, Player computer, int playerHandValue,
			int computerHandValue);
}
