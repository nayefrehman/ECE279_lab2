public class GuitarSpec {
    private Builder builder;
    private String model;
    private Type type;
    private Wood backWood;
    private Wood topWood;
    
    // Constructor
    public GuitarSpec(Builder builder, String model, Type type, Wood backWood, Wood topWood) {
        this.builder = builder;
        this.model = model;
        this.type = type;
        this.backWood = backWood;
        this.topWood = topWood;
    }
    
    // Getter methods
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
    
    // Method to check if this spec matches another spec
    public boolean matches(GuitarSpec otherSpec) {
        // Check builder
        if (builder != null && builder != otherSpec.getBuilder()) {
            return false;
        }
        
        // Check model
        if (model != null && !model.equals("") && !model.equals(otherSpec.getModel())) {
            return false;
        }
        
        // Check type
        if (type != null && type != otherSpec.getType()) {
            return false;
        }
        
        // Check backWood
        if (backWood != null && backWood != otherSpec.getBackWood()) {
            return false;
        }
        
        // Check topWood
        if (topWood != null && topWood != otherSpec.getTopWood()) {
            return false;
        }
        
        // All checks passed!
        return true;
    }
}