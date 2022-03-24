public class Intersection {
   private String name;
   private int nrStreets;

    public Intersection(String name) {
        this.name = name;
    }

    public void setNrStreets(int nrStreets){ this.nrStreets = nrStreets; }

    public int getNrStreets(){ return nrStreets; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Intersection name = " + name ;
    }
}
