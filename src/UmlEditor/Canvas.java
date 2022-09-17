package UmlEditor;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

import UmlMode.Mode;
import UmlShape.Group;
import UmlShape.Line;
import UmlShape.Shape;
import UmlShape.UseCaseObj;

public class Canvas extends JPanel{
	
	private static Canvas instance = null;
	
	private EventListener listener = null;
	protected Mode curMode = null;
	
	public Shape selectedObj = null;
	public Line tmpLine=null;
	
	public Rectangle selectedArea=null;
	private List<Shape> shapes=new ArrayList<Shape>();
	//private List<Group> groups=new ArrayList<Group>();
	private List<Line> lines=new ArrayList<Line>();
	
	public Canvas() {
		
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setPreferredSize(new Dimension(980, 300));
	}
	public static Canvas getInstance() { //singleton
		
		if (instance == null) {
			instance = new Canvas();
		}
		return instance;
	}
	
	public List<Shape> getShapes() {
		return shapes;
	}
	
	public void addShape(Shape shape) {
		shapes.add(shape);
	}
	
	public void addLine(Line line) {
		lines.add(line);
	}
	
	public void changeObjName(String name)
	{
		if(selectedObj!=null)
		{
			selectedObj.changeName(name);
		}
	}
	
	public void createGroup()
	{
		Group G=new Group();
		for(int i=0;i<shapes.size();i++)
		{
			Shape shape=shapes.get(i);
			if(shape.isSelected==true)
			{
				shape.isSelected=false;
				G.addShape(shape);
				shapes.remove(i);
				i--;
			}
		}
		G.setEdge();
		//groups.add(G);
		shapes.add(G);
		selectedObj=null;
	}
	
	public void unGroup()
	{
		Group G=(Group)selectedObj;
		List<Shape> inGroup=G.getShapes();
		for(int i=0;i<inGroup.size();i++)
		{
			Shape shape=inGroup.get(i);
			shapes.add(shape);
		}
		shapes.remove(selectedObj);
		//groups.remove(G);
		selectedObj=null;
	}
	
	public void setCurMode(Mode m)
	{
		removeMouseListener((MouseListener) listener);
		removeMouseMotionListener((MouseMotionListener) listener);
		curMode=m;
		listener = curMode;
		addMouseListener((MouseListener) listener);
		addMouseMotionListener((MouseMotionListener) listener);
	}
	
	public boolean withinSelectedArea(Shape shape)
	{
		Point top1=new Point(shape.getX1(),shape.getY1());
		Point top2=new Point(shape.getX2(),shape.getY1());
		Point bot1=new Point(shape.getX1(),shape.getY2());
		Point bot2=new Point(shape.getX2(),shape.getY2());
		
		return (selectedArea.contains(top1) && selectedArea.contains(top2) && selectedArea.contains(bot1) && selectedArea.contains(bot2));
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		
		Dimension dim = getSize();
		g.setColor(new Color(200, 200, 200));
		g.fillRect(0, 0, dim.width, dim.height);
		
		g.setColor(new Color(0, 0, 0));
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(4));
		
		for (int i=shapes.size()-1; i>=0;i--) 
		{
			Shape shape = shapes.get(i);
			shape.draw(g);
			shape.drawGroup(g);
			if(shape.isSelected==true)
			{
				shape.drawPort(g);
			}
		}
		
		/*for (int i=groups.size()-1; i>=0;i--) 
		{
			Group group=groups.get(i);
			group.drawGroup(g);
		}*/
		
		g.setColor(new Color(0, 0, 0));
		for (int i=lines.size()-1; i>=0;i--) 
		{
			Line line=lines.get(i);
			line.draw(g);
		}
		
		g.setColor(new Color(0, 0, 0));
		if(selectedObj!=null)
			selectedObj.drawPort(g);
		
		if(tmpLine!=null)
			tmpLine.draw(g);
		
		if (selectedArea!=null) 
		{
			g.setColor(new Color(153, 153, 0, 50));
			g.fillRect(selectedArea.x, selectedArea.y, selectedArea.width, selectedArea.height);
			g.setColor(new Color(153, 153, 0));
			g.drawRect(selectedArea.x, selectedArea.y, selectedArea.width, selectedArea.height);

		}
		repaint();
	}
}
