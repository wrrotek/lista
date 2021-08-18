package pl.javastart.lista;

public enum Category {

    HOUSEWORK("Prace domowe"), WORK("Praca"), SCHOOL("Szkoła");

    private String displayName;

    Category(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}

