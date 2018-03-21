package com.stillwell.olympus.apollo.audio;

public class AudioPlayerThread extends Thread
{

	AudioPlayer player;
	
	@Override
	public synchronized void start()
	{
//		super.start();
		run();
	}
	
	@Override
	public void run()
	{
		player.start();
	}
	
	public AudioPlayerThread(AudioPlayer player)
	{
		this.player = player;
	}
	
	public AudioPlayer getAudioPlayer()
	{
		return player;
	}
	
	public void setAudioPlayer(AudioPlayer play)
	{
		player.setVolume(play.getVolume());
		player.pauseTrack();
		player.playTrack();
	}
	
}
