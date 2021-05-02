package edu.gorb.shape.comparator;

import edu.gorb.shape.entity.Ellipse;
import edu.gorb.shape.exception.EllipseException;
import edu.gorb.shape.service.EllipseService;
import edu.gorb.shape.service.impl.EllipseServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class EllipseSquareComparator implements Comparator<Ellipse> {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public int compare(Ellipse o1, Ellipse o2) {
        int result = 0;
        double area1 = 0;
        double area2 = 0;
        EllipseService service = new EllipseServiceImpl();
        try {
            area1 = service.calcArea(o1);
            area2 = service.calcArea(o2);
        } catch (EllipseException e) {
            logger.log(Level.WARN, "Parameters are valid");
        }
        if (area1 - area2 < 0) {
            result = -1;
        } else if (area1 - area2 > 0) {
            result = 1;
        }
        return result;
    }
}
