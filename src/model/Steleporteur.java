package model;

import java.awt.Color;

public class Steleporteur extends Type{
	
	public Steleporteur(Coordinate c, Game g) {
		super(c, g);
		// TODO Auto-generated constructor stub
		this.couleur=Color.ORANGE;
		
	}

	public EnumTerrain getType() {
			return EnumTerrain.Steleporteur;
	}
	
	public EnumDestructible getDestructible() {
		return EnumDestructible.Indestructible;
	}
	
	public boolean isTerrain() {
		return false;
	}
}