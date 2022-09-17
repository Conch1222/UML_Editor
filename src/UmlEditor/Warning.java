package UmlEditor;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Warning extends JFrame{
	
	public Warning(String hint,int w)
	{
		super("Warning");
		  
		  GridLayout gridLayout = new GridLayout(0,1);
		  this.setLayout(gridLayout);
		  
		  JPanel panel=new JPanel();
			
		  JLabel label = new JLabel(hint);
		  panel.add(label);
		  this.getContentPane().add(panel);
		  
		  panel=new JPanel();
		  JButton ok=new JButton("OK");
		  
		  ok.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
		  });
		  
		  panel.add(ok);
		  this.getContentPane().add(panel);
		  
		  setLocationRelativeTo(null);
	      setSize(w, 120);
	      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	      setVisible(true);
	}
}
