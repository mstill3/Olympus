package com.stillwell.olympus.aphrodite.image;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import com.stillwell.olympus.aphrodite.ColorPallet;

public class ImageEditor
{

	private BufferedImage image;

	public ImageEditor(BufferedImage img)
	{
		image = img;
	}

	public ImageEditor(Image img)
	{
		image = getBuffered(img);
	}

	public static BufferedImage getBuffered(Image img)
	{
		return (BufferedImage) img;
	}

	public Color getColor(int x, int y)
	{
		return new Color(getBuffered(image).getRGB(x, y));
	}

	public void setColor(int x, int y, Color color)
	{
		image.setRGB(x, y, color.getRGB());
	}

	public BufferedImage getBufferedImage()
	{
		return image;
	}

	public int width()
	{
		return image.getWidth();
	}

	public int height()
	{
		return image.getHeight();
	}

	public void addColor(int r, int g, int b)
	{
		for(int x = 0; x < image.getWidth(); x++)
		{
			for(int y = 0; y < image.getHeight(); y++)	
			{

				int rgb = image.getRGB(x, y);

				//rgb to r,g,b
				int red = (rgb >> 16) & 0xFF;
				int green = (rgb >> 8) & 0xFF;
				int blue = rgb & 0xFF;

				//stuff
				red += r;
				green += g;
				blue += b;

				//r,g,b to rgb
				int rgb2 = red;
				rgb2 = (rgb2 << 8) + green;
				rgb2 = (rgb2 << 8) + blue;

				image.setRGB(x, y, rgb2);
			}
		}
	}
	
	public void invertColor()
	{
		for(int x = 0; x < image.getWidth(); x++)
		{
			for(int y = 0; y < image.getHeight(); y++)	
			{

				int rgb = image.getRGB(x, y);

				//rgb to r,g,b
				int red = (rgb >> 16) & 0xFF;
				int green = (rgb >> 8) & 0xFF;
				int blue = rgb & 0xFF;

				Color c = new Color(red, green, blue);
				c = ColorPallet.invert(c);
				
				//stuff
				red = c.getRed();
				green = c.getGreen();
				blue = c.getBlue();

				//r,g,b to rgb
				int rgb2 = red;
				rgb2 = (rgb2 << 8) + green;
				rgb2 = (rgb2 << 8) + blue;

				image.setRGB(x, y, rgb2);
			}
		}
	}
	
}
