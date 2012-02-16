package imageprocessing.image.operations;

public class InvertOp extends RGBMapOp
{

	public InvertOp()
	{
		for(int i = 0; i < 256; i++)
			setTableEntry(i, 255-i);
	}

	@Override
	public void computeMapping(int low, int high)
	{
		//No limits needed
	}
}