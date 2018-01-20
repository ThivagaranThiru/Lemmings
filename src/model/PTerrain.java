package model;

import java.awt.Color;

public class PTerrain extends Type{

	protected PTerrain(Coordinate c, Game g) {
		super(c, g);
		// TODO Auto-generated constructor stub
		this.couleur=Color.DARK_GRAY;
	}
	
	@Override
	public EnumTerrain getType() {
		// TODO Auto-generated method stub
		return EnumTerrain.PTerrain;
	}

	@Override
	public EnumDestructible getDestructible() {
		// TODO Auto-generated method stub
		return EnumDestructible.Destructible;
	}

	@Override
	public boolean isTerrain() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public void explosion() {
		int x = coordonnee.getX();
		int y = coordonnee.getY();
		Coordinate c;
		
		for(int i=0; i<jeu.getLemmings().getSquad().size(); i++) {
			for(int j=-5; j<=5; j++) {
				for(int k=-5; k<=5; k++) {
					c = new Coordinate(x+j, y+k);
					if(c == jeu.getLemmings().getSquad().get(i).getCoord()) {
						jeu.getLemmings().getSquad().get(i).setVivant(false);
					}
				}
			}
		}
	}
	
	public void destroy(Coordinate c, Character charc, int i) {
		if(c == charc.getCoord()) {
			jeu.getLemmings().getSquad().get(i).setVivant(false);
		}
	}
}
