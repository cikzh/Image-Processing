package imageprocessing.image.operations;


public class LinearOp extends GreyMapOp
{

	public LinearOp()
	{
		computeMapping();
	}
	
	public LinearOp(int low, int high)
	{
		computeMapping(low, high);
	}
	
	@Override
	public void computeMapping(int low, int high)
	{
		if(low < 0 || high > 255 || low >=high)
			throw new java.awt.image.ImagingOpException("invalid mapping limits");
		
		float scaling = 255.0f / (high-low);
		for(int i = 0; i < 256; i++)
		{
			setTableEntry(i, Math.round(scaling * (i-low)));
		}

	}

}
