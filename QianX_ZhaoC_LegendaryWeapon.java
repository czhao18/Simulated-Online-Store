/*This is a class declaration for legendary weapon inherited from QianX_ZhaoC_Weapon Class, it has additional attribute which is cHitChance
 * and overriden method of calcTAttack()
 * Xiaoyu Qian & Chengnan Zhao
 * CS201  Spring2014
 * Final Project 2014028
 * 
 */
public class QianX_ZhaoC_LegendaryWeapon extends QianX_ZhaoC_Weapon{

	private double cHitChance;
	
	public QianX_ZhaoC_LegendaryWeapon() {
		super();
		cHitChance = 0;
	}
	
	public QianX_ZhaoC_LegendaryWeapon(QianX_ZhaoC_Common aCommon,double anAtk, double anAtkSpd,double aCHitChance){
		super (aCommon,anAtk,anAtkSpd);
		cHitChance = aCHitChance;
	}
	
	public double getCHitChance(){
		return cHitChance;
	}
	
	public void setCHitChange(double aCHitChance){
		cHitChance = aCHitChance;
	}
	
	public String toString(){
		return super.toString()+"\tCritical Hit Chance is "+cHitChance;
	}
	
	public double calcTAttack(){
		return super.calcTAttack()*(1+cHitChance);
	}

	public String getC(){
		return cHitChance+"";
	}
}
