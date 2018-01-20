package model;

import java.awt.Color;

public class Entree extends Type {
	
	public Entree(Coordinate c, Game g) {
		super(c, g);
		// TODO Auto-generated constructor stub
		this.couleur = Color.YELLOW;
	}

	public EnumTerrain getType() {
		return EnumTerrain.Entree;
	}
	
	public EnumDestructible getDestructible() {
		return EnumDestructible.Indestructible;
	}
	
	public boolean isTerrain() {
		return false;
	}
}
