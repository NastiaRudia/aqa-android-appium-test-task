package base.data;

public enum OptionsValue {

    GOOGLE_PLAY("Google Play"),

    FUTURE("\uD83D\uDD2E Be prepared for the future");

    private final String value;

    OptionsValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
