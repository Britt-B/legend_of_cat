public class Weapon{
	//attributes
	private String name;
	private int damage;
	private int parry;
	
	//construct weapon based on user choice
	public Weapon(String name, int damage, int parry){
		this.name = name;
		this.damage = damage;
		this.parry = parry;
	}
	//getters
	public int getDamage(){
		return this.damage;
	}
	public int getParry(){
		return this.parry;
	}
	public String getName(){
		return this.name;
	}

}