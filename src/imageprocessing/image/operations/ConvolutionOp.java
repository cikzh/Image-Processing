package imageprocessing.image.operations;

public class ConvolutionOp
{
	private float[] coeffs;
	private int	kernelW;
	//private int	kernelH;
	
	public ConvolutionOp(float[] coefficients)
	{
		this.coeffs = coefficients;
		int kernelSize = (int)Math.sqrt(coeffs.length);
		this.kernelW = kernelSize;
		//this.kernelH = kernelSize;

	}
	
	public int getKernelSize()
	{
		return kernelW;
	}
	
}