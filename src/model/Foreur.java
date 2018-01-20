package model;

public class Foreur extends LemmingsState{
	
	private int FOREUR_PERIOD = 0;
	private Direction direction = Direction.Down;
	
	
	protected Foreur(Character character) {
		super(character);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void action() {
		// TODO Auto-generated method stub
		
		Coordinate coord = new Coordinate(charc.getCoord().getX() + Direction.Down.getX(), charc.getCoord().getY() + Direction.Down.getY());
		Type endessous = charc.getGame().getTerrain(coord);
		
		FOREUR_PERIOD++;
		charc.compte();
		
		if(FOREUR_PERIOD == 1) direction = charc.getDir();
		

		if(endessous.getDestructible() == EnumDestructible.Destructible) {
			charc.setCompteurZero();
			
			if(endessous.getType() == EnumTerrain.OTerrain) {
				OTerrain terrain = new OTerrain(coord,charc.getGame());
				terrain.Newobstacle();
			}
			
			if(endessous.getType() == EnumTerrain.PTerrain) {
				PTerrain piege = new PTerrain(coord,charc.getGame());
				piege.explosion();
			}
			try {charc.getGame().removeTerrain(coord);} catch (TerrainExistantException e) {e.printStackTrace();}
			charc.setDir(Direction.Down);
		}else charc.setDir(Direction.Down);
		
		if(FOREUR_PERIOD >= 5 || (endessous.getDestructible() == EnumDestructible.Indestructible && endessous.getType() != EnumTerrain.Air) || endessous.getType() == EnumTerrain.Bloque) {
			charc.setDir(direction);
			charc.changeState(new NormalState(charc));
			try {charc.getEtat().action();} catch (TerrainExistantException e) {e.printStackTrace();}
		}
	}
}
	


