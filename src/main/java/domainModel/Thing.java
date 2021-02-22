package domainModel;

public class Thing {
    private String name;
    private String owner;

    public Thing(String name, String owner) {
        this.name = name;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }
}
