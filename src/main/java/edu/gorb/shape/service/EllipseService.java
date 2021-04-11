package edu.gorb.shape.service;

import edu.gorb.shape.entity.Ellipse;
import edu.gorb.shape.exception.EllipseException;

public interface EllipseService {
    boolean isCircle(Ellipse ellipse) throws EllipseException;

    boolean isOval(Ellipse ellipse) throws EllipseException;

    boolean isValidOval(Ellipse ellipse) throws EllipseException;

    double calcPerimeter(Ellipse ellipse) throws EllipseException;

    double calcArea(Ellipse ellipse) throws EllipseException;
}
