package com.stillwell.olympus.athena.structure;

public class Tester
{

	public static void main(String[] args)
	{
	
		Integer[] nums = {4, 3, 4, 5};
		Pail<Integer> p = new Pail<Integer>(nums);
		System.out.println(p);
		System.out.println(p.indexOf(nums, 3));
		p.sort();
		System.out.println(p);
		p.flip();
		System.out.println(p);
		
	}
	
}
