package com.stillwell.olympus.aphrodite;

//Matt Stillwell
//8/20/14

import java.awt.Color;

public class ColorPallet
{
	public static Color aqua = new Color(0, 255, 255);
	public static Color azure = new Color(240, 255, 255);
	public static Color banana = new Color(227, 207, 87);
	public static Color beige = new Color(245, 245, 220);
	public static Color black = new Color(0, 0, 0);
	public static Color blue = new Color(0, 0, 255);
	public static Color brick = new Color(156, 102, 31);
	public static Color bronze = new Color(205, 127, 50);
	public static Color brown = new Color(139, 69, 19);
	public static Color cadet = new Color(95, 158, 160);
	public static Color carrot = new Color(237, 145, 33);
	public static Color chartreuse = new Color(113, 198, 113);
	public static Color chocolate = new Color(210, 105, 30);
	public static Color cobalt = new Color(61, 89, 171);
	public static Color coral = new Color(255, 127, 80);
	public static Color crimson = new Color(220, 20, 60);
	public static Color cyan = aqua;
	public static Color darkSlateGray = new Color(49, 79, 79);
	public static Color diamond = new Color(185, 242, 255);
	public static Color eggshell = new Color(252, 230, 201);
	public static Color fuschia = new Color(255, 0, 255);
	public static Color ghost = new Color(248, 248, 255);
	public static Color gold = new Color(255, 215, 0);
	public static Color goldenrod = new Color(255, 193, 37);
	public static Color gray = new Color(128, 128, 128);
	public static Color green = new Color(0, 128, 0);
	public static Color honeydew = new Color(240, 255, 240);
	public static Color hotPink = new Color(255, 105, 180);
	public static Color indigo = new Color(75, 0, 130);
	public static Color juniper = new Color(118, 152, 143);
	public static Color khaki = new Color(255, 246, 143);
	public static Color lavender = new Color(230, 230, 250);
	public static Color lime = new Color(0, 255, 0);
	public static Color magenta = fuschia;
	public static Color maroon = new Color(128, 0, 0);
	public static Color midnight = new Color(25, 25, 112);
	public static Color moccasin = new Color(255, 228, 181);
	public static Color navy = new Color(0, 0, 128);
	public static Color olive = new Color(128, 128, 0);
	public static Color orange = new Color(255, 165, 0);
	public static Color orcid = new Color(218, 112, 214);
	public static Color peacock = new Color(51, 161, 201);
	public static Color pink = new Color(255, 192, 203);
	public static Color plum = new Color(255, 187, 255);
	public static Color purple = new Color(128, 0, 128);
	public static Color quartzGray = new Color(108, 105, 96);
	public static Color raspberry = new Color(135, 38, 87);
	public static Color red = new Color(255, 0, 0);
	public static Color salmon = new Color(250, 128, 114);
	public static Color seaGreen = new Color(46, 139, 87);
	public static Color sepia = new Color(94, 38, 18);
	public static Color sienna = new Color(160, 82, 45);
	public static Color silver = new Color(192, 192, 192);
	public static Color skyBlue = new Color(135, 206, 250);
	public static Color tan = new Color(222, 184, 135);
	public static Color teal = new Color(0, 128, 128);
	public static Color tomato = new Color(255, 99, 71);
	public static Color turquoise = new Color(0, 245, 255);
	public static Color ultramarine = new Color(18, 10, 143);
	public static Color violet = new Color(143, 0, 255);
	public static Color wheat = new Color(245, 222, 179);
	public static Color white = new Color(255, 255, 255);
	public static Color xanthic = new Color(237, 237, 9);
	public static Color yellow = new Color(255, 255, 0);
	public static Color zucchini = new Color(81, 97, 56);
	
	public static Color getRandomColor()
	{
		return getRandomColor(255, 0);
	}

	private static Color getRandomColor(int low/* 0 */, int high/* 255 */)
	{
		return new Color((int) ((high - low + 1) * Math.random() + low), (int) ((high - low + 1) * Math.random() + low),
				(int) ((high - low + 1) * Math.random() + low));
	}

	public static int modulo255(int n)
	{
		if (n < 0)
			while (n < 0)
				n += 255;
		if (n > 255)
			while (n > 255)
				n -= 255;
		return n;
	}

	public static Color invert(Color c)
	{
		return new Color(modulo255(255 - c.getRed()), modulo255(255 - c.getBlue()), modulo255(255 - c.getGreen())); // invert																												// forth
	}

	public static Color shade(Color c, int factor) // 1/amount darker
	{
		return shade(c, 1.0 / (double) factor);
	}

	public static Color shade(Color c, double factor) // darker
	{
		return new Color((modulo255((int) (c.getRed() * factor))), modulo255(((int) (c.getGreen() * factor))),
				modulo255(((int) (c.getBlue() * factor))));
	}

	public static Color tint(Color c, int factor) // 1/amount lighter
	{
		return tint(c, 1.0 / (double) factor);
	}

	public static Color tint(Color c, double factor) // lighter
	{
		Color i = invert(c);
		Color iPrime = new Color((modulo255((int) (i.getRed() * factor))), modulo255(((int) (i.getGreen() * factor))),
				modulo255(((int) (i.getBlue() * factor))));
		return invert(iPrime);
	}

}
