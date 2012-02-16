package imageprocessing.image.operations;


import java.awt.image.BufferedImage;
import java.awt.image.ByteLookupTable;
import java.awt.image.LookupOp;

public abstract class GreyMapOp extends StandardImageOp
{

	protected byte[] table = new byte[256];
	
	public int getTableEntry(int i)
	{
		if (table[i] < 0)
			return 256 + (int) table[i];
		else
			return (int) table[i];
	}
	
	protected void setTableEntry(int i, int value)
	{
		if(value < 0)
			table[i] = (byte) 0;
		else if (value > 255)
			table[i] = (byte) 255;
		else
			table[i] = (byte) value;
	}
	
	public void computeMapping()
	{
		computeMapping(0, 255);
	}
	
	public abstract void computeMapping(int low, int high);
	
	public BufferedImage filter(BufferedImage src, BufferedImage dest)
	{
		if(dest == null)
			dest = createCompatibleDestImage(src, null);
		
		LookupOp operation = new LookupOp(new ByteLookupTable(0, table), null);
		operation.filter(src, dest);
		return dest;
	}
}
