package model;

public enum Direction {
	Up(0, -1), Down(0, 1), Left(-1, 0), Right(1, 0);

	private int x;
	private int y;
	
	Direction(int x1, int y1) {
		this.x = x1;
		this.y = y1;
	}	
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public static Direction opposer(Direction d) {
		switch (d) {
		case Right:
			return Direction.Left;
		case Left:
			return Direction.Right;
		case Up:
			return Direction.Down;
		case Down:
			return Direction.Up;
		default:
			return null;
		}
	}
}
