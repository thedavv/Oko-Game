package model.cardfactory;

import model.card.Color;
import model.card.Value;

public class CardFactory {
	public Card getCard(Color color, Value value){
		return new PlayerCard(color, value);	
	};
}
