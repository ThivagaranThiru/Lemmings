package model;

import java.awt.Color;

public abstract class Type implements Caracteristique {
	
	protected Coordinate coordonnee;
	protected Game jeu;
	protected Color couleur;
	
	protected Type(Coordinate c, Game g) {
		this.jeu = g;
		this.coordonnee = c;
	}
	
	public Coordinate getCoordonne() {
		return coordonnee;
	};
	
	public  Color getColor() {
		return couleur;
	};
	
	public abstract EnumTerrain getType();
}
