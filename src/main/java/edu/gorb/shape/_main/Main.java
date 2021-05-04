package edu.gorb.shape._main;

import edu.gorb.shape.entity.Ellipse;
import edu.gorb.shape.entity.Point;
import edu.gorb.shape.exception.EllipseException;
import edu.gorb.shape.factory.EllipseFactory;
import edu.gorb.shape.filler.RepositoryFiller;
import edu.gorb.shape.filler.WarehouseFiller;
import edu.gorb.shape.observer.EllipseObserver;
import edu.gorb.shape.observer.impl.EllipseObserverImpl;
import edu.gorb.shape.parser.ShapeParser;
import edu.gorb.shape.reader.ShapeFileReader;
import edu.gorb.shape.repository.EllipseRepository;
import edu.gorb.shape.repository.EllipseSpecification;
import edu.gorb.shape.repository.impl.EllipseIdSpecification;
import edu.gorb.shape.warehouse.Warehouse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.net.URL;
import java.util.List;

public class Main {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        URL fileURL = Main.class.getClassLoader().getResource("files/shape_data.txt");
        if (fileURL == null) {
            logger.log(Level.FATAL, "File does not exist");
            return;
        }
        File file = new File(fileURL.getFile());
        String filePath = file.getAbsolutePath();
        try {
            ShapeFileReader reader = new ShapeFileReader();
            List<String> validFileLines = reader.readFile(filePath);
            ShapeParser parser = new ShapeParser();
            EllipseRepository repository = EllipseRepository.getInstance();
            Warehouse warehouse = Warehouse.getInstance();
            RepositoryFiller repositoryFiller = new RepositoryFiller();
            WarehouseFiller warehouseFiller = new WarehouseFiller();
            EllipseObserver observer = new EllipseObserverImpl();
            for (String fileLine : validFileLines) {
                List<Double> lineValues = parser.parseShape(fileLine);
                Ellipse ellipse = EllipseFactory.createEllipse(lineValues);
                ellipse.attach(observer);
                repositoryFiller.fillRepository(ellipse);
                warehouseFiller.fillWarehouse(ellipse);
            }
            EllipseSpecification specification = new EllipseIdSpecification(0);
            List<Ellipse> queryRes = repository.query(specification);
            Ellipse foundEllipse = queryRes.get(0);
            var paramBeforeChange = warehouse.getParameters(foundEllipse.getEllipseId());
            foundEllipse.setFirstPoint(new Point(15, 15));
            var paramAfterChange = warehouse.getParameters(foundEllipse.getEllipseId());
            logger.log(Level.INFO, "Parameters before change: {}", paramBeforeChange);
            logger.log(Level.INFO, "Parameters after change: {}", paramAfterChange);
        } catch (EllipseException e) {
            logger.log(Level.FATAL, e.getMessage());
        }

    }
}
