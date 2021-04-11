package edu.gorb.shape.observer.impl;

import edu.gorb.shape.exception.EllipseException;
import edu.gorb.shape.observer.EllipseEvent;
import edu.gorb.shape.observer.Observer;
import edu.gorb.shape.service.EllipseService;
import edu.gorb.shape.service.impl.EllipseServiceImpl;
import edu.gorb.shape.warehouse.Warehouse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EllipseObserver implements Observer {
    private static final Logger logger = LogManager.getLogger();
    private static final EllipseService service = new EllipseServiceImpl();

    @Override
    public void parameterChanged(EllipseEvent event) {
        double area = 0;
        double perimeter = 0;
        try {
            perimeter = service.calcPerimeter(event.getSource());
            area = service.calcArea(event.getSource());
        } catch (EllipseException ignored) {
        }
        long id = event.getSource().getEllipseId();
        Warehouse warehouse = Warehouse.getInstance();
        try{
            warehouse.updateParameters(id, area, perimeter);
        }catch (EllipseException e){
            logger.log(Level.WARN, e.getMessage());
        }
    }
}
