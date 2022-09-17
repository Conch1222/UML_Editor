package UmlShape;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Point;

public class ClassObj extends BasicObj{
	
	public ClassObj(int x1,int y1,String name)
	{
		this.width=100;
		this.height=120;
		this.x1=x1;
		this.y1=y1;
		this.x2=width+x1;
		this.y2=height+y1;
		this.name=name;
		createPorts();
	}

	public void draw(Graphics g) 
	{
		g.setColor(new Color(153, 204, 255));
		g.fillRect(x1, y1, 100, 120);
	
		g.setColor(new Color(0, 0, 0));
		g.drawRect(x1, y1, 100, 120);
		
		int split = 40;
		g.drawLine(x1, y1 + split, x2, y1 + split);
		g.drawLine(x1, y1 + split * 2, x2, y1 + split * 2);
		
		// set obj name
		int stringWidth = g.getFontMetrics(font).stringWidth(name);
		double empty = (Math.abs(x1-x2) - stringWidth)/2;
		g.setFont(font);	
		g.drawString(name, x1 + (int)empty, y1 + 25);
	}
}
