package model;

import java.awt.Color;

public class Bloque extends Type{

	public Bloque(Coordinate c, Game g) {
		super(c, g);
		// TODO Auto-generated constructor stub
		this.couleur = Color.GRAY;
	}

	@Override
	public EnumTerrain getType() {
		// TODO Auto-generated method stub
		return EnumTerrain.Bloque;
	}
	
	public EnumDestructible getDestructible() {
		return EnumDestructible.Indestructible;
	}
	
	public boolean isTerrain() {
		return false;
	}

}
