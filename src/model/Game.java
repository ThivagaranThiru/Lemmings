package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.LemmingsEvent.ChangeType;
import model.TerrainExistantException;
import model.FactoryTerrain;
import model.EnumTerrain;


public class Game  {
	
	private List<LemmingsEvent> eventsTerrain = new ArrayList<LemmingsEvent>();
	private ArrayList<Type> carte;
	private Coordinate start;
	private Character character;
	private Lemmings lemmings;
	private int NbLemmings;
	private int NbSauve;
	private int height;
	private int width;
	private int line;
	private int column;
	private char[][] map;
	private int n = 0;
	private BufferedReader buffer;
	
	public Game(String file) {
		
		try{
			
			InputStream fichier = new FileInputStream(file);
			InputStreamReader reader = new InputStreamReader(fichier);
			
			buffer = new BufferedReader(reader);
			String ligne = buffer.readLine();
			
			this.width =Integer.parseInt(ligne);
			ligne = buffer.readLine();
			this.height = Integer.parseInt(ligne);
			
			ligne = buffer.readLine();
			this.line = Integer.parseInt(ligne);
			this.column = Integer.parseInt(ligne);
			
			
			ligne = buffer.readLine();
			this.NbLemmings = Integer.parseInt(ligne);
			
			ligne = buffer.readLine();
			this.NbSauve = Integer.parseInt(ligne);
	
			this.map = new char[line][column];
		
			int j = 0;
			while((ligne = buffer.readLine())!= null){
				for(int i = 0; i < line; i++){
					if(ligne.charAt(i) == '2') {
						this.start = new Coordinate(i,j);
					}
					this.map[i][j] = ligne.charAt(i);
				}
				j++;
			} 
		}
		catch(Exception e){
			System.out.println(e.toString());
		}
		
		this.carte = creeCarte();
		this.lemmings = new Lemmings(this);
	}	

