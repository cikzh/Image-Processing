package imageprocessing.image.operations;

public class AddOp extends GreyMapOp
{
	
	public AddOp(int amount)
	{
		for(int i = 0; i < 256; i++)
			setTableEntry(i, i+amount);
	}

	@Override
	public void computeMapping(int low, int high)
	{
		// no limits needed
	}

}
