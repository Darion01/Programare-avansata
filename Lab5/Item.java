package Lab5;

public abstract class Item {
    private String type;
    private String title;
    private String location;


    public Item(String type, String title, String location) {
        this.type = type;
        this.title = title;
        this.location = location;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Item{" +
                "type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
