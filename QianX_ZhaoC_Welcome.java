/*This is a class declaration contains three buttons allow users to choose different actions
 * Xiaoyu Qian & Chengnan Zhao
 * CS201  Spring2014
 * Final Project 2014028
 * 
 */
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class QianX_ZhaoC_Welcome extends JFrame implements ActionListener {

	private JPanel pane = new JPanel();
	private JLabel label1 = new JLabel("Welcome to Weapon Store");
	private JButton customerButton = new JButton("Customer");
	private JButton ownerButton = new JButton("Owner");
	private JButton exitButton = new JButton("Quit");
	private JLabel pic = new JLabel();
	

	public QianX_ZhaoC_Welcome() {
		
		setSize(500, 500);
	
		add(pane);
		setBackground(Color.white);
		
		setLayout(null);
		add(label1);
		label1.setBounds(170, 0, 500, 50);
		
		pic.setIcon(new ImageIcon("sword.jpg"));
		pic.setBounds(100, 50, 300, 100);
		add(pic);

		customerButton.setBounds(50, 200, 100, 100);
		add(customerButton);
		customerButton.addActionListener(this);

	
		ownerButton.setBounds(200, 200, 100, 100);
		add(ownerButton);
		ownerButton.addActionListener(this);
		
		exitButton.setBounds(350, 200, 100, 100);
		add(exitButton);
		exitButton.addActionListener(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Customer")) {
			this.dispose();
			new QianX_ZhaoC_Customer();
			
		}

		else if (e.getActionCommand().equals("Owner")) {
			this.dispose();
			new QianX_ZhaoC_Owner();
			
		} else
		{
			JOptionPane.showMessageDialog(this, "Thank you for shopping!");
			System.exit(0);
		}

	}


}
