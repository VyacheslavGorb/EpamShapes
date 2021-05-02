package edu.gorb.shape.observer.impl;

import edu.gorb.shape.entity.Ellipse;
import edu.gorb.shape.exception.EllipseException;
import edu.gorb.shape.observer.EllipseEvent;
import edu.gorb.shape.observer.EllipseObserver;
import edu.gorb.shape.service.EllipseService;
import edu.gorb.shape.service.impl.EllipseServiceImpl;
import edu.gorb.shape.warehouse.Warehouse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EllipseObserverImpl implements EllipseObserver {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void parameterChanged(EllipseEvent event) {
        double area = 0;
        double perimeter = 0;
        EllipseService service = new EllipseServiceImpl();
        Ellipse ellipse = event.getSource();

        try {
            perimeter = service.calcPerimeter(ellipse);
            area = service.calcArea(ellipse);
        } catch (EllipseException ignored) {
            logger.log(Level.WARN, "Arguments are always valid");
        }

        long id = ellipse.getEllipseId();
        Warehouse warehouse = Warehouse.getInstance();
        try {
            warehouse.updateParameters(id, area, perimeter);
        } catch (EllipseException e) {
            logger.log(Level.WARN, e.getMessage());
        }
    }
}
