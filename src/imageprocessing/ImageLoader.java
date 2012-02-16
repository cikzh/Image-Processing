package imageprocessing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader
{
	
	private BufferedImage img;
	
	public ImageLoader(String path)
	{
		img = null;
		try {
		    img = ImageIO.read(new File(path));
		} catch (IOException e) {
			System.err.println(e);
		}
		
		//Flushes original images, because we don't need it anymore
		img.flush();
	}
	
	protected BufferedImage getImage()
	{
		return this.img;
	}
	

	
}
