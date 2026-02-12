import java.util.LinkedList;

public class Inventory {
    private LinkedList<Guitar> guitarList;
    
    public Inventory() {
        guitarList = new LinkedList<Guitar>();
    }
    
    // UPDATED: Now takes GuitarSpec instead of individual parameters
    public void addGuitar(String serialNo, double priceSet, GuitarSpec spec) {
        Guitar guitarObj = new Guitar(serialNo, priceSet, spec);
        guitarList.add(guitarObj);
    }
    
    // Get guitar by serial number
    public Guitar getGuitar(String serialNumber) {
        for (Guitar guitar : guitarList) {
            if (guitar.getSerialNumber().equals(serialNumber)) {
                return guitar;
            }
        }
        return null;
    }
    
    public void printInventory() {
        System.out.println("Inventory : ");
        for (Guitar g : guitarList) {
            GuitarSpec spec = g.getSpec();
            System.out.println(g.getSerialNumber() + " " + g.getPrice() + " " + 
                               spec.getBuilder() + " " + spec.getModel() + " " + 
                               spec.getType() + " " + spec.getBackWood() + " " + spec.getTopWood());
        }
        System.out.println(": End");
    }
    
    // NEW: Search takes GuitarSpec and returns matching guitars
    public LinkedList<Guitar> search(GuitarSpec searchSpec) {
        LinkedList<Guitar> matchingGuitars = new LinkedList<Guitar>();
        
        for (Guitar guitar : guitarList) {
            GuitarSpec guitarSpec = guitar.getSpec();  // Get the guitar's spec
            
            if (searchSpec.matches(guitarSpec)) {  // Use the matches() method!
                matchingGuitars.add(guitar);
            }
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
                GuitarSpec spec = g.getSpec();
                System.out.println("  - " + g.getSerialNumber() + " $" + g.getPrice() + " " + 
                                   spec.getBuilder() + " " + spec.getModel() + " " + 
                                   spec.getType() + " " + spec.getBackWood() + " " + spec.getTopWood());
            }
        }
    }
    
    public static void main(String[] args) {
        Inventory invObj = new Inventory();
        
        // Add guitars using GuitarSpec
        invObj.addGuitar("X7X 0Y8", 208.99, 
            new GuitarSpec(Builder.FENDER, "AXp", Type.ELECTRIC, Wood.ALDER, Wood.ALDER));
        
        invObj.addGuitar("X1X 0Y0", 679.99, 
            new GuitarSpec(Builder.FENDER, "AP88", Type.ELECTRIC, Wood.MAHOGONY, Wood.CANADIAN_MAPLE));
        
        invObj.addGuitar("X1X 0Y0", 788.99, 
            new GuitarSpec(Builder.FENDER, "AV123", Type.ELECTRIC, Wood.MAHOGONY, Wood.BRAZILIAN_ROSEWOOD));
        
        invObj.addGuitar("X2P 0Z2", 3088.5, 
            new GuitarSpec(Builder.MARTIN, "D-28", Type.ACOUSTIC, Wood.BRAZILIAN_ROSEWOOD, Wood.SITKA));
        
        invObj.addGuitar("K7C 0Y8", 1007.90, 
            new GuitarSpec(Builder.GIBSON, "Les Paul Standard", Type.ELECTRIC, Wood.MAHOGONY, Wood.CANADIAN_MAPLE));
        
        invObj.printInventory();
        
        // Alex wants: Fender, Electric, Mahogany topwood
        GuitarSpec whatAlexLikes = new GuitarSpec(Builder.FENDER, null, Type.ELECTRIC, null, Wood.MAHOGONY);
        invObj.printSearchResults(invObj.search(whatAlexLikes));
    }
    
    
    /*ARCHIVED CODE FROM STEPS 1-3
     
        * OLD addGuitar method:
      
    public void addGuitar(String serialNo, double priceSet, Builder builder, String model, 
                          Type type, Wood topWood, Wood backWood) {
        Guitar guitarObj = new Guitar(serialNo, priceSet, builder, model, type, topWood, backWood);
        guitarList.add(guitarObj);
    }
    
     * OLD search method that took Guitar object:
     * 
    public LinkedList<Guitar> search(Guitar searchObj) {
        LinkedList<Guitar> matchingGuitars = new LinkedList<Guitar>();
        Iterator<Guitar> it = guitarList.iterator();
        
        while (it.hasNext()) {
            Guitar item = it.next();
            
            if (searchObj.getBuilder() != null && searchObj.getBuilder() != item.getBuilder()) {
                continue;
            }
            
            if (searchObj.getType() != null && searchObj.getType() != item.getType()) {
                continue;
            }
            
            if (searchObj.getModel() != null && !searchObj.getModel().equals(item.getModel())) {
                continue;
            }
            
            if (searchObj.getBackWood() != null && searchObj.getBackWood() != item.getBackWood()) {
                continue;
            }
            
            if (searchObj.getTopWood() != null && searchObj.getTopWood() != item.getTopWood()) {
                continue;
            }
            
            matchingGuitars.add(item);
        }
        
        return matchingGuitars;
    }
    
     END OF ARCHIVED CODE *******/
}