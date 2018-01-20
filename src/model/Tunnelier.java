package model;

public class Tunnelier extends LemmingsState {
	
	private Direction direction = Direction.Right;
	private boolean creuser = false;

	protected Tunnelier(Character character) {
		super(character);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		
		Coordinate coord = new Coordinate(charc.getCoord().getX() + charc.getDir().getX(), charc.getCoord().getY() + charc.getDir().getY());
		Type inconnu = charc.getGame().getTerrain(coord);
		Type endessous = charc.getGame().getTerrain(new Coordinate(charc.getCoord().getX() + Direction.Down.getX(), charc.getCoord().getY() + Direction.Down.getY()));
		
		
		if(charc.getGame().isOut(coord)) {
			charc.setDir(Direction.opposer(charc.getDir()));
			coord = new Coordinate(charc.getCoord().getX() + charc.getDir().getX(), charc.getCoord().getY() + charc.getDir().getY());
			inconnu = charc.getGame().getTerrain(coord);
		}
		
		if(charc.getDir() == Direction.Up) {
			charc.setDir(Direction.opposer(charc.getDir()));
			coord = new Coordinate(charc.getCoord().getX() + charc.getDir().getX(), charc.getCoord().getY() + charc.getDir().getY());
			inconnu = charc.getGame().getTerrain(coord);
		}
		
		if(inconnu.getType() == EnumTerrain.Air && charc.getDir() == Direction.Down) charc.compte();
		
		if((inconnu.isTerrain() || inconnu.getType() == EnumTerrain.Bloque) && charc.getDir() == Direction.Down) {
			charc.setCompteurZero();
			charc.setDir(direction);
			coord = new Coordinate(charc.getCoord().getX() + charc.getDir().getX(), charc.getCoord().getY() + charc.getDir().getY());
			inconnu = charc.getGame().getTerrain(coord);	
		}
		
		if(charc.getDir() == Direction.Left || charc.getDir() == Direction.Right){
			direction = charc.getDir();
			
			if(charc.getGame().isOut(coord) || inconnu.getType() == EnumTerrain.Bloque) {
				charc.setDir(Direction.opposer(charc.getDir()));
				coord = new Coordinate(charc.getCoord().getX() + charc.getDir().getX(), charc.getCoord().getY() + charc.getDir().getY());
				inconnu = charc.getGame().getTerrain(coord);
			}
			
			if(inconnu.getDestructible() == EnumDestructible.Destructible && endessous.isTerrain()) {
				creuser = true;
				if(inconnu.getType() == EnumTerrain.PTerrain) {
					PTerrain piege = new PTerrain(coord,charc.getGame());
					piege.explosion();
				}
				
				if(inconnu.getType() == EnumTerrain.OTerrain) {
					OTerrain terrain = new OTerrain(coord,charc.getGame());
					terrain.Newobstacle();
				}
				
				try {charc.getGame().removeTerrain(coord);} catch (TerrainExistantException e) {e.printStackTrace();}
			}
			
			if(creuser == true && endessous.isTerrain() && (inconnu.getType() == EnumTerrain.Air || inconnu.getDestructible() == EnumDestructible.Indestructible)) charc.changeState(new NormalState(charc));
			
			Type saut = charc.getGame().getTerrain(new Coordinate(coord.getX() + Direction.Down.getX(), coord.getY() + Direction.Down.getY()));
			
			if(endessous.getType() == EnumTerrain.Air) {
				charc.setDir(Direction.Down);
			}else if(sauter(saut,inconnu,endessous)) {
				charc.setCoord(coord);
				charc.setDir(Direction.Down);
			}
		}
	}
}
