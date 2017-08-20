package util;

import model.Player;
import model.deck.CardDeckFactory;
import model.deck.Deck;

//TODO rework to static variables
public class Settings {
	public static int		menuLenght				= Const.DRAW_MENU_X_SIZE;

	private static Settings	instance;
	private int				cardSizeX				= Const.CARD_SIZE_X;
	private int				cardSizeY				= Const.CARD_SIZE_Y;
	// TODO add exception for setting space too low
	private int				spaceBetweenPlayers		= Const.SPACE_BETWEEN_PLAYERS;
	private Player			player					= new Player("player");
	private Player			computer				= new Player("computer");
	private int				cardPartialSizeX		= Const.CARD_PARTIAL_SIZE_X;
	private int				drawStyle				= Const.DRAW_PLAYERS_CARDS_MIRROR_WAY;
	private int				playersBeginingMoney	= Const.PLAYERS_MONEY_BEGINING;
	private int				computersBeginingMoney	= Const.PLAYERS_MONEY_BEGINING;
	private int				finalScore				= Const.MAX_SCORE;
	private int				minimalBet				= Const.MIN_BET;
	private int				bet						= 2;

	private Deck			deck;
	private Deck			pile;
	// handlers
	private CardDeckFactory	cardDeckFactory			= new CardDeckFactory();

	private Settings() {
		this.deck = cardDeckFactory.createCardDeck();
		this.pile = cardDeckFactory.createCardDeck();
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

	// TODO exception for small large pace
	public void setSpaceBetweenPlayers(int spaceBetweenPlayers) {
		this.spaceBetweenPlayers = spaceBetweenPlayers;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayerName(String name) {
		this.player.setName(name);
	}

	public Player getComputer() {
		return computer;
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

	public int getDrawStyle() {
		return drawStyle;
	}

	public void setDrawStyle(int drawStyle) {
		this.drawStyle = drawStyle;
	}

	public Deck getDeck() {
		return deck;
	}

	public Deck getPile() {
		return pile;
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

	public int getFinalScore() {
		return finalScore;
	}
	
	public int getMinimalBet() {
		return minimalBet;
	}

	public void setMinimalBet(int minimalBet) {
		this.minimalBet = minimalBet;
	}

	public int getBet() {
		return bet;
	}

	public void setBet(int bet) {
		this.bet = bet;
	}
}
