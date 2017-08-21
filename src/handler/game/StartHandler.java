package handler.game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;

import model.cardfactory.Card;
import model.deck.Deck;
import util.Const;
import util.Settings;

/**
 * Class contains helpful methods for checking rules and handling the counts of
 * cards in hand
 */
public class StartHandler {
	Settings settings = Settings.getInstance();

	/**
	 * Method for counting cards in hand
	 *
	 * @param hand
	 *            is players hand
	 * @return total int card value in hand
	 */
	public int countCardsInHand(List<Card> hand) {
		int handValue = 0;
		for (Card card : hand) {
			handValue += card.getValue().getIntValue();
		}
		return handValue;
	}

	/**
	 * Method for calculating if hand exceeded max hand value
	 *
	 * @param handValue
	 *            players cards value
	 * @return true if hand exceeded the max hand value defined in
	 *         <code>Const</Settings> class
	 */
	public boolean isHandValueMoreThanMaxValue(int handValue) {
		return (handValue > Const.MAX_HAND_VALUE) ? true : false;
	}

	public Deck shufflePileIntoDeck(Deck cardDeck, Deck cardPile) {
		cardDeck.addCards(cardPile.getAllCards());
		cardDeck.shuffle();

		return cardDeck;
	}

	public int substractBetValue(int bet, int playerBank) {
		return playerBank - bet;
	}

	public int addBetValue(int bet, int playerBank) {
		return playerBank + bet;
	}

	public int updateScorePlayerLost(int bet, int score) {
		if (score - bet < 0) {
			return 0;
		}
		return score - bet;
	}

	public int updateScorePlayerWon(int bet, int score) {
		if (bet > settings.getMaximalBet()) {
			return score + bet * 2;
		}
		return score + bet;
	}

	public boolean isBankZero(int playerBank) {
		return (playerBank <= 0) ? true : false;
	}

	public int setBet(Scanner sc) {
		int bet = sc.nextInt();

		if ((bet < settings.getMinimalBet()) || (bet > settings.getMaximalBet())) {
			System.err.println(
					"bad input setting to minimal input: " + settings.getMinimalBet());
			bet = settings.getMinimalBet();
		}

		return bet;
	}

	public int setBetDoubleDown(Scanner sc, int bet) {
		String s = sc.next();

		switch (s) {
			case "1":
				bet *= 2;
				break;
			case "2":
				break;

			default:
				System.out.println("bad input");
				break;
		}

		return bet;
	}

	// TODO
	public void storeFinalScore(String playerName, int finalScore, File file) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
			bw.write("Player: " + playerName + " Score: " + finalScore);
			bw.newLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getFinalScoreLeaderboard(File file) {
		StringBuilder sb = new StringBuilder();

		if (file.exists()) {
			try (BufferedReader br = new BufferedReader(new FileReader(file))) {
				String line = br.readLine();

				while (line != null) {
					sb.append(line);
					line = br.readLine();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
}
