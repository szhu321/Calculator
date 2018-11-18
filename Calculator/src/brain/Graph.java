package brain;
import java.util.ArrayList;
import java.util.List;

import datatypes.Vector2;

public class Graph
{
	private List<Vector2> vectors;
	
	public Graph()
	{
		vectors = new ArrayList<Vector2>();
	}
	
	public List<Vector2> getVectors()
	{
		return vectors;
	}
}
