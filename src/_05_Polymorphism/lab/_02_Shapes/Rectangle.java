package _05_Polymorphism.lab._02_Shapes;

public class Rectangle extends Shape{
    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        setHeight(height);
        setWidth(width);
    }

    public Double getHeight() {
        return height;
    }

    private void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    private void setWidth(Double width) {
        this.width = width;
    }

    @Override
    public Double calculatePerimeter() {
        super.setPerimeter(2 * width + 2 * height);
        return super.getPerimeter();
    }

    @Override
    public Double calculateArea() {
        super.setArea(width * height);
        return super.getArea();
    }
}
