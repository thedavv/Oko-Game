package handler.print.menu;

import app.Screen;
import util.Const;
/**
 * Creates the Lost menu Screen
 */
public class LostMenu extends LineCreation implements MenuCreation {

	@Override
	public String createMenu() {
		StringBuilder sb = new StringBuilder();
		int finalScore = Screen.getScore();
		sb.append(drawLine(settings.getMenuLenght(), Const.LMJ, Const.RMJ, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, "YOU LOST THE GAME :("));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.LMJ, Const.RMJ, Const.HL, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(
				drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, "YOUR FINAL SCORE IS: " + finalScore));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.VL, Const.VL, Const.SP, null));
		sb.append("\n");
		sb.append(drawLine(settings.getMenuLenght(), Const.BLC, Const.BRC, Const.HL, null));

		return sb.toString();
	}

}
