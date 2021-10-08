
public class Hero{
	
	//hero attributes
	private int health;
	private int strength;
	private String name;
	private String suffix;
	private int armor;
	
	//create inventory
	protected Inventory inventory;
	
	//hold weapon spot
	protected Weapon weapon1;
	protected Weapon weapon2;
	protected Weapon weapon3;
	protected Weapon weapon4;
	
	//basic constructor
	public Hero(String name, String suffix, int health, int armor){
		this.name = name;
		this.suffix = suffix;
		this.health = health;
		this.strength = strength;
		this.armor = armor;

		//create inventory
		inventory = new Inventory();
		//create weapons
		weapon1 = new Weapon("claws", 10, 0);
		weapon2 = new Weapon("dinky sword", 25, 15);
		weapon3 = new Weapon("bow", 50, 5);
		weapon4 = new Weapon("master sword", 100, 50);
		
	}
	
	//getters
	public String getName(){
		return this.name;
	}
	public String getSuffix(){
		return this.suffix;
	}
	public int getHealth(){
		return this.health;
	}
	public int getStrength(){
		return this.strength;
	}
	public int getArmor(){
		return this.armor;
	}
	
	
	//attack
	public int attackEnemy(Weapon weapon){
		//add weapon damage later
		int damageDone = (int)(this.strength*0.5) + (int)(weapon.getDamage()*0.5);
		System.out.println("---------------------------------------------------");
		System.out.println("You attacked with " + damageDone + " damage.");
		return damageDone;
	}
	//take damage from fight
	public void takeDamage(int damage){
		this.health -= (int)(damage - (0.5 * this.armor));
	}
	//gain health (hero can not die in this game)
	public void consumeSoul(){
		this.health += 1000;
		this.strength += 5;
	}

}