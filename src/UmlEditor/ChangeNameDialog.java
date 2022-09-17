package UmlEditor;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import UmlShape.Shape;

public class ChangeNameDialog extends JFrame{
	
	private Canvas canvas = Canvas.getInstance();
	
	public ChangeNameDialog(String Name)
	{
		super("Change Object Name");
		
		this.getContentPane().setLayout(new BorderLayout());
		
		GridLayout gridLayout = new GridLayout(0,1);
		this.setLayout(gridLayout);
		
		JPanel panel=new JPanel();
		
		JLabel label = new JLabel("New Object Name : ");
		panel.add(label);
		
		JTextField text =  new JTextField("  "+Name+" ");
		text.setSize(80, 60);
		panel.add(text);
		
		this.getContentPane().add(panel);
		
		panel=new JPanel();
		
		JButton ok=new JButton("OK");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input=text.getText();
				if(input.length()>10)
				{
					Warning outOfSize=new Warning("Please set your name within 10 alphanumeric characters !",400);
				}
				else
				{
					canvas.selectedObj.changeName(input);
					dispose();
				}
			}
		});
		panel.add(ok);
		
		JButton cancel=new JButton("Cancel");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel.add(cancel);
		
		this.getContentPane().add(panel, BorderLayout.PAGE_END);
		
		setLocationRelativeTo(null);
		setSize(400, 150);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
}
