package imageprocessing;

/**
 * 
 * JPanel used to display images.
 * Overrides paint method that will process 
 * images operations before displaying image
 * 
 * @author Marlon Peeters
 * 
 */

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImageCanvas extends JPanel
{
	private static final long	serialVersionUID	= 1L;

	private BufferedImage image;
	
	public ImageCanvas()
	{

	}
	
	public void setImage(BufferedImage img)
	{
		image = img;
	}
	
	public void paint(BufferedImageOp operation)
	{
		Graphics g = this.getGraphics();
		if(image != null)
		{
			if(operation != null)
			{
				BufferedImage filteredImage = operation.filter(image, null);
				BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
				Graphics big = newImage.getGraphics();
		        big.drawImage(image, 0, 0, null);
		        BufferedImage biFiltered = image = filteredImage;
		        
		        Graphics2D g2 = (Graphics2D) g;
				g2.drawImage(biFiltered, 0, 0, this);
			}
			else
			{
				Graphics2D g2 = (Graphics2D) g;
				g2.drawImage(image, 0, 0, this);
			}
		}
	}
	
	public void saveImage(File file)
	{
		try
		{
			ImageIO.write(image, "png", file);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
