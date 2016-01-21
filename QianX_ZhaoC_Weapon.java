/*This is a class declaration for weapon, has the basic attributes of a ordinary weapon
 * Xiaoyu Qian & Chengnan Zhao
 * CS201  Spring2014
 * Final Project 2014028
 * 
 */
public class QianX_ZhaoC_Weapon {

	private QianX_ZhaoC_Common weapCom;
	private double atk;
	private double atkSpd;
	
	public QianX_ZhaoC_Weapon() {
		weapCom = new QianX_ZhaoC_Common();
		atk = 0;
		atkSpd = 0;
	}
	
	public QianX_ZhaoC_Weapon(QianX_ZhaoC_Common aCommon,double anAtk, double anAtkSpd){
		weapCom = aCommon;
		atk = anAtk;
		atkSpd = anAtkSpd;
	}
	
	public QianX_ZhaoC_Common getWeapCom(){
		return weapCom;
	}
	
	public double getAtk(){
		return atk;
	}
	
	public double getAtkSpd(){
		return atkSpd;
	}

	public void setWeapCom(QianX_ZhaoC_Common aCommon){
		weapCom = aCommon;
	}
	
	public void setAtk(double anAtk){
		atk = anAtk;
	}
	
	public void setAtkSpd(double anAtkSpd){
		atkSpd = anAtkSpd;
	}
	
	public String toString(){
		return weapCom.toString()+"\tAttack is "+atk+"\tAttack Speed is "+atkSpd;
	}
	
	public String getC(){
		return "";
	}
	
	public boolean equals(QianX_ZhaoC_Weapon aWeapon){
		if (weapCom.equal(aWeapon.getWeapCom())&&(atk==aWeapon.getAtk())&& (atkSpd == aWeapon.getAtkSpd())){
			return true;
		}
		else
			return false;
	}
	
	
	
	public double calcTAttack(){
		return atk*atkSpd;
	}
	
	
}
