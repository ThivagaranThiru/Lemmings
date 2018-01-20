package model;

public class Bloqueur extends LemmingsState{

	protected Bloqueur(Character character) {
		super(character);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void action() throws TerrainExistantException {
		// TODO Auto-generated method stub
		
		Coordinate coord = new Coordinate(charc.getCoord().getX() + Direction.Down.getX(), charc.getCoord().getY() + Direction.Down.getY());
		Type endessous = charc.getGame().getTerrain(coord);
		
		if(endessous.isTerrain()) {
			charc.getGame().addTerrain(charc.getCoord(), EnumTerrain.Bloque);
			charc.setVivant(false);
		}
	}

}
