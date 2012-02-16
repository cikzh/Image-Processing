package imageprocessing.image.operations;

import java.awt.image.ImagingOpException;

public class ExpOp extends GreyMapOp
{
	
	private static final double SCALE = Math.log(256.0D) / 255.0D;
	
	public ExpOp()
	{
		computeMapping();
	}
	
	public ExpOp(int low, int high)
	{
		computeMapping(low, high);
	}

	@Override
	public void computeMapping(int low, int high)
	{
		if ((low < 0) || (high > 255) || (low >= high))
			throw new ImagingOpException("invalid mapping limits");
		
		double l = Math.exp(SCALE * low) - 1.0D;
		double h = Math.exp(SCALE *high) - 1.0D;
		double scaling = 255.0D / (h-l);
		for(int i = 0; i < 256; i++)
		{
			int value = (int) Math.round(scaling * (Math.exp(SCALE * i) - 1.0D - l));
			setTableEntry(i, value);
		}
	}

}
