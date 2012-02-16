package imageprocessing.image.operations;

import java.awt.image.BufferedImage;
import java.awt.image.ByteLookupTable;
import java.awt.image.LookupOp;

public abstract class RGBMapOp extends StandardImageOp
{

	protected byte[] table = new byte[256];
	protected byte[] red = new byte[256];
	protected byte[] green = new byte[256];
	protected byte[] blue = new byte[256];
	protected byte[] alpha = new byte[256];
	
	public int getTableEntry(int i)
	{
		if (table[i] < 0)
			return 256 + (int) table[i];
		else
			return (int) table[i];
	}
	
	protected void setTableEntry(int i, int value)
	{
		if(value < 0) {
			red[i] = (byte) 0;
			green[i] = (byte) 0;
			blue[i] = (byte) 0;
		}
		else if (value > 255) {
			red[i] = (byte) 255;
			green[i] = (byte) 255;
			blue[i] = (byte) 255;
		}
		else {
			red[i] = (byte) value;
			green[i] = (byte) value;
			blue[i] = (byte) value;
		}
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
		
		LookupOp operation = new LookupOp(new ByteLookupTable(0, red), null);
		operation.filter(src, dest);
		return dest;
	}
}
