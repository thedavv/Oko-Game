package handler.print.menu;

/**
 * Clears the console screen
 */
public class ClearScreen {
	public void clc() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
}
