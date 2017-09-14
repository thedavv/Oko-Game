package handler.print.player;

import java.util.List;

/**
 * Use this class for creating partial and full lines, that are used for Drawing
 * game board
 *
 */
public class LineCreation {
	/**
	 * Creates complete line new card on bottom, from Left to Right
	 * 
	 * @param handSize
	 *            is the count of all players cards
	 * @param sizeX
	 *            is the card size X use value form settings
	 * @param sizePartial
	 *            is the partial size printed out below the main card
	 * @param leftBorder
	 *            is the left card border
	 * @param rightBorder
	 *            is the left card border
	 * @param join
	 *            is the join between cards
	 * @param middleSection
	 *            is the section between left and right border
	 * @param middleSectionText
	 *            is the text section between left and right border. use null if
	 *            there is no text
	 * @return string representation of full line
	 */
	@Deprecated
	public String createCompleteLineLROld(int handSize, int sizeX, int sizePartial, String leftBorder,
			String rightBorder, String join, String middleSection, List<String> middleSectionText) {
		StringBuilder sb = new StringBuilder();

		// if null
		if (middleSectionText == null) {
			sb.append(createLeftSideOfLine(sizeX / 2, leftBorder, middleSection, null));

			// hand size - first card - last card
			for (int i = 1; i < handSize - 1; i++) {
				sb.append(createRightSideOfLine(sizePartial, join, middleSection, null));
			}
			// has hand one card?
			if (handSize > 1) {
				sb.append(createRightSideOfLine(sizePartial, rightBorder, middleSection, null));
				// append after first left side
				sb.insert(sizeX / 2, createRightSideOfLine(sizeX / 2, join, middleSection, null));
			} else {
				sb.append(createRightSideOfLine(sizeX / 2, rightBorder, middleSection, null));
			}
			// not null
		} else {
			sb.append(createLeftSideOfLine(sizeX / 2, leftBorder, middleSection, middleSectionText.get(0)));
			// hand size - first card - last card
			for (int i = 1; i < handSize - 1; i++) {
				sb.append(createRightSideOfLine(sizePartial, join, middleSection, middleSectionText.get(i)));
			}
			// if hand size is one skip
			if (handSize > 1) {
				sb.append(createRightSideOfLine(sizePartial, rightBorder, middleSection,
						middleSectionText.get(handSize - 1)));
				// append fitst right side
				sb.insert(sizeX / 2, createRightSideOfLine(sizeX / 2, join, middleSection, middleSectionText.get(0)));
			} else {
				sb.append(createRightSideOfLine(sizeX / 2, rightBorder, middleSection, middleSectionText.get(0)));
			}
		}
		return sb.toString();
	}

	/**
	 * Creates complete line new card on bottom, from Right to Left
	 * 
	 * @param handSize
	 *            is the count of all players cards
	 * @param sizeX
	 *            is the card size X use value form settings
	 * @param sizePartial
	 *            is the partial size printed out below the main card
	 * @param leftBorder
	 *            is the left card border
	 * @param rightBorder
	 *            is the left card border
	 * @param join
	 *            is the join between cards
	 * @param middleSection
	 *            is the section between left and right border
	 * @param middleSectionText
	 *            is the text section between left and right border. use null if
	 *            there is no text
	 * @return string representation of full line
	 */
	@Deprecated
	public String createCompleteLineRLOld(int handSize, int sizeX, int sizePartial, String leftBorder,
			String rightBorder, String join, String middleSection, List<String> middleSectionText) {
		StringBuilder sb = new StringBuilder();

		// if null
		if (middleSectionText == null) {
			// append right side
			sb.append(createRightSideOfLine(sizeX / 2, rightBorder, middleSection, null));
			// hand size - first card - last card
			for (int i = 1; i < handSize - 1; i++) {
				sb.insert(0, createLeftSideOfLine(sizePartial, join, middleSection, null));
			}
			// has hand one card?
			if (handSize > 1) {
				sb.insert(0, createLeftSideOfLine(sizePartial, leftBorder, middleSection, null));
				// append after first left side
				sb.insert(sb.length() - sizeX / 2, createLeftSideOfLine(sizeX / 2, join, middleSection, null));
			} else {
				sb.insert(0, createLeftSideOfLine(sizeX / 2, leftBorder, middleSection, null));
			}
			// not null
		} else {
			// append right side
			sb.append(createRightSideOfLine(sizeX / 2, rightBorder, middleSection, middleSectionText.get(0)));
			// hand size - first card - last card
			for (int i = 1; i < handSize - 1; i++) {
				sb.insert(0, createLeftSideOfLine(sizePartial, join, middleSection, middleSectionText.get(i)));
			}
			// has hand one card?
			if (handSize > 1) {
				sb.insert(0, createLeftSideOfLine(sizePartial, leftBorder, middleSection,
						middleSectionText.get(handSize - 1)));
				// append after first left side
				sb.insert(sb.length() - sizeX / 2,
						createLeftSideOfLine(sizeX / 2, join, middleSection, middleSectionText.get(0)));
			} else {
				sb.insert(0, createLeftSideOfLine(sizeX / 2, leftBorder, middleSection, middleSectionText.get(0)));
			}
		}
		return sb.toString();
	}

