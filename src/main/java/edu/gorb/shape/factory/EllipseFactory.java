package edu.gorb.shape.factory;

import edu.gorb.shape.entity.Ellipse;
import edu.gorb.shape.exception.EllipseException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class EllipseFactory {
    private static final Logger logger = LogManager.getLogger();

    public static Ellipse createEllipse(String shapeType) throws EllipseException {
        if (shapeType == null) {
            logger.log(Level.ERROR, "Shape is null");
            throw new EllipseException("Shape is null");
        }
        logger.log(Level.INFO, "Ellipse created successfully");
        return new Ellipse();
    }
}
