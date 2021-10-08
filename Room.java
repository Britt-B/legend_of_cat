public class Room{
	//name of area
	String name;
	//exits
	Room northExit;
	Room eastExit;
	Room westExit;
	Room southExit;
	
	//room id
	int roomID;
	
	//new room for movement
	Room newRoom;
	
	public Room(String name, int id){
		this.name = name;
		this.roomID = id;
	
	}
	
	//set exits
	public void setExits(Room n, Room e, Room w, Room s){
		this.northExit = n;
		this.eastExit = e;
		this.westExit = w;
		this.southExit = s;
	}
	
	//movement
	public Room moveNorth(){
		return this.northExit;
	}
	
	public Room moveEast(){
		return this.eastExit;
	}
	
	public Room moveWest(){
		return this.westExit;
	}
	
	public Room moveSouth(){
		return this.southExit;
	}
	
	//returns new area
	public Room getNewPosition(String exitLocation){
		
		if(exitLocation.equals("n")){
			this.newRoom = this.northExit;
		}
		else if(exitLocation.equals("e")){
			this.newRoom = this.eastExit;
		}
		else if(exitLocation.equals("w")){
			this.newRoom = this.westExit;
		}
		else if(exitLocation.equals("s")){
			this.newRoom = this.southExit;
		}
		//city center exits
		if(exitLocation.equals("0")){
			this.newRoom = LegendOfCat.cityGates;
		}
		if(exitLocation.equals("1")){
			this.newRoom = LegendOfCat.royalArmory;
		}
		if(exitLocation.equals("2")){
			this.newRoom = LegendOfCat.generalStore;
		}
		if(exitLocation.equals("3")){
			this.newRoom = LegendOfCat.mayorMittens;
		}
		if(exitLocation.equals("8")){
			this.newRoom = LegendOfCat.furstoneLibrary;
		}
		if(exitLocation.equals("7")){
			this.newRoom = LegendOfCat.pawprintMuseum;
		}
		if(exitLocation.equals("6")){
			this.newRoom = LegendOfCat.tomCatBar;
		}
		if(exitLocation.equals("5")){
			this.newRoom = LegendOfCat.backtailAlley;
		}
		if(exitLocation.equals("4")){
			this.newRoom = LegendOfCat.stables;
		}
		
		return this.newRoom;
	}
	
	public String getName(){
		return this.name;
	}
	public int getRoomID(){
		return this.roomID;
	}
}