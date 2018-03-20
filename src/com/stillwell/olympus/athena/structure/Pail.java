package com.stillwell.olympus.athena.structure;

import java.util.ArrayList;

public class Pail<T extends Comparable<T>>
{
	private ArrayList<T> list;

	public Pail()
	{
		list = new ArrayList<T>();
	}	

	public Pail(T element)
	{
		list = new ArrayList<T>();
		add(element);
	}	

	public Pail(T[] list)
	{
		this.list = new ArrayList<T>();
		for(T t : list)
			add(t);
	}
	
	public Pail(ArrayList<T> list)
	{
		this.list = new ArrayList<T>();
		for(T t : list)
			add(t);
	}

	public void add(T element)
	{
//		if(!hasElement(element))
			list.add(element);
	}
	
	public void add(T[] elements)
	{
		for(T t : elements)
			add(t);
	}
	
	public void add(ArrayList<T> elements)
	{
		for(T t : elements)
			add(t);
	}
	
	public void remove(T element)
	{
//		if(hasElement(element))
			list.remove(element);
	}
	
	public void remove(T[] elements)
	{
		for(T t : elements)
			remove(t);
	}
	
	public void remove(ArrayList<T> elements)
	{
		for(T t : elements)
			remove(t);
	}

	public boolean hasElement(T element)
	{
		for(int i = 0; i < list.size(); i++)
			if(list.get(i).equals(element))
				return true;
		return false;
	}

	public void sort()
	{
		for (int pass = 0; pass < list.size() - 1; pass++)
		{
			for (int i = 0; i < list.size() - 1; i++)
			{
				Comparable<T> listElem = (Comparable<T>) list.get(i);
				if (listElem.compareTo(list.get(i + 1)) > 0)
				{
					T temp = list.get(i);
					list.set(i, list.get(i + 1));
					list.set(i + 1, temp);
				}
			}
		}
	}
	
	public void flip()
	{
		ArrayList<T> temp = new ArrayList<T>();
		for(int i = list.size()-1; i >= 0; i--)
			temp.add(list.get(i));
		
		for(int i = 0; i < list.size(); i++)
			list.set(i, temp.get(i));
	}

	public int indexOf(T[] list, T searchItem)
	{
		for(int i = 0; i < list.length; i++)
			if(list[i].equals(searchItem))
				return i;
		return -1;
	}

	public String toString()
	{
		String str = "";
		for(int i = 0; i < list.size(); i++)
			str += list.get(i) + "  ";
		return str; 
	}
}

