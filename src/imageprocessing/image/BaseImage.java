package imageprocessing.image;

/**
 * 
 * BaseImage class is a 2D representation of the BaseArray class.
 * Used for calculations where a 2D representation is vital
 * 
 * @author Marlon Peeters
 *
 */

public class BaseImage extends BaseArray
{
	private int width;
	private int height;
	
	public BaseImage(int w, int h)
	{
		super(w*h);
		this.width = w;
		this.height = h;
	}

	public byte getPixel(int x, int y)
	{
		return 0;
	}
	
	public void setPixel(int x, int y, int value)
	{
		
	}
	
	public int getWidth()
	{
		return this.width;
	}

	public int getHeight()
	{
		return this.height;
	}

	
}
