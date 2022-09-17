package UmlShape;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Port extends Rectangle{
	
	private List<Line> lines = new ArrayList<Line>(); 
	
	public void setPort(int cx, int cy) 
	{
		int x = cx - 5;
		int y = cy - 5;
		int w = 10;
		int h = 10;
		setBounds(x, y, w, h);
	}
	
	public void addLine(Line line)
	{
		lines.add(line);
		System.out.println(lines);
	}
	
	public void deletLine(Line line)
	{
		lines.remove(line);
	}
	
	public void setLine()
	{
		for(int i=0;i<lines.size();i++)
		{
			Line line=lines.get(i);
			line.setLocation();
		}
	}
}
