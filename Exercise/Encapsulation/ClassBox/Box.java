package Exercise.Encapsulation.ClassBox;

import java.security.InvalidParameterException;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setHeight(height);
        setLength(length);
        setWidth(width);
    }

    private void setHeight(double height) {
        validateSide(height, "Height");
        this.height = height;
    }

    private void setLength(double length) {
        validateSide(length, "Length");
        this.length = length;
    }

    private void setWidth(double width) {
        validateSide(width, "Width");
        this.width = width;
    }

    private void validateSide(double side, String prefix) {
        if (side <= 0) {
            throw new InvalidParameterException(prefix + " cannot be zero or negative.");
        }
    }

    public double calculateSurfaceArea() {
        return (2*length*width + 2*length*height + 2*width*height);
    }

    public double calculateLateralSurfaceArea() {
        return (2*length*height + 2*width*height);
    }

    public double calculateVolume() {
        return length*width*height;
    }
}
