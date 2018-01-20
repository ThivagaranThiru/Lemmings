package model;

public abstract class LemmingsState {
	
	protected Character charc;
	
	protected LemmingsState(Character character) {
		this.charc = character;
	}
	
	public boolean sauter(Type saut,Type inconnu, Type endessous) {
		if(!saut.isTerrain() && saut.getType() != EnumTerrain.Bloque && inconnu.getType() == EnumTerrain.Air && (endessous.isTerrain()|| endessous.getType() == EnumTerrain.Bloque)) return true;
		return false;
	}
	
	public boolean demiTour(Type inconnu,Type audessus, Coordinate coord) {
		if(charc.getGame().isOut(coord) || charc.getGame().isWall(coord) || inconnu.getType() == EnumTerrain.Bloque) {
			return true;
		}else if(inconnu.isTerrain() && (audessus.isTerrain() || audessus.getType() == EnumTerrain.Bloque)) {
			return true;
		}
		return false;
	}

	public abstract void action() throws TerrainExistantException;

}
