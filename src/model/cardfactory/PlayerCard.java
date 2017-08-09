package model.cardfactory;

import model.cardproperty.Color;
import model.cardproperty.Value;

/**
 * @author David Racek
 * 
 * Class player card. Implements interface Card
 * Created card has value and color
 */
public class PlayerCard implements Card{
	private Color color;
	private Value value;
	
	public PlayerCard(Color color, Value value) {
		this.color = color;
		this.value = value;
	}
	
	@Override
	public Value getValue() {
		return this.value;
	}

	@Override
	public Color getColor() {
		return this.color;
	}
}
