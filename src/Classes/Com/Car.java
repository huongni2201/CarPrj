package Classes.Com;

public class Car implements Comparable<Car> {

    private String carID;
    private Brand brand;
    private String colour;
    private String frameID;
    private String engineID;

    public Car() {
    }

    public Car(String carID, Brand brand, String colour, String frameID, String engineID) {
        this.carID = carID;
        this.brand = brand;
        this.colour = colour;
        this.frameID = frameID;
        this.engineID = engineID;
    }

    public String getCarID() {
        return carID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getFrameID() {
        return frameID;
    }

    public void setFrameID(String frameID) {
        this.frameID = frameID;
    }

    public String getEngineID() {
        return engineID;
    }

    public void setEngineID(String engineID) {
        this.engineID = engineID;
    }

    @Override
    public String toString() {
        return carID + ", " + brand.getBrandID() + ", " + colour + ", "
                + frameID + ", " + engineID;
    }

    public String screenString() {
        return brand.toString() + "\n" + this.toString();
    }

    @Override
    public int compareTo(Car o) {
        if (this.brand.getBrandName().
                compareToIgnoreCase(o.getBrand().getBrandName()) == 0) {
            return -this.brand.getBrandID().
                    compareTo(o.getBrand().getBrandID());
        } else {
            return this.brand.getBrandName().
                    compareToIgnoreCase(o.getBrand().getBrandName());
        }
    }

}
