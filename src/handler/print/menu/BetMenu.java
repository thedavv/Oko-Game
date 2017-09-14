package handler.print.menu;

import app.Screen;
import util.Const;

/**
 * Creates menu for betting
 * 
 */
public class BetMenu extends LineCreation implements MenuCreation {

	@Override
	public String createMenu() {
		StringBuilder sb = new StringBuilder();
		int bet = Screen.getBet();
		sb.append(drawLine(settings.getMenuLenght(), Const.TLC, Const.TRC, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, "SET YOUR BET"));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.LMJ, Const.RMJ, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, "Bet last Round : " + bet));
		sb.append("\n");
		sb.append(
				drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, "Maximum bet is : " + Const.MAX_BET));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.BLC, Const.BRC, Const.HL, null));

		return sb.toString();
	}

}
