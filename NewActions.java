import java.util.Scanner;

public class NewActions{
	//items that unlock next part of story
	private boolean hasSonStory;
	private boolean hasBow;
	private boolean hasGemstone;
	private boolean hasOars;
	private boolean hasMasterSword;
	private boolean hasTacoStory;
	private boolean hasTaco;
	private boolean hasKey;
	private boolean hasMouse;
	
	//money
	private int cashMoneys;
	
	//checks to restrict exits
	private boolean isWanted = false;
	
	//check positions
	private Room currentPosition;
	private Room newPosition;
	
	//check if first interaction - eliminates repeating dialouge
	private boolean firstInteraction;
	
	//finish game boolean
	private boolean mainQuest;
	
	//constructor, set values
	public NewActions(){
		hasSonStory = false;
		hasBow = false;
		hasGemstone = false;
		hasOars = false;
		hasMasterSword = false;
		hasTacoStory = false;
		hasTaco = false;
		hasKey = false;
		hasMouse = false;
		
		cashMoneys = 20;
		
		//set current position to City gates		
		this.currentPosition = LegendOfCat.cityGates;
		//set first interaction to true
		firstInteraction = true;
		
		mainQuest = true;
		
	}
	
	//get exits prompts the players for exits AND executes actions
	public boolean getExitsActions(){
		//make scanner
		Scanner input = new Scanner(System.in);
		//initialize impossible choice
		String choice = "100";
		//combat variables
		int attackChoice = 0;
		int damage = 0;
		String thisChoice = "";
		//loop conditions for combat
		boolean enemyLives = true;
		boolean validChoice = false;
		//room ID number to switch
		int roomID = this.currentPosition.getRoomID();
		
		switch(roomID){
			//forest, gains mouse, pushes player to combat area
			case -4:
				System.out.printf("Well, the forest isn't so bad right? There's trees, and flowers, and a big scary cat looming over you... Gannon Cat?!?!.%n" +
								"Scruffy prison cat: No I'm not Gannon you little runt! Listen, I busted out of prison to find you here. I've got to admit, I "+
								"was wrong. You've done well to get this far. But it's dangerous to go alone, take this.%nYou got...a rotting \u001b[36mmouse " +
								"corpse\u001b[0m?%nScruffy: This is the \u001b[36mMouse of Eternal Wisdom\u001b[0m. I have depended on it greaty, but now we " +
								"depend on you, Hero. Go now, quickly.%nYou take the disintegrating \u001b[36mmouse\u001b[0m and run for it. Gannon may be a " +
								"bad guy, but at least he's not insane like this one. Next stop, <Cat Scratch Dungeon>.");
				this.newPosition = executeActions(-4, 1);
				setNewPosition();
			break;
			//calico island; gain master sword, lose oars
			case -3:
				System.out.printf("You find your way to the little island in the lake, only to notice a stone stairway leading into the ground.%n" +
									"[1]Check it out%n[2]Curiosity killed the cat! Turn around.%n");
				System.out.println("---------------------------------------------------");
				choice = input.next();
				if(choice.equals("q")){
					mainQuest = false;
				}
				else if(choice.equals("i")){
					LegendOfCat.hero.inventory.showInventory(cashMoneys);
					this.newPosition = this.currentPosition;
				}
				else{
					this.newPosition = executeActions(-3, Integer.parseInt(choice));
				}
				if(this.currentPosition != this.newPosition){
					firstInteraction = true;
				}
				else{
					firstInteraction = false;
				}
				
				setNewPosition();
			break;
			//hunting grounds, has a rabbit, leads to barricade/forest
			case -2:
				if(firstInteraction){
					System.out.printf(LegendOfCat.huntingGrounds.getName() + ":%nThere is equipment for soldiers to train with near the city wall. Bunnies run " +
									"free in a patch of daisies. Beyond them you can see the barricade to Flea Forest.%n");
				}
				System.out.printf("[1]Inspect bunny%n[2]Go to barricade%n[3]Go to capitol gates%n");
				choice = input.next();
				if(choice.equals("q")){
					mainQuest = false;
				}
				else if(choice.equals("i")){
					LegendOfCat.hero.inventory.showInventory(cashMoneys);
					this.newPosition = this.currentPosition;
				}
				else{
					this.newPosition = executeActions(-2, Integer.parseInt(choice));
				}
				if(this.currentPosition != this.newPosition){
					firstInteraction = true;
				}
				else{
						firstInteraction = false;
				}
				
				setNewPosition();
			break;
			//cove, nothing here for now
			case -1:
				System.out.printf("You are in kitten cove, your home. Better leave before Mama or Gramps see you!%n[1] Go to the Capital%n");
				choice = input.next();
				this.newPosition = executeActions(-1, Integer.parseInt(choice));
				setNewPosition();
			break;
			//city gates, access to outside only if not wanted criminal
			case 0:
				if(firstInteraction){
					System.out.printf(LegendOfCat.cityGates.getName() + ":%n");
				}
				System.out.printf("[1]Talk to guards%n" + "[2]Go north, to the stables%n[3]Go west, to Cat Nip Fields%n[4]Go south, to the " +
								"Armory%n[5]Go to the City Center%n[6]Go to the hunting grounds%n[7]Go to Kitten Cove%n");
				choice = input.next();
				if(choice.equals("q")){
					mainQuest = false;
				}
				else if(choice.equals("i")){
					LegendOfCat.hero.inventory.showInventory(cashMoneys);
					this.newPosition = this.currentPosition;
				}
				else{
					this.newPosition = executeActions(0, Integer.parseInt(choice));
				}
				if(this.currentPosition != this.newPosition){
					firstInteraction = true;
				}
				else{
						firstInteraction = false;
				}
				
				setNewPosition();
			break;
			//armory, can look around etc
			case 1:
				if(firstInteraction){
				System.out.printf(LegendOfCat.royalArmory.getName() + ":%n");
				}
				System.out.printf("[1]Talk to the Warden%n[2]Look in the jail%n" +
								"[3]Go north, to the city gates%n[4]Go east, to the General Store%n[5]Go to the City Center%n");
				choice = input.next();
				if(choice.equals("q")){
					mainQuest = false;
				}
				if(choice.equals("i")){
					LegendOfCat.hero.inventory.showInventory(cashMoneys);
					this.newPosition = this.currentPosition;
				}
				else{
					this.newPosition = executeActions(1, Integer.parseInt(choice));
				}
				if(this.currentPosition != this.newPosition){
					firstInteraction = true;
				}
				else{
						firstInteraction = false;
				}
								
				setNewPosition();
			break;
			//general store, gain gemstone
			case 2:
				if(firstInteraction){
					System.out.printf(LegendOfCat.generalStore.getName() + ":%n The owner sits glumly behind the counter, reading the news.%n");
				}
				System.out.printf("[1]Talk to owner%n[2]Look around the shop%n[3]Go east, to Mayor Mitten's Mansion%n" + 
								"[4]Go west, to the Armory%n[5]Go to the City Center%n");
				choice = input.next();
				if(choice.equals("q")){
					mainQuest = false;
				}
				else if(choice.equals("i")){
					LegendOfCat.hero.inventory.showInventory(cashMoneys);
					this.newPosition = this.currentPosition;
				}
				else{
					this.newPosition = executeActions(2, Integer.parseInt(choice));
				}
				if(this.currentPosition != this.newPosition){
					firstInteraction = true;
				}
				else{
						firstInteraction = false;
				}
				
				setNewPosition();
			break;
			//mayor mittens, if has Taco can go to Zooldar
			case 3:
				if(firstInteraction){
					System.out.printf(LegendOfCat.mayorMittens.getName() + ":%nThe room you enter is the definition of posh. Paintings of old cats hang on the wall, and " +
									"every detail is carved to perfection. A large cat lay slumped in front of a grand door... " +
									"the entrance to <Zooldar's Castle>.%n");
				}
				System.out.printf("[1]Talk to Mayor Mittens%n[2]Go north to Furstone Library%n" +
								"[3]Go west to the general store%n[4]Go to the City Center%n");
								
				choice = input.next();
				if(choice.equals("q")){
					mainQuest = false;
				}
				else if(choice.equals("i")){
					LegendOfCat.hero.inventory.showInventory(cashMoneys);
					this.newPosition = this.currentPosition;
				}
				else{
					this.newPosition = executeActions(3, Integer.parseInt(choice));
				}
				if(this.currentPosition != this.newPosition){
					firstInteraction = true;
				}
				else{
					firstInteraction = false;
				}
				
				setNewPosition();
			break;
			//stable, can get bow after talking to librarian
			case 4:
				if(firstInteraction){
					System.out.printf(LegendOfCat.stables.getName() + ":%n A young boy is brushing a horse. He is startled when he sees you.%n");
				}
				System.out.printf("[1]Talk to stable boy%n[2]Pet horse%n[3]Go east, to Backtail Alley%n[4]Go south, to the city gates%n" +
									"[5]Go to City Center%n");
				choice = input.next();
				if(choice.equals("q")){
					mainQuest = false;
				}
				else if(choice.equals("i")){
					LegendOfCat.hero.inventory.showInventory(cashMoneys);
					this.newPosition = this.currentPosition;
				}
				else{
					this.newPosition = executeActions(4, Integer.parseInt(choice));
				}
				if(this.currentPosition != this.newPosition){
					firstInteraction = true;
				}
				else{
						firstInteraction = false;
				}
				
				setNewPosition();
			break;
			//backtail alley, can leave through here if wanted
			case 5:
				if(firstInteraction){
					System.out.printf(LegendOfCat.backtailAlley.getName() + ":%nIt's a dark humid alley, and it's filled with the grotesque stench of stable manure " +
									"and whatever contents did not remain in the bar patrons' stomaches last night. You notice the bricks of the " +
									"city wall here are cracked and crumbling away, probably because no one wants to maintain this area.%n");
				}
				System.out.printf("[1]Go east to Tom Cat Bar%n[2]Go west to the stables%n[3]Go to City Center%n");
				choice = input.next();
				if(choice.equals("q")){
					mainQuest = false;
				}
				else if(choice.equals("i")){
					LegendOfCat.hero.inventory.showInventory(cashMoneys);
					this.newPosition = this.currentPosition;
				}
				else{
					this.newPosition = executeActions(5, Integer.parseInt(choice));
				}
				if(this.currentPosition != this.newPosition){
					firstInteraction = true;
				}
				else{
						firstInteraction = false;
				}
				
				setNewPosition();
			break;
			//Tom cat bar, can get location of Taco's
			case 6:
				if(firstInteraction){
					System.out.printf(LegendOfCat.tomCatBar.getName() + ":%nThe toughest cats in town all tend to gather here on a Wednesday afternoon. Scars, " +
									"tattoos, and eyepatches blur together as the drunken cats slur sea shanties.%nBar Tender: ♪...Weigh-hey and up she " +
									"rises early in the morning!...♪%nAre you even old enough to be in here lad?%n[1]Yes%n[2]No%n");
				}
				System.out.printf("[3]Go east to PawPrint Museum%n[4]Go west to Backtail alley%n[5]Go to City Center%n");
				choice = input.next();
				if(choice.equals("q")){
					mainQuest = false;
				}
				else if(choice.equals("i")){
					LegendOfCat.hero.inventory.showInventory(cashMoneys);
					this.newPosition = this.currentPosition;
				}
				else{
					this.newPosition = executeActions(6, Integer.parseInt(choice));
				}
				if(this.currentPosition != this.newPosition){
					firstInteraction = true;
				}
				else{
						firstInteraction = false;
				}
				
				setNewPosition();
			break;
			//give gemston, get oars
			case 7:
				if(firstInteraction){
					System.out.printf(LegendOfCat.pawprintMuseum.getName() + ":%nOnce the door closes behind you, the curator bustles herself over from cleaning.%nCurator: " +
									"Welcome dear! It's wonderful to see such a young face interested in our precious history. Please look around, I know all about these items!%n");
				}
				System.out.printf("[1]Look at scrolls%n[2]Look at nautical display%n[3]Look at map%n[4]Go east to Furstone Library%n[5]Go west to Tom Cat Bar%n" +
								"[6]Go to City Center%n");
				choice = input.next();
				if(choice.equals("q")){
					mainQuest = false;
				}
				else if(choice.equals("i")){
					LegendOfCat.hero.inventory.showInventory(cashMoneys);
					this.newPosition = this.currentPosition;
				}
				else{
					this.newPosition = executeActions(7, Integer.parseInt(choice));	
				}
				if(this.currentPosition != this.newPosition){
					firstInteraction = true;
				}
				else{
					firstInteraction = false;
				}
				
				setNewPosition();
			break;
			//get first part of story
			case 8:
				if(firstInteraction){
					System.out.printf(LegendOfCat.furstoneLibrary.getName() + ":%nStepping into the library, the shift in atmosphere from the streets outside is " +
									"overwhelming. You smell the old pages of a thousand books stacked from floor to ceiling. Small chimes sing as a breeze " +
									"comes through a window. The librarian looks up from his desk expectantly and gives you a soft smile.%n");
				}
				System.out.printf("[1]Talk to librarian%n[2]Examine books%n[3]Inspect desk%n[4]Go west to Pawprint Museum%n" +
								"[5]Go south to Mayor Mitten's House%n[6]Go to the City Center%n");
				choice = input.next();
				if(choice.equals("q")){
					mainQuest = false;
				}
				else if(choice.equals("i")){
					LegendOfCat.hero.inventory.showInventory(cashMoneys);
					this.newPosition = this.currentPosition;
				}
				else{
					this.newPosition = executeActions(8, Integer.parseInt(choice));
				}
				if(this.currentPosition != this.newPosition){
					firstInteraction = true;
				}
				else{
					firstInteraction = false;
				}
					
				setNewPosition();
			break;
			//city center, serves as quick portal around city, can get tacos once location i known
			case 9:
				System.out.printf(LegendOfCat.cityCenter.getName() + ":%nLooking through the market stalls, you seem to forget about the impending doom " +
								"upon this city. Everyone seems to go about " +
								"their day as if nothing were amiss. There are several paths that will lead you around the city.%n[1]Go to city gates%n" +
								"[2]Go to Royal Cat Armory%n[3]Go to the General Store%n[4]Go to Mayor Mitten's house%n[5]Go to Furstone Library%n[6]Go to " +
								"Paw Print Museum%n[7]Go to Tom Cat Bar%n[8]Go to Backtail alley%n[9]Go to the stables%n");
				choice = input.next();
				if(choice.equals("q")){
					mainQuest = false;
				}
				else if(choice.equals("i")){
					LegendOfCat.hero.inventory.showInventory(cashMoneys);
					this.newPosition = this.currentPosition;
				}
				else{
					this.newPosition = executeActions(9, Integer.parseInt(choice));
				}
				if(this.currentPosition != this.newPosition){
					firstInteraction = true;
				}
				else{
						firstInteraction = false;
				}
				
				setNewPosition();
			break;
			//Zooldar; progresses story, gives you a key to forest, you are now wanted 
			case 10:
			System.out.printf(LegendOfCat.princessZooldar.getName() + ":%nYou step into a courtyard filled with flowers and bubbling fountains. A graceful cat steps " +
								"silently toward you, her fluffy face hidden by a veil.%nPrincess Zooldar: " + LegendOfCat.hero.getName() + LegendOfCat.hero.getSuffix() + 
								", you have come to save the kingdom in our most dire time. " +
								"The invasion of fleas has broken through the barricades, and I fear our humble capital will soon be taken. " +
								"<Gannon Cat> will do everything in his power to plague our Cat Folk, and take the weakened land for himself." +
								"No other 'hero' has gotten past Mayor Mittens. I have faith you are of the legend, and will fulfill the prophecy. " +
								"Take this \u001b[36mkey\u001b[0m and run north, to the barricade. In the <forest>, I predict a *great sage* will guide you to " +
								"<Cat Scratch Dungeon>. %n%nYou run from Zooldar's castle, bearing the key to the barricades. Bursting out the Mayor's door you find....%n");
				this.newPosition = executeActions(10, 1);
				setNewPosition();
			break;			
			//meet Scruffy, he lets you out
			case 11:
				if(firstInteraction){
				System.out.printf(LegendOfCat.felineFelonsJailhouse.getName() + ":%nThe jail is cramped and cold. A prisoner sits chained to the corner. " +
								"He is a big cat covered in scars.%n");
				}
				System.out.printf("[1]Talk to the guards%n[2]Look around%n[3]Talk to the prisoner%n");
				choice = input.next();
				if(choice.equals("q")){
					mainQuest = false;
				}
				else if(choice.equals("i")){
					LegendOfCat.hero.inventory.showInventory(cashMoneys);
					this.newPosition = this.currentPosition;
				}
				else{
					this.newPosition = executeActions(11, Integer.parseInt(choice));
				}
				if(this.currentPosition!= this.newPosition){
					firstInteraction = true;
				}
				else{
						firstInteraction = false;
				}
				
				setNewPosition();
			break;
			//if has oars, can go to Calico island in the boat
			case 12:
			if(firstInteraction){
				System.out.printf(LegendOfCat.catNipFields.getName() + ":%nStepping into the soft grass a sudden calm comes across you. You don't really want " +
								"to do... anything. There is a boat softly floating on the shore of a lake. You become drowsy watching it. You sure could take " +
								"a nap here... Oh wait, save the world...right.%n");
			}
			System.out.printf("[1]Look at the boat%n[2]Have a snack%n[3]Return to the Capital%n");
				choice = input.next();
				if(choice.equals("q")){
					mainQuest = false;
				}
				else if(choice.equals("i")){
					LegendOfCat.hero.inventory.showInventory(cashMoneys);
					this.newPosition = this.currentPosition;
				}
				else{
					this.newPosition = executeActions(12, Integer.parseInt(choice));
				}
				if(this.currentPosition != this.newPosition){
					firstInteraction = true;
				}
				else{
						firstInteraction = false;
				}
				
				setNewPosition();
			break;
			//enemy combat one
			case 13:
				Enemy enemyWave1 = new Enemy(13);
				
				//loop combat
				System.out.printf(LegendOfCat.dungeon1.getName() + ":%n");
				System.out.printf(enemyWave1.getName() +" has appeared!! "+ enemyWave1.getName() + " has " + enemyWave1.getHealth() + 
								" health and " + enemyWave1.getStrength() + " attack power.%n");
				while(enemyLives){
					System.out.printf("[1]Use your claws%n[2]Use the dinky sword Gramps gave you%n[3]Use the bow and arrows%n[4]Use the Master Sword (*cough*hint hint*cough*)%n");
					thisChoice = input.next();
					if(choice.equals("q")){
						mainQuest = false;
					}
					else if(thisChoice.equals("i")){
						LegendOfCat.hero.inventory.showInventory(cashMoneys);
						this.newPosition = this.currentPosition;
					}
					else{
						attackChoice = Integer.parseInt(thisChoice);
						while(!validChoice){
							if(attackChoice == 1){
								damage = LegendOfCat.hero.attackEnemy(LegendOfCat.hero.weapon1);
								//enemy attacks hero, hero loses health
								enemyWave1.attackHero(LegendOfCat.hero);
								System.out.println("You now have " + LegendOfCat.hero.getHealth() + " health.");
								//enemy takes damage from attack, returns if dead
								enemyLives = enemyWave1.takeDamage(damage);
								
								validChoice = true;
							}
							else if(attackChoice == 2){
								damage = LegendOfCat.hero.attackEnemy(LegendOfCat.hero.weapon2);
								//enemy attacks hero, hero loses health
								enemyWave1.attackHero(LegendOfCat.hero);
								System.out.println("You now have " + LegendOfCat.hero.getHealth() + " health.");
								//enemy takes damage from attack, returns if dead
								enemyLives = enemyWave1.takeDamage(damage);
								
								validChoice = true;
							}
							else if(attackChoice == 3){
								damage = LegendOfCat.hero.attackEnemy(LegendOfCat.hero.weapon3);
								//enemy attacks hero, hero loses health
								enemyWave1.attackHero(LegendOfCat.hero);
								System.out.println("You now have " + LegendOfCat.hero.getHealth() + " health.");
								//enemy takes damage from attack, returns if dead
								enemyLives = enemyWave1.takeDamage(damage);
								
								validChoice = true;
							}
							else if(attackChoice == 4){
								damage = LegendOfCat.hero.attackEnemy(LegendOfCat.hero.weapon4);
								//enemy attacks hero, hero loses health
								enemyWave1.attackHero(LegendOfCat.hero);
								System.out.println("You now have " + LegendOfCat.hero.getHealth() + " health.");
								//enemy takes damage from attack, returns if dead
								enemyLives = enemyWave1.takeDamage(damage);
								
								validChoice = true;
							}
							else{
								System.out.println("enter a valid weapon");
							}
							System.out.println("---------------------------------------------------");
						}
						validChoice = false;
					}//end validation loop
				}//end enemy life loop
				this.newPosition = executeActions(13, 1);
				setNewPosition();
			break;
			//enemy combat two
			case 14:
				Enemy enemyWave2 = new Enemy(14);
				
				//loop combat
				System.out.printf(LegendOfCat.dungeon2.getName() + ":%n");
				System.out.printf(enemyWave2.getName() + " has appeared!! " + enemyWave2.getName() + " has " + enemyWave2.getHealth() + " health and " + 
								enemyWave2.getStrength() + " attack power.%n");
				while(enemyLives){
					System.out.printf("[1]Use your claws%n[2]Use the dinky sword Gramps gave you%n[3]Use the bow and arrows%n[4]Use the Master Sword (*cough*hint hint*cough*)%n");
					thisChoice = input.next();
					if(choice.equals("q")){
						mainQuest = false;
					}
					else if(thisChoice.equals("i")){
						LegendOfCat.hero.inventory.showInventory(cashMoneys);
						this.newPosition = this.currentPosition;
					}
					else{
						attackChoice = Integer.parseInt(thisChoice);
						while(!validChoice){
							if(attackChoice == 1){
								damage = LegendOfCat.hero.attackEnemy(LegendOfCat.hero.weapon1);
								//enemy attacks hero, hero loses health
								enemyWave2.attackHero(LegendOfCat.hero);
								System.out.println("You now have " + LegendOfCat.hero.getHealth() + " health.");
								//enemy takes damage from attack, returns if dead
								enemyLives = enemyWave2.takeDamage(damage);
								
								validChoice = true;
							}
							else if(attackChoice == 2){
								damage = LegendOfCat.hero.attackEnemy(LegendOfCat.hero.weapon2);
								//enemy attacks hero, hero loses health
								enemyWave2.attackHero(LegendOfCat.hero);
								System.out.println("You now have " + LegendOfCat.hero.getHealth() + " health.");
								//enemy takes damage from attack, returns if dead
								enemyLives = enemyWave2.takeDamage(damage);
								
								validChoice = true;
							}
							else if(attackChoice == 3){
								damage = LegendOfCat.hero.attackEnemy(LegendOfCat.hero.weapon3);
								//enemy attacks hero, hero loses health
								enemyWave2.attackHero(LegendOfCat.hero);
								System.out.println("You now have " + LegendOfCat.hero.getHealth() + " health.");
								//enemy takes damage from attack, returns if dead
								enemyLives = enemyWave2.takeDamage(damage);
								
								validChoice = true;
							}
							else if(attackChoice == 4){
								damage = LegendOfCat.hero.attackEnemy(LegendOfCat.hero.weapon4);
								//enemy attacks hero, hero loses health
								enemyWave2.attackHero(LegendOfCat.hero);
								System.out.println("You now have " + LegendOfCat.hero.getHealth() + " health.");
								//enemy takes damage from attack, returns if dead
								enemyLives = enemyWave2.takeDamage(damage);
								
								validChoice = true;
							}
							else{
								System.out.println("enter a valid weapon");
							}
							System.out.println("---------------------------------------------------");
						}
						validChoice = false;
					}//end validation loop
				}//end enemy life loop
				this.newPosition = executeActions(14, 1);
				setNewPosition();
			break;
			//enemy combat three
			case 15:
				Enemy enemyWave3 = new Enemy(15);
				
				//loop combat
				System.out.printf(LegendOfCat.dungeon3.getName() + ":%n");
				System.out.printf(enemyWave3.getName() +" has appeared!!" + enemyWave3.getName() + " has " + enemyWave3.getHealth() + 
								" health and " + enemyWave3.getStrength() + " attack power.%n");
				while(enemyLives){
					System.out.printf("[1]Use your claws%n[2]Use the dinky sword Gramps gave you%n[3]Use the bow and arrows%n[4]Use the Master Sword (*cough*hint hint*cough*)%n");
					thisChoice = input.next();
					if(choice.equals("q")){
						mainQuest = false;
					}
					else if(thisChoice.equals("i")){
						LegendOfCat.hero.inventory.showInventory(cashMoneys);
						this.newPosition = this.currentPosition;
					}
					else{
						attackChoice = Integer.parseInt(thisChoice);
						while(!validChoice){
							if(attackChoice == 1){
								damage = LegendOfCat.hero.attackEnemy(LegendOfCat.hero.weapon1);
								//enemy attacks hero, hero loses health
								enemyWave3.attackHero(LegendOfCat.hero);
								System.out.println("You now have " + LegendOfCat.hero.getHealth() + " health.");
								//enemy takes damage from attack, returns if dead
								enemyLives = enemyWave3.takeDamage(damage);

								validChoice = true;
							}
							else if(attackChoice == 2){
								damage = LegendOfCat.hero.attackEnemy(LegendOfCat.hero.weapon2);
								//enemy attacks hero, hero loses health
								enemyWave3.attackHero(LegendOfCat.hero);
								System.out.println("You now have " + LegendOfCat.hero.getHealth() + " health.");
								//enemy takes damage from attack, returns if dead
								enemyLives = enemyWave3.takeDamage(damage);
								
								validChoice = true;
							}
							else if(attackChoice == 3){
								damage = LegendOfCat.hero.attackEnemy(LegendOfCat.hero.weapon3);
								//enemy attacks hero, hero loses health
								enemyWave3.attackHero(LegendOfCat.hero);
								System.out.println("You now have " + LegendOfCat.hero.getHealth() + " health.");
								//enemy takes damage from attack, returns if dead
								enemyLives = enemyWave3.takeDamage(damage);
								
								validChoice = true;
							}
							else if(attackChoice == 4){
								damage = LegendOfCat.hero.attackEnemy(LegendOfCat.hero.weapon4);
								//enemy attacks hero, hero loses health
								enemyWave3.attackHero(LegendOfCat.hero);
								System.out.println("You now have " + LegendOfCat.hero.getHealth() + " health.");
								//enemy takes damage from attack, returns if dead
								enemyLives = enemyWave3.takeDamage(damage);
								
								validChoice = true;
							}
							else{
								System.out.println("enter a valid weapon");
							}
							System.out.println("---------------------------------------------------");
						}
						validChoice = false;
					}//end validation loop
				}//end enemy life loop
				this.newPosition = executeActions(15, 1);
				setNewPosition();
			break;
			//Gannon cat; does not loop, you can't defeat him unless you are Kratos cat
			case 16:
				Enemy Gannon = new Enemy(16);
				
				//loop combat
				System.out.printf(LegendOfCat.dungeon4.getName() + ":%n");
				System.out.printf(Gannon.getName() +" has appeared!!" + Gannon.getName() + " has " + Gannon.getHealth() + " health and " +
								Gannon.getStrength() + " attack power.%n");
					System.out.printf("[1]Use your claws%n[2]Use the dinky sword Gramps gave you%n[3]Use the bow and arrows%n[4]Use the Master Sword (*cough*hint hint*cough*)%n");
					thisChoice = input.next();
					if(choice.equals("q")){
						mainQuest = false;
					}
					while(thisChoice.equals("i")){
						LegendOfCat.hero.inventory.showInventory(cashMoneys);
						this.newPosition = this.currentPosition;
						thisChoice = input.next();
					}
					attackChoice = Integer.parseInt(thisChoice);
					while(!validChoice){
						if(attackChoice == 1){
							damage = LegendOfCat.hero.attackEnemy(LegendOfCat.hero.weapon1);
							//enemy attacks hero, hero loses health
							Gannon.attackHero(LegendOfCat.hero);
							//enemy takes damage from attack, returns if dead
							enemyLives = Gannon.takeDamage(damage);
							
							validChoice = true;
						}
						else if(attackChoice == 2){
							damage = LegendOfCat.hero.attackEnemy(LegendOfCat.hero.weapon2);
							//enemy attacks hero, hero loses health
							Gannon.attackHero(LegendOfCat.hero);
							//enemy takes damage from attack, returns if dead
							enemyLives = Gannon.takeDamage(damage);
							
							validChoice = true;
						}
						else if(attackChoice == 3){
							damage = LegendOfCat.hero.attackEnemy(LegendOfCat.hero.weapon3);
							//enemy attacks hero, hero loses health
							Gannon.attackHero(LegendOfCat.hero);
							//enemy takes damage from attack, returns if dead
							enemyLives = Gannon.takeDamage(damage);
							
							validChoice = true;
						}
						else if(attackChoice == 4){
							damage = LegendOfCat.hero.attackEnemy(LegendOfCat.hero.weapon4);
							//enemy attacks hero, hero loses health
							Gannon.attackHero(LegendOfCat.hero);
							//enemy takes damage from attack, returns if dead
							enemyLives = Gannon.takeDamage(damage);
							
							validChoice = true;
						}
						else{
							System.out.println("enter a valid weapon");
						}
						System.out.println("---------------------------------------------------");
				}//end validation loop
				validChoice = false;
				this.newPosition = executeActions(16, 1);
				setNewPosition();
			break;
			
			//return is valid
			default:
				System.out.println("Please enter a valid input%n");
				getExitsActions();	
			break;
			
		}//end switch
		
		return mainQuest;	
	}//end getExitsActions
	
	
	//execute actions, change positions, gives reraction dialogue based on choice
	public Room executeActions(int caseNumber, int selectionNumber){
		Room newPosition = this.currentPosition;
		System.out.println("\u001b[35m");
		switch(caseNumber){
			case -4:
				if(selectionNumber == 1){
					hasMouse = true;
					newPosition = LegendOfCat.dungeon1;
				}
			break;
			case -3:
				if(selectionNumber == 2){
					System.out.println("Get over it short-stack. You're the Hero, now get your tail down there.");
				}
				System.out.printf("Descending the stairwell, the air becomes moist and cold. However, at the bottom you look around in wonder%n" +
								"There is glittering treasures stacked twice your height, and old maps litter the floor.%n");
				System.out.printf("Capn' Calico: My my, what's this? Been a while since I've had a visitor. You must be a 'Hero' from Kitten Cove, " +
								"they all come here looking for swords in my collection. Well, just grab one off the top.%nIf you die try to get it shipped " +
								"back before the weekend, it's less expensive that way.%n I'll push you back to the fields, but I'm keeping the \u001b[36moars\u001b[35m so the " +
								"programmer doesn't have to write more code. She's late for class now.%n");							
				hasMasterSword = true;
				LegendOfCat.hero.inventory.setMasterSword(true);
				newPosition = LegendOfCat.calicoIsland;
			break;
			case -2:
				if(selectionNumber == 1){
					System.out.println("Bunny: Ehhhhhh, what's up doc?");
				}
				else if(selectionNumber == 2){
					if(isWanted){
						System.out.println("You quickly use the \u001b[35mkey\u001b]0m *Princess Zooldar* gave you and enter the forest....");
						newPosition = LegendOfCat.longFleaForest;
					}
					else{
						System.out.println("Hmmm, it's locked. Go find a \u001b[35mkey!");
					}
				}
				else if(selectionNumber == 3){
					if(isWanted){
						System.out.println("Are you crazy! You're a criminal! You can't go there, so get your lazy tail to *Gannon Cat*!");
					}
					else{
						newPosition = LegendOfCat.cityGates;
					}
				}
			break;
			case -1:
				if(selectionNumber == 1){
					newPosition = LegendOfCat.cityGates;
				}
			break;
			case 0:
				if(selectionNumber == 1){
					if(isWanted){
						System.out.println("Bad idea! The gates are locked and reinforced. Better find another way out of here.");
					}
					else{
						System.out.printf("Guard 1: Hello again friend, my coworker is off fetching the captain. You better not dawdle too long!%n" +
										"	Check out Furstone Library if you're bored, the Librarian sure is a kind fellow!%n");
					}
				}
				else if(selectionNumber == 2){
					newPosition = LegendOfCat.cityGates.getNewPosition("n");
				}
				else if(selectionNumber == 3){
					if(isWanted){
						System.out.printf("Bad idea! The gates are locked and reinforced. Better find another way out of here.%n");
					}
					else{
						newPosition = LegendOfCat.cityGates.getNewPosition("w");
					}
				}
				else if(selectionNumber == 4){
					newPosition = LegendOfCat.cityGates.getNewPosition("s");
				}
				else if(selectionNumber == 5){
					newPosition = LegendOfCat.cityCenter;
				}
				else if(selectionNumber == 6){
					if(isWanted){
						System.out.println("Bad idea! The gates are locked and reinforced. Better find another way out of here.%n");
					}
					else{
						newPosition = LegendOfCat.huntingGrounds;
					}
				}
				else if(selectionNumber == 7){
					if(isWanted){
						System.out.printf("Bad idea! The gates are locked and reinforced. Better find another way out of here.");
					}
					else{
					newPosition = LegendOfCat.kittenCove;
					}
				}
				else{
					System.out.println("Enter a valid choice");
					newPosition = LegendOfCat.cityGates;
				}
			break;
			case 1:
				if(isWanted){
					System.out.printf("Are you crazy! You just got out of here! Find a way out of the Capital.%n");
					newPosition = LegendOfCat.cityCenter;
				}
				else if(selectionNumber == 1){
					System.out.printf("You walk over to speak with the Warden, only to see that he is in a deep slumber. Best not disturb him, he looks tough.%n");
				}
				else if(selectionNumber == 2){
					System.out.printf("Inside the jail cell is a scruffy cat, covered in scars with a dead look in his eyes. You should let him be.%n");
				}
				else if(selectionNumber == 3){
					newPosition = LegendOfCat.royalArmory.getNewPosition("n");
				}
				else if(selectionNumber == 4){
					newPosition = LegendOfCat.royalArmory.getNewPosition("e");
				}
				else if(selectionNumber == 5){
					newPosition = LegendOfCat.cityCenter;
				}
				else{
					System.out.println("Enter a valid choice");
					newPosition = LegendOfCat.royalArmory;
				}
			break;
			case 2:
				if(hasBow){
					System.out.printf("Owner: Wait..! Is that a \u001b[36mbow?\u001b[35m Are you an adventurer too? Well I'll be.... Alright kid, seems you got guts. " +
										"I'll give you a little gift, it may help you in your travels.%n You got a \u001b[36mprecious green gemstone!%n");
					hasGemstone = true;
					LegendOfCat.hero.inventory.setGemstone(true);
					hasBow = false;
				}
				else if(selectionNumber == 1){
					System.out.printf("Owner: Eh? How old are you..? Do you even have cash money? Yeah that won't be enough to buy anything here. Most of my wares come " +
									"from the great adventures I had as a young cat, they are priceless artifacts. But those days are over now. Anyhow, come " +
									"back when you have money.%n");
				}
				
				else if(selectionNumber == 2){
					System.out.printf("The shelves contain a slew of trinkets and gadgets covered with dust. You have to admit though, they would look quite nice " +
									"with a little cleaning.%n");
				}
				else if(selectionNumber == 3){
					newPosition = LegendOfCat.generalStore.getNewPosition("e");
				}
				else if(selectionNumber == 4){
					newPosition = LegendOfCat.generalStore.getNewPosition("w");
				}
				else if(selectionNumber == 5){
					newPosition = LegendOfCat.cityCenter;
				}
				else{
					System.out.println("Enter a valid choice");
					newPosition = LegendOfCat.generalStore;
				}
			break;
			case 3:
				if(selectionNumber == 1){
					if(hasTaco){
						System.out.printf("Mayor Mittens: Oh...Is this a \u001b[36mfish taco\u001b[35m from that market stall in the back? ... for me?! " +
										"What a kind young gentleman! Well, I suppose you can take a quick peak at the castle while I eat. Just don't disturb " +
										"*Princess Zooldar*!%n");
						hasTaco = false;
						LegendOfCat.hero.inventory.setTaco(false);
						newPosition = LegendOfCat.princessZooldar;
					}
					else{
						System.out.printf("Mayor Mittens: Hmmmm? And who are you? You don't look like the son of an Aristocat. Too scrawny. Well you certainly can't pass this " +
									"door to the castle grounds.%n*grrrgle*%nAh man am I hungry! I wish I had some food, my my secretary called in sick!%n" +
									"catscratch fever... poor thing.%n");
					}
				}
				
				else if(selectionNumber == 2){
					newPosition = LegendOfCat.mayorMittens.getNewPosition("n");
				}
				else if(selectionNumber == 3){
					newPosition = LegendOfCat.mayorMittens.getNewPosition("w");
				}
				else if(selectionNumber == 4){
					newPosition = LegendOfCat.cityCenter;
				}
				else{
					System.out.println("Enter a valid choice");
					newPosition = LegendOfCat.mayorMittens;
				}
			break;
			case 4:
				if(selectionNumber == 1){
					if(hasSonStory){
					System.out.printf("Stable boy: Wow, I can't believe my dad is proud of me. Thank you, you should take my \u001b[36mbow\u001b[35m and be a great warrior!%n");
					hasBow = true;
					LegendOfCat.hero.inventory.setBow(true);
					}
					else if(!hasSonStory ){
					System.out.printf("Stable boy: I'm training to be a great warrior so my dad can be proud of me. He's super smart, but I didn't do well " +
										"in school.%n");
					}
				}
				else if(selectionNumber == 2){
					System.out.printf("You try to talk to the horse, but he's no Mr. Ed. (if you get that reference kudos)%n");
				}
				else if(selectionNumber == 3){
					newPosition = LegendOfCat.stables.getNewPosition("e");
				}
				else if(selectionNumber == 4){
					newPosition = LegendOfCat.stables.getNewPosition("s");
				}
				else if(selectionNumber == 5){
					newPosition = LegendOfCat.cityCenter;
				}
				else{
					System.out.println("Enter a valid choice");
					newPosition = LegendOfCat.stables;
				}
			break;
			case 5:
				if(isWanted){
					System.out.printf("Hold on, the crumbling wall! You run over and desperately claw at the crack, pieces of brick falling to your feet.%n" +
									"You just barely squeeze through, gratefully pulling fresh air into your lungs. Off to the dungeon....%n");
					newPosition = LegendOfCat.huntingGrounds;
				}
				else if(selectionNumber == 1){
					newPosition = LegendOfCat.backtailAlley.getNewPosition("e");
				}
				else if(selectionNumber == 2){
					newPosition = LegendOfCat.backtailAlley.getNewPosition("w");
				}
				else if(selectionNumber == 3){
					newPosition = LegendOfCat.cityCenter;
				}
				else{
					System.out.println("Enter a valid choice");
					newPosition = LegendOfCat.backtailAlley;
				}
			break;
			case 6:
				if(selectionNumber == 1){
					System.out.println("Bar tender: You're a dirty liar! I like it. You can stay boy.");
				}
				else if(selectionNumber == 2){
					System.out.println("Bar tender: An honest man dies young at sea. Be careful boy.");
				}
				
				else if(selectionNumber == 3){
					newPosition = LegendOfCat.tomCatBar.getNewPosition("e");
				}
				else if(selectionNumber == 4){
					newPosition = LegendOfCat.tomCatBar.getNewPosition("w");
				}
				else if(selectionNumber == 5){
					newPosition = LegendOfCat.cityCenter;
				}
				else{
					System.out.println("Enter a valid choice");
					newPosition = LegendOfCat.tomCatBar;
				}
				if(hasMasterSword){
					System.out.printf("Drunk: Wait up boy! That's a mighty sword you got there, reminds me of the one my old captain had, Cap'n Calico it was." +
									"Did you know all calicos are females? Ah if you want to meet a nice calico go talk to the lady in the back of " +
									"The market selling the \u001b[36mfish tacos\u001b[35m. Those are delicious boy. Ain't lived until ya tried em!%n");
					hasMasterSword = false;
					hasTacoStory = true;
				}
			break;
			case 7:
				if(hasGemstone){
					System.out.printf("Curator: Oh my! That \u001b[36mgem\u001b[35m, it's wonderful! It's just what I need to bring in a new crowd. How much are you " +
									"asking for it?%nThe \u001b[36moars\u001b[35m on the wall... are you sure? Well, certainly! Take them dear, you've done me a great service!%n");
					hasGemstone = false;
					LegendOfCat.hero.inventory.setGemstone(false);
					hasOars = true;
					LegendOfCat.hero.inventory.setOars(true);
				}
				if(selectionNumber == 1){
					System.out.printf("Curator: Those are the scrolls of the Hero of Cat. It follows the many kittens on their perilous journey, often ending in their " +
									"demise. Quite sad, but such is the world!%n");
				}
				else if(selectionNumber == 2){
					System.out.printf("Curator: Ah, these lands are abundant with water and fish. This display may not be a valuable artifact, but is a tribute to the " +
									"many sailors among us.%n");
				}
				else if(selectionNumber == 3){
					System.out.printf("Curator: This is a map of our vast lands! From the soft sands of <Kitten Cove> to the terrible frost of <Cat Scratch dungeon>, it's all " +
									"here! Legend says an old pirate keeps a great treasure over here, at <Calico Island>.%n");
				}
				else if(selectionNumber == 4){
					newPosition = LegendOfCat.pawprintMuseum.getNewPosition("e");
				}
				else if(selectionNumber == 5){
					newPosition = LegendOfCat.pawprintMuseum.getNewPosition("w");
				}
				else if(selectionNumber == 6){
					newPosition = LegendOfCat.cityCenter;
				}
				else{
					System.out.println("Enter a valid choice");
					newPosition = LegendOfCat.pawprintMuseum;
				}
			break;
			case 8:
				if(selectionNumber == 1){
					System.out.printf("Librarian: Hello young adventurer! You look like a hero on a great quest! I'm sure I have some books here that you would like...%n");
				}
				else if(selectionNumber == 2){
					System.out.printf("A Tail of Two Kitties, Of Mice and Cat, Lord of the Cats, Harry Catter, Cat Farm...%n");
				}
				else if(selectionNumber == 3){
					if(hasSonStory == false){
						System.out.printf("Librarian: Ah! That's a picture of my son! He didn't pursue the scholarly path as I did, he works as a stable hand. I think he " +
										"feels he should join the royal guard to impress me, since his mother passed. I wish I could tell him to follow his passion, " +
										"he's really good with those horses! But his mother was much better at talking to him, I wouldn't know what to say.%n");
						hasSonStory = true;
					}
					else{
						System.out.println("My sweet boy....");
					}
				}
				else if(selectionNumber == 4){
					newPosition = LegendOfCat.furstoneLibrary.getNewPosition("w");
				}
				else if(selectionNumber == 5){
					newPosition = LegendOfCat.furstoneLibrary.getNewPosition("s");
				}	
				else if(selectionNumber == 6){
					newPosition = LegendOfCat.cityCenter;
				}
				else{
					System.out.println("Enter a valid choice");
					newPosition = LegendOfCat.furstoneLibrary;
				}				
			break;
			case 9:
				int move = 9;
				if(hasTacoStory){
					System.out.println("Before you go, you decide to follow that cat's advice and grab a \u001b[36mtaco\u001b[35m from the secret stand around the back. " +
									"They were expensive, you paid 17 cash moneys for them. Totally worth it though.");
					hasTacoStory = false;
					hasTaco = true;
					LegendOfCat.hero.inventory.setTaco(true);
					cashMoneys -= 17;
				}
				if(selectionNumber == 1){
					newPosition = LegendOfCat.cityCenter.getNewPosition("0");
				}
				else if(selectionNumber == 2){
					newPosition = LegendOfCat.cityCenter.getNewPosition("1");
				}
				else if(selectionNumber == 3){
					newPosition = LegendOfCat.cityCenter.getNewPosition("2");
				}
				else if(selectionNumber == 4){
					newPosition = LegendOfCat.cityCenter.getNewPosition("3");
				}
				else if(selectionNumber == 5){
					newPosition = LegendOfCat.cityCenter.getNewPosition("8");
				}
				else if(selectionNumber == 6){
					newPosition = LegendOfCat.cityCenter.getNewPosition("7");
				}
				else if(selectionNumber == 7){
					newPosition = LegendOfCat.cityCenter.getNewPosition("6");
				}
				else if(selectionNumber == 8){
					newPosition = LegendOfCat.cityCenter.getNewPosition("5");
				}
				else if(selectionNumber == 9){
					newPosition = LegendOfCat.cityCenter.getNewPosition("4");
				}
				else{
					System.out.println("Enter a valid choice");
				}
			break;
			case 10:
				if(selectionNumber == 1){
					hasKey = true;
					System.out.printf("That obnoxious guard, with the captain. Before you can utter a word you find your wrists tied as you're dragged off to jail.%n" +
									"Guard 1: Well loo' at wha' I found! Hehehe, you'll be sleepin' wi' Scruffy tonigh'!%n");
					newPosition = LegendOfCat.felineFelonsJailhouse;
					isWanted = true;
				}
			break;
			case 11:
				if(selectionNumber == 1){
					System.out.printf("Guard 1: Ya though' ya could ge' away eh? Well no sir, no' from me! Now si' in the corner and be quiet!%n");
				}
				else if(selectionNumber == 2){
					System.out.printf("Not much here, just a scary cat in the corner. And a rotting mat, presumably to sleep on.%n");
				}
				else if(selectionNumber == 3){
					System.out.printf("Prisoner: You... you're a hero from <Kitten Cove> aren't you? Don't think you're special, plenty of 'heroes' tried to " +
									"defeat the great evil. I was once one....%nWhat, you still want to try?? A kitten your size couldn't even make it " +
									"through the forest!%nAre you seriously willing to throw yourself at death?!%nI see...In that case, I will aid you in your " +
									"quest.%nI have dug a hole underneath the mat, hurry through it. You can't leave through the main gates, find another way out. " +
									"Good luck.%n");
					newPosition = LegendOfCat.cityCenter;				
				}
				else{
					System.out.println("Enter a valid choice");
					newPosition = LegendOfCat.felineFelonsJailhouse;
				}
			break;
			case 12:
				if(selectionNumber == 1){
					if(hasOars){
						System.out.println("You decide a short boat ride to that little island can't hurt. Even the hero needs a break sometimes.");
						hasOars = false;
						LegendOfCat.hero.inventory.setOars(false);
						newPosition = LegendOfCat.calicoIsland;
					}
					else{
						System.out.println("The boat looks relaxing, but there are no oars to use.");
					}
				}
				else if(selectionNumber == 2){
					System.out.println("*Munch munch*...");
				}
				else if(selectionNumber == 3){
					newPosition = LegendOfCat.cityGates;
				}
				else{
					System.out.println("Enter a valid choice");
					newPosition = LegendOfCat.catNipFields;
				}
			break;
			case 13:
				if(selectionNumber == 1){
					System.out.printf("Hmmm, something tells me that wasn't Gannon Cat.%nWell, let's consume it's soul to gain health and streangth!%n" +
									"....don't look at me like that! It's a game, geez! haven't you watched Soul Eater? I'm not about to program health potions " +
									"So get over it.");
					LegendOfCat.hero.consumeSoul();
					newPosition = LegendOfCat.dungeon2;	
				}	
				
			break;
			case 14: 
				if(selectionNumber == 1){
					System.out.println("Well, that wasn't bad. Good job hero, consume it's soul and let's keep going!");
				}
				LegendOfCat.hero.consumeSoul();
				newPosition = LegendOfCat.dungeon3;
			break;
			case 15:
				if(selectionNumber == 1){
					System.out.println("Are we in the right dungeon? These NPCs must be broken. Ay Gannon Cat, where ya at?");
				}
				LegendOfCat.hero.consumeSoul();
				newPosition = LegendOfCat.dungeon4;
			break;
			//final dialogue, ends game
			case 16:
				if(selectionNumber == 1){
					if((LegendOfCat.hero.getName()).equals("Kratos")){
						System.out.println("Gannon Cat: What?! Your power level... it's over 9,000! It cant be, are you " + LegendOfCat.hero.getName() +
										LegendOfCat.hero.getSuffix() + "? Take it. Take the frontline. I'll just go. Leave me alone, you win.");
					}
					else{
						System.out.printf("Ummmm, ouch!%n This guy is way stronger than his groupies back there. I see why they follow him now though, " +
											"that hair is luxurious.%n");
						System.out.println("Fire Lord Ozai! I mean uh, Gannon Cat! We are here to defeat you!");
						System.out.printf("Gannon Cat: BWAHAHAHA, you're the tiniest cat to face me yet! What are you going to do, chase your tail?%n" +
										"Gannon Cat thows you against a wall, and the mouse tumbles out of your pocket...%nGannon Cat's " +
										"eyes widen and he turns into ... a playfull kitten?%n");
						System.out.printf("Well, we can't hurt a kitten. That's just wrong. I mean, he's not really a threat like this anyhow. Grab that box of frontline" +
										"and lets get going. I've got a gig in 10, another hero is about to be born from the Cove. Later, " + LegendOfCat.hero.getName() +
										LegendOfCat.hero.getSuffix() + ". Ya did good kid.%n");
						System.out.printf("Meanwhile.....%nGannon Cat: Bahahaha! That narrator keeps falling for the same trick! And that hero did nothing to me!'Tis but a scratch! " +
										"I'm glad they didn't know the secret hero creation code,%n up up down down left right left right b a start%nIf that cat had been created, " +
										"I'd be in trouble!");
					}
					mainQuest = false;
				}
		}//end switch
		System.out.println("\u001b[0m");
		
		//change location
		//Room holdNewPosition = LegendOfCat.Room(currentPosition, newDirection);
		//"" means no movement
		/*if(!holdNewPosition.equals("")){
			this.newPosition = holdNewPosition;
		}	
		*/
		return newPosition;
	}
	
	//set position method
	public void setNewPosition(){
		this.currentPosition = this.newPosition;
	}

}