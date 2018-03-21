package com.stillwell.olympus.athena;

import java.util.Scanner;

public class MathPlus
{

	public static void main(String[] args)
	{		
		while(true)
		{
			int n = new Scanner(System.in).nextInt();
			System.out.println(modulo(n, 255));
		}
	}

	public static int modulo(int num, int base)
	{
		int remainder = num % base;
		if (remainder < 0)
			remainder += base;
		return remainder;
	}

}