	public Lemmings getLemmings() {
		return lemmings;
	}
	
	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}
	
	public int getNbLemmings() {
		return NbLemmings;
	}
	
	public int getLine() {
		return line;
	}
	
	public int getColumn() {
		return column;
	}
	
	public ArrayList<Type> getCarte(){
		return carte;
	}
	
	public List<LemmingsEvent> getEventsTerrain() {
		return eventsTerrain;
	}
	
	public void removeEventsTerrain(Coordinate c) {
		Iterator <LemmingsEvent> it = eventsTerrain.iterator();
		LemmingsEvent a;
		while(it.hasNext()) {
			a = it.next();
			if(a.getCoordinate().getX() == c.getX() && a.getCoordinate().getY() == c.getY()) {
					it.remove();
			}
		}
	}
	
	public  Type getTerrain(Coordinate c){
		for(Type t : carte){
			if((t.getCoordonne().getX()== c.getX()) && t.getCoordonne().getY()== c.getY())
				return t;
		}
		return null;
		
	}
	
	public void addTerrain(Coordinate c, EnumTerrain t)  throws TerrainExistantException {
		Iterator <Type> it = carte.iterator();
		Type a;
		while(it.hasNext()) {
			a = it.next();
			if(a.getCoordonne().getX() == c.getX() && a.getCoordonne().getY() == c.getY()) {
				if(a.getType() == EnumTerrain.Air) {
					it.remove();
					removeEventsTerrain(c);
				}else throw new TerrainExistantException("Terrain existant");
			}
		}                                                                           
		carte.add(FactoryTerrain.getTerrain(c,this, t));
		eventsTerrain.add(new LemmingsEvent(c,converse(t)));
	}
	
	public void removeTerrain(Coordinate c)  throws TerrainExistantException {
		Iterator <Type> it = carte.iterator();
		Type t;
		while(it.hasNext()) {
			t = it.next();
			if(t.getCoordonne().getX() == c.getX() && t.getCoordonne().getY() == c.getY()) {
				if(t.getDestructible() == EnumDestructible.Destructible) {
					it.remove();
					removeEventsTerrain(c);
				}else throw new TerrainExistantException("Vous ne pouvez pas le supprimer desole");
			}
		}
		
		carte.add(FactoryTerrain.getTerrain(c,this, EnumTerrain.Air));
		eventsTerrain.add(new LemmingsEvent(c,ChangeType.AIR));
	}
	
	private ChangeType converse(EnumTerrain t){
		
		switch(t){
		case Air:
			return ChangeType.AIR;
		case Entree:
			return ChangeType.ENTREE;
		case Lave:
			return ChangeType.LAVE;
		case Sortie:
			return ChangeType.SORTIE;
		case DTerrain:
			return ChangeType.DTERRAIN;
		case ITerrain:
			return ChangeType.ITERRAIN;
		case PTerrain:
			return ChangeType.PTERRAIN;
		case OTerrain:
			return ChangeType.OTERRAIN;
		case Eteleporteur:
			return ChangeType.ETELEPORTEUR;
		case Steleporteur:
			return ChangeType.STELEPORTEUR;
		case Bloque:
			return ChangeType.BLOQUE;
		default:
			return null;
		
		}
	}
	public ArrayList<Type> creeCarte() {
		
		ArrayList<Type> m = new ArrayList<>();
		Coordinate pos;
		
		for (int i = 0; i < line; i++) {
			for (int j = 0; j < column; j++) {
				switch(map[i][j]) {
				case '2' : 
						   pos = new Coordinate(i,j);
						   Type entree = new Entree(pos,this);	
						   m.add(entree);
						   eventsTerrain.add(new LemmingsEvent(pos,ChangeType.ENTREE));
						   break;
				case '1' : 
						  pos = new Coordinate(i,j);
						  Type dterrain = new DTerrain(pos,this);
						  m.add(dterrain);
						  eventsTerrain.add(new LemmingsEvent(pos,ChangeType.DTERRAIN));
						  break;
				case '6' : 
					  	  pos = new Coordinate(i,j);
					  	  Type iterrain = new ITerrain(pos,this);
					  	  m.add(iterrain);
					  	  eventsTerrain.add(new LemmingsEvent(pos,ChangeType.ITERRAIN));
					  	  break;
				case '8' : 
						  pos = new Coordinate(i,j);
						  Type pterrain = new PTerrain(pos,this);
						  m.add(pterrain);
				  	 	  eventsTerrain.add(new LemmingsEvent(pos,ChangeType.PTERRAIN));
				  	 	  break;
				case '9' : 
					  	  pos = new Coordinate(i,j);
					      Type oterrain = new OTerrain(pos,this);
					      m.add(oterrain);
			  	 	      eventsTerrain.add(new LemmingsEvent(pos,ChangeType.OTERRAIN));
			  	 	      break;
				case '3' : 
					  	  pos = new Coordinate(i,j);
					  	  Type sortie = new Sortie(pos,this);
					  	  m.add(sortie);
					  	  eventsTerrain.add(new LemmingsEvent(pos,ChangeType.SORTIE));
					  	  break;
				case '7' : 
					      pos = new Coordinate(i,j);
					      Type lave = new Lave(pos,this);
					      m.add(lave);
					      eventsTerrain.add(new LemmingsEvent(pos,ChangeType.LAVE));
					      break;
				case '4' : 
						  pos = new Coordinate(i,j);
						  Type eteleporteur = new Eteleporteur(pos,this);
						  m.add(eteleporteur);
						  eventsTerrain.add(new LemmingsEvent(pos,ChangeType.ETELEPORTEUR));
						  break;
				case '5' : 
					  	  pos = new Coordinate(i,j);
					      Type steleporteur = new Steleporteur(pos,this);
					      m.add(steleporteur);
					      eventsTerrain.add(new LemmingsEvent(pos,ChangeType.STELEPORTEUR));
					      break;
				default	 :
						 pos = new Coordinate(i,j);
				         Type air = new Air(pos,this);
				         m.add(air);
				         eventsTerrain.add(new LemmingsEvent(pos,ChangeType.AIR));
				         break; 
				}
			}
		}
		return m;
	}
	
	public boolean isOut(Coordinate c) {
			if (c.getX() < 0 || c.getY() < 0)
				return true;
			if (c.getX() >= line || c.getY() >= column)
				return true;
			return false;
	}
	
	public  boolean isWall(Coordinate c){
		for(Type b : carte){
			if(b.isTerrain()) {
				if((c.getX()) == b.getCoordonne().getX() && c.getY() == b.getCoordonne().getY()) {
					for (Type m : carte) {
						if(m.isTerrain() || m.getType() == EnumTerrain.Bloque) {
							if((m.getCoordonne().getX()) == b.getCoordonne().getX() &&  m.getCoordonne().getY() == b.getCoordonne().getY()-1) {
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}

	
	public Coordinate getSteleporteur() {
		for(Type s : carte){
			if(s.getType() == EnumTerrain.Steleporteur) {
				return s.getCoordonne();
			}
		}
		return null;
	}
	 
	public void step() {
		if(n < NbLemmings) {
			for(int i = 0; i < NbLemmings; i++) {
				character = new Character(start, Direction.Down,this);
				lemmings.addSquad(character);
				lemmings.move();
				n++;
			}
		}else lemmings.move();
		
		if(lemmings.getSquad().isEmpty()) {
			if(lemmings.getNbArrivee() > this.NbSauve) {
				System.out.println("Vous avez gagné");
				lemmings.setAlive(false);
			}else{
				System.out.println("Vous avez perdu");
			}
		}
	}		
}
