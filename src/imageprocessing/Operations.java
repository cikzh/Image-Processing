package imageprocessing;

public enum Operations
{
	NONE 			("None"),
	ADD				("Add"),
	LINEAR_MAP		("Linear Mapping"),
	INVERT			("Invert"),
	EQUALIZE		("Histogram Equalization"),
	BLUR			("Blur"),
	EDGE_DETECTION 	("Edge Detector"),
	EXP				("Exponential Mapping")
	;
	
	private final String id;
	
	Operations(String id)
	{
		this.id = id;
	}
	
	public String id(){ return id; }
}
