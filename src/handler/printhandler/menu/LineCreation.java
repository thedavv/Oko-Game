package handler.printhandler.menu;

public class LineCreation {
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
