package model;



public class NormalState extends LemmingsState {
	
	private Direction direction = Direction.Right;
	
	protected NormalState(Character character) {
		super(character);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void action() {
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
			
			if(demiTour(inconnu,audessus,coord) && endessous.isTerrain()) {
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
			}else if(inconnu.isTerrain()) {
				if(audessus.getType() == EnumTerrain.Air) {
					charc.setCoord(new Coordinate(charc.getCoord().getX() + Direction.Up.getX(), charc.getCoord().getY() + Direction.Up.getY()));
				}else charc.setDir(Direction.Up);
			}
		}
	}
}
