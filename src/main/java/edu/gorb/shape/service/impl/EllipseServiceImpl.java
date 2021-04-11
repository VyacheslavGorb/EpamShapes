package edu.gorb.shape.service.impl;

import edu.gorb.shape.entity.Ellipse;
import edu.gorb.shape.entity.Point;
import edu.gorb.shape.exception.EllipseException;
import edu.gorb.shape.service.EllipseService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EllipseServiceImpl implements EllipseService {
    private static final Logger logger = LogManager.getLogger();
    private static final String SHAPE_IS_NULL_ERROR_MESSAGE = "Shape is null";

    @Override
    public boolean isCircle(Ellipse ellipse) throws EllipseException {
        if (ellipse == null) {
            logger.log(Level.ERROR, SHAPE_IS_NULL_ERROR_MESSAGE);
            throw new EllipseException(SHAPE_IS_NULL_ERROR_MESSAGE);
        }
        Point firstPoint = ellipse.getFirstPoint();
        Point secondPoint = ellipse.getSecondPoint();
        double width = Math.abs(firstPoint.getX() - secondPoint.getX());
        double height = Math.abs(firstPoint.getY() - secondPoint.getY());
        boolean result = Double.compare(width, height) == 0;
        logger.log(Level.INFO, "Is shape circle: {}", result);
        return result && isValidOval(ellipse);
    }

    @Override
    public boolean isOval(Ellipse ellipse) throws EllipseException {
        if (ellipse == null) {
            logger.log(Level.ERROR, SHAPE_IS_NULL_ERROR_MESSAGE);
            throw new EllipseException(SHAPE_IS_NULL_ERROR_MESSAGE);
        }
        Point firstPoint = ellipse.getFirstPoint();
        Point secondPoint = ellipse.getSecondPoint();
        double width = Math.abs(firstPoint.getX() - secondPoint.getX());
        double height = Math.abs(firstPoint.getY() - secondPoint.getY());
        boolean result = Double.compare(width, height) != 0;
        logger.log(Level.INFO, "Is shape oval: {}", result);
        return result && isValidOval(ellipse);
    }

    @Override
    public boolean isValidOval(Ellipse ellipse) throws EllipseException {
        if (ellipse == null) {
            logger.log(Level.ERROR, SHAPE_IS_NULL_ERROR_MESSAGE);
            throw new EllipseException(SHAPE_IS_NULL_ERROR_MESSAGE);
        }
        Point firstPoint = ellipse.getFirstPoint();
        Point secondPoint = ellipse.getSecondPoint();
        boolean result = firstPoint.getX() != secondPoint.getX()
                && firstPoint.getY() != secondPoint.getY();
        logger.log(Level.INFO, "Is oval valid: {}", result);
        return result;
    }

    @Override
    public double calcPerimeter(Ellipse ellipse) throws EllipseException {
        if (ellipse == null) {
            logger.log(Level.ERROR, SHAPE_IS_NULL_ERROR_MESSAGE);
            throw new EllipseException(SHAPE_IS_NULL_ERROR_MESSAGE);
        }
        Point firstPoint = ellipse.getFirstPoint();
        Point secondPoint = ellipse.getSecondPoint();
        double a = Math.abs(firstPoint.getX() - secondPoint.getX()) / 2;
        double b = Math.abs(firstPoint.getY() - secondPoint.getY()) / 2;
        double perimeter = 2 * Math.PI * Math.sqrt((a * a + b * b) / 2);
        logger.log(Level.INFO, "Perimeter is: {}", perimeter);
        return perimeter;
    }

    @Override
    public double calcArea(Ellipse ellipse) throws EllipseException {
        if (ellipse == null) {
            logger.log(Level.ERROR, SHAPE_IS_NULL_ERROR_MESSAGE);
            throw new EllipseException(SHAPE_IS_NULL_ERROR_MESSAGE);
        }
        Point firstPoint = ellipse.getFirstPoint();
        Point secondPoint = ellipse.getSecondPoint();
        double a = Math.abs(firstPoint.getX() - secondPoint.getX()) / 2;
        double b = Math.abs(firstPoint.getY() - secondPoint.getY()) / 2;
        double area = Math.PI * a * b;
        logger.log(Level.INFO, "Area is: {}", area);
        return area;
    }
}
