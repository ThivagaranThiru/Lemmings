package view;


import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.EnumState;
import model.Game;
import model.LemmingsEvent;
import model.LemmingsObserver;

@SuppressWarnings("serial")
public class Gui extends JFrame implements LemmingsObserver{
	
	private Panel panel;
	private JPanel pan;
	private JButton foreur;
	private JButton charpentier;
	private JButton tunnelier;
	private JButton bloqueur;
	private JButton grimpeur;
	private JButton bombeur;
	private JButton parachutiste;
	private EnumState pouvoir;
	
	public Gui(Game game) {
		this.panel = new Panel(game,this);
		this.pan = new JPanel();
		this.pouvoir = EnumState.Marcheur;
		this.foreur= new JButton("Foreur");
		this.charpentier = new JButton("Charpentier");
		this.tunnelier = new JButton("Tunnelier");
		this.bloqueur = new JButton("Bloqueur");
		this.grimpeur = new JButton("Grimpeur");
		this.bombeur = new JButton("Bombeur");
		this.parachutiste = new JButton("Parachutiste");
		
		this.setTitle("Lemmings");
		this.setSize(game.getWidth(),game.getHeight());
		this.setLocation(100,100);
		this.setResizable(false);
		
		pan.setLayout(new BoxLayout(pan, BoxLayout.LINE_AXIS)); 
		pan.add(foreur);
		pan.add(charpentier);
		pan.add(tunnelier);
		pan.add(bloqueur);
		
		JPanel a = new JPanel();
		a.setLayout(new BoxLayout(a, BoxLayout.LINE_AXIS));
		a.add(grimpeur);
		a.add(bombeur);
		a.add(parachutiste);
		
		JPanel b = new JPanel();
		b.setLayout(new BoxLayout(b, BoxLayout.PAGE_AXIS)); 
		b.add(pan);
		b.add(a);

		
		foreur.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						
						pouvoir = EnumState.Foreur;
					}	
				});
		
		charpentier.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						
						pouvoir = EnumState.Charpentier;
					}	
				});
		
		tunnelier.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
					
						pouvoir = EnumState.Tunnelier;
					}	
				});
		
		bloqueur.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
					
						pouvoir = EnumState.Bloqueur;
					}	
				});
		
		grimpeur.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
					
						pouvoir = EnumState.Grimpeur;
					}	
				});
		
		bombeur.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						
						pouvoir = EnumState.Bombeur;
					}	
				});
		parachutiste.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						
						pouvoir = EnumState.Parachutiste;
					}	
				});
		
		this.getContentPane().add(panel);
		this.getContentPane().add(b,BorderLayout.SOUTH);
		this.setVisible(true);
	}

	@Override
	public void notify(List<LemmingsEvent> events) {
		// TODO Auto-generated method stub
		panel.repaint();
	}
	public EnumState getPouvoir () {
		return this.pouvoir;
	}
	
	public void resetPouvoir () {
		this.pouvoir = EnumState.Marcheur;
	}
}
