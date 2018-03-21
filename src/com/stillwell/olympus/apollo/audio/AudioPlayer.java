package com.stillwell.olympus.apollo.audio;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
 
// Matt Stillwell

public class AudioPlayer extends Thread implements LineListener
{
 
    private boolean playCompleted;
    private String audioFilePath;
    private boolean loop;
    private int volume;
    
    private Clip audioClip;
    
    private final float MUTE = -80.0f;
    private final float FULL_BLAST = 6.0206f;

    public AudioPlayer(String audioFilePath)
	{
    	loop = true;
		setAudioFile(audioFilePath);
		setVolume(0);
	}
    
    public AudioPlayer(String audioFilePath, int volume)
	{
		setAudioFile(audioFilePath);
		setVolume(volume);
	}
    
    @Override
    public void run() 
    {
    	play();
    }
    
    public void pauseTrack()
    {
    	audioClip.stop();
    	playCompleted = true;
    }
    
    public void playTrack()
    {
    	FloatControl gainControl = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(getActualVolume());
    	audioClip.start();
    	playCompleted = false;
    }
    
    public void restartTrack()
    {
    	play();
    }
    
    public boolean playCompleted()
    {
    	return playCompleted;
    }
    
    public String getAudioFile()
    {
    	return audioFilePath;
    }
    
    public void setAudioFile(String audioFilePath)
    {
    	this.audioFilePath = "res/" + audioFilePath + ".wav";
    }
    
    public int getVolume()
    {
    	return volume;
    }
    
    private float getActualVolume()
    {
    	final float RANGE = FULL_BLAST * 2;
    	float STEP_AMOUNT = RANGE / 100;
    	
    	float actualVol = (volume * STEP_AMOUNT) - FULL_BLAST;
    	
    	if(volume < 50)
    		actualVol *= 6;
    	if(volume == 0)
    		return MUTE;
    	
      	return actualVol;
    }
    
    public void setVolume(int vol)
    {
    	volume = vol;
    	if(vol < 0 || vol > 100)
    	{
    		volume = 50;
    		System.out.println("ERROR: Volume must be an integer between 0 and 100");
    	}
    }    
    
    public void play()
    {
        File audioFile = new File(audioFilePath);
 
        try {
        	
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            audioClip = (Clip) AudioSystem.getLine(info);
            audioClip.addLineListener(this);
            audioClip.open(audioStream);        
            FloatControl gainControl = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(getActualVolume());
            audioClip.start();
          
            while (!playCompleted)
            {
                try
                {
                    Thread.sleep(1000);
                }
                catch (InterruptedException ex)
                {
                    ex.printStackTrace();
                }
            }
            
            if(loop)
            	play();
             
//            audioClip.close();
             
        }
        catch (UnsupportedAudioFileException ex)
        {
            System.out.println("The specified audio file is not supported.");
            ex.printStackTrace();
        }
        catch (LineUnavailableException ex)
        {
            System.out.println("Audio line for playing back is unavailable.");
            ex.printStackTrace();
        }
        catch (IOException ex)
        {
            System.out.println("Error playing the audio file.");
            ex.printStackTrace();
        }
         
    }
     
    @Override
    public void update(LineEvent event)
    {
        LineEvent.Type type = event.getType();
         
        if (type == LineEvent.Type.START)
        {
        	playCompleted = false;
//            System.out.println("Playback started.");     
        }
        else if (type == LineEvent.Type.STOP)
        {
            playCompleted = true;
//            System.out.println("Playback completed.");
        }
 
    }
 
}