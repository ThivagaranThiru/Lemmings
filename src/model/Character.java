package model;

public class Character {
	
	private Game jeu;
	private Coordinate coord;
	private LemmingsState state;
	private Direction dir;
	private int nbchute;
	private boolean vivant;
	
	public Character(Coordinate c, Direction d,Game g) {
		this.coord = c;
		this.dir = d;
		this.state = new NormalState(this);
		this.nbchute = 0;
		this.jeu = g;
		this.vivant = true;
	}
	
	public Game getGame() {
		return jeu;
	}

	public void setGame(Game game) {
		this.jeu = game;
	}
	
	public Coordinate getCoord() {
		return this.coord;
	}
	
	public void setCoord(Coordinate c) {
		this.coord = c;
	}
	
	public Direction getDir() {
		return this.dir;
	}
	
	public void setDir(Direction d) {
		this.dir = d;
	}
	
	public int compte() {
		return nbchute = nbchute + 1;
	}
	
	public int setCompteurZero(){
		return nbchute = 0;
	}
	
	public int getnbchute() {
		return nbchute;
	}
	
	public boolean isVivant() {
		return vivant;
	}

	public void setVivant(boolean vivant) {
		this.vivant = vivant;
	}	
	
	public LemmingsState getEtat() {
		return state;
	}
	
	public void changeState(LemmingsState state) {
		this.state = state;
	}
}
