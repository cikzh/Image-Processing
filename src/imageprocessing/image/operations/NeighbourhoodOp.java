package imageprocessing.image.operations;

/**
 * TODO: Make this work
 */

import java.awt.image.ImagingOpException;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;

public class NeighbourhoodOp extends StandardImageOp
{
  protected int width;
  protected int height;
  protected int size;
  protected BorderStrategy borderStrategy;

  public NeighbourhoodOp(int w, int h, BorderStrategy border)
  {
    if ((w < 1) || (h < 1) || (w % 2 == 0) || (h % 2 == 0))
      throw new ImagingOpException("invalid neighbourhood dimensions");
    this.width = w;
    this.height = h;
    this.size = (w * h);
    this.borderStrategy = border;
  }

  public static final int circIndex(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0)
      return paramInt1 + paramInt2;
    if (paramInt1 >= paramInt2) {
      return paramInt1 - paramInt2;
    }
    return paramInt1;
  }

  protected void copyBorders(Raster src, WritableRaster dest)
  {
    int i = src.getWidth();
    int j = src.getHeight();
    int k = this.width / 2;
    int m = this.height / 2;
    int i2;
    for (int n = 0; n < i; n++) {
      for (int i1 = 0; i1 < m; i1++)
        dest.setSample(n, i1, 0, src.getSample(n, i1, 0));
      for (i2 = j - m; i2 < j; i2++)
        dest.setSample(n, i2, 0, src.getSample(n, i2, 0));
    }
    for (int i1 = 0; i1 < j; i1++) {
      for (i2 = 0; i2 < k; i2++)
        dest.setSample(i2, i1, 0, src.getSample(i2, i1, 0));
      for (int i3 = i - k; i3 < i; i3++)
        dest.setSample(i3, i1, 0, src.getSample(i3, i1, 0));
    }
  }

  public int getWidth() { return this.width; }
  public int getHeight() { return this.height; }
  public int getNumPixels() { return this.size; }
  public BorderStrategy getBorderStrategy() { return this.borderStrategy; }

  public static final int refIndex(int i, int n)
  {
    if (i < 0)
      return -i - 1;
    if (i >= n) {
      return 2 * n - i - 1;
    }
    return i;
  }
}