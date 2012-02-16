package imageprocessing.image.operations;

import com.pearsoneduc.ip.op.Histogram;
import com.pearsoneduc.ip.op.HistogramException;

public class EqualizeOp extends GreyMapOp
{
	
	public EqualizeOp(Histogram hist) throws HistogramException
	{
		float scale = 255.0f / hist.getNumSamples();
		for(int i = 0; i < 256; i++)
			setTableEntry(i, Math.round(scale * hist.getCumulativeFrequency(i)));
	}

	@Override
	public void computeMapping(int low, int high)
	{
		//No limits needed in equalization
	}

}
