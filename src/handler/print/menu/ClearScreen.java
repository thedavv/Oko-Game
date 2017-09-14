package handler.print.menu;

public class ClearScreen {
	public void clc() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
}
