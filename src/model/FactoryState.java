package model;

public class FactoryState {
	
	public  static LemmingsState changeState(EnumState power, Character c) {
		
		LemmingsState state = null;
		
		switch(power) {
		case Marcheur :
			 state = new NormalState(c);
			 break;
		case Foreur : 
			 state = new Foreur(c);
			 break;
		case Tunnelier : 
			 state = new Tunnelier(c);
			 break;
		case Charpentier : 
			 state = new Charpentier(c);
			 break;
		case Bloqueur : 
			 state = new Bloqueur(c);
			 break;
		case Grimpeur : 
			state = new Grimpeur(c);
			 break;
		case Bombeur : 
			 state = new Bombeur(c);
			 break;
		case Parachutiste : 
			 state = new Parachutiste(c);
			 break;
		default :
			
		}
		
		return state;
	}
}
