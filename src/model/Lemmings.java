package model;

import java.util.ArrayList;
import java.util.List;

import model.LemmingsEvent.ChangeType;

public class Lemmings extends LemmingsObservable {
	
	static final int SPEED = 1000;
	
	private Game game;
	private List<Character> squad = new ArrayList<>();
	private int NbArrivee = 1;
	private boolean alive = true;
	
	public Lemmings(Game g) {
		this.game = g ;
		squad = new ArrayList<>();
	}
	
	public void addSquad(Character c) {
		squad.add(c);
	}
	
	public List<Character> getSquad() {
		return new ArrayList<>(squad);
	}
	
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
	
	public int getNbArrivee() {
		return NbArrivee;
	}

	public void setNbArrivee(int n) {
		this.NbArrivee = n;
	}
	
	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	void move() {
		List<LemmingsEvent> events = new ArrayList<LemmingsEvent>();
		for (int m = 0; m < 10; m++) {
			try {Thread.sleep(SPEED);} catch (InterruptedException e) {e.printStackTrace();}
			for (int j = 0; j < squad.size(); j++) {
				events.add(new LemmingsEvent(squad.get(j).getCoord(),ChangeType.LEAVE));
				try {squad.get(j).getEtat().action();} catch (TerrainExistantException e) {e.printStackTrace();}
				Coordinate next = new Coordinate(squad.get(j).getCoord().getX() + squad.get(j).getDir().getX(), squad.get(j).getCoord().getY() + squad.get(j).getDir().getY());
				squad.get(j).setCoord(next);
				if(this.game.getTerrain(next).getType() ==  EnumTerrain.Eteleporteur)squad.get(j).setCoord(this.game.getSteleporteur());
				if(squad.get(j).getnbchute() == 5 || this.game.getTerrain(next).getType() ==  EnumTerrain.Lave || squad.get(j).isVivant() == false) {
					squad.remove(j);
				}else if(this.game.getTerrain(next).getType() ==  EnumTerrain.Sortie) {
					this.NbArrivee++;
					squad.remove(j);
				}else events.add(new LemmingsEvent(squad.get(j).getCoord(),ChangeType.ENTER));
				notifyObserver(events);
			}
		}
	}
}