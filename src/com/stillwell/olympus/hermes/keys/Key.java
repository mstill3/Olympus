package com.stillwell.olympus.hermes.keys;

public class Key
{

	private boolean isPressed;
	private String name;
	private int character;
	private int code;

	public Key(int character, int code)
	{
		setCode(code);
		setCharacter(character);
		setName(KeyData.getName(character, code));
		setPressed(false);
	}

	public Key(int character, int code, String name)
	{
		setCode(code);
		setCharacter(character);
		setName(name);
		setPressed(false);
	}

	public boolean isPressed()
	{
		return isPressed;
	}

	public void setPressed(boolean isPressed)
	{
		this.isPressed = isPressed;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getCharacter()
	{
		return character;
	}

	public void setCharacter(int character)
	{
		this.character = character;
	}

	public int getCode()
	{
		return code;
	}

	public void setCode(int code)
	{
		this.code = code;
	}

	public boolean equals(Key k)
	{
//		System.out.println(name + " - " + k.getName() + "           " + code  + " - " + k.getCode());
		return ((name.equals(k.getName())) && (code == k.getCode()));
	}

	public String toString()
	{

		String str = "";
		if(KeyData.undefined(getCharacter()))
			str = "UNDEFINED";
		else
			str = getCharacter() + "";

		return str + " - " + getCode() + " - " + getName();
	}

}
