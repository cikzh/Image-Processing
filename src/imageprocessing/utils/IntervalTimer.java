package imageprocessing.utils;

public final class IntervalTimer
{
  private long startTime;
  private long endTime;
  private boolean timing;

  public double getElapsedTime()
  {
    if (this.timing) {
      long l = System.nanoTime();
      return (l - this.startTime) / 1000.0D;
    }

    return (this.endTime - this.startTime) / 1000.0D;
  }

  public boolean isStopped()
  {
    return this.timing ^ true;
  }

  public boolean isTiming()
  {
    return this.timing;
  }

  public void reset()
  {
    this.startTime = (this.endTime = 0L);
    this.timing = false;
  }

  public void start()
  {
    if (!this.timing)
    {
      this.startTime = System.currentTimeMillis();
      this.endTime = 0L;
      this.timing = true;
    }
  }

  public double stop()
  {
    if (this.timing) {
      this.endTime = System.currentTimeMillis();
      this.timing = false;
    }
    return (this.endTime - this.startTime) / 1000.0D;
  }

  public String toString()
  {
    if ((this.startTime == 0L) && (this.endTime == 0L)) {
      return new String(getClass().getName() + ": unused");
    }
    if (this.timing) {
      return new String(getClass().getName() + ": started " + this.startTime);
    }
    return new String(getClass().getName() + ": started " + this.startTime + 
      ", stopped " + this.endTime);
  }
}