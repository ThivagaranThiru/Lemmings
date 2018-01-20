package model;

import java.awt.Color;
import java.util.Random;

public class OTerrain extends Type{

	protected OTerrain(Coordinate c, Game g) {
		super(c, g);
		// TODO Auto-generated constructor stub
		this.couleur = Color.MAGENTA;
	}
	
	@Override
	public EnumTerrain getType() {
		// TODO Auto-generated method stub
		return EnumTerrain.OTerrain;
	}

	@Override
	public EnumDestructible getDestructible() {
		// TODO Auto-generated method stub
		return EnumDestructible.Destructible;
	}

	@Override
	public boolean isTerrain() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public void Newobstacle() {
		Random r = new Random();
		for (int i = 0; i < 3; i++) {
			Coordinate coordinate = new Coordinate(r.nextInt(jeu.getColumn()),r.nextInt(jeu.getLine()));
			Type inconnu = jeu.getTerrain(coordinate);
			Coordinate coord = new Coordinate(coordinate.getX() + Direction.Down.getX(), coordinate.getY() + Direction.Down.getY());
			Type endessous = jeu.getTerrain(coord);
			if(inconnu.getType() == EnumTerrain.Air && endessous.isTerrain()) {
				try {jeu.addTerrain(coordinate,EnumTerrain.ITerrain);} catch (TerrainExistantException e) {e.printStackTrace();}
			}else i--;
		}
	}
}
