package com.roget;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KeyInput extends KeyAdapter{
	
	private Handler handler;
    private int xp, xm, yp, ym; //xm stands for x minus and xp stands for x plus etc.
    private int defXP, defXM, defYP, defYM;
    
    private Buy buy = new Buy();
    
    private STATE gameState;
    
    public KeyInput(Handler handler) {
            this.handler = handler;
    }

    public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            for (int i = 0; i < handler.object.size(); i++) {
                    GameObject tempObject = handler.object.get(i);

                    if (tempObject.getId() == ID.Player) {
                    	 //I collect the numbers before actually set the velocity.
                        //In addition, you can use arrow keys
                        if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP) ym = 5; //Change to 10 for superspeed
                        if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) xm = 5; //Change to 10 for superspeed
                        if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) yp = 5; //Change to 10 for superspeed
                        if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) xp = 5; //Change to 10 for superspeed
                       
                        //And here I set the velocity
                        tempObject.setVelX(xp - xm);
                        tempObject.setVelY(yp - ym);
                        
                        if (key == KeyEvent.VK_B) 
                            {
                            	if(buy.isBuying == false)
                            	{
                            		gameState = STATE.Buy;
                            		buy.isBuying = true;
                            		
                            		
                            	} else if(buy.isBuying == true) {
                            		//Game.gameState = STATE.Game;
                            		buy.isBuying = false;
                            	}
                            }
                    }
            }
    }

    public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();

            for (int i = 0; i < handler.object.size(); i++) {
                    GameObject tempObject = handler.object.get(i);

                    if (tempObject.getId() == ID.Player) {

                            //Same story. I collect numbers before I change velocity
                            if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP) ym = 0;
                            if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) xm = 0;
                            if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) yp = 0;
                            if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) xp = 0;
                           
                            tempObject.setVelX(xp - xm);
                            tempObject.setVelY(yp - ym);
                            
                    }
                    
                    if(key == KeyEvent.VK_ESCAPE) System.exit(0);
            }

    }

}
