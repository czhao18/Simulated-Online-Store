/*This is a class declaration for a subclass of Genericlist, it has several additional methods which can show
 *the total string of an arraylist, specific details of one item, and search and sort methods
 *Xiaoyu Qian & Chengnan Zhao
 * CS201  Spring2014
 * Final Project 2014028
 */
import java.text.DecimalFormat;

public class QianX_ZhaoC_SubGenericList extends QianX_ZhaoC_GenericList<QianX_ZhaoC_Weapon> {

	private int counter;

	public QianX_ZhaoC_SubGenericList() {
		super();
		counter = 0;
	}

	public QianX_ZhaoC_SubGenericList(int size) {
		super(size);
		counter = 0;

	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int a) {
		counter = a;
	}

	public String showT() {
		String tStr = "";
		tStr = "ID"
				+ "\tNAME                                                  "
				+ "\tTYPE    " + "\tATTACK" + "\tATK SPEED" + "\tTOTAL ATK"
				+"\tPRICE"+ "\tCHC";
		DecimalFormat fo = new DecimalFormat("##.##");
		for (int i = 0; i < index; i++) {
			String name = getElement(i).getWeapCom().getName();
			while (name.length() < 55) {
				name += " ";
			}
			tStr += "\n" + getElement(i).getWeapCom().getId() + "\t" + name
					+ "\t" + getElement(i).getWeapCom().getType() + "\t"
					+ getElement(i).getAtk() + "\t" + getElement(i).getAtkSpd()
					+ "        \t" + fo.format(getElement(i).calcTAttack()) + "    \t"
					+ getElement(i).getWeapCom().getPrice()+     "\t"+getElement(i).getC();
		}
		return tStr;
	}
	
	public String showE(int i){
		String str="";
		DecimalFormat fo = new DecimalFormat("##.##");
		str = "ID: "+ getElement(i).getWeapCom().getId()+"\n"+
				"Name: " +getElement(i).getWeapCom().getName()+"\n"+
				"Type: "+getElement(i).getWeapCom().getType()+"\n"+
				"Price: "+getElement(i).getWeapCom().getPrice()+"\n"+
				"Attack: "+getElement(i).getAtk()+"\n"+
				"Attack Speed: "+getElement(i).getAtkSpd();
		return str;
	}
	
	public int sequentialSearchByName(String sName) {
		counter = 0;
		for (int i = 0; i < index; i++) {
			counter++;
			if (getElement(i).getWeapCom().getName().equalsIgnoreCase(sName)) {
				return i;
			}

		}
		return -1;
	}
	
	public int sequentialSearchByID(String idno) {
		
		for (int i = 0; i < index; i++) {
			
			if (getElement(i).getWeapCom().getId().equals(idno)) {
				return i;
			}

		}
		return -1;
	}

	public void selectSortByName() {
		counter = 0;
		int s = 0;
		for (int i = 0; i < index - 1; i++) {
			QianX_ZhaoC_Weapon min = getElement(i);
			s = i;
			for (int j = i + 1; j < index; j++) {
				counter++;
				if (min.getWeapCom().compareToName(getElement(j).getWeapCom()) > 0) {
					min = getElement(j);
					s = j;
				}
			}

			arr[s] = arr[i];
			arr[i] = min;

		}
	}
	
	public void selectSortById() {
		counter = 0;
		int s = 0;
		for (int i = 0; i < index - 1; i++) {
			QianX_ZhaoC_Weapon min = getElement(i);
			s = i;
			for (int j = i + 1; j < index; j++) {
				counter++;
				if (min.getWeapCom().compareToID(getElement(j).getWeapCom()) > 0) {
					min = getElement(j);
					s = j;
				}
			}

			arr[s] = arr[i];
			arr[i] = min;

		}
	}
	
	public void selectSortByPrice() {
		counter = 0;
		int s = 0;
		for (int i = 0; i < index - 1; i++) {
			QianX_ZhaoC_Weapon min = getElement(i);
			s = i;
			for (int j = i + 1; j < index; j++) {
				counter++;
				if (min.getWeapCom().compareToPrice(getElement(j).getWeapCom()) > 0) {
					min = getElement(j);
					s = j;
				}
			}

			arr[s] = arr[i];
			arr[i] = min;

		}
		
	}
}
	