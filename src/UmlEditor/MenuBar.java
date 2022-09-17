package UmlEditor;

import javax.swing.*;

import UmlShape.Group;
import UmlShape.Shape;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MenuBar extends JMenuBar{
	
	JMenu file = new JMenu("File");
	private Canvas canvas = Canvas.getInstance();
	
	private List<Shape> shapes=null;
	
	public MenuBar() {
		
		
		this.add(file);
		
		JMenu edit = new JMenu("Edit");
		
		JMenuItem changeObjName = new JMenuItem("Change Object Name");
		changeNameListener(changeObjName);
		edit.add(changeObjName);
		edit.addSeparator();
		
		JMenuItem group = new JMenuItem("Group");
		groupListener(group);
		edit.add(group);
		edit.addSeparator();
		
		JMenuItem unGroup = new JMenuItem("UnGroup");
		unGroupListener(unGroup);
		edit.add(unGroup);
		
		this.add(edit);
	}
	
	public void changeNameListener(JMenuItem itemName)
	{
		itemName.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent ev) 
		    {
		   	    if(canvas.selectedObj!=null)
		    	{
		    		ChangeNameDialog dialog=new ChangeNameDialog(canvas.selectedObj.name);
		    	}
		    	else
		    	{
		    		Warning noObj=new Warning("You must select exactly a object !", 300);
		    	}
		    }
		});
	}
	
	public void groupListener(JMenuItem itemName)
	{
		itemName.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent ev) 
		    {
		    	shapes=canvas.getShapes();
		    	System.out.println("shapes size :" + shapes.size());
		    	int cnt=0;
		    	for(int i=0;i<shapes.size();i++)
		    	{
		    		Shape shape = shapes.get(i);
					if(shape.isSelected)
					{
						cnt++;
					}
		    	}
		    	
		    	if(cnt>=2)
		    	{
		    		canvas.createGroup();
		    	}
		    	else
		    	{
		    		Warning lessThanTwoObj=new Warning("You must select two or more objects !", 300);
		    	}
		    }
		});
	}
	
	public void unGroupListener(JMenuItem itemName)
	{
		itemName.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent ev) 
		    {
		    	Shape shape=canvas.selectedObj;
		    	
		    	if(shape!=null && (shape instanceof Group))
		    	{
		    		canvas.unGroup();
		    	}
		    	else
		    	{
		    		Warning nullObj=new Warning("You must select exactly a group object !", 300);
		    	}
		    }
		});
	}
}
