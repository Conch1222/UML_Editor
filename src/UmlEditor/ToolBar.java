package UmlEditor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import UmlShape.ClassObj;

import UmlEditor.Canvas;
import UmlMode.CreateClassMode;
import UmlMode.CreateLineMode;
import UmlMode.CreateUseCaseMode;
import UmlMode.Mode;
import UmlMode.SelectMode;

public class ToolBar extends JToolBar {
	
	private JButton curBtn=null;
	private Canvas canvas;
	private Mode mode;
	
	public ToolBar() {
		
		canvas=Canvas.getInstance();
		
		GridLayout gridLayout = new GridLayout(6,1);
		setLayout(gridLayout);
		this.setBackground(new Color(83, 85, 87));
		
		mode=new SelectMode();
		JButton selectBtn = setButton("Select","img//select.png","set the select mode",mode);
		this.add(selectBtn);
		
		mode=new CreateLineMode("AssociationLine");
		JButton associationBtn = setButton("<html>Association<br>Line</html>","img//association.png","create a association line",mode);
		this.add(associationBtn);
		
		mode=new CreateLineMode("GeneralizationLine");
		JButton generalizationBtn = setButton("<html>Generalization<br>Line</html>","img//generalization.png","create a generalization line",mode);
		this.add(generalizationBtn);
		
		mode=new CreateLineMode("CompositionLine");
		JButton compositionBtn = setButton("<html>Composition<br>Line</html>","img//composition.png","create a composition line",mode);
		this.add(compositionBtn);
		
		mode=new CreateClassMode();
		JButton classBtn = setButton("Class","img//class.png","create a class object",mode);
		this.add(classBtn);
		
		mode=new CreateUseCaseMode();
		JButton useCaseBtn = setButton("Use Case","img//use case.png","create a use case object",mode);
		this.add(useCaseBtn);
	}
	
	private JButton setButton(String name, String imgPath, String tipTxt, Mode m) {
		JButton Btn=new JButton();
		Btn.setFocusPainted(false);
		
		Btn.setLayout(new BorderLayout());
		JLabel txt = new JLabel(name, SwingConstants.CENTER);
		JLabel img = new JLabel(new ImageIcon(imgPath));
		Btn.add(img, BorderLayout.WEST);
		Btn.add(txt, BorderLayout.CENTER);
		
		Btn.setToolTipText(tipTxt);
		Btn.setBackground(new java.awt.Color(255, 255, 255));
		
		Btn.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 if(curBtn!=null)
					 curBtn.setBackground(new java.awt.Color(255, 255, 255));
				 
				 curBtn=(JButton) e.getSource();
				 curBtn.setBackground(new java.awt.Color(120, 120, 120));
				 
				 canvas.setCurMode(m);
				 canvas.selectedObj=null;
			 }
		});
		
		return Btn;
	}
}
