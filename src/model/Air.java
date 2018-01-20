package model;

import java.awt.Color;

public class Air extends Type{
	
	public Air(Coordinate c, Game g) {
		super(c, g);
		// TODO Auto-generated constructor stub
		this.couleur = Color.WHITE;
	}

	public EnumTerrain getType() {
		return EnumTerrain.Air;
	}
	
	public EnumDestructible getDestructible() {
		return EnumDestructible.Indestructible;
	}
	
	public boolean isTerrain() {
		return false;
	}
}