	/**
	 * Creates right partial line. From middle of card to most right side
	 * 
	 * @param cardLenght
	 *            is the lenght of a card. Use settings
	 * @param rightBorder
	 *            is the right border of card
	 * @param middleSection
	 *            is the middle section of a card between left and right border
	 * @param middleSectionText
	 *            is the middle text section of a card between left and right
	 *            border. use null if there is no text
	 * @return String representation of partial right line
	 */
	public String createRightSideOfLine(int cardLenght, String rightBorder, String middleSection,
			String middleSectionText) {
		StringBuilder sb = new StringBuilder();
		// no text
		if (middleSectionText == "" || middleSectionText == null) {
			for (int i = 0; i < cardLenght - 1; i++) {
				sb.append(middleSection);
			}
			// with text
		} else {
			// is number
			if (middleSectionText.matches("[A-Z]|\\d+")) {
				for (int i = 0; i < cardLenght - 1 - middleSectionText.length(); i++) {
					sb.append(middleSection);
				}
				// check for 10
				sb.append(middleSectionText);
				// is color
			} else {
				for (int i = 0; i < cardLenght - 2 - middleSectionText.length(); i++) {
					sb.append(middleSection);
				}
				sb.append(middleSectionText).append(middleSection);
			}
		}
		sb.append(rightBorder);

		return sb.toString();
	}

	/**
	 * Creates right partial line. From middle of card to most right side
	 * 
	 * @param cardLenght
	 *            is the lenght of a card. Use settings
	 * @param leftBorder
	 *            is the left border of card
	 * @param middleSection
	 *            is the middle section of a card between left and right border
	 * @param middleSectionText
	 *            is the middle text section of a card between left and right
	 *            border. use null if there is no text
	 * @return String representation of partial left line
	 */
	public String createLeftSideOfLine(int cardLenght, String leftBorder, String middleSection,
			String middleSectionText) {
		StringBuilder sb = new StringBuilder();

		sb.append(leftBorder);
		// no text
		if (middleSectionText == "" || middleSectionText == null) {
			for (int i = 0; i < cardLenght - 1; i++) {
				sb.append(middleSection);
			}
			// with text
		} else {
			// is value
			if (middleSectionText.matches("[A-Z]|\\d+")) {
				// check for 10
				sb.append(middleSectionText);
				for (int i = 0; i < cardLenght - 1 - middleSectionText.length(); i++) {
					sb.append(middleSection);
				}
				// is color
			} else {
				sb.append(middleSection).append(middleSectionText);
				for (int i = 0; i < cardLenght - 2 - middleSectionText.length(); i++) {
					sb.append(middleSection);
				}
			}
		}

		return sb.toString();
	}

