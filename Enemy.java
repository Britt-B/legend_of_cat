public class Enemy{
	//attributes
	private int health;
	private int strength;
	private String name;
	
	public Enemy(int positionNumber){
		//assign values based on area of difficulty
		
		if(positionNumber == 13){
			strength = 25;
			health = 50;
			name = "Gannon Cat";
		}
		if(positionNumber == 14){
			strength = 50;
			health = 75;
			name = "dungeon ninja cat";
		}
		if(positionNumber == 15){
			strength = 75;
			health = 100;
			name = "strong dungeon ninja cat";
		}
		if(positionNumber == 16){
			strength = 9000;
			health = 9000;
			name = "Gannon Cat, God of Fleas, Destroyer of Peace";
		}
		this.strength = strength;
		this.health = health;
		this.name = name;
	}
	
	//getters
	public String getName(){
		return this.name;
	}
	public int getHealth(){
		return this.health;
	}
	public int getStrength(){
		return this.strength;
	}
	
	//attack hero
	public void attackHero(Hero hero){
		hero.takeDamage(this.strength);
		System.out.println(this.name + " attacked you with " + this.strength + " damage");
	}
	
	//take damage, determine if enemy is alive
	public boolean takeDamage(int damage){
		boolean living = true;
		
		this.health -= damage;
		
		if(this.health > 0){
			System.out.println(this.name + " now has " + this.health + " health.");
		}
		else if(this.health <= 0){
			System.out.println("You have defeated " + this.name + "!");
			living = false;
		}
		return living;
	}

}