package com.stillwell.olympus.aphrodite;

//Matt Stillwell
//8/20/14

import java.awt.Color;
import java.awt.Component;
import javax.swing.JFrame;

import com.stillwell.olympus.athena.MathPlus;

public class ColorPallet extends Component
{

	private static final long serialVersionUID = 1L;

	final static JFrame frame = new JFrame();

	public static final Color aqua = new Color(0, 255, 255);
	public static final Color azure = new Color(240, 255, 255);
	public static final Color banana = new Color(227, 207, 87);
	public static final Color beige = new Color(245, 245, 220);
	public static final Color black = new Color(0, 0, 0);
	public static final Color blue = new Color(0, 0, 255);
	public static final Color brick = new Color(156, 102, 31);
	public static final Color bronze = new Color(205, 127, 50);
	public static final Color brown = new Color(139, 69, 19);
	public static final Color cadet = new Color(95, 158, 160);
	public static final Color carrot = new Color(237, 145, 33);
	public static final Color chartreuse = new Color(113, 198, 113);
	public static final Color chocolate = new Color(210, 105, 30);
	public static final Color cobalt = new Color(61, 89, 171);
	public static final Color coral = new Color(255, 127, 80);
	public static final Color crimson = new Color(220, 20, 60);
	public static final Color cyan = aqua;
	public static final Color darkSlateGray = new Color(49, 79, 79);
	public static final Color diamond = new Color(185, 242, 255);
	public static final Color eggshell = new Color(252, 230, 201);
	public static final Color fuschia = new Color(255, 0, 255);
	public static final Color ghost = new Color(248, 248, 255);
	public static final Color gold = new Color(255, 215, 0);
	public static final Color goldenrod = new Color(255, 193, 37);
	public static final Color gray = new Color(128, 128, 128);
	public static final Color green = new Color(0, 128, 0);
	public static final Color honeydew = new Color(240, 255, 240);
	public static final Color hotPink = new Color(255, 105, 180);
	public static final Color indigo = new Color(75, 0, 130);
	public static final Color juniper = new Color(118, 152, 143);
	public static final Color khaki = new Color(255, 246, 143);
	public static final Color lavender = new Color(230, 230, 250);
	public static final Color lime = new Color(0, 255, 0);
	public static final Color magenta = fuschia;
	public static final Color maroon = new Color(128, 0, 0);
	public static final Color midnight = new Color(25, 25, 112);
	public static final Color moccasin = new Color(255, 228, 181);
	public static final Color navy = new Color(0, 0, 128);
	public static final Color olive = new Color(128, 128, 0);
	public static final Color orange = new Color(255, 165, 0);
	public static final Color orcid = new Color(218, 112, 214);
	public static final Color peacock = new Color(51, 161, 201);
	public static final Color pink = new Color(255, 192, 203);
	public static final Color plum = new Color(255, 187, 255);
	public static final Color purple = new Color(128, 0, 128);
	public static final Color quartzGray = new Color(108, 105, 96);
	public static final Color raspberry = new Color(135, 38, 87);
	public static final Color red = new Color(255, 0, 0);
	public static final Color salmon = new Color(250, 128, 114);
	public static final Color seaGreen = new Color(46, 139, 87);
	public static final Color sepia = new Color(94, 38, 18);
	public static final Color sienna = new Color(160, 82, 45);
	public static final Color silver = new Color(192, 192, 192);
	public static final Color skyBlue = new Color(135, 206, 250);
	public static final Color tan = new Color(222, 184, 135);
	public static final Color teal = new Color(0, 128, 128);
	public static final Color tomato = new Color(255, 99, 71);
	public static final Color turquoise = new Color(0, 245, 255);
	public static final Color ultramarine = new Color(18, 10, 143);
	public static final Color violet = new Color(143, 0, 255);
	public static final Color wheat = new Color(245, 222, 179);
	public static final Color white = new Color(255, 255, 255);
	public static final Color xanthic = new Color(237, 237, 9);
	public static final Color yellow = new Color(255, 255, 0);
	public static final Color zucchini = new Color(81, 97, 56);
	
	public static Color[] rainbow =
	{
		white, ghost, azure, honeydew, beige, lavender, silver, juniper, gray, quartzGray,
		violet, raspberry, purple, indigo, ultramarine, midnight, navy, blue, cobalt, teal, seaGreen, olive,
		zucchini, green, cadet, skyBlue, turquoise, aqua, diamond, lime, chartreuse, tan, banana, khaki, yellow,
		xanthic, gold, goldenrod, moccasin, eggshell, wheat, plum, pink, hotPink, fuschia, orcid, salmon, tomato,
		red, crimson, carrot, coral, orange, chocolate, brick, sienna, brown, sepia, maroon, black, bronze
	};

	public static String[] rainbowNames =
	{
		"white", "ghost", "azure", "honeydew", "beige", "lavender", "silver",
		"juniper", "gray", "quartzGray", "violet", "raspberry", "purple", "indigo", "ultramarine", "midnight",
		"navy", "blue", "cobalt", "teal", "seaGreen", "olive", "zucchini", "green", "cadet", "skyBlue", "turquoise",
		"aqua", "diamond", "lime", "chartreuse", "tan", "banana", "khaki", "yellow", "xanthic", "gold", "goldenrod",
		"moccasin", "eggshell", "wheat", "plum", "pink", "hotPink", "fuschia", "orcid", "salmon", "tomato", "red",
		"crimson", "carrot", "coral", "orange", "chocolate", "brick", "sienna", "brown", "sepia", "maroon", "black",
		"bronze"
	};

	public static Color getRandomColor()
	{
		return getRandomColor(255, 0);
	}

	public static Color getRandomColor(int low/* 0 */, int high/* 255 */)
	{
		return new Color((int) ((high - low + 1) * Math.random() + low), (int) ((high - low + 1) * Math.random() + low),
				(int) ((high - low + 1) * Math.random() + low));
	}

	public static Color getRandomPalletColor()
	{
		return rainbow[((int) (((rainbow.length - 1) - 0 + 1) * Math.random() + 0))];
	}

	public static Color invert(Color c)
	{
		return new Color(MathPlus.modulo(255 - c.getRed(), 255), MathPlus.modulo(255 - c.getBlue(), 255), MathPlus.modulo(255 - c.getGreen(), 255));																									// forth
	}

	public static Color shade(Color c, int factor) // 1/amount darker
	{
		return shade(c, 1.0 / (double) factor);
	}

	public static Color shade(Color c, double factor) // darker
	{
		return new Color((MathPlus.modulo((int) (c.getRed() * factor), 255)), MathPlus.modulo(((int) (c.getGreen() * factor)), 255),
				MathPlus.modulo(((int) (c.getBlue() * factor)), 255));
	}

	public static Color tint(Color c, int factor) // 1/amount lighter
	{
		return tint(c, 1.0 / (double) factor);
	}

	public static Color tint(Color c, double factor) // lighter
	{
		Color i = invert(c);
		Color iPrime = new Color((MathPlus.modulo((int) (i.getRed() * factor), 255)), MathPlus.modulo(((int) (i.getGreen() * factor)), 255),
				MathPlus.modulo(((int) (i.getBlue() * factor)), 255));
		return invert(iPrime);
	}

}
