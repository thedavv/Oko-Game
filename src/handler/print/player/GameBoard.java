package handler.printhandler.player;

import model.Player;

public interface GameBoard {
	public void drawGameBoard(int style, Player player, Player computer);
	public void drawGameBoard(int style, Player player);
}
