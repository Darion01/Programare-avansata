import java.util.Arrays;
import java.util.List;

public class City {
    List<Street> streetList;
    Intersection intersection[];

    public List<Street> getStreetList() {
        return streetList;
    }

    public void setStreetList(List<Street> streetList) {
        this.streetList = streetList;
    }

    public Intersection[] getIntersection() {
        return intersection;
    }

    public void setIntersection(Intersection[] intersection) {
        this.intersection = intersection;
    }

    @Override
    public String toString() {
        return "City{" +
                "streetList=" + streetList +
                ", intersection=" + Arrays.toString(intersection) +
                '}';
    }
}
