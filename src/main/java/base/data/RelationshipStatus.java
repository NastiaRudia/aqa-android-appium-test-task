package base.data;

public enum RelationshipStatus {

    SINGLE("Single"),
    IN_RELATIONSHIP("In relationship"),
    COHABITANTS("Cohabitants"),
    ENGAGED("Engaged"),
    MARRIED("Married"),
    SEPARATED("Separated"),
    DIVORCED("Divorced"),
    WIDOWED("Widowed"),
    COMPLICATED("Complicated");

    private final String value;

    RelationshipStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
