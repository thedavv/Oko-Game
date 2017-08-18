package util;

import handler.DeckHandler;
import model.Player;
import model.deck.CardDeck;
import model.deck.CardDeckFactory;
import model.deck.Deck;

//TODO rework to static variables
public class Settings {
	private static Settings	instance;
	private int				cardSizeX;
	private int				cardSizeY;
	// TODO add exception for setting space too low
	private int				spaceBetweenPlayers;
	private Player			player;
	private Player			computer;
	private int				cardPartialSizeX;
	private int				drawStyle;
	private Deck			deck;
	private Deck			pile;

	// hanlers
	private CardDeckFactory	cardDeckFactory	= new CardDeckFactory();

	public static int		menuLenght		= Const.DRAW_MENU_X_SIZE;

	private Settings() {
		this.cardSizeX = Const.CARD_SIZE_X;
		this.cardSizeY = Const.CARD_SIZE_Y;
		this.spaceBetweenPlayers = Const.SPACE_BETWEEN_PLAYERS;
		this.player = new Player("player");
		this.computer = new Player("computer");
		this.cardPartialSizeX = Const.CARD_PARTIAL_SIZE_X;
		this.drawStyle = Const.DRAW_PLAYERS_CARDS_MIRROR_WAY;
		this.deck = cardDeckFactory.createCardDeck();
		this.pile = cardDeckFactory.createCardStack();
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

}
