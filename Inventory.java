import java.util.LinkedList;
import java.util.Iterator;

public class Inventory {
	private LinkedList<Guitar> guitarList;  // CHANGED: Array → LinkedList
	
	public Inventory() {
		guitarList = new LinkedList<Guitar>();  // Initialize LinkedList
	}
	
	// UPDATED: Parameters are now enums
	public void addGuitar(String serialNo, double priceSet, Builder builder, String model, 
	                      Type type, Wood topWood, Wood backWood) {
		Guitar guitarObj = new Guitar(serialNo, priceSet, builder, model, type, topWood, backWood);
		guitarList.add(guitarObj);  // CHANGED: Simply add to LinkedList (no need to find space!)
	}
	
	// Get guitar by serial number
	public Guitar getGuitar(String serialNumber) {
		for (Guitar guitar : guitarList) {
			if (guitar.getSerialNumber().equals(serialNumber)) {
				return guitar;
			}
		}
		return null;  // Not found
	}
	
	public void printInventory() {
		System.out.println("Inventory : ");
		for (Guitar g : guitarList) {  // CHANGED: Use for-each loop with LinkedList
			System.out.println(g.getSerialNumber() + " " + g.getPrice() + " " + 
			                   g.getBuilder() + " " + g.getModel() + " " + 
			                   g.getType() + " " + g.getBackWood() + " " + g.getTopWood());
		}
		System.out.println(": End");
	}
	
	// NEW: Search method that returns MULTIPLE matching guitars
	public LinkedList<Guitar> search(Guitar searchObj) {
		LinkedList<Guitar> matchingGuitars = new LinkedList<Guitar>();
		Iterator<Guitar> it = guitarList.iterator();
		
		while (it.hasNext()) {
			Guitar item = it.next();
			
			// Check builder (if searchObj specifies one)
			if (searchObj.getBuilder() != null && searchObj.getBuilder() != item.getBuilder()) {
				continue;  // Skip this guitar - builder doesn't match
			}
			
			// Check type (if searchObj specifies one)
			if (searchObj.getType() != null && searchObj.getType() != item.getType()) {
				continue;  // Skip this guitar - type doesn't match
			}
			
			// Check model (if searchObj specifies one)
			if (searchObj.getModel() != null && !searchObj.getModel().equals(item.getModel())) {
				continue;  // Skip this guitar - model doesn't match
			}
			
			// Check backWood (if searchObj specifies one)
			if (searchObj.getBackWood() != null && searchObj.getBackWood() != item.getBackWood()) {
				continue;  // Skip this guitar - backWood doesn't match
			}
			
			// Check topWood (if searchObj specifies one)
			if (searchObj.getTopWood() != null && searchObj.getTopWood() != item.getTopWood()) {
				continue;  // Skip this guitar - topWood doesn't match
			}
			
			// If we made it here, the guitar matches all specified criteria!
			matchingGuitars.add(item);
		}
		
		return matchingGuitars;
	}
	
	// Helper method to print search results
	public void printSearchResults(LinkedList<Guitar> results) {
		if (results.isEmpty()) {
			System.out.println("Sorry! We don't have anything for you.");
		} else {
			System.out.println("Here's what we found:");
			for (Guitar g : results) {
				System.out.println("  - " + g.getSerialNumber() + " " + g.getPrice() + " " + 
				                   g.getBuilder() + " " + g.getModel() + " " + 
				                   g.getType() + " " + g.getBackWood() + " " + g.getTopWood());
			}
		}
	}
	
	public static void main(String[] args) {
		Inventory invObj = new Inventory();
		
		// Add guitars using ENUMS
		invObj.addGuitar("X7X 0Y8", 208.99, Builder.FENDER, "AXp", 
		                 Type.ELECTRIC, Wood.ALDER, Wood.ALDER);
		invObj.addGuitar("X1X 0Y0", 679.99, Builder.FENDER, "AP88", 
		                 Type.ELECTRIC, Wood.MAHOGONY, Wood.CANADIAN_MAPLE);
		invObj.addGuitar("X1X 0Y0", 788.99, Builder.FENDER, "AV123", 
		                 Type.ELECTRIC, Wood.MAHOGONY, Wood.BRAZILIAN_ROSEWOOD);
		invObj.addGuitar("X2P 0Z2", 3088.5, Builder.MARTIN, "D-28", 
		                 Type.ACOUSTIC, Wood.BRAZILIAN_ROSEWOOD, Wood.SITKA);
		invObj.addGuitar("K7C 0Y8", 1007.90, Builder.GIBSON, "Les Paul Standard", 
		                 Type.ELECTRIC, Wood.MAHOGONY, Wood.CANADIAN_MAPLE);
		
		invObj.printInventory();
		
		// Alex wants: Fender, Electric, Mahogany topwood (doesn't care about model or backwood)
		Guitar whatAlexLikes = new Guitar(Builder.FENDER, null, Type.ELECTRIC, Wood.MAHOGONY, null);
		invObj.printSearchResults(invObj.search(whatAlexLikes));
	}
}