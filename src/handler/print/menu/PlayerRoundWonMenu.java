package handler.print.menu;

import app.Screen;
import util.Const;

/**
 * Creates the PlayerRoundWon menu. Use it when player wins the round
 */
public class PlayerRoundWonMenu extends LineCreation implements MenuCreation {

	@Override
	public String createMenu() {
		StringBuilder sb = new StringBuilder();
		String wonPlayerName = Screen.getPlayer().getName();
		String lostPlayerName = Screen.getComputer().getName();
		int wonPlayerHandValue = Screen.getPlayerHandValue();
		int lostPlayerHandValue = Screen.getComputerHandValue();

		sb.append(drawLine(settings.getMenuLenght(), Const.TLC, Const.TRC, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, wonPlayerName + " won the round"));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.LMJ, Const.RMJ, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				wonPlayerName + " hand value: " + wonPlayerHandValue));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				lostPlayerName + " hand value: " + lostPlayerHandValue));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.BLC, Const.BRC, Const.HL, null));

		return sb.toString();
	}
}
