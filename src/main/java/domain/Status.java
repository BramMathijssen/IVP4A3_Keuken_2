package main.java.domain;
/**
 *
 * @author Bram
 */
    public enum Status {
    PLACED("Geplaatst"),
    ACCEPTED("Geaccepteerd"),
    READY("Klaar voor bezorgen"),
    DELIVERED("Bezorgd");
    
    private String state;
    
    Status(String state) {
        this.state = state;
    }
}
