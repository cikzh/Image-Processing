package imageprocessing.image;

public class ByteImage extends BaseImage
{
	@SuppressWarnings("unused")
	private byte[] data;
	
	public ByteImage(int w, int h, byte[] d)
	{
		super(w,h);
		this.data = d;
	}

}
