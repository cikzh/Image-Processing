package imageprocessing.image;

/**
 * 
 * The BaseArray class is used mainly for raw data storage.
 * Data is stored in a 1D array, so calculations without
 * need for spatial representation go here
 * 
 * @author Marlon Peeters
 * 
 */

public abstract class BaseArray
{
	
	private int size;
	
	public BaseArray(int s)
	{
		this.size = s;
	}
	
	public int getSize()
	{
		return this.size;
	}
	
	public double getElement(int i)
	{
		return i;
	}
	
	public void setElement(int i, double value)
	{
		
	}
}
