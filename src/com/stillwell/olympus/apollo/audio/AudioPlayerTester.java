package com.stillwell.olympus.apollo.audio;

public class AudioPlayerTester
{

    public static void main(String[] args)
    {
    	//file needs to be of type .wav and in a folder called res in root directory
        AudioPlayer player = new AudioPlayer("summer", 100);
//        player.setVolume(0);
//        player.setVolume(33);
//        player.setVolume(66);
//        player.setVolume(100);
        player.play();
    }

}

