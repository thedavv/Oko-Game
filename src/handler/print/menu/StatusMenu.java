package handler.print.menu;

import app.Screen;
import util.Const;

/**
 * Creates the StatusMenu menu. it contains status of current round
 */
public class StatusMenu extends LineCreation implements MenuCreation {

	@Override
	public String createMenu() {
		int playerHandValue = Screen.getPlayerHandValue();
		int playerBank = Screen.getPlayerBank();
		int computerBank = Screen.getComputerBank();

		StringBuilder sb = new StringBuilder();
		sb.append(drawLine(settings.getMenuLenght(), Const.TLC, Const.TRC, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, "Status"));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.LMJ, Const.RMJ, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"Hand card value count : " + playerHandValue));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"Player bank remaining : " + playerBank));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP,
				"Computer bank remaining : " + computerBank));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, null));

		return sb.toString();
	}

}
