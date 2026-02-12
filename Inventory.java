
public class Inventory {
	private Guitar guitarArray[];
	public Inventory() {
		guitarArray = new Guitar[10];
	}
	
	public void addGuitar(String serialNo, double priceSet, String builder, String model, 
			String type, String topWood, String backWood) {
		Guitar guitarObj = new Guitar(serialNo, priceSet, builder, model, type, topWood, backWood);

		
		int findSpace = insertGuitar();
		if(findSpace >=0 && findSpace<guitarArray.length) {
			// if the space is greater than 0, meaning there is space and its < the length of the 
			/*
			 * If insertGuitar() returns a valid index, then
			 * you will insert the guitarObj in the guitarArray
			 * */
			guitarArray[findSpace] = guitarObj;
		} else {
			System.out.println("Inventory is full, cannot add more guitat.");
		}
	}
	
	public int insertGuitar() {
		
		/*
		 * This method returns the index of the smallest index of array which is empty 
		 * You have to insert new guitar objects into the Array.
		 * But to insert into the Array, you have to first find out an empty
		 * space, also need to check that Array has not been full.
		*/

		// to determine the empty index otherwise return if its full 
		int findEmptySpace = 0;
		for(int i = 0; i < guitarArray.length; i++){
			if(guitarArray[i] == null){
				findEmptySpace = i;
			}
		}

		return findEmptySpace;
	}
	
	public void printInventory(){
		System.out.println("Inventory : ");
		/*
		 * Print the whole inventory
		 * */
		for(int i = 0; i < guitarArray.length; i++){
			if(guitarArray[i] != null){
				Guitar g = guitarArray[i];
				System.out.println(g.getSerialNumber() + " " + g.getPrice() + " " + g.getBuilder() + " " + g.getModel() + " " + g.getType() + " "+ g.getBackWood() + " "+ g.getTopWood());
			} 
		}
		System.out.println(": End");
	}
	
	public Guitar searchForGuitar(Guitar key) {
		Guitar foundItem = null; // initialize found to null
		/*
		 * Search method to find guitar through all the guitar properties.
		 * */
		// loop through the guitarArray and set current guitar to the matched one 
		for(int i = 0; i < guitarArray.length; i++){
			if(guitarArray[i] != null){
				Guitar current = guitarArray[i]; // set current guitar object to the current guitarArray index 

				boolean foundBuilder = current.getBuilder().equalsIgnoreCase(key.getBuilder());
				boolean foundModel = current.getModel().equalsIgnoreCase(key.getModel());
				boolean foundType = current.getType().equalsIgnoreCase(key.getType());
				boolean foundBackWood = current.getBackWood().equalsIgnoreCase(key.getBackWood());
				boolean foundTopWood = current.getTopWood().equalsIgnoreCase(key.getTopWood());

				// have initialized all booleans to see if it matches the found condition or not 
				// use if condition to check if all types have met 
				if(foundBuilder && foundModel && foundType && foundBackWood && foundTopWood){
					foundItem = current;
				}
			}
		}


		return foundItem;
	}
	
	public void findGuitar(Guitar clientWants) {
		//Here we are searching for a guitar.
		Guitar item = searchForGuitar(clientWants);
		
		//We print what our search method returns
		if( item == null) {
			System.out.println("Sorry We dont have anything for you");
		}else {
			System.out.print("Here's what we got: ");
			System.out.println(item.getSerialNumber() + " " + item.getPrice() + " "+ item.getModel() + " "+
					item.getBuilder()+" "+ item.getType()+ " " + item.getTopWood()+ " " + item.getBackWood());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Inventory invRef = new Inventory();
		System.out.println("Inventory Size: " + invRef.guitarArray.length); //Print Array Size
		
		invRef.addGuitar("X7X 0Y8", 208.99, "FENDER", "AXp", "ELECTRIC", "ALDER", "ALDER");
		invRef.printInventory();
		invRef.addGuitar("PCQ 288", 208.99, "FENDER", "AP88", "ELECTRIC", "MAHOGONY", "CANADIAN_MAPLE");
		invRef.addGuitar("X78 9V5", 208.99, "GIBSON", "Les Paul Standard", "ELECTRIC", "MAHOGONY", "CANADIAN_MAPLE");
		invRef.printInventory();
		invRef.addGuitar("X2P 0Z2", 3088.5, "MARTIN", "D-28", "ACOUSTIC", "BRAZILIAN_ROSEWOOD", "SITKA");
		
		//Create a search by Client Specification
		Guitar whatClientLikes = new Guitar("GIBSON", "Les Paul Standard", "ELECTRIC", "MAHOGONY", "CANADIAN_MAPLE");
		invRef.findGuitar(whatClientLikes);
	}

}
