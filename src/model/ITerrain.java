package model;

import java.awt.Color;

public class ITerrain extends Type{
	
	public ITerrain(Coordinate c, Game g) {
		super(c, g);
		// TODO Auto-generated constructor stub
		
		this.couleur = Color.DARK_GRAY;
	}

	public EnumTerrain getType() {
		return EnumTerrain.ITerrain;
	}
	
	public EnumDestructible getDestructible() {
		return EnumDestructible.Indestructible;
	}
	
	public boolean isTerrain() {
		return true;
	}
}
