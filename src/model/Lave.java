package model;

import java.awt.Color;

public class Lave extends Type{
	
	public Lave(Coordinate c, Game g) {
		super(c, g);
		// TODO Auto-generated constructor stub
		this.couleur = Color.RED;
	}

	public EnumTerrain getType() {
		return EnumTerrain.Lave;
	}
	
	public EnumDestructible getDestructible() {
		return EnumDestructible.Indestructible;
	}
	
	public boolean isTerrain() {
		return false;
	}
}
