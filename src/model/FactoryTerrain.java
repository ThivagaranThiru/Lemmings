package model;


public class FactoryTerrain {

	public static Type getTerrain(Coordinate coordonnees,Game jeu, EnumTerrain t) {
		// TODO Auto-generated method stub
		
		Type terrain = null;
		
		switch(t){
		case Air:
			terrain = new Air(coordonnees,jeu);
			break;
		case DTerrain:
			terrain = new DTerrain(coordonnees,jeu);
			break;
		case ITerrain:
			terrain = new ITerrain(coordonnees,jeu);
			break;
		case PTerrain:
			terrain = new PTerrain(coordonnees,jeu);
			break;
		case OTerrain:
			terrain = new OTerrain(coordonnees,jeu);
			break;
		case Eteleporteur:
			terrain = new Eteleporteur(coordonnees,jeu);
			break;
		case Entree:
			terrain = new Entree(coordonnees,jeu);
			break;
		case Steleporteur:
			terrain = new Steleporteur(coordonnees,jeu);
			break;
		case Lave:
			terrain = new Lave(coordonnees,jeu);
			break;
		case Sortie:
			terrain = new Sortie(coordonnees,jeu);
			break;
		case Bloque:
			terrain = new Bloque(coordonnees,jeu);
			break;
		default:
			break;
		 
		}
		
		return terrain;
	}

}
