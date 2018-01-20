package model;

import java.awt.Color;

public class Sortie extends Type{

	public Sortie(Coordinate c, Game g) {
		super(c, g);
		// TODO Auto-generated constructor stub
		this.couleur = Color.PINK;
	}

	public EnumTerrain getType() {
		return EnumTerrain.Sortie;
	}
	
	public EnumDestructible getDestructible() {
		return EnumDestructible.Indestructible;
	}
	
	public boolean isTerrain() {
		return false;
	}
}
