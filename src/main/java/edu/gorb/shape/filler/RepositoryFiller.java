package edu.gorb.shape.filler;

import edu.gorb.shape.entity.Ellipse;
import edu.gorb.shape.repository.EllipseRepository;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;

public class RepositoryFiller {
    private static final Logger logger = LogManager.getLogger();

    public void fillRepository(List<Ellipse> ellipses){
        EllipseRepository repository = EllipseRepository.getInstance();
        for (Ellipse ellipse : ellipses){
            repository.add(ellipse);
        }
        logger.log(Level.INFO, "Repository filled successfully {}", ellipses);
    }

    public void fillRepository(Ellipse ...ellipses){
        fillRepository(Arrays.asList(ellipses));
    }
}
