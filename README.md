# Legend of Cat
***
## Task
Make a text-based adventure game using concepts of object-oriented programming taught in this course (introduction to programming with Java).
***
## Criteria
* Game must be Java based
* Create "Room" objects that the player can navigate
* Include some form of comabt
* Fabricate a story or theme
***
## Summary
This was the final project of my first computer science class. While there may be more optimal ways to code this, I wanted to leave it in it's original form to show my development process. Check out the next iteration, TragedyOFGannon, for some code overhaul and a sequal story.
***
## Functionality
To keep the interface simple the user selects numbers correlating to their desired action, "i" for inventory, and "q" to quit. There is a cheat guide in otherdocs that provides the fastest possible way to complete the game.
***
## Design
Please see attached UML diagrams for a detiled breakdown of the classes.
	
We start in LegendOfCat class. This class contains the introductory dialogue, hero selection, and the main quest loop. There are various boolean values assigned to validate input and run loops. This class has a hero, and has an area. The constructor creates both objects for the game. I found that I needed to access those objects from other classes later, so they were assigned as protected static.
	
Next, we will look at the Hero class. The hero is determined based on the input of the user. There is an overloaded constructor for a "special code" that is gained upon game completion. The Hero has getters, attack, and take damge methods. It also has an inventory.

The Inventory class contains arrays for item names and whether the player has them (boolean). There are setter methods to determine these values. The player can view 4
the inventory at any time by pressing [i].

The Weapon class originally extended inventory, but they had so little in common it seemed like a pointless work-around. The constuctor sets the values of the weapon
variables based on the choice, and there are getters for these values to be used in combat.
	
The Areas class contained "first level" actions previously (the first interaction a player has in that location), but it has been reduced to strictly array maps. This
class is responsible for moving the player throughout the city, which has adjacent areas that can be easily calculated. Moving a player to a non adjacent area (an area 
outside of the capital, for instance) uses the pullPosition method, which will teleport the player directly to the next area.
	
The Actions class is by far the largest class of the game. It contains the dilogue tree switch statements, as well as the resulting action switch statement. So the first
switch will present a player with their options and prompt a selection. The second part will produce the result of the selected statement. This will either present the 
player with a message from the NPCs/narrator or give the map class values to move the player. These cases are called through the LegendOfCat class loop, and will continue
until the player chooses to quit [q] or finishes the game.
	
Finally, we have the Enemy class. Originally the Hero and Enemy classes both extended a Character class, and had overridden methods and variables to distinguish the two. 
This was removed due to the two acting so differently in the game. The hero was more of a developed "character", but the enemies were more simple items that had little
feedback or impact on the story. The enemy has attributes depending on their location, and methods that are geared toward giving and taking damage.
***
## Run Locally
* On a machine with JDK, open the terminal in the file location with LegendOfCat.java
* javac LegendOfCat.java
* java LegendOfCat
