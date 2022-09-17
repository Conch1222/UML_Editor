package UmlShape;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;
import java.awt.Font;

import UmlEditor.Canvas;
import java.awt.Point;

public abstract class Shape {
	protected int x1, y1, x2, y2;
	public boolean isSelected=false;
	public String name;
	
	public int getX1()
	{
		return this.x1;
	}
	public int getX2()
	{
		return this.x2;
	}
	public int getY1()
	{
		return this.y1;
	}
	public int getY2()
	{
		return this.y2;
	}
	
	public Canvas canvas = Canvas.getInstance();
	protected Font font = new Font(Font.DIALOG, Font.BOLD, 13);
	
	public abstract void draw(Graphics g);
	public abstract int isInside(Point p);
	
	public void drawPort(Graphics g) {};
	public Port getPort(int index) 
	{
		return null;
	}
	public void changeName(String name){};
	public void setLocation(Point mouse, Point point) {};
	public void setLocation() {};
	
	public void drawGroup(Graphics g){};
	
	public Shape getSelectedObj() 
	{
		return null;
	};
}
