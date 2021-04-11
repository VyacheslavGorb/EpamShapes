package edu.gorb.shape.parser;

import edu.gorb.shape.entity.Ellipse;
import edu.gorb.shape.entity.Point;
import edu.gorb.shape.exception.EllipseException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ShapeParser {
    private static final Logger logger = LogManager.getLogger();

    public List<Ellipse> parseShapes(List<String> shapeStrings) throws EllipseException {
        var shapesList = new ArrayList<Ellipse>();
        for (String shapeString : shapeStrings) {
            List<Double> valueList;
            try {
                valueList = Arrays.stream(shapeString.split("\\s"))
                        .map(Double::parseDouble)
                        .collect(Collectors.toList());
            } catch (NumberFormatException e) {
                logger.log(Level.ERROR, "Error while parsing double");
                throw new EllipseException("Error while parsing double");
            }
            if (valueList.size() != 4) {
                logger.log(Level.ERROR, "Illegal number count in line");
                throw new EllipseException("Illegal number count in line");
            }
            Point firstPoint = new Point(valueList.get(0), valueList.get(1));
            Point secondPoint = new Point(valueList.get(2), valueList.get(3));
            shapesList.add(new Ellipse(firstPoint, secondPoint));
        }
        logger.log(Level.INFO, "Lines parsed successfully");
        return shapesList;
    }
}
