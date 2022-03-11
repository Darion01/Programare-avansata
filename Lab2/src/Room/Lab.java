package Room;

import java.util.List;

public class Lab extends Room{

    protected String operatingSys;


    public Lab(int size, String name, String operatingSys) {
        super(size, name);
        this.operatingSys = operatingSys;
    }

    public String getOperatingSystem() {
        return operatingSys;
    }

    public void setOperatingSystem(String operatingSys) {
        this.operatingSys = operatingSys;
    }

    @Override
    public String toString() {
        return "Laborator cu " + operatingSys + ": " + super.toString();
    }
}
