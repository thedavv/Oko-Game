package util;

/**
 * Constants
 */
public class Const {
	/**
	 *	Space " "
	 */
	public static final char   SP  	  	= Character.MIN_VALUE;;
	
	/**
	 * Empty Space 
	 */
	public static final String EMPTY  	= "";
	
	/**
	 * zvysla ciara vertikala "┃"
	 */
	public static final char   VL  		= 9553;//9475;
	
	/**
	 * lavy horny roh "┎"
	 */
	public static final char   TLC 		= 9556;//9487;
	
	/**
	 * pravy horny roh "┓"
	 */
	public static final char   TRC 		= 9559;//9491;
	
	/**
	 * horizontala "━"
	 */
	public static final char   HL 		= 9552;//9473;
	
	/**
	 * vrchny spoj "┳"
	 */
	public static final char   TJ 		= 9574;//9523;
	
	/**
	 * dolny spoj "┻"
	 */
	public static final char   BJ 		= 9577;//9531;
	
	/**
	 * lavy dolny spoj "┗"
	 */
	public static final char   BLC 		= 9562;//9495;
	
	/**
	 * pravy dolny spoj "┛"
	 */
	public static final char   BRC      = 9565;//9499;
	
	/**
	 * Zelen "♠"
	 */
	public static final char   SPADES   = 9824;
	
	/**
	 * Zalud "♣"
	 */
	public static final char   CLUBS    = 9827;
	
	/**
	 * Cerven "♥"
	 */
	public static final char   HEARTHS  = 9829;
	
	/**
	 * Gula "♦"
	 */
	public static final char   DIAMONDS = 9830;
	
	/**
	 *  Enum Value lable
	 * */
	public static final String SEVEN = "7";
	public static final String EIGHT = "8";
	public static final String NINE  = "9";
	public static final String TEN   = "10";
	public static final String JACK  = "J";
	public static final String QUEEN = "Q";
	public static final String KING  = "K";
	public static final String ACE   = "A";
	
	/**
	 * Size of a card x and y
	 * */
	public static final int CARD_SIZE_X = 10;
	public static final int CARD_SIZE_Y = 8;
	
	/**
	 * Card print settings
	 * */
	public static final int 	SPACE_BETWEEN_PLAYERS = 7;
	public static final boolean PLAYER_PRINTOUT_STYLE = true;
	

//	public static final int DRAW_TOP_LINE    = 1;
//	public static final int DRAW_BOTTOM_LINE = 2;
//	public static final int DRAW_NUMBER_LINE = 3;
//	public static final int DRAW_COLOR_LINE  = 4;
//	public static final int DRAW_EMPTY_LINE  = 5;
	
	/**
	 * Constants for drawGameBoard method in handler package
	 * */
	public static final int DRAW_PLAYERS_CARDS_SAME_WAY    = 1;
	public static final int DRAW_PLAYERS_CARDS_MIRROR_WAY  = 2;
	public static final int DRAW_PLAYERS_CARDS_OPOSITE_WAY = 3;
	
	/**
	 * Constants for menu printout
	 * */
	public static final int  DRAW_MENU_X_SIZE = 53;
	public static final int  DRAW_MENU_Y_SIZE = 7;
	public static final char LMJ        	  = 9568;     //left middle join
	public static final char RMJ         	  = 9571;     //right middle join
	
	
	/**
	 * Ruleset
	 * */
	public static final int MAX_HAND_VALUE = 21;

}
