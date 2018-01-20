package view;


import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

import model.Game;
import model.LemmingsEvent;
import model.LemmingsObserver;
import model.Type;
import model.Character;
import model.FactoryState;

@SuppressWarnings("serial")
public class Panel extends JPanel implements LemmingsObserver{
		
		private Game game;
		private Gui gui;
		public MyListener mouse = new MyListener();
		private static final int scale = 40;
	
		
		public Panel (Game jeu, Gui gi){
			this.game = jeu ;
			this.gui = gi;
		}

		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);

			this.addMouseListener(mouse);
			
			for(int i=0; i < game.getLemmings().getSquad().size(); i++) {
				if(mouse.getX() >= game.getLemmings().getSquad().get(i).getCoord().getX()*scale
				   && mouse.getX() < scale + game.getLemmings().getSquad().get(i).getCoord().getX()*scale
				   && mouse.getY() >= game.getLemmings().getSquad().get(i).getCoord().getY()*scale
				   && mouse.getY() < scale + game.getLemmings().getSquad().get(i).getCoord().getY()*scale) {
						game.getLemmings().getSquad().get(i).changeState(FactoryState.changeState(gui.getPouvoir(),game.getLemmings().getSquad().get(i)));
						mouse.setXZero();
						mouse.setYZero();
				}	
			}
		
			for(Type t : game.getCarte()) {
				g.setColor(t.getColor());
				g.fillRect(t.getCoordonne().getX()* scale, t.getCoordonne().getY() * scale ,scale,scale);
			}
				
			g.setColor(Color.BLUE);
			for (Character c : game.getLemmings().getSquad()) {
				g.fillRect(c.getCoord().getX() * scale, c.getCoord().getY() * scale,scale,scale);
			}
			
			/*g.setColor(Color.GRAY);
			g.fillRect(mouse.getX(), mouse.getY(), scale, scale);*/
			
			mouse.setXZero();
			mouse.setYZero();
		}
		
		@Override
		public void notify(List<LemmingsEvent> events) {
			// TODO Auto-generated method stub
			this.repaint();
		}
}
