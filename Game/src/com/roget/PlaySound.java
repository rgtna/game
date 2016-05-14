package com.roget;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class PlaySound {
	
	public void playSoundHurt() throws IOException
	{
		String file="/Users/ralabastro20/desktop/hit_hurt.wav";
		try {
			InputStream in = new FileInputStream(file);
			
			AudioStream as = new AudioStream(in);
			
			AudioPlayer.player.start(as);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public void playSoundCoinPickup() throws IOException
	{
		String file="/Users/ralabastro20/desktop/Pickup_Coin.wav";
		try {
			InputStream in = new FileInputStream(file);
			
			AudioStream as = new AudioStream(in);
			
			AudioPlayer.player.start(as);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public void playSoundMusic() throws IOException
	{
		
		String file="/Users/ralabastro20/desktop/sandstorm.mp3";
		try {
			InputStream in = new FileInputStream(file);
			
			AudioStream as = new AudioStream(in);
			
			AudioPlayer.player.start(as);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
