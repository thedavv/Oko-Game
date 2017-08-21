package handler.print.menu;

import model.Player;

public interface Menu {
	void createMenu(int menuType);

	void createMenu(int menuType, String data);
	
	void createMenu(int menuType, int finalScore);

	void createMenu(int menuType, Player player, int playerHandValue);

	void createMenu(int menuType, int playerHandValue, int playerBank, int ComputerBank);

	void createMenu(int menuType, Player player, Player computer, int playerHandValue,
			int computerHandValue, boolean playerWon);
	
}
