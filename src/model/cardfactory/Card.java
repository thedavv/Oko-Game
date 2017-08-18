package model.cardfactory;

import model.cardproperty.Color;
import model.cardproperty.Value;

/**
 * Interface Card. Clases that are creating cards must implement this interface
 *
 * @author David Racek
 */
public interface Card {
	public Value getValue();

	public Color getColor();

}
