package imageprocessing;

import imageprocessing.image.operations.RGBMapOp;

public class TestOp extends RGBMapOp
{
	
	public TestOp()
	{
		System.out.println(getTableEntry(0));
		
		for(int i = 0; i < 256; i++)
			setTableEntry(i, i);
	}

	@Override
	public void computeMapping(int low, int high)
	{
		
	}

}