	/**
	 * Creates complete line new card on top, from Left to Right
	 * 
	 * @param handSize
	 *            is the count of all players cards
	 * @param sizeX
	 *            is the card size X use value form settings
	 * @param sizePartial
	 *            is the partial size printed out below the main card
	 * @param leftBorder
	 *            is the left card border
	 * @param rightBorder
	 *            is the left card border
	 * @param join
	 *            is the join between cards
	 * @param middleSection
	 *            is the section between left and right border
	 * @param middleSectionText
	 *            is the text section between left and right border. use null if
	 *            there is no text
	 * @return string representation of full line
	 */
	public String createCompleteLineLR(int handSize, int sizeX, int sizePartial, String leftBorder, String rightBorder,
			String join, String middleSection, List<String> middleSectionText) {
		StringBuilder sb = new StringBuilder();

		// if null
		if (middleSectionText == null) {
			sb.append(createLeftSideOfLine(sizeX / 2, leftBorder, middleSection, null));

			// hand size - first card - last card
			for (int i = 1; i < handSize - 1; i++) {
				sb.append(createRightSideOfLine(sizePartial, join, middleSection, null));
			}
			// has hand one card?
			if (handSize > 1) {
				sb.append(createRightSideOfLine(sizePartial, rightBorder, middleSection, null));
				// append after first left side
				sb.insert(sizeX / 2, createRightSideOfLine(sizeX / 2, join, middleSection, null));
			} else {
				sb.append(createRightSideOfLine(sizeX / 2, rightBorder, middleSection, null));
			}
			// not null
		} else {
			sb.append(createLeftSideOfLine(sizeX / 2, leftBorder, middleSection, middleSectionText.get(handSize - 1)));
			sb.insert(sizeX / 2,
					createRightSideOfLine(sizeX / 2, join, middleSection, middleSectionText.get(handSize - 1)));
			// hand size - first card - last card
			for (int i = handSize - 2; i >= 0; i--) {
				sb.append(createRightSideOfLine(sizePartial, join, middleSection, middleSectionText.get(i)));
			}
		}
		return sb.toString();
	}

	/**
	 * Creates complete line new card on top, from Right to Left
	 * 
	 * @param handSize
	 *            is the count of all players cards
	 * @param sizeX
	 *            is the card size X use value form settings
	 * @param sizePartial
	 *            is the partial size printed out below the main card
	 * @param leftBorder
	 *            is the left card border
	 * @param rightBorder
	 *            is the left card border
	 * @param join
	 *            is the join between cards
	 * @param middleSection
	 *            is the section between left and right border
	 * @param middleSectionText
	 *            is the text section between left and right border. use null if
	 *            there is no text
	 * @return string representation of full line
	 */
	public String createCompleteLineRL(int handSize, int sizeX, int sizePartial, String leftBorder, String rightBorder,
			String join, String middleSection, List<String> middleSectionText) {
		StringBuilder sb = new StringBuilder();

		// if null
		if (middleSectionText == null) {
			// append right side
			sb.append(createRightSideOfLine(sizeX / 2, rightBorder, middleSection, null));
			// hand size - first card - last card
			for (int i = 1; i < handSize - 1; i++) {
				sb.insert(0, createLeftSideOfLine(sizePartial, join, middleSection, null));
			}
			// has hand one card?
			if (handSize > 1) {
				sb.insert(0, createLeftSideOfLine(sizePartial, leftBorder, middleSection, null));
				// append after first left side
				sb.insert(sb.length() - sizeX / 2, createLeftSideOfLine(sizeX / 2, join, middleSection, null));
			} else {
				sb.insert(0, createLeftSideOfLine(sizeX / 2, leftBorder, middleSection, null));
			}
			// not null
		} else {
			// append right side
			sb.append(createLeftSideOfLine(sizeX / 2, leftBorder, middleSection, middleSectionText.get(handSize - 1)));
			sb.append(
					createRightSideOfLine(sizeX / 2, rightBorder, middleSection, middleSectionText.get(handSize - 1)));

			// hand size - first card - last card
			for (int i = handSize - 2; i >= 0; i--) {
				sb.insert(0, createLeftSideOfLine(sizePartial, join, middleSection, middleSectionText.get(i)));
			}
		}
		return sb.toString();
	}
}
