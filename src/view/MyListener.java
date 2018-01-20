package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyListener extends MouseAdapter {
	
	private int x;
	private int y;
	
	public void mouseClicked(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}
		
	public int getX() {
		return x;
	}
		
	public int getY() {
		return y;
	}
	
	public void setXZero() {
		this.x = 0;
	}
	
	public void setYZero() {
		this.y = 0;
	}
		
}

