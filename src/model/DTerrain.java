package model;

import java.awt.Color;

public class DTerrain extends Type{
	
	public DTerrain(Coordinate c, Game g) {
		super(c, g);
		// TODO Auto-generated constructor stub
		
		this.couleur=Color.BLACK;
	}

	public EnumTerrain getType() {
		return EnumTerrain.DTerrain;
	}
	
	public EnumDestructible getDestructible() {
		return EnumDestructible.Destructible;
	}
	
	public boolean isTerrain() {
		return true;
	}
}
