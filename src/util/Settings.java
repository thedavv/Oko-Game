package util;

import model.Player;

public class Settings {
	private static Settings	instance;
	private int				menuLenght				= Const.DRAW_MENU_X_SIZE;
	private int				cardSizeX				= Const.CARD_SIZE_X;
	private int				cardSizeY				= Const.CARD_SIZE_Y;
	// TODO add exceptions for setters
	private int				spaceBetweenPlayers		= Const.SPACE_BETWEEN_PLAYERS;
	private int				cardPartialSizeX		= Const.CARD_PARTIAL_SIZE_X;
	private int				drawStyle				= Const.DRAW_PLAYERS_CARDS_MIRROR_WAY;
	private int				playersBeginingMoney	= Const.PLAYERS_MONEY_BEGINING;
	private int				computersBeginingMoney	= Const.PLAYERS_MONEY_BEGINING;
	private int				beginningScore			= Const.MAX_SCORE;
	private int				minimalBet				= Const.MIN_BET;
	private int				maximalBet				= Const.MAX_BET;
	private Player			player					= new Player("player");
	private Player			computer				= new Player("computer");

	private Settings() {
	}

	public static Settings getInstance() {
		if (instance == null) {
			instance = new Settings();
		}
		return instance;
	}

	public void setCardSize(int cardSizeX, int cardSizeY) throws DimensionsException {
		if (cardSizeX < 6 || cardSizeY < 6) {
			throw new DimensionsException(
					"Bad card size dimension. Min dimensions are [6,6] "
							+ "card x-lenght: " + cardSizeX + " card y-lenght: "
							+ cardSizeY,
					new int[] { cardSizeX, cardSizeY });
		}
		this.cardSizeX = cardSizeX;
		this.cardSizeY = cardSizeY;
	}

	public int getSpaceBetweenPlayers() {
		return spaceBetweenPlayers;
	}

	// TODO exception for small/ large pace
	public void setSpaceBetweenPlayers(int spaceBetweenPlayers) {
		this.spaceBetweenPlayers = spaceBetweenPlayers;
	}

	public int getCardSizeX() {
		return this.cardSizeX;
	}

	public int getCardSizeY() {
		return this.cardSizeY;
	}

	public int getCardPartialSizeX() {
		return cardPartialSizeX;
	}

	public void setCardPartialSizeX(int cardPartialSizeX) {
		this.cardPartialSizeX = cardPartialSizeX;
	}

	public int getDrawStyle() {
		return drawStyle;
	}

	public void setDrawStyle(int drawStyle) {
		this.drawStyle = drawStyle;
	}

	public int getPlayersBeginingMoney() {
		return playersBeginingMoney;
	}

	public void setPlayersBeginingMoney(int playersBeginingMoney) {
		this.playersBeginingMoney = playersBeginingMoney;
	}

	public int getComputersBeginingMoney() {
		return computersBeginingMoney;
	}

	public void setComputersBeginingMoney(int computersBeginingMoney) {
		this.computersBeginingMoney = computersBeginingMoney;
	}

	public int getBeginningScore() {
		return beginningScore;
	}

	public void setBeginningScore(int beginningScore) {
		this.beginningScore = beginningScore;
	}

	public int getMinimalBet() {
		return minimalBet;
	}

	public void setMinimalBet(int minimalBet) {
		this.minimalBet = minimalBet;
	}

	public int getMenuLenght() {
		return menuLenght;
	}

	public void setMenuLenght(int menuLenght) {
		this.menuLenght = menuLenght;
	}

	public void setPlayerName(String name){
		this.player.setName(name);
	}
	
	public void setComputerName(String name){
		this.computer.setName(name);
	}
	
	public Player getPlayer(){
		return player;
	}
	
	public Player getComputer(){
		return computer;
	}

	public int getMaximalBet() {
		return maximalBet;
	}

	public void setMaximalBet(int maximalBet) {
		this.maximalBet = maximalBet;
	}
}
