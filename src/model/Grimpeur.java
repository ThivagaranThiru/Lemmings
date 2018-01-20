package model;

public class Grimpeur extends LemmingsState {
	
	private Direction direction = Direction.Right;

	protected Grimpeur(Character character) {
		super(character);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void action() throws TerrainExistantException {
		// TODO Auto-generated method stub
		
		Coordinate coord = new Coordinate(charc.getCoord().getX() + charc.getDir().getX(), charc.getCoord().getY() + charc.getDir().getY());
		Type inconnu = charc.getGame().getTerrain(coord);
		Type audessus = charc.getGame().getTerrain(new Coordinate(charc.getCoord().getX() + Direction.Up.getX(), charc.getCoord().getY() + Direction.Up.getY()));
		Type endessous = charc.getGame().getTerrain(new Coordinate(charc.getCoord().getX() + Direction.Down.getX(), charc.getCoord().getY() + Direction.Down.getY()));
		
		if(charc.getGame().isOut(coord)) {
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
			
	
			if(inconnu.isTerrain() && (audessus.isTerrain() || audessus.getType() == EnumTerrain.Bloque)) {
				charc.setDir(Direction.opposer(charc.getDir()));
				direction = charc.getDir();
				coord = new Coordinate(charc.getCoord().getX() + charc.getDir().getX(), charc.getCoord().getY() + charc.getDir().getY());
				inconnu = charc.getGame().getTerrain(coord);
			}
			
			Type saut = charc.getGame().getTerrain(new Coordinate(coord.getX() + Direction.Down.getX(), coord.getY() + Direction.Down.getY()));
			
			if(endessous.getType() == EnumTerrain.Air) {
				charc.setDir(Direction.Down);
			}else if(sauter(saut,inconnu,endessous)) {
				charc.setCoord(coord);
				charc.setDir(Direction.Down);
			}
		}
		
		if(inconnu.isTerrain() && endessous.isTerrain() && !audessus.isTerrain() && audessus.getType() != EnumTerrain.Bloque) {
			charc.setDir(Direction.Up);
			coord = new Coordinate(charc.getCoord().getX() + charc.getDir().getX(), charc.getCoord().getY() + charc.getDir().getY());
			inconnu = charc.getGame().getTerrain(coord);
		}
		
		if(charc.getDir() == Direction.Up) {
			Type cotedroitgauche = charc.getGame().getTerrain(new Coordinate(coord.getX() + direction.getX(), coord.getY() + direction.getY()));
			if(charc.getCoord().getY() <= 0 || audessus.isTerrain() || audessus.getType() == EnumTerrain.Bloque) {
				charc.setDir(Direction.opposer(charc.getDir()));
				charc.changeState(new NormalState(charc));
			} else if(cotedroitgauche.getType() == EnumTerrain.Air && !inconnu.isTerrain()) {
				if(inconnu.getType() == EnumTerrain.Air) {
					charc.setCoord(new Coordinate(charc.getCoord().getX() + Direction.Up.getX(), charc.getCoord().getY() + Direction.Up.getY()));
					charc.setDir(direction);
				}
				charc.changeState(new NormalState(charc));
			}
		}
	}
}