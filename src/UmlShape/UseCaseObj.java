package UmlShape;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;

public class UseCaseObj extends BasicObj{
	
	public UseCaseObj(int x1,int y1,String name)
	{
		this.width=120;
		this.height=90;
		this.x1=x1;
		this.y1=y1;
		this.x2=width+x1;
		this.y2=height+y1;
		this.name=name;
		
		createPorts();
	}
	
	public void draw(Graphics g) 
	{
		g.setColor(new Color(153, 255, 153));
		g.fillOval(x1,y1,120,90);
		
		g.setColor(new Color(0, 0, 0));
		g.drawOval(x1,y1,120,90);
		
		// set obj name
		int stringWidth = g.getFontMetrics(font).stringWidth(name);
		double empty = (120 - stringWidth)/2;
		g.setFont(font);	
		
		g.drawString(name, x1 + (int)empty, y1 + 50);
	}
}
