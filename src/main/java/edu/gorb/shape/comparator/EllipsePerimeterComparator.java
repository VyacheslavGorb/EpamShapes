package edu.gorb.shape.comparator;

import edu.gorb.shape.entity.Ellipse;
import edu.gorb.shape.exception.EllipseException;
import edu.gorb.shape.service.EllipseService;
import edu.gorb.shape.service.impl.EllipseServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class EllipsePerimeterComparator implements Comparator<Ellipse> {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public int compare(Ellipse o1, Ellipse o2) {
        int result = 0;
        double perimeter1 = 0;
        double perimeter2 = 0;
        EllipseService service = new EllipseServiceImpl();
        try {
            perimeter1 = service.calcPerimeter(o1);
            perimeter2 = service.calcPerimeter(o2);
        } catch (EllipseException e) {
            logger.log(Level.ERROR, "Parameters are valid");
        }
        if (perimeter1 - perimeter2 < 0) {
            result = -1;
        } else if (perimeter1 - perimeter2 > 0) {
            result = 1;
        }
        return result;
    }
}
