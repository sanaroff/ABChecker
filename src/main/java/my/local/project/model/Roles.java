package my.local.project.model;

public enum Roles {
    CLIENT("Client"),
    ADMINISTRATOR("Administrator"),
    INSTRUCTOR("Instructor"),
    GUEST("Guest");

    private final String label;

    private Roles(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
