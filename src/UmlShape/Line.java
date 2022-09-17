package UmlShape;

import java.awt.Graphics;
import java.awt.Point;

public abstract class Line extends Shape{

	protected Port[] ports = new Port[2];
	
	public abstract void draw(Graphics g);

	public void setPort(Port port1, Port port2)
	{
		this.ports[0]=port1;
		this.ports[1]=port2;
	}
	
	public void drawPort(Graphics g) {
		this.draw(g);
	}
	
	@Override
	public void setLocation()
	{
		this.x1=(int) this.ports[0].getCenterX();
		this.y1=(int) this.ports[0].getCenterY();
		
		this.x2=(int) this.ports[1].getCenterX();
		this.y2=(int) this.ports[1].getCenterY();
		
	}
	
	public int isInside(Point p) {
		return -2;
	}

}
