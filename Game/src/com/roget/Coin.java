package com.roget;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.spec.PSSParameterSpec;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Coin extends GameObject {
	
	//private Random r = new Random();
	Handler handler;
	PlaySound ps = new PlaySound();
	
	private int coins = 0;
	private Image image = this.getImage();
	
	//private long life = 100000000000000L;
	
	public Coin(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
	}
	
	public void tick() {
		collision();
	}
	
	private void collision()
	{
		for(int i = 0; i < handler.object.size(); i++)
		{
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player)
			{
				if(getBounds().intersects(tempObject.getBounds())){
					coins += 1;
					// ps.playSoundCoinPickup();
					System.out.println(coins);
					handler.removeObject(this);
				}
			}
		}
	}
	
	// Gets the file from the desktop
	private Image getImage() 
	{
		InputStream file = ClassLoader.getSystemResourceAsStream("resources/coin.png");
		BufferedImage image = null;
		try {
			image = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
	
	private ImageIcon imgico()
	{
		URL url = Coin.class.getResource("resources/coin.png");
		ImageIcon icon = new ImageIcon(url);
		return icon;
	}

	public void render(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect((int)x, (int)y, 8, 8);
		
		//g.drawImage(image, x, y, null);
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 8, 8);
	}
	
}
