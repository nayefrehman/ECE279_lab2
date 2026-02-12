public class Guitar {
    private String serialNumber; 
    private double price;
    private GuitarSpec spec;  // NEW: All specs are now in GuitarSpec object!
    
    // Constructor with GuitarSpec
    public Guitar(String serialNo, double priceSet, GuitarSpec spec) {
        this.spec = spec;
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
    
    // NEW: Return the GuitarSpec object
    public GuitarSpec getSpec() {
        return this.spec;
    }
    
    
    /******************** ARCHIVED CODE FROM LAB 2 & STEP 1-3 ********************
     * 
     * OLD VERSION WITH ENUMS (Step 1-3):
     * 
    private Builder builder;
    private String model; 
    private Type type;
    private Wood backWood;
    private Wood topWood;
    
    public Guitar(Builder builder, String model, Type type, Wood topWood, Wood backWood) {
        this.serialNumber = "";
        this.price = 0.0;
        this.builder = builder;
        this.model = model;
        this.type = type;
        this.topWood = topWood;
        this.backWood = backWood;
    }
    
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
    
    public Builder getBuilder() {
        return this.builder;
    }
    
    public String getModel() {
        return this.model;
    }
    
    public Type getType() {
        return this.type;
    }
    
    public Wood getBackWood() {
        return this.backWood;
    }
    
    public Wood getTopWood() {
        return this.topWood;
    }
    
    ******************** END OF ARCHIVED CODE ********************/
}