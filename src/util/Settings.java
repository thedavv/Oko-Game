package util;

import java.io.File;

import model.Player;

public class Settings {
	private static Settings	instance;
	private int				menuLenght			   = Const.DRAW_MENU_X_SIZE;
	private int				cardSizeX			   = Const.CARD_SIZE_X;
	private int				cardSizeY			   = Const.CARD_SIZE_Y;
	private int				spaceBetweenPlayers	   = Const.SPACE_BETWEEN_PLAYERS;
	private int				cardPartialSizeX	   = Const.CARD_PARTIAL_SIZE_X;
	private int				drawStyle			   = Const.DRAW_PLAYERS_CARDS_MIRROR_WAY;
	private int				playersBeginingMoney   = Const.PLAYERS_MONEY_BEGINING;
	private int				computersBeginingMoney = Const.PLAYERS_MONEY_BEGINING;
	private int				beginningScore		   = Const.MAX_SCORE;
	private int				minimalBet			   = Const.MIN_BET;
	private int				maximalBet			   = Const.MAX_BET;
	private Player			player				   = new Player("player");
	private Player			computer			   = new Player("computer");
	private File			scoreFile			   = new File("scoreboard.txt");

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

	public void setSpaceBetweenPlayers(int spaceBetweenPlayers)
			throws DimensionsException {
		if (spaceBetweenPlayers > Const.MAX_SPACE_BETWEEN_PLAYERS
				|| spaceBetweenPlayers < Const.MIN_SPACE_BETWEEN_PLAYERS) {
			throw new DimensionsException("Bad card size dimenzion. Max card dimenzion is"
					+ Const.MAX_SPACE_BETWEEN_PLAYERS + "Min card dimenzion is"
					+ Const.MIN_SPACE_BETWEEN_PLAYERS);
		}
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

	public void setCardPartialSizeX(int cardPartialSizeX) throws DimensionsException {
		if ((cardPartialSizeX > cardSizeX - 1) || (cardPartialSizeX < 3)) {
			throw new DimensionsException(
					"Bad imput for printing out bottom card. Max dimension: "
							+ (cardSizeX - 1) + "Min dimension: "
							+ Const.MIN_BOTOM_CARD_SIZE);
		}

		this.cardPartialSizeX = cardPartialSizeX;
	}

	public int getDrawStyle() {
		return drawStyle;
	}

	public void setDrawStyle(int drawStyle) throws InvalidArgumentException {
		switch (drawStyle) {
			case Const.DRAW_PLAYERS_CARDS_SAME_WAY_TOP_CARD_LEFT:
				drawStyle = Const.DRAW_PLAYERS_CARDS_SAME_WAY_TOP_CARD_LEFT;
				break;
			case Const.DRAW_PLAYERS_CARDS_SAME_WAY_TOP_CARD_RIGHT:
				drawStyle = Const.DRAW_PLAYERS_CARDS_SAME_WAY_TOP_CARD_RIGHT;
				break;
			case Const.DRAW_PLAYERS_CARDS_MIRROR_WAY:
				drawStyle = Const.DRAW_PLAYERS_CARDS_MIRROR_WAY;
				break;
			case Const.DRAW_PLAYERS_CARDS_REVERSE_MIRROR_WAY:
				drawStyle = Const.DRAW_PLAYERS_CARDS_REVERSE_MIRROR_WAY;
				break;
			default:
				throw new InvalidArgumentException("Selected Draw style doesnt exist.");
		}
		this.drawStyle = drawStyle;
	}

	public int getPlayersBeginingMoney() {
		return playersBeginingMoney;
	}

	public void setPlayersBeginingMoney(int playersBeginingMoney)
			throws InvalidArgumentException {
		if (playersBeginingMoney < 1) {
			throw new InvalidArgumentException("Player money cant be less then 1");
		}
		this.playersBeginingMoney = playersBeginingMoney;
	}

	public int getComputersBeginingMoney() {
		return computersBeginingMoney;
	}

	public void setComputersBeginingMoney(int computersBeginingMoney)
			throws InvalidArgumentException {
		if (computersBeginingMoney < 1) {
			throw new InvalidArgumentException("Computer money cant be less then 1");
		}
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

	public void setMinimalBet(int minimalBet) throws InvalidArgumentException {
		if (minimalBet < 0 || minimalBet >= Const.MAX_BET) {
			throw new InvalidArgumentException(
					"Bet cant be more than maximal bet, or less than 0");
		}
		this.minimalBet = minimalBet;

	}

	public int getMenuLenght() {
		return menuLenght;
	}

	public void setMenuLenght(int menuLenght) throws DimensionsException {
		if (menuLenght < Const.DRAW_MENU_X_SIZE) {
			throw new DimensionsException(
					"menu cant be less than: " + Const.DRAW_MENU_X_SIZE);
		}
		this.menuLenght = menuLenght;
	}

	public void setPlayerName(String name) throws InvalidArgumentException {
		if (name.length() < 1) {
			throw new InvalidArgumentException("Name cant be blank space");
		}
		this.player.setName(name);
	}

	public void setComputerName(String name) throws InvalidArgumentException {
		if (name.length() < 1) {
			throw new InvalidArgumentException("Name cant be blank space");
		}
		this.computer.setName(name);
	}

	public Player getPlayer() {
		return player;
	}

	public Player getComputer() {
		return computer;
	}

	public int getMaximalBet() {
		return maximalBet;
	}

	public void setMaximalBet(int maximalBet) throws InvalidArgumentException {
		if (maximalBet <= Const.MIN_BET || maximalBet > playersBeginingMoney
				|| maximalBet > computersBeginingMoney) {
			throw new InvalidArgumentException(
					"Maximal bet can be less than minimal bet or more than starting money");
		}
		this.maximalBet = maximalBet;
	}

	public File getScoreFile() {
		return scoreFile;
	}
}
