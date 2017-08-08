package util;

public class Settings {
	private static Settings instance;
	private int cardSizeX;
	private int cardSizeY;
	private int spaceBetweenPlayers;

	private Settings(){
		this.cardSizeX = Const.CARD_SIZE_X;
		this.cardSizeY = Const.CARD_SIZE_Y;
		this.spaceBetweenPlayers = Const.SPACE_BETWEEN_PLAYERS;
	}

	public static Settings getInstance(){
		if(instance == null){
			instance = new Settings();
		}
		return instance;
	}
	
	public void setCardSize(int cardSizeX, int cardSizeY) throws DimensionsException{
		if(cardSizeX < 6 || cardSizeY < 6){
			throw new DimensionsException("Bad card size dimension. Min dimensions are [6,6] " + "card x-lenght: " 
					+ cardSizeX + " card y-lenght: " + cardSizeY,new int[]{cardSizeX, cardSizeY});
		}
		
		this.cardSizeX =cardSizeX;
		this.cardSizeY = cardSizeY;
	}
	
	public int getCardSizeX() {
		return cardSizeX;
	}

	public int getCardSizeY() {
		return cardSizeY;
	}

	public int getSpaceBetweenPlayers() {
		return spaceBetweenPlayers;
	}

	public void setSpaceBetweenPlayers(int spaceBetweenPlayers) {
		this.spaceBetweenPlayers = spaceBetweenPlayers;
	}

	
	
}
