package com.stillwell.olympus.hermes.keys;

import java.awt.Container;
import java.awt.Label;

import javax.swing.JFrame;

public class KeysTester
{

	public static Label label = new Label("Goose");
	
	public static void main(String[] args)
	{

		JFrame frame = new JFrame();
		Keys keys = new Keys();

		frame.addKeyListener(keys);
		frame.setSize(1000, 100);
		frame.setVisible(true);

		Container contentPane = frame.getContentPane();

		contentPane.add(label);
		System.out.println("d");

	}

}
