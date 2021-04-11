package edu.gorb.shape.entity;

import edu.gorb.shape.exception.EllipseException;
import edu.gorb.shape.observer.EllipseEvent;
import edu.gorb.shape.observer.Observable;
import edu.gorb.shape.observer.Observer;
import edu.gorb.shape.observer.impl.EllipseObserver;
import edu.gorb.shape.validator.EllipseParameterValidator;

public class Ellipse implements Observable {
    private static final EllipseParameterValidator validator = new EllipseParameterValidator();
    private static long counter = 0;
    private final long ellipseId;
    private Point firstPoint;
    private Point secondPoint;
    private Observer observer = new EllipseObserver();

    public Ellipse() {
        this.firstPoint = new Point();
        this.secondPoint = new Point();
        ellipseId = counter++;
    }

    public Ellipse(Point firstPoint, Point secondPoint) throws EllipseException {
        if (!validator.areValidParameters(firstPoint,secondPoint)){
            throw new EllipseException("Illegal arguments");
        }
        this.firstPoint = new Point(firstPoint);
        this.secondPoint = new Point(secondPoint);
        ellipseId = counter++;
    }

    public Point getFirstPoint() {
        return new Point(firstPoint);
    }

    public void setFirstPoint(Point firstPoint) {
        this.firstPoint = new Point(firstPoint);
        notifyObservers();
    }

    public Point getSecondPoint() {
        return new Point(secondPoint);
    }

    public void setSecondPoint(Point secondPoint) {
        this.secondPoint = new Point(secondPoint);
        notifyObservers();
    }

    public long getEllipseId() {
        return ellipseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ellipse ellipse = (Ellipse) o;
        return ellipse.firstPoint.equals(firstPoint)
                && ellipse.secondPoint.equals(secondPoint);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result += result * 31 + firstPoint.hashCode();
        result += result * 31 + secondPoint.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Ellipse{" +
                "ellipseId=" + ellipseId +
                ", firstPoint=" + firstPoint +
                ", secondPoint=" + secondPoint +
                '}';
    }

    @Override
    public void notifyObservers() {
        if (observer == null){
            return;
        }
        EllipseEvent event = new EllipseEvent(this);
        observer.parameterChanged(event);
    }

    @Override
    public void attach(Observer observer) {
    }

    @Override
    public void detach(Observer observer) {
    }
}
