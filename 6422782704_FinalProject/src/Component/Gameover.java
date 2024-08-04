package Component;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Game.game;

public class Gameover extends JPanel{
	JLabel label_over = new JLabel("Game Over!!!");
	
	public Gameover(){
		
		label_over.setForeground(Color.red);
		game.main_panel.removeAll();
		this.setLayout(null);
		this.add(label_over);
		label_over.setBounds(game.frame.getWidth()/2-150,game.frame.getHeight()/2-100, 500, 50);
		
		
		this.add(game.retrybt);
		game.retrybt.setBounds(game.frame.getWidth()/2-50,game.frame.getHeight()/2+50, 100, 50);
		game.retrybt.setVisible(true);
		game.main_panel.add(this);
	}
	public void paintComponent(Graphics g) {
 		super.paintComponent(g);
 		setBackground(Color.black);
 		Font myfont = new Font("SanSerif",Font.BOLD,50);
 		label_over.setFont(myfont);
 		
}}
