package model;

import java.awt.Color;

public class Eteleporteur extends Type{
	
		
	public Eteleporteur(Coordinate c, Game g) {
		super(c, g);
		// TODO Auto-generated constructor stub
		this.couleur = Color.GREEN;
	}

	public EnumTerrain getType() {
			return EnumTerrain.Eteleporteur;
	}

	public EnumDestructible getDestructible() {
		return EnumDestructible.Indestructible;
	}
	
	public boolean isTerrain() {
		return false;
	}
}
