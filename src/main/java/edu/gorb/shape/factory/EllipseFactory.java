package edu.gorb.shape.factory;

import edu.gorb.shape.entity.Ellipse;
import edu.gorb.shape.entity.Point;
import edu.gorb.shape.exception.EllipseException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


public class EllipseFactory {
    private static final Logger logger = LogManager.getLogger();
    private static final int VALUE_COUNT = 4;

    public static Ellipse createEllipse(List<Double> coordinates) throws EllipseException {
        if (coordinates.size() != VALUE_COUNT) {
            logger.log(Level.ERROR, "Invalid argument count: {}", coordinates);
            throw new EllipseException("Invalid argument count: " + coordinates);
        }
        Point firstPoint = new Point(coordinates.get(0), coordinates.get(1));
        Point secondPoint = new Point(coordinates.get(2), coordinates.get(3));
        var ellipse = new Ellipse(firstPoint, secondPoint);
        logger.log(Level.INFO, "Ellipse created successfully");
        return new Ellipse();
    }
}
