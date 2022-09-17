package UmlShape;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

public abstract class BasicObj extends Shape{

	int width,height;
	protected Port[] ports = new Port[4];
	
	public abstract void draw(Graphics g);
	
	public void setLocation(Point p1, Point p2)
	{
		int moveX=p1.x-p2.x;
		int moveY=p1.y-p2.y;
		this.x1+=moveX;
		this.y1+=moveY;
		this.x2=width+x1;
		this.y2=height+y1;
		
		int[] xpoint = {(x1+x2)/2, x2, (x1+x2)/2, x1};
		int[] ypoint = {y1, (y1+y2)/2, y2, (y1+y2)/2};
		
		for(int i = 0; i < ports.length; i++) 
		{
			ports[i].setPort(xpoint[i], ypoint[i]);
			ports[i].setLine();
		}
	}
	
	protected void createPorts() 
	{
		int[] xpoint = {(x1+x2)/2, x2, (x1+x2)/2, x1};
		int[] ypoint = {y1, (y1+y2)/2, y2, (y1+y2)/2};

		for(int i = 0; i < ports.length; i++) 
		{
			Port p = new Port();
			p.setPort(xpoint[i], ypoint[i]);
			ports[i] = p;
		}
	}
	
	public void drawPort(Graphics g)
	{
		for(int i = 0; i < ports.length; i++)
		{
			g.fillRect(ports[i].x,ports[i].y,ports[i].width,ports[i].height);
		}
	}
	
	@Override
	public void changeName(String name)
	{
		this.name=name;
	}
	
	@Override
	public int isInside(Point p) {
		Point c = new Point();
		c.x = (x1 + x2) / 2;
		c.y = (y1 + y2) / 2;
		Point[] points = { new Point(x1, y1), new Point(x2, y1), new Point(x2, y2), new Point(x1, y2) };
		
		for (int i = 0; i < points.length; i++) {
			Polygon polygon = new Polygon();
			
			int next = ((i + 1) % 4);
			polygon.addPoint(points[i].x, points[i].y);
			polygon.addPoint(points[next].x, points[next].y);
			polygon.addPoint(c.x, c.y);

			if (polygon.contains(p)) {
				return i;
			}
		}
		return -1;
	}
	
	@Override
	public Port getPort(int index)
	{
		return ports[index];
	}
}
