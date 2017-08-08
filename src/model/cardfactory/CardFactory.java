package model.cardfactory;

import model.cardproperty.Color;
import model.cardproperty.Value;

public class CardFactory {
	public Card createCard(Color color, Value value){
		return new PlayerCard(color, value);	
	};
}
