package imageprocessing.image.operations;

import java.awt.RenderingHints;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ColorModel;

public class StandardImageOp implements BufferedImageOp
{

	public BufferedImage filter(BufferedImage src, BufferedImage dest)
	{
		if(dest == null)
		{
			dest = createCompatibleDestImage(src, null);
		}
		return dest;
	}
	
	public BufferedImage createCompatibleDestImage(BufferedImage src, ColorModel destModel)
	{
		if (destModel == null)
			destModel = src.getColorModel();
		
		int w = src.getWidth();
		int h = src.getHeight();
		
		BufferedImage image = new BufferedImage(destModel, 
				destModel.createCompatibleWritableRaster(w, h), 
				destModel.isAlphaPremultiplied(),
				null);
		
		return image;
	}

	@Override
	public Rectangle2D getBounds2D(BufferedImage src)
	{
		return src.getRaster().getBounds();
	}

	@Override
	public Point2D getPoint2D(Point2D srcPoint, Point2D destPoint)
	{
		if(destPoint == null)
			destPoint = new Point2D.Float();
		
		destPoint.setLocation(srcPoint.getX(), srcPoint.getY());
		return destPoint;
	}

	@Override
	public RenderingHints getRenderingHints()
	{
		return null;
	}
}
