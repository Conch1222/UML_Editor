package UmlMode;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.List;

import UmlShape.AssociationLine;
import UmlShape.CompositionLine;
import UmlShape.GeneralizationLine;
import UmlShape.Line;
import UmlShape.Port;
import UmlShape.Shape;

public class CreateLineMode extends Mode{
	
	private String LineMode="";
	private List<Shape> shapes;
	private Shape shape1, shape2;
	private int port1, port2;
	
	private Point point1, point2;
	
	
	public CreateLineMode(String LineMode)
	{
		this.LineMode=LineMode;
	}
	
	public Line createLine(String type,Point start, Point end)
	{
		Line line=null;
		switch(type) 
		{
			case "AssociationLine":
				line=new AssociationLine(start.x,start.y,end.x,end.y);
				break;
			case "GeneralizationLine":
				line=new GeneralizationLine(start.x,start.y,end.x,end.y);
				break;
			case "CompositionLine":
				line=new CompositionLine(start.x,start.y,end.x,end.y);
				break;
			
		}
		return line;
	}
	
	public void mousePressed(MouseEvent e)
	{
		shapes=canvas.getShapes();
		point1=findObj(e.getPoint(),1);
	}
	
	public void mouseDragged(MouseEvent e) 
	{
		if(point1!=null)
		{
			Line tmpLine=createLine(LineMode,point1,e.getPoint());
			canvas.tmpLine=tmpLine;
			canvas.repaint();
		}
	}
	
	public void mouseReleased(MouseEvent e)
	{
		if(point1!=null)
		{
			point2=findObj(e.getPoint(),2);
			if(point2!=null && shape1!=shape2)
			{
				Line line=createLine(LineMode,point1,point2);
				canvas.addLine(line);
				
				line.setPort(shape1.getPort(port1), shape2.getPort(port2));
				
				shape1.getPort(port1).addLine(line);
				shape2.getPort(port2).addLine(line);

			}
			canvas.tmpLine=null;
			point1=null;
			point2=null;
			
			//canvas.repaint();
		}
	}
	
	public Point findObj(Point p, int tar)
	{
		for(int i=0;i<shapes.size();i++)
		{
			Shape shape=shapes.get(i);
			
			int in=shape.isInside(p);
			if(in>=0)
			{
				if(in==4)
				{
					shape=shape.getSelectedObj();
					in=shape.isInside(p);
				}
				
				if(tar==1)
				{
					shape1=shape;
					port1=in;
				}
				else if(tar==2)
				{
					shape2=shape;
					port2=in;
				}
				Point portPoint=new Point();
				
				portPoint.setLocation(shape.getPort(in).getCenterX(), shape.getPort(in).getCenterY());
				return portPoint;
			}
		}
		return null;
	}
}
