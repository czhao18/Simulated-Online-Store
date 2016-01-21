/*This is a class declaration for Store Owner inherited from the User Class. It has additional methods that Owner can add items
 * to the weapon list and delete item from the weapon list
 * Xiaoyu Qian & Chengnan Zhao
 * CS201  Spring2014
 * Final Project 2014028
 * 
 */
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class QianX_ZhaoC_Owner extends QianX_ZhaoC_User{
	private JButton logB = new JButton("Login");
	private JButton delG = new JButton("Delete Item");
	private JButton addG = new JButton("Add Item");
	private JTextField username = new JTextField("");
	private JPasswordField password = new JPasswordField("");
	
	public QianX_ZhaoC_Owner(){
		super();
		
		logB.setBounds(0, 0, 70, 50);
		add(logB);
		logB.addActionListener(this);
		
		delG.setBounds(0, 450, 300, 50);
		add(delG);
		delG.setVisible(false);
		delG.addActionListener(this);
		
		addG.setBounds(0, 525, 300, 50);
		add(addG);
		addG.setVisible(false);
		addG.addActionListener(this);
		
		username.setBounds(70, 0, 125, 25);
		add(username);
		username.addActionListener(this);
		
		password.setBounds(70, 25, 125, 25);
		add(password);
		password.addActionListener(this);
		
		
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);

		if (e.getSource() == delG) {
			String input = JOptionPane.showInputDialog(this,
					"Enter an ID number to delete");
			int sPos = aList.sequentialSearchByID(input);
			if (sPos != -1) {
				aList.delete(sPos);
				myA.setText(aList.showT());
			} else
				JOptionPane.showMessageDialog(this, "Not in the List");

			FileWriter fileOut = null;
			BufferedWriter output = null;
			try {
				fileOut = new FileWriter("weapon.txt"); // open file for
														// output
				output = new BufferedWriter(fileOut);
				for (int i = 0; i < aList.getIndex(); i++) {
					String sStr = aList.getElement(i).getWeapCom().getId()
							+ "," + aList.getElement(i).getWeapCom().getName()
							+ "," + aList.getElement(i).getWeapCom().getType()
							+ "," + aList.getElement(i).getAtk() + ","
							+ aList.getElement(i).getAtkSpd() + ","
							+ aList.getElement(i).getWeapCom().getPrice() + ","
							+ aList.getElement(i).getC();
					output.write(sStr);
					if (i != aList.getIndex() - 1) {
						output.newLine();
					}
				}
				output.close();
			} catch (IOException ioe) {
				System.out.println(ioe.getMessage());
			}
		}
		if (e.getSource() == addG) {
			String str = "Enter as following format: ID,Name,Type,Attack,ATK Speed,Price,(Critical Hit Chance)\nSeperate by comma, Only legendary weapon has Critical Hit Chance\nType must be legendary or ordinary";
			String input = JOptionPane.showInputDialog(this, str);
			if (input != null) {
				String[] data = input.split(",");
				QianX_ZhaoC_Weapon newW = new QianX_ZhaoC_Weapon();
				QianX_ZhaoC_Common newC = new QianX_ZhaoC_Common();
				if ((data.length == 7 && data[2].equals("legendary")) ||( data.length==6 && data[2].equals("ordinary"))) {
					try {
						if (data[2].equals("ordinary")) {

							newC = new QianX_ZhaoC_Common(data[0], data[1], data[2],

							Integer.parseInt(data[5]));
							newW = new QianX_ZhaoC_Weapon(newC,
									Double.parseDouble(data[4]),
									Double.parseDouble(data[5]));
						} else {
							newC = new QianX_ZhaoC_Common(data[0], data[1], data[2],
									Integer.parseInt(data[5]));
							newW = new QianX_ZhaoC_LegendaryWeapon(newC,
									Double.parseDouble(data[3]),
									Double.parseDouble(data[4]),
									Double.parseDouble(data[6]));
						}
						aList.add(newW);
					} catch (NumberFormatException nfe) {
						JOptionPane.showMessageDialog(this,
								"Not A Valid Weapon!");
					}

					myA.setText(aList.showT());

					FileWriter fileOut = null;
					BufferedWriter output = null;
					try {
						fileOut = new FileWriter("weapon.txt", true); // open
																		// file
																		// for
																		// output
						output = new BufferedWriter(fileOut);
						String somS ="";
						if (data.length ==7){
						somS = data[0] + "," + data[1] + "," + data[2]
								+ "," + data[3] + "," + data[4] + "," + data[5]
								+ "," + data[6];}
						else{
						somS = data[0] + "," + data[1] + "," + data[2]
									+ "," + data[3] + "," + data[4] + "," + data[5]
									+ "," ;}
						
						output.newLine();
						output.write(somS);
						output.close();
					} catch (IOException ioe) {
						System.out.println(ioe.getMessage());
					}

				} else
					JOptionPane.showMessageDialog(this, "Not A Valid Weapon!");
			}
		}
		if (e.getSource() == logB) {
			String account = username.getText();
			String psw = new String(password.getPassword());
			if ((account.equals("zcn") && psw.equals("123"))
					|| (account.equals("qxy") && psw.equals("456"))) {
				delG.setVisible(true);
				addG.setVisible(true);
			} else
				JOptionPane.showMessageDialog(this, "Failed Login");
		}
	}
}
