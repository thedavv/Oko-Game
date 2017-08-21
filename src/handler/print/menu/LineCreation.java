package handler.print.menu;

/**
 * Class for creating Menu line
 * 
 * @author David Racek
 */
public class LineCreation {
	/**
	 * Method for creating line. for line parameters use <Code>util.Const</Code> line constants
	 * 
	 * @param menuLenght
	 *            - is the lenght of menu x size
	 * @param leftBorder
	 *            - is left border to be apended
	 * @param rightBorder
	 *            - is right border to be apended
	 * @param middleSection
	 *            - is the middle section, usually it is <Code>Const.SP</Code>
	 * @param middleSectionText
	 *            - is the middle section text. String to be printed out between
	 *            borders
	 * @return String representation of created line
	 */
	public String drawLine(int menuLenght, char leftBorder, char rightBorder,
			char middleSection, String middleSectionText) {
		StringBuilder sb = new StringBuilder();
		sb.append(leftBorder);
		// no text
		if (middleSectionText == "" || middleSectionText == null) {
			for (int i = 0; i < menuLenght - 2; i++) {
				sb.append(middleSection);
			}
		// with text
		} else {
			// space between border
			sb.append(middleSection);
			sb.append(middleSectionText);
			for (int i = 0; i < menuLenght - middleSectionText.length() - 3; i++) {
				sb.append(middleSection);
			}
		}
		sb.append(rightBorder);

		return sb.toString();
	}
}
