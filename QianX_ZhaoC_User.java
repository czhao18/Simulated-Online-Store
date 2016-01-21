/*This is a class declaration for User, has the fundamental method to call the search and sort methods.
 * Xiaoyu Qian & Chengnan Zhao
 * CS201  Spring2014
 * Final Project 2014028
 * 
 */
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
public class QianX_ZhaoC_User extends JFrame implements ActionListener {
	protected QianX_ZhaoC_SubGenericList aList = new QianX_ZhaoC_SubGenericList();
	private JButton searchName = new JButton("Search Weapon By Name");
	private JButton searchIdno = new JButton("Search Weapon By ID Number");
	private JButton sortByName = new JButton("Sort Weapon By Name");
	private JButton sortByIdno = new JButton("Sort Weapon By ID Number");
	private JButton sortByPrice = new JButton("Sort Weapon By Price");
	private JButton returnMain = new JButton("Return to main menu");
	
	protected JTextArea myA = new JTextArea(35,80);
	
	public int readF(){
		Scanner read =null;
		int lineN=0;
		try {
			read = new Scanner(new File("weapon.txt"));
		} catch (FileNotFoundException e) {
			System.err.println("File Not Found");
		}
		while(read.hasNext()){
			lineN++;
			String line = read.nextLine();
			String [] data = line.split(",");
			QianX_ZhaoC_Common aC = new QianX_ZhaoC_Common(data[0],data[1],data[2],Integer.parseInt(data[5]));
			QianX_ZhaoC_Weapon aW;
			if (data[2].equals("ordinary"))
				aW = new QianX_ZhaoC_Weapon(aC, Double.parseDouble(data[3]),
						Double.parseDouble(data[4]));
			else
				aW = new QianX_ZhaoC_LegendaryWeapon(
						aC,
						Double.parseDouble(data[3]),
						Double.parseDouble(data[4]), Double.parseDouble(data[6]));
			aList.add(aW);
		}
		return lineN;
		
	}
	public QianX_ZhaoC_User(){
		readF();
		setSize(1300,700);
	
		setBackground(Color.WHITE);
		setLayout(null);
		
		searchName.setBounds(0, 75, 300, 50);
		add(searchName);
		searchName.addActionListener(this);
		
		searchIdno.setBounds(0, 150, 300, 50);
		add(searchIdno);
		searchIdno.addActionListener(this);
		
		sortByName.setBounds(0, 225, 300, 50);
		add(sortByName);
		sortByName.addActionListener(this);
		
		sortByIdno.setBounds(0, 300, 300, 50);
		add(sortByIdno);
		sortByIdno.addActionListener(this);
		
		sortByPrice.setBounds(0, 375, 300, 50);
		add(sortByPrice);
		sortByPrice.addActionListener(this);
		
		returnMain.setBounds(0, 600, 300, 50);
		add(returnMain);
		returnMain.addActionListener(this);
		
		JPanel p1 = new JPanel();
		p1.setBounds(300, 0,1000, 800);
		JScrollPane scroll = new JScrollPane(myA);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		p1.add(scroll);
		add(p1);
		myA.setText(aList.showT());
		myA.setEditable(false);
		
	}
	
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == searchName) {
			String input = "";
			input = JOptionPane.showInputDialog(this, "Enter a name to search");
			int someN = aList.sequentialSearchByName(input);
			if (someN >= 0)
				JOptionPane.showMessageDialog(this, aList.showE(someN));
			else
				JOptionPane.showMessageDialog(this, "Item Not Found");

		}
		if (e.getSource() == searchIdno) {
			String input = JOptionPane.showInputDialog(this,
					"Enter an ID number to search");
			int someN = aList.sequentialSearchByID(input);
			if (someN >= 0)
				JOptionPane.showMessageDialog(this, aList.showE(someN));
			else
				JOptionPane.showMessageDialog(this, "Item Not Found");
		}
		if(e.getSource()==sortByName){
			aList.selectSortByName();
			myA.setText(aList.showT());
		}
		if(e.getSource()==sortByIdno){
			aList.selectSortById();
			myA.setText(aList.showT());
		}
		if(e.getSource()==sortByPrice){
			aList.selectSortByPrice();
			myA.setText(aList.showT());
		}
		if(e.getSource()==returnMain)
			{
			this.dispose();
			new QianX_ZhaoC_Welcome();
			}
	}

}
