package UmlShape;

import java.util.ArrayList;
import java.util.List;

import UmlEditor.Canvas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class Group extends Shape{
	
	private List<Shape> groupShapes=new ArrayList<Shape>();
	private Rectangle groupRec=new Rectangle();
	
	public Shape selectedObj = null;
	
	public Group()
	{
		this.name="Group";
	}
	
	public void draw(Graphics g)
	{
		for(int i=groupShapes.size()-1;i>=0;i--)
		{
			Shape shape=groupShapes.get(i);
			shape.draw(g);
		}
	}
	
	@Override
	public void drawGroup(Graphics g)
	{
		g.setColor(new Color(153, 255, 204, 50));
		g.fillRect(groupRec.x-10, groupRec.y-10, groupRec.width+20, groupRec.height+20);
		g.setColor(new Color(153, 255, 204));
		g.drawRect(groupRec.x-10, groupRec.y-10, groupRec.width+20, groupRec.height+20);
	}
	
	public void addShape(Shape shape)
	{
		groupShapes.add(shape);
	}
	
	public List<Shape> getShapes() {
		return groupShapes;
	}
	
	public void setLocation(Point p1, Point p2) 
	{
		for (int i = 0; i < groupShapes.size(); i++) 
		{
			Shape shape = groupShapes.get(i);
			shape.setLocation(p1, p2);
		}
		setRecLocation(p1, p2);
	}
	
	public void setRecLocation(Point p1, Point p2) 
	{
		int moveX=p1.x-p2.x;
		int moveY=p1.y-p2.y;
		groupRec.setLocation(groupRec.x + moveX, groupRec.y + moveY);
		x1 = groupRec.x;
		y1 = groupRec.y;
		x2 = groupRec.x + groupRec.width;
		y2 = groupRec.y + groupRec.height;
	}
	
	public void setEdge()
	{
		int x1=Integer.MAX_VALUE;
		int x2=Integer.MIN_VALUE;
		int y1=Integer.MAX_VALUE;
		int y2=Integer.MIN_VALUE;
		
		for(int i=0;i<groupShapes.size();i++)
		{
			Shape shape=groupShapes.get(i);
			
			x1=Math.min(shape.getX1(), x1);
			x2=Math.max(shape.getX2(), x2);
			y1=Math.min(shape.getY1(), y1);
			y2=Math.max(shape.getY2(), y2);
		}
		groupRec.setBounds(x1, y1, Math.abs(x1-x2), Math.abs(y1-y2));

		this.x1 = groupRec.x;
		this.y1 = groupRec.y;
		this.x2 = groupRec.x + groupRec.width;
		this.y2 = groupRec.y + groupRec.height;
	}
	public int isInside(Point p) 
	{
		for (int i = 0; i < groupShapes.size(); i++) 
		{
			Shape shape = groupShapes.get(i);
			int inside = shape.isInside(p);
			if (inside >=0) 
			{
				selectedObj = shape;
				return 4;
			}
		}
		return -1;
	}
	
	public void changeName(String name)
	{
		this.name=name;
	}
	
	@Override
	public Shape getSelectedObj() 
	{
		return selectedObj;
	};
}
