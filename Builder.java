public enum Builder {
    FENDER, MARTIN, GIBSON, OLSON, PRS;
    
    public String toString() {
        switch(this) {
            case FENDER: return "fender";
            case MARTIN: return "martin";
            case GIBSON: return "gibson";
            case OLSON: return "olson";
            case PRS: return "prs";
            default: return "";
        }
    }
}