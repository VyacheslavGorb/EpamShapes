package edu.gorb.shape.entity;

import edu.gorb.shape.exception.EllipseException;
import edu.gorb.shape.observer.EllipseEvent;
import edu.gorb.shape.observer.EllipseObservable;
import edu.gorb.shape.observer.EllipseObserver;
import edu.gorb.shape.util.ShapeIdGenerator;
import edu.gorb.shape.validator.EllipseParameterValidator;

import java.util.ArrayList;

public class Ellipse implements EllipseObservable {
    private final long ellipseId;
    private Point firstPoint;
    private Point secondPoint;
    private final ArrayList<EllipseObserver> observers = new ArrayList<>();

    public Ellipse() {
        this.firstPoint = new Point();
        this.secondPoint = new Point();
        ellipseId = ShapeIdGenerator.generateId();
    }

    public Ellipse(Point firstPoint, Point secondPoint) throws EllipseException {
        if (!EllipseParameterValidator.areValidParameters(firstPoint, secondPoint)) {
            throw new EllipseException("Illegal arguments");
        }
        this.firstPoint = new Point(firstPoint);
        this.secondPoint = new Point(secondPoint);
        ellipseId = ShapeIdGenerator.generateId();
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
        final StringBuilder sb = new StringBuilder("Ellipse{");
        sb.append("ellipseId=").append(ellipseId);
        sb.append(", firstPoint=").append(firstPoint);
        sb.append(", secondPoint=").append(secondPoint);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void notifyObservers() {
        for (EllipseObserver observer : observers) {
            if (observer == null) {
                continue;
            }
            EllipseEvent event = new EllipseEvent(this);
            observer.parameterChanged(event);
        }
    }

    @Override
    public void attach(EllipseObserver observer) {
        observers.add(observer);
    }

    @Override
    public void detach(EllipseObserver observer) {
        observers.remove(observer);
    }
}
