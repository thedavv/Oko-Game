package model.cardfactory;

import model.cardproperty.Color;
import model.cardproperty.Value;

public class PlayerCard implements Card{
	private Color color;
	private Value value;
	
	public PlayerCard(Color color, Value value) {
		this.color = color;
		this.value = value;
	}
	
	/*	@Override
	public void draw(CardHandler ch) {
		ch.drawCard(this);
	}

	@Override
	public void setColor(Color color) {
		this.value = value;
	}

	@Override
	public void setValue(Value value) {
		this.value = value;
	}*/

	@Override
	public Value getValue() {
		return this.value;
	}

	@Override
	public Color getColor() {
		return this.color;
	}
}
