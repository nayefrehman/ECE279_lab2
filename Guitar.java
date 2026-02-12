public class Guitar {
	private String serialNumber; 
	private double price;
	private Builder builder;  // CHANGED: String → Builder enum
	private String model; 
	private Type type;        // CHANGED: String → Type enum
	private Wood backWood;    // CHANGED: String → Wood enum
	private Wood topWood;     // CHANGED: String → Wood enum
	
	// Constructor 1: For searching (no serial number or price)
	public Guitar(Builder builder, String model, Type type, Wood topWood, Wood backWood) {
		this.serialNumber = "";
		this.price = 0.0;
		
		this.builder = builder;
		this.model = model;
		this.type = type;
		this.topWood = topWood;
		this.backWood = backWood;
	}
	
	// Constructor 2: For adding guitars to inventory (with serial and price)
	public Guitar(String serialNo, double priceSet, Builder builder, String model, 
	              Type type, Wood topWood, Wood backWood) {
		this.builder = builder;
		this.model = model;
		this.type = type;
		this.topWood = topWood;
		this.backWood = backWood;
		
		setSerialNumber(serialNo);
		setPrice(priceSet);
	}
	
	private void setSerialNumber(String serialNo) {
		if (serialNo != null && !serialNo.isEmpty()) {
			this.serialNumber = serialNo;
		}
	}
	
	private void setPrice(double priceSet) {
		if (priceSet >= 0) {
			this.price = priceSet;
		} 
	}
	
	public String getSerialNumber() {
		return this.serialNumber;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	// CHANGED: Return Builder enum instead of String
	public Builder getBuilder() {
		return this.builder;
	}
	
	public String getModel() {
		return this.model;
	}
	
	// CHANGED: Return Type enum instead of String
	public Type getType() {
		return this.type;
	}
	
	// CHANGED: Return Wood enum instead of String
	public Wood getBackWood() {
		return this.backWood;
	}
	
	// CHANGED: Return Wood enum instead of String
	public Wood getTopWood() {
		return this.topWood;
	}
}