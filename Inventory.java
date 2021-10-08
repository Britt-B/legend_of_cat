
public class Inventory           {
	//holds all existing items in game, and if the player has them
	private boolean[] allItemsBoolean;
	//holds name of all items corresponding to allItemsValue
	private String[] allItemsName;
	//decides if player has item
	private boolean hasDinkySword;
	private boolean hasBow;
	private boolean hasGemstone;
	private boolean hasOars;
	private boolean hasMasterSword;
	private boolean hasTaco;
	private boolean hasKey;
	private boolean hasMouse;
	
	
	public Inventory(){
		//create inventory arrays
		allItemsBoolean = new boolean[8];
		allItemsName = new String[8];
		//beginner item, always has this
		hasDinkySword = true;
	}
	
	//show items
	public void showInventory(int cashMoneys){
		//arrays corrolate values and assigned names
		allItemsBoolean = new boolean[] {(hasDinkySword), (hasBow), (hasGemstone), (hasOars), (hasMasterSword), (hasTaco), (hasKey), (hasMouse)};
		allItemsName = new String[]{"Dinky Sword", "Bow", "Gemstone", "Boat oars", "Master sword", "Taco", "Key", "Mouse"};
		
		String hold = "";
		boolean nothing = true;
		
		//accumulate items
		for(int i = 0; i < allItemsBoolean.length; i++){
			if(allItemsBoolean[i]){
				hold += (allItemsName[i] + "%n");
			}
			//check if inventory is empty
			if(allItemsBoolean[i]){
				nothing = false;
			}
		}
		//if player has no items
		if(nothing){
			System.out.println("You don't have anything right now");
		}
		else{
			//prints formatted inventory (easier to read)
			System.out.println("\u001b[34m\u001b[47m*************************\u001B[0m");
			System.out.printf("You have:%n" + cashMoneys + 
								" Cash Moneys%n" + "" + hold + "%n");
			System.out.println("\u001b[34m\u001b[47m*************************\u001B[0m");
		}
	}
	
	//items value setters to display
	public void setDinkySword(boolean value){
		this.hasBow = value;
	}
	public void setBow(boolean value){
		this.hasBow = value;
	}
	public void setGemstone(boolean value){
		this.hasGemstone = value;
	}
	public void setOars(boolean value){
		this.hasOars = value;
	}
	public void setMasterSword(boolean value){
		this.hasMasterSword = value;
	}
	public void setTaco(boolean value){
		this.hasTaco = value;
	}
	public void setKey(boolean value){
		this.hasKey = value;
	}
	public void setMouse(boolean value){
		this.hasMouse = value;
	}
}
