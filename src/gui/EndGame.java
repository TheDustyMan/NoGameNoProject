package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import logic.Boy;

public class EndGame extends JPanel {
	
	public EndGame(){
		this.setSize(GameFrame.WIDTH, GameFrame.HEIGHT);
		this.setLayout(null);
		loadInformations();
	}

	private void loadInformations() {
		try {
			
			gameOver=ImageIO.read(getClass().getResource("../images/gameOver.png"));
			pixelFont=Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("../fonts/pixel.ttf")).deriveFont(35.0f);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (FontFormatException e) {
			e.printStackTrace();
		}
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;
		g2.setColor(Color.WHITE);
		g2.setFont(pixelFont);
		
		if(boy.getLife()<=0){
			g2.drawImage(gameOver,0,0,GameFrame.WIDTH,GameFrame.HEIGHT,null);
		}
	}
	

	public void addBoy(Boy boy) {
		this.boy=boy;
	}
	
	private BufferedImage gameOver;
	private Boy boy;
	private Font pixelFont;
}
