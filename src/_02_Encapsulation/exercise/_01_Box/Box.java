package _02_Encapsulation.exercise._01_Box;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setHeight(height);
        setWidth(width);
    }

    public double getLength() {
        return length;
    }

    private void setLength(double length) {
        if (length <= 0){
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        } else {
            this.length = length;
        }
    }

    public double getWidth() {
        return width;
    }

    private void setWidth(double width) {
        if (width <= 0){
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        } else {
            this.width = width;
        }
    }

    public double getHeight() {
        return height;
    }

    private void setHeight(double height) {
        if (height <= 0){
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        } else {
            this.height = height;
        }
    }

    public double calculateSurfaceArea(){
        return (2*getLength()*getWidth()) + (2*getLength()*getHeight())
                + (2*getWidth()*getHeight());
    }
    public double calculateLateralSurfaceArea(){
        return (2*getLength()*getHeight()) + (2*getWidth()*getHeight());
    }
    public double calculateVolume(){
        return getLength()*getHeight()*getWidth();
    }
}
