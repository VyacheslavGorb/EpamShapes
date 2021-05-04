package edu.gorb.shape.filler;

import edu.gorb.shape.entity.Ellipse;
import edu.gorb.shape.exception.EllipseException;
import edu.gorb.shape.service.EllipseService;
import edu.gorb.shape.service.impl.EllipseServiceImpl;
import edu.gorb.shape.warehouse.Warehouse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;

public class WarehouseFiller {
    private static final Logger logger = LogManager.getLogger();

    public void fillWarehouse(List<Ellipse> ellipses) throws EllipseException {
        EllipseService service = new EllipseServiceImpl();
        Warehouse warehouse = Warehouse.getInstance();
        for (Ellipse ellipse : ellipses) {
            double perimeter = service.calcPerimeter(ellipse);
            double area = service.calcArea(ellipse);
            warehouse.putParameters(ellipse.getEllipseId(), perimeter, area);
        }
        logger.log(Level.INFO, "Warehouse filled successfully {}", ellipses);
    }

    public void fillWarehouse(Ellipse ...ellipses) throws EllipseException {
        fillWarehouse(Arrays.asList(ellipses));
    }
}
