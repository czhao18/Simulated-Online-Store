/*This is a class declaration for Common attributes, both QianX_ZhaoC_LegendaryWeapon and QianX_ZhaoC_Weapon has a QianX_ZhaoC_Common
 * Xiaoyu Qian & Chengnan Zhao
 * CS201  Spring2014
 * Final Project 2014028
 * 
 */
public class QianX_ZhaoC_Common {

	private String idno;
	private String name;
	private String type;
	private int price;
	

	public QianX_ZhaoC_Common() {
		idno ="";
		name = "";
		type = "";
		price = 0;
	}
	
	public QianX_ZhaoC_Common(String anIdno, String aName, String aType, int aPrice){
		idno = anIdno;
		name = aName;
		type = aType;
		price = aPrice;
	}
	
	public String getId(){
		return idno;
	}
	
	public void setId(String anIdno){
		idno = anIdno;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String aName){
		name = aName;
	}
	
	public String getType(){
		return type;
	}
	
	public void setType(String aType){
		type = aType;
	}
	
	public int getPrice(){
		return price;
	}
	
	public void setPrice(int aPrice){
		price = aPrice;
	}

	public String toString(){
		return "The ID number is "+idno+"\tThe name is "+name+"\tThe type is "+type+"\tThe price is "+price;
	}
	
	public boolean equal(QianX_ZhaoC_Common aCommon){
		if (idno.equals(aCommon.getId())&&name.equals(aCommon.getName())&&type.equals(aCommon.getType())&&(price==aCommon.getPrice())){
			return true;
		}
		else
			return false;
	}
	
	public int compareToName(QianX_ZhaoC_Common aCommon){
		if (name.compareTo(aCommon.getName())<0){
			return -1;
		}
		else if (name.compareTo(aCommon.getName())>0){
			return 1;
		}
		else{
			return 0;
		}		
	}
	
	public int compareToID(QianX_ZhaoC_Common aCommon){
		if (idno.compareTo(aCommon.getId())<0){
			return -1;
		}
		else if (idno.compareTo(aCommon.getId())>0){
			return 1;
		}
		else{
			return 0;
		}
	}
	
	public int compareToPrice(QianX_ZhaoC_Common aCommon){
		if (price <aCommon.getPrice()){
			return -1;
		}
		else if (price >aCommon.getPrice()){
			return 1;
		}
		else{
			return 0;
		}
	}
	
}
