package model;

import java.util.List;

public final class Screen {
	private static Screen instance;
	
	private Player player;
	private Player computer;
	private List<StringBuilder> lines;
	
	public static Screen getInstance(){
		if(instance == null){
			instance = new Screen();
		}
		
		return instance;
	}
}
