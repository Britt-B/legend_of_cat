import java.util.Scanner;

public class LegendOfCat{
	//protected static Areas myArea;
	static Hero hero;
	//rooms
	static Room kittenCove = new Room("Kitten Cove", -1);
	static Room catNipFields = new Room("Cat Nip Fields", 12);
	static Room calicoIsland = new Room("Calico Island", -3);
	static Room huntingGrounds = new Room("Hunting Grounds", -2);
	static Room cityGates = new Room("City Gates", 0);
	static Room royalArmory = new Room("Royal Cat Armory", 1);
	static Room felineFelonsJailhouse = new Room("Feline Felons Jailhouse", 11);
	static Room generalStore = new Room("General Store", 2);
	static Room mayorMittens = new Room("Mayor Mittens's House", 3);
	static Room princessZooldar = new Room("Princess Zooldar's Castle", 10);
	static Room furstoneLibrary = new Room("Furstone Library", 8);
	static Room pawprintMuseum = new Room("Pawprint Museum", 7);
	static Room tomCatBar = new Room("Tom Cat Bar", 6);
	static Room backtailAlley = new Room("Backtail Alley", 5);
	static Room stables = new Room("stables", 4);
	static Room cityCenter = new Room("city center", 9);
	static Room longFleaForest = new Room("Long Flea Forest", -4);
	static Room dungeon1 = new Room("Dungeon Entrance", 13);
	static Room dungeon2 = new Room("Pit of Doom", 14);
	static Room dungeon3 = new Room("Room of Firey Death", 15);
	static Room dungeon4 = new Room("Gannon Cat's Lair of Demise", 16);

