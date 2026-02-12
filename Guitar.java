
public class Guitar {
	private String serialNumber; 
	private double price;
	private String builder; 
	private String model; 
	private String type;
	private String backWood;
	private String topWood;
	
	public Guitar(String builder, String model, 
			String type, String topWood, String backWood){
		this.serialNumber="";
		this.price=0.0;
		
		this.builder = builder;
		this.model = model;
		this.type = type;
		this.topWood = topWood;
		this.backWood = backWood;
	}
	
	public Guitar(String serialNo, double priceSet, String builder, String model, 
							String type, String topWood, String backWood) {
		this.builder = builder;
		this.model = model;
		this.type = type;
		this.topWood = topWood;
		this.backWood = backWood;
		
		setSerialNumber(serialNo);
		setPrice(priceSet);
	}
	
	private void setSerialNumber(String serialNo) {
		if (serialNo != null && !serialNo.isEmpty()){
			this.serialNumber = serialNo;
		}
	}
	private void setPrice(double priceSet){
		// check if price is negative before inserting, ensure the priceSet is positive before inserting 
		if(priceSet >= 0){
			this.price = priceSet;
		} 
	}
	
	public String getSerialNumber() {
		return this.serialNumber;

	}
	public double getPrice() {
		return price;
	}

	public String getBuilder() {
		return this.builder;

	}
	
	public String getModel() {
		return this.model;

	}

	public String getType() {
		return this.type;

	}
	public String getBackWood() {
		return this.backWood;

	}

	public String getTopWood() {
		return this.topWood;

	}
	
}

