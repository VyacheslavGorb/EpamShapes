package edu.gorb.shape.warehouse;

public class EllipseParameter {
    private double perimeter;
    private double area;

    public EllipseParameter() {
    }

    public EllipseParameter(double perimeter, double area) {
        this.perimeter = perimeter;
        this.area = area;
    }

    public EllipseParameter(EllipseParameter newData) {
        perimeter = newData.perimeter;
        area = newData.area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EllipseParameter that = (EllipseParameter) o;
        return Double.compare(that.perimeter, perimeter) == 0 && Double.compare(that.area, area) == 0;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result += 31 * result + Double.hashCode(perimeter);
        result += 31 * result + Double.hashCode(area);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EllipseParameter{");
        sb.append("perimeter=").append(perimeter);
        sb.append(", area=").append(area);
        sb.append('}');
        return sb.toString();
    }
}
