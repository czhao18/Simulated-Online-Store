/*This is a class declaration for Customer inherited from the User Class. 
 * It has two additional methods that Customers can add items to transaction history list and check it
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


public class QianX_ZhaoC_Customer extends QianX_ZhaoC_User {
	private JButton buy = new JButton("Buy Weapon By ID Number");
	private JButton his = new JButton("Transaction History");
	private QianX_ZhaoC_SubGenericList buyList = new QianX_ZhaoC_SubGenericList();
	public QianX_ZhaoC_Customer(){
		super();
		
		buy.setBounds(0, 450, 300, 50);
		add(buy);
		buy.addActionListener(this);
		
		his.setBounds(0, 525, 300, 50);
		add(his);
		his.addActionListener(this);
		
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e){
		super.actionPerformed(e);
		
		if(e.getSource()==buy)
		{
			String input = JOptionPane.showInputDialog(this,
					"Enter an ID number to buy");
			int sPos = aList.sequentialSearchByID(input);
			if(sPos>=0){
				buyList.add(aList.getElement(sPos));
				JOptionPane.showMessageDialog(this, "Successful Purchase");
			}
			else
				JOptionPane.showMessageDialog(this, "Not In The List");
			
			
		}
		
		if (e.getSource() == his) {
			int sum = 0;
			for(int i =0;i<buyList.getIndex();i++){
				sum+= buyList.getElement(i).getWeapCom().getPrice();
			}
			myA.setText(aList.showT() + "\n\n\n\t\t\tTransaction History\n\n\n"
					+ buyList.showT()+"\n\n\nTotal Price is: "+sum);
			FileWriter fileOut = null;
			BufferedWriter output = null;
			try {
				fileOut = new FileWriter("TransactionHistory.txt"); // open file
																	// for
				// output
				output = new BufferedWriter(fileOut);
				String trHis = "\t\t\tTransaction History\n\n\n"
						+ buyList.showT()+"\n\n\nTotal Price is: "+sum;
				output.write(trHis);
				output.newLine();
				output.close();
			} catch (IOException ioe) {
				System.out.println(ioe.getMessage());
			}
		}
		
	}
}
