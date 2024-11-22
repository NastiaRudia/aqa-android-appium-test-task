package base.data;

public enum Interests {

    MONEY("money"),
    BUSINESS("business"),
    FRIENDS("friends"),
    LOVE("love"),
    FAMILY("family"),
    CAREER("career");

    private final String value;

    Interests(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