	private static boolean mainQuest = true;
	
	
	public static void main(String [] args){
		//set exits to rooms
		catNipFields.setExits(null, cityGates, null, null);
		cityGates.setExits(stables, null, catNipFields, royalArmory);
		royalArmory.setExits(cityGates, generalStore, null, null);
		generalStore.setExits(null, mayorMittens, royalArmory, null);
		mayorMittens.setExits(furstoneLibrary, null, generalStore, null);
		furstoneLibrary.setExits(null, null, pawprintMuseum, mayorMittens);
		pawprintMuseum.setExits(null, furstoneLibrary, tomCatBar, null);
		tomCatBar.setExits(null, pawprintMuseum, backtailAlley, null);
		backtailAlley.setExits(null, tomCatBar, stables, null);
		stables.setExits(null, backtailAlley, null, cityGates);
		
		//player selection variable
		int choice = 100;
		//ensure valid choice is selected
		boolean validChoice = false;
		//create scanner
		Scanner input = new Scanner(System.in);
		

			//introduction
			System.out.printf("Long ago, there existed a kingdom where a medical formula lay hidden. " +
					" One day, a cat of great evil found this formula and took it for himself, and " +
					"with it at his command, he spread fleas across the kingdom. But then...just as " +
					"all hope had died, a young kitten clothed in green appeared as if from nowhere. " +
					"Wielding a blade that repelled evil, he sealed the dark one away and gave the " +
					"land FRONTLINE® Plus for Cats Flea Treatment. This cat, who traveled through time " +
					"to save the land, was known as the Hero of Cat. The cat's tail was passed down " +
					"through generations until it became legend... the Legend of Cat.%n%n" +
					
					"And then a day came when a fell wind began to blow across the kingdom, and the " +
					"great evil once again crept forth from the depths of the earth. The cat-folk " +
					"believed that the Hero of Cat would again come to save them. But the hero did not appear....%n%n" +

					"What became of that kingdom...? None remain who know. The memory of the kingdom " +
					"vanished, but its legend survived on the wind's breath.%n%n" +

					"On a certain cove, it became customary to garb young cats in green when they " +
					"come of age. Clothed in the green of fields, they aspire to find heroic blades " +
					"and cast evil down. The elders wish only for the kittens to know courage like the hero of legend.%n%n");
			System.out.printf("You, a freshly trained cat from Kitten Cove, must embark on an adventure to vanquish " +
					"this great evil of fleas. Prepare yourself young one.%n%n");

			//role selection
			System.out.println("My hero is: ");
			System.out.println("[1]Fluffy, the Furious - armor +50 			(paladin)");
			System.out.println("[2]Snowball, the Slayer - health +50 			(rougue)");
			System.out.println("[3]Waffles, the Warlord - strength +50			(warrior)");
			
			
			while(validChoice != true){
				String roleSelect = input.nextLine();

				//create hero
				if(roleSelect.equals("up up down down left right left right b a start")){
					hero = new Hero("Kratos", ", God of Cat", 9001, 9001, 9001);
					validChoice = true;
				}
				else{
					//determine character to create hero object
					if (roleSelect.equals("1")){
						hero = new Hero("Fluffy", ", the Furious", 100, 50, 100);
						validChoice = true;
					}
					else if (roleSelect.equals("2")){
						hero = new Hero("Snowball", ", the Slayer", 150, 50, 50);
						validChoice = true;
					}
					else if (roleSelect.equals("3")){
						hero = new Hero("Waffles", ", the Warlord", 100, 100, 50);
						validChoice = true;
					}
					else{
						System.out.println("Not a valid input. 1-4 only! Unless you've got a secret code, (or looked at  code, cheater). Try again.");
						
					}
				}
			}//end validation 
			//rest validation
			validChoice = false;
			//continue story
			System.out.println("Mama Cat: " + (hero.getName()) + "! Wake up! Are you ready for your perilous adventure you may never return from? " +
								" I'm so excited for you! I made you some extra snacks to take. Here is 20 cash moneys for your quest. " +
								"Well, don't stand around much longer! Get going dear, Grandpa is waiting outside.");
			//prompt action
			while(validChoice == false){
				System.out.printf("[1]Go back to bed%n[2]Go outside%n");
				
				choice = input.nextInt();
					if(choice == 1){
						System.out.println("Mama Cat: Are you sleeping in?! Get your lazy tail up and save the world!!");
						validChoice = true;
					}
					else if(choice == 2){
						validChoice = true;
					}
					else{
						System.out.println("Select a valid option");
					}
					System.out.println("You step outside to feel a cool breeze on your whiskers, and taste salt in the air. Near the shore, " +
											"an ancient grey feline sits still. You call to him, but he doesn't hear you.");
			}//end validation
			//reset validation
			validChoice = false;
			while(validChoice == false){
				System.out.printf("[1]Gramps...Hello! Gramps!...GRANDFATHER!!!%n[2]Grandpa...are you dead?%n[3]tap him on the shoulder%n");
				
				choice = input.nextInt();
					if(choice == 1){
						System.out.println("Grandpa: Why are you yelling?!?!  Oh, isn't it that big day of yours?" +
											"you've finally finished your training, huh?");
						validChoice = true;
					}
					else if(choice == 2){
						System.out.println("Of course I'm not dead you disrespectful little... What's that? Oh yeah, hero of the land and all that. ");
						validChoice = true;
					}
					else if(choice == 3){
						System.out.println("Gah!! Why would you scare a poor old cat like that? At least I know your training has paid off.");
						validChoice = true;
					}
					else{
						System.out.println("Select a valid option");
					}
				//gramps talks about your quest etc
				System.out.printf("It's time for you to embark on your death... err, quest! You've mastered, well, sort of mastered, the way of the Great Cat." +
									" You will have to find your way around these lands, and gain strength as you make your way to <Cat Scratch Dungeon>, " +
									"where you will (try to) defeat *Gannon Cat*. %nBut young " + hero.getName() + ", remember that the people need your help. " +
									"Don't fight for glory, fight for the good of the Kingdom. You may find that helping others will also aid your own quest.%n");
				System.out.println("Here is a ^Sword^ and some armor, to keep you alive a bit longer, if that's possible.");
				System.out.printf("Now hurry along! Save the kingdom before this old cat is dead.%n%n");
				
			}//end validation
			//reset validation
			validChoice = false;
			
			//talk to guards, enter city
			System.out.println("...and so you're off. You travel far and long, for 25 whole minutes, and finally reach the capital.");
			System.out.printf("You walk up to the gates, where 2 guards are standing. The first guard turns to you.%n%nGuard 1: Oi! Who goes there? Is tha'... " +
							"a ki'in?? Wha'??? We can' 'ave ki'ins runnin aroun' 'ere! Don' ya know there's evil in the Kingdom??%nWha'? Ya say yer a " +
							"Hero? Bah! Go away or I shall taunt you a second time!%n	I can' believe ya! Stay 'ere, I'm goin ta tell the Capn' abou' ya!%n" +
							"%nGuard 2: Hi friend, don't mind him. He's just a bit jumpy sometimes. You can cross into the city if you'd like.%nBe sure to " +
							"check out the city enter, it's the quickest way between, well, everywhere!%n");
			
			System.out.println("You enter the gates, and your kitty whiskers are blown away. The town is bustling with cats. Your nose is bombarded by the " +
								"smell of fresh fish Tacos, and lively kittens play in the gardens.");
								
			//loop main quest area (no more introduction play, allow movement in city etc)
			NewActions performActions = new NewActions();
			//myArea = new Areas();
			
			while(mainQuest){
				System.out.println("---------------------------------------------------");
				System.out.printf("Press [i] to view inventory%nPress [q] to quit%n");
				//provide feedback for current area
				mainQuest = performActions.getExitsActions();
			}

	}//end main method
	
}