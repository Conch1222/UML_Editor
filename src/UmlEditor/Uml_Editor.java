package UmlEditor;

import java.awt.BorderLayout;
import javax.swing.*;

public class Uml_Editor extends JFrame {

	private ToolBar toolbar;
	private MenuBar menubar;
	private Canvas canvas;
	
	public Uml_Editor() {
		super("UML Editor");
		
		toolbar=new ToolBar();
		toolbar.setOpaque(true);
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(toolbar,BorderLayout.WEST);
		
		menubar=new MenuBar();
		this.setJMenuBar(menubar);
		
		canvas=Canvas.getInstance();
		this.getContentPane().add(canvas,BorderLayout.EAST);
		
		setSize(1200, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		Uml_Editor mainWindow = new Uml_Editor();
		
		
	}

}
