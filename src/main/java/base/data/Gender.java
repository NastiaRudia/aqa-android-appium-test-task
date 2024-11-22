package base.data;

public enum Gender {

    MALE("Male"),
    FEMALE("Female"),
    NON_BINARY("Non-binary");

    private final String value;

    Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
