package UmlMode;
import java.awt.*;
import java.awt.event.*;

import UmlShape.ClassObj;
import UmlShape.Shape;

public class CreateClassMode extends Mode{
	
	public CreateClassMode()
	{
		
	}
	
	public void mousePressed(MouseEvent e)
	{
		System.out.println("x:" + e.getX() + "  y: "  + e.getY());
		Shape obj = new ClassObj(e.getX(),e.getY(),"Class");
		canvas.addShape(obj);
	}
}
