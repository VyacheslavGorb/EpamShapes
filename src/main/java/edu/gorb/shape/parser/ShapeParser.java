package edu.gorb.shape.parser;

import edu.gorb.shape.exception.EllipseException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ShapeParser {
    private static final Logger logger = LogManager.getLogger();
    private static final String SPACE_REGEXP = "\\s+";
    private static final int VALUE_COUNT = 4;

    public List<Double> parseShape(String shapeLine) throws EllipseException {
        List<Double> valueList;
        try {
            valueList = Arrays.stream(shapeLine.split(SPACE_REGEXP))
                    .map(Double::parseDouble)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            logger.log(Level.ERROR, "Error while parsing double");
            throw new EllipseException("Error while parsing double");
        }
        if (valueList.size() != VALUE_COUNT) {
            logger.log(Level.ERROR, "Illegal number count in line");
            throw new EllipseException("Illegal number count in line");
        }
        logger.log(Level.INFO, "Lines parsed successfully");
        return valueList;
    }
}
