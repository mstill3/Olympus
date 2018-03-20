package com.stillwell.olympus.hermes.keys;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Keys implements java.awt.event.KeyListener
{
	private ArrayList<Key> keys;

	public Keys()
	{
		keys = new ArrayList<Key>();
	}

	private int getKeyIndex(Key next)
	{		
		for(int i = 0; i < keys.size(); i++)
			if(keys.get(i).equals(next))
				return i;
		return -1;
	}

	private boolean keyAlreadyPressed(Key next)
	{
		for(Key k : keys)
			if(k.equals(next))
				return true;
		return false;
	}

	public boolean pressed(String name)
	{
		ArrayList<Key> keysPressed = getKeysPressed();

		for(Key k : keysPressed)
			if(k.equals(KeyData.getKey(name)))
				return true;

		return false;
	}

	public boolean unpressed(String name)
	{
		ArrayList<Key> keysReleased = getKeysReleased();

		for(Key k : keysReleased)
			if(k.equals(KeyData.getKey(name)))
				return true;

		return false;
	}

	@Override
	public void keyPressed(KeyEvent e)
	{

		//		System.out.println((int) e.getKeyChar() + "    " + e.getKeyCode() + "    " + e.getKeyChar());
		Key next = new Key(e.getKeyChar(), e.getKeyCode());
		if(!keyAlreadyPressed(next))
			keys.add(next);
		keys.get(getKeyIndex(next)).setPressed(true);
		keysToLabel();
	}

	public ArrayList<Key> getKeysPressed()
	{
		ArrayList<Key> keysPressed = new ArrayList<Key>();

		for(Key k : keys)
			if(k.isPressed())
				keysPressed.add(k);

		return keysPressed;
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		int num = getKeyIndex(new Key(e.getKeyChar(), e.getKeyCode()));
		if(num != -1)
		{
			keys.get(num).setPressed(false);	
			keysToLabel();
		}
	}

	public ArrayList<Key> getKeysReleased()
	{
		ArrayList<Key> keysReleased = new ArrayList<Key>();

		for(Key k : keys)
			if(!k.isPressed())
				keysReleased.add(k);

		return keysReleased;
	}

	@Override
	public void keyTyped(KeyEvent e){}

	public void keysToLabel()
	{
		ArrayList<Key> keys = getKeysPressed();
		String lab = "";

		for(Key k : keys)
			lab += k + "    ";

		KeysTester.label.setText(lab);
	}

}
