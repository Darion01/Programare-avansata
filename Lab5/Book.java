package Lab5;

public class Book extends Item {
    private String type;
    private String title;
    private String location;

    public Book(String type, String title, String location, String type1, String title1, String location1) {
        super(type, title, location);
        this.type = type1;
        this.title = title1;
        this.location = location1;
    }


    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Book{" +
                "type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}

